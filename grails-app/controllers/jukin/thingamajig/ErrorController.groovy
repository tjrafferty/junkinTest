package jukin.thingamajig


import grails.converters.JSON

class ErrorController {

    //Forbidden
    def error403() {

        withFormat {
            html {
                render(view: 'authorize')
            }
            json {
                render(status: 403, text: '', contentType: 'application/json')
            }
        }
    }

    //Not Found
    def error404() {
        withFormat {
            html {
                render(view: 'missing')
            }
            json {
                render(status: 404, text: '', contentType: 'application/json')
            }
        }
    }

    //Houston
    def error500() {
        def exception = request.exception
        log.error(exception)
        withFormat {
            html {
                render(view: 'server')
            }
            json {
                render(status: 500, text: '', contentType: 'application/json')
            }
        }
    }
}