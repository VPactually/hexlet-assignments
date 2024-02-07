@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <div class="container">
        @if(page.getUsers().isEmpty())
            <p>Users not added in the list</p>
        @else
            <h2>Users list</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Name</th>
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
            </table>
        @endif
    </div>
`
)
