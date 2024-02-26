package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    private List<CommentDTO> toCommentsDTO(List<Comment> comments) {
        var result = new ArrayList<CommentDTO>();
        for (var comment : comments) {
            var dto = new CommentDTO();
            dto.setId(comment.getId());
            dto.setBody(comment.getBody());
            result.add(dto);
        }
        return result;
    }

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setComments(toCommentsDTO(commentRepository.findByPostId(post.getId())));
        return dto;
    }

    @GetMapping
    public List<Post> index() {
        return new ArrayList<>(postRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public PostDTO show (@PathVariable Long id) {
        var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return toPostDTO(post);
    }
}
// END
