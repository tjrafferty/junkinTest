package jukin.thingamajig

import groovyx.net.http.ContentType

class GithubController {

    def feedService

    def index() {
        def rtn = [:], opts = [:], repos = []
        opts.url = "http://api.github.com"
        opts.path = "/search/repositories"
        def addParams = [
                access_token: grailsApplication.config.github.accessToken,
                sort    : 'stars',
                order   : 'desc',
                per_page: 20
        ]
        def searchQuery = [
                language: "java"
        ]
        opts.query = [q: searchQuery] + addParams
        opts.contentType = ContentType.JSON
        def response = feedService.getFeed(opts)
        def reposTotal = response.total_count

        response.items.each { repo ->
            //opts.path = "/repos/${repo.owner.login}/${repo.name}/commits/git/refs/heads/master"
            //opts.query = [:]
            //def commits = feedService.getFeed(opts)
            //repo.lastCommit = commits[0]
/*
            def url = "https://api.github.com/repos/${repo.owner.login}/${repo.name}/commits"
            def newTExt = queryGit(url)
            if (newTExt) {
                def commits = new JsonSlurper().parseText(newTExt)
                repo.lastCommit = commits[0]
                println commits[0]//'lastCommit', ((newReposJson as List)[0] as Map).commit.author.date
            }
*/

            repos << repo
        }

        rtn.repos = repos
        rtn.reposTotal = reposTotal

        return rtn
    }

    def vote(){

    }

    def comment(){

    }


    def list() {
        def rtn = [:], opts = [:], repos = []
        opts.url = "http://api.github.com"
        opts.path = "/search/repositories"
        def addParams = [
                //access_token: grailsApplication.config.github.accessToken,
                sort    : 'stars',
                order   : params.order ?: 'desc',
                per_page: params.perPage ?: 20
        ]
        def searchQuery = [
                language: "java"
        ]
        opts.query = [q: searchQuery] + addParams
        opts.contentType = ContentType.JSON
        def response = feedService.getFeed(opts)
        def reposTotal = response.total_count

        response.items.each { repo ->
            println response

            repos << repo
        }

        rtn.repos = repos
        rtn.reposTotal = reposTotal
        render template: '/templates/repos/list', model: rtn

    }

    public static def queryGit(String urlToRead) {

        URL url;

        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();

        } catch (IOException e) {
            e.printStackTrace();


        } catch (Exception e) {
            e.printStackTrace();

        }
        return result
    }


}
