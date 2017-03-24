<div class="repos-container">
    <ul>
        <g:each in="${repos}" var="repo" status="idx">
            <li class="repo-data" data-id="${repo.id}" data-owner="${repo.owner.login}" data-name="${repo.name}" data-url="${repo.url}">
                <div class="flex space-between">
                    <h4>${repo.full_name} <span class="fa fa-star">&nbsp;${repo.stargazers_count}</span></h4>
                    <button type="button" class="btn btn-info" data-toggle="modal"
                            data-target="#voteModal">Vote</button>
                </div>

                <p>${thinga.truncateHtml(value: repo.description, length: '250')}"</p>

                <p><g:link uri="${repo.url}" target="_blank">${repo.owner.html_url}</g:link></p>

                <p>Latest commit: <span class="latest-commit">
                    <button class="btn btn-default btn-outline btn-xs show-commit btn-loading"
                            data-loading-text="<i class='fa fa-circle-o-notch fa-spin'></i> Searching">SHOW</button>
                </span></p>

                <p data-toggle="collapse" data-target="#comments-${idx}">Comments&nbsp;<span
                        class="fa fa-plus-square-o cursor"></span></p>

                <div id="comments-${idx}" class="collapse">
                    <ul class="votes-list">
                        <g:if test="${repo.votes}">
                            <g:each in="${repo.votes}" var="vote">
                                <li>
                                    <p>
                                        <g:if test="${vote.voteValue == 'LIKE'}">
                                            <span class="fa fa-thumbs-up green"></span>
                                        </g:if>
                                        <g:elseif test="${vote.voteValue == 'DISLIKE'}">
                                            <span class="fa fa-thumbs-down red"></span>
                                        </g:elseif>
                                        ${vote.comment ?: 'No need to comment my thumb says it all ;-)'}
                                    </p>
                                </li>
                            </g:each>
                        </g:if>
                        <g:else>
                            <li class="no-vote">
                                <p>Currently there are no votes. Click here to <g:link uri="#" data-toggle="modal" data-target="#voteModal">add vote</g:link>.</p>
                            </li>
                        </g:else>
                    </ul>
                </div>
            </li>

        </g:each>
    </ul>
</div>
