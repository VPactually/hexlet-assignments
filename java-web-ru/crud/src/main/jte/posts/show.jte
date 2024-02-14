@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(content = @`
<div class="container">
    <h2>${page.getPost().getId()}</h2>
    <h3>${page.getPost().getName()}</h3>
    <h4>${page.getPost().getBody()}</h4>
</div>
`)
