package exercise.dto.posts;

import java.util.List;

import exercise.model.Post;

import exercise.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
public class PostsPage {
    private List<Post> posts;
    private int page;

    public PostsPage(List<Post> posts, int page) {
        this.posts = posts;
        this.page = page;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public int getPage() {
        return page;
    }

    public boolean hasNextPage() {
        return PostRepository.getEntities().size() > page * 5 ;
    }

    public boolean hasPreviousPage() {
        return this.page > 1;
    }
}
// END


