package exercise.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {

        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = 5;

        page = page == 0 ? 1 : page;

        var posts = PostRepository.getEntities();

        var startIndex = (page - 1) * per;
        var endIndex = Math.min(startIndex + per, posts.size());
        var postsPage = new PostsPage(posts.subList(startIndex, endIndex), page);
        ctx.render("posts/index.jte", Collections.singletonMap("page", postsPage));

    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        if (PostRepository.find(id).isEmpty()) {
            ctx.status(404);
            ctx.result("Page not found");
        } else {
            var post = PostRepository.find(id).get();
            var page = new PostPage(post);
            ctx.render("posts/show.jte", Collections.singletonMap("page", page));
        }
    }
    // END
}
