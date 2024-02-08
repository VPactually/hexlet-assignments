@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <div class="container">
        @if(page.getUsers().isEmpty())
            <p>Not found any users</p>
            <a href="/users">Back</a>
        @else
            <h2>Users list</h2>
            <form class="nav active" action="/users" method="get">
                <label>
                    <input type="search" required name="term">
                </label>
                <input class="nav-link" type="submit" value="Искать">
            </form>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                </tr>
                </thead>
                <tbody>
                @for(var user : page.getUsers())
                    <tr>
                        <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                        <td>${user.getEmail()}</td>
                        <td>${user.getFirstName() + " " + user.getLastName()}</td>
                    </tr>
                @endfor
                </tbody>
                <tr>
                    <td colspan="4">

                        @if (page.getCurrentPage() < page.getTotalPages())
                        @if (page.getCurrentPage() > 1)
                            <a href="/courses?page=${page.getCurrentPage()-1}&per=${page.getPerParam()}">Previous</a>
                        @endif
                        <a href="/courses?page=${page.getCurrentPage()+1}&per=${page.getPerParam()}">Next</a>
                    </td>
                    @else
                        <a href="/courses?page=${page.getCurrentPage()-1}&per=${page.getPerParam()}">Previous</a>
                    @endif
                    @endif
                </tr>
            </table>
    </div>
`
)
