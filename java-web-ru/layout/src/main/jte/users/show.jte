@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <div class="description-from-type-label">
        <h2>${page.getUser().getId()}</h2>
        <p>${page.getUser().getFirstName()  + " " + page.getUser().getLastName()}</p>
        <p>${page.getUser().getEmail()}</p>
    </div>
`
)

