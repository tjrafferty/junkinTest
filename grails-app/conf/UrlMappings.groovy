import java.nio.file.AccessDeniedException

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "github", action: "index")
        "/latestCommit"(controller: "github", action: "getLatestCommit")

        //ERROR Handling
        "403"(controller: "error", action: "error403", exception: AccessDeniedException)
        "404"(controller: "error", action: "error404")
        "500"(controller: "error", action: "error500")


    }
}
