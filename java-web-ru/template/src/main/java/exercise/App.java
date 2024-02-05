package exercise;

import io.javalin.Javalin;

import java.util.Comparator;
import java.util.List;

import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import io.javalin.rendering.template.JavalinJte;

import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {
        USERS.sort(Comparator.comparing(User::getId));
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var description = "Users list";
            var page = new UsersPage(USERS, description);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            if (Integer.parseInt(id) - 1 > USERS.size() || Integer.parseInt(id) - 1 < 0) {
                ctx.status(404);
                ctx.result("User not found");
            } else {
                User user = USERS.get(Integer.parseInt(id) - 1);
                var page = new UserPage(user);
                ctx.render("users/show.jte", Collections.singletonMap("page", page));
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
