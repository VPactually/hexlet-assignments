@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if(page != null && page.getName() != null)
        <h2>Welcome, ${page.getName().toString()}!!!</h2>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <h2>Welcome !!!</h2>
        <p><a href="${NamedRoutes.buildSessionPath()}">Войти</a></p>
    @endif
`
)