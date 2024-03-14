package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathToFile1, String pathToFile2, String desc) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("1 is ok");
                return new String(Files.readAllBytes(Paths.get(pathToFile1).toAbsolutePath().normalize()));
            } catch (IOException e) {
                System.out.println(e.getClass().toString());
                return null;
            }
        });
        future1.get();
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("2 is ok");
                return new String(Files.readAllBytes(Paths.get(pathToFile2).toAbsolutePath().normalize()));
            } catch (IOException e) {
                System.out.println(e.getClass().toString());
                return null;
            }
        });
        future2.get();
        return future1.thenCombine(future2, (f1, f2) -> {
            var result = f1 + f2;
            try {
                Files.write(Paths.get(desc).toAbsolutePath().normalize(), result.getBytes(), StandardOpenOption.CREATE);
                return result;
            } catch (IOException e) {
                System.out.println(e.getClass().toString());
                return null;
            }

        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getClass().toString());
            return null;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/file3.txt");
        // END
    }
}

