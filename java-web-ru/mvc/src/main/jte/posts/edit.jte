@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(content = @`
    <div align="left">
        @if (page.getErrors() != null)
            <ul>
                @for (var validator : page.getErrors().values())
                    @for (var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif
    </div>


    <div align="left">
        <form action="${NamedRoutes.postPath(page.getId())}" method="post">
            <div>
                <p>Текущий заголовок - ${page.getName()}</p>
                <p>
                    Заголовок
                    <label>
                        <input type="text" name="name"/>
                    </label>
                </p>
            </div>
            <div>
                <p>Текущее описание - ${page.getBody()}</p>
                <p>
                    Описание
                    <label>
                        <input type="text" name="body"/>
                    </label>
                </p>
            </div>
            <br>
            <input type="submit" value="Обновить"/>
        </form>
    </div>
`)