@import exercise.dto.users.UserPage
@param UserPage page
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${page.getUser().getFirstName()}</title>
    </head>
    <body>
        <div class="description-from-type-label">
            <h2>${page.getUser().getId()}</h2>
            <p>${page.getUser().getFirstName()}</p>
            <p>${page.getUser().getLastName()}</p>
            <p>${page.getUser().getEmail()}</p>
        </div>
    </body>
</html>
