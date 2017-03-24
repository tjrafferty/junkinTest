package jukin.thingamajig

import grails.converters.JSON
import groovyx.net.http.ContentType
import junkin.thingamajig.Repo
import junkin.thingamajig.Vote

class GithubController {

    def feedService
    def quoteService

    def index() {
        def rtn = [:], opts = [:], repos = []
        opts.url = "http://api.github.com"
        opts.path = "/search/repositories"
        def addParams = [
                //access_token: grailsApplication.config.github.accessToken,
                sort    : 'stars',
                order   : 'desc',
                per_page: 20
        ]
        def searchQuery = [
                is: "public"
        ]
        opts.query = [q: searchQuery] + addParams
        opts.contentType = ContentType.JSON
        def response = feedService.getFeed(opts)
        def reposTotal = response.total_count

        response.items.each { repo ->
            def id = repo.id
            def repository = Repo.findByRepoId(id)
            if (repository) {
                repo.votes = repository.votes
            } else {
                repo.votes = null
            }

            repos << repo
        }
        rtn.randomQuote = quoteService.getRandomQuote()
        rtn.repos = repos
        rtn.reposTotal = reposTotal

        return rtn
    }

    def vote() {
        def rtn = [success: false]
        def vote = new Vote(comments: params.comments, vote: params.vote)
        def repo = Repo.findByName(params.name)
        if (!repo) {
            repo = new Repo(name: params.name, repoId: params.id).save(flush: true)
        }
        repo.addToVotes(vote)
        if (repo.save(flush: true)) {
            rtn.id = repo.repoId
            rtn.vote = vote
            rtn.success = true
        }

        render rtn as JSON
    }

    def getLatestCommit() {
        def rtn = [:], opts = [:]
        opts.url = "http://api.github.com"
        opts.path = "/repos/${params.owner}/${params.name}/commits"
        opts.query = [:]
        opts.contentType = ContentType.JSON
        def commits = feedService.getFeed(opts)
        def lastCommit = commits[0]
        def commitUrl = lastCommit.html_url
        def date = lastCommit.commit.author.date
        def sha = lastCommit.sha

        rtn.commit = "<span>" + date + "&nbsp;<a href='" + commitUrl + "' target='_blank'>" + sha + "</a></span>"

        render rtn as JSON
    }


}
