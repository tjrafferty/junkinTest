package jukin.thingamajig

import groovy.json.JsonSlurper

class GithubController {



    def index = {
        render "<H1>Hello World</H1>"
    }

//    def list = {
    public def list() {
//        render "${params.id ?: 'what?'}"
        def accessToken='f0c3134e73eef152ae784ccab218cc2935319fd3'
        def text = queryGit("https://api.github.com/repositories?access_token=${accessToken}")
        assert text : "whoa no github result"
        def reposJson = new JsonSlurper().parseText(text)

        def model =[json:reposJson]

        def lastCommitForRepo=[:]
        reposJson.each { Map map ->


            def full_name = map.full_name
//            def url = "https://api.github.com/repos/${full_name}/commits"
            // rate limiting
            def url = "https://api.github.com/repos/${full_name}/commits?access_token=${accessToken}"
            def newTExt = queryGit(url)
            if (newTExt) {
                def newReposJson = new JsonSlurper().parseText(newTExt)

                map.put 'lastCommit', ((newReposJson as List)[0] as Map).commit.author.date
            }

        }
        model.put 'lastCommitForRepo', lastCommitForRepo

        render(view: 'index', model:model, contentType: 'text/html')

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
             rd = new BufferedReader(new InputStreamReader(conn.getInputStream() ) );
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
