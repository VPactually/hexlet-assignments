package exercise.dto.users;

import exercise.model.User;

import java.util.List;

// BEGIN
public final class UsersPage {
    private List<User> users;
    private String header;
    int totalPages;
    int currentPage;

    public UsersPage(List<User> users, String header, Integer totalPages, Integer currentPage) {
        this.users = users;
        this.header = header;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    public UsersPage() {

    }

    public List<User> getUsers() {
        return users;
    }

    public String getHeader() {
        return header;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPerParam() {
        return users.size() / totalPages;
    }
}
// END
