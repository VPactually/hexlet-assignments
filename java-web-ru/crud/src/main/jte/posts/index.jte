@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(content = @`
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Post</th>
        </tr>
        </thead>
        <tbody>
        @for(var post : page.getPosts())
            <tr>
                <td><a href="${NamedRoutes.postPath(post.getId())}">${post.getId()}</a></td>
                <td><a href="${NamedRoutes.postPath(post.getId())}">${post.toString()}</a></td>
            </tr>
        @endfor
        </tbody>
    </table>
    <nav aria-label="...">
        <ul class="pagination">
            @if (page.hasPreviousPage())
                <li class="page-item">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">Previous</a>
                </li>
            @else
                <li class="page-item disabled">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">Previous</a>
                </li>
            @endif
            @if (page.hasNextPage())
                <li class="page-item">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">Next</a>
                </li>
            @else
                <li class="page-item disabled">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">Next</a>
                </li>
            @endif

            <li class="page-item">

            </li>
        </ul>
    </nav>
`)
    