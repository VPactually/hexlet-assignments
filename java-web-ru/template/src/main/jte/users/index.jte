@import exercise.dto.users.UsersPage
@param UsersPage page
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>
        ${page.getDescription()}
    </title>
</head>
<body>
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
                <th>FirstName</th>
                <th>LastName</th>
            </tr>
            </thead>
            <tbody>
            @for(var user : page.getUsers())
                <tr>
                    <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
