import java.nio.file.AccessDeniedException
import org.codehaus.groovy.grails.web.mapping.DefaultUrlMappingEvaluator

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "github", action: "index")
        "/latestCommit"(controller: "github", action: "getLatestCommit")
        "/votes"(resources: "votes")

        //ERROR Handling
        "403"(controller: "error", action: "error403", exception: AccessDeniedException)
        "404"(controller: "error", action: "error404")
        "500"(controller: "error", action: "error500")


    }
}
