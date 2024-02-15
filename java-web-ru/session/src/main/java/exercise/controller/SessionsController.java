package exercise.controller;

import java.util.Collections;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;

import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage();
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class).get();
        var password = ctx.formParam("password");
        var user = new User(name, Security.encrypt(password));
        if (UsersRepository.findByName(name) != null) {
            if (UsersRepository.findByName(name).getPassword().equals(user.getPassword())) {
                ctx.sessionAttribute("logged", name);
                ctx.redirect(NamedRoutes.rootPath());
            } else {
                var page = new LoginPage(name, "Wrong username or password");
                ctx.render("build.jte", Collections.singletonMap("page", page));
            }
        } else {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void show(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("logged"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("logged", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
