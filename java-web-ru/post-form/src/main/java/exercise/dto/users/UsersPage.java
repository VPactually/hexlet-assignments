package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import exercise.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
public class UsersPage {
    private List<User> users;

    public UsersPage(List<User> list) {
        this.users = list;

    }

    public UsersPage() {

    }

    public List<User> getUsers() {
        return users;
    }

}
// END
