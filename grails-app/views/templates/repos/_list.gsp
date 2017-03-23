<div class="repos-container">
    <ul>
        <g:each in="${repos}" var="repo" status="idx">
            <li class="repo-data" data-id="${repo.id}">
                <h4>${repo.full_name} <span class="fa fa-star">&nbsp;${repo.stargazers_count}</span></h4>

                <p>${thinga.truncateHtml(value: repo.description, length: '250')}"</p>

                <p><g:link uri="${repo.url}" target="_blank">${repo.owner.html_url}</g:link></p>
                <%--<p>Latest commit: ${repo.lastCommit}</p>--%>


                <div class="voters">
                    <button class="vote-button down btn btn-danger btn-sm">
                        <span class="fa fa-thumbs-up"></span> Down Vote
                    </button>

                    <button class="vote-button up btn btn-info btn-sm">
                        <span class="fa fa-thumbs-down"></span> Up Vote
                    </button>
                </div>

                <g:form name="repo-comment-form" class="repo-comment-form" controller="github" action="postComments">
                    <div class="form-group">
                        <textarea class="form-control comments" placeholder="Tell us what you think" rows="7" cols="50"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </g:form>

            </li>

        </g:each>
    </ul>
</div>
