package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
public final class UsersPage {
    private List<User> users;
    private String description;

    public UsersPage(List<User> users, String description) {
        this.users = users;
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getDescription() {
        return description;
    }
}
// END
