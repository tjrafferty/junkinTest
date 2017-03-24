package jukin.thingamajig.utils

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

/**
 * Created by FULL-MB on 3/22/17.
 */
class ApiConsumer {
    static def postText(String baseUrl, String path, query, method = Method.POST, contentType = ContentType.TEXT) {
        try {
            def ret, http = new HTTPBuilder(baseUrl)

            http.request(Method.GET, contentType) { req ->
                uri.path = path
                uri.query = query
                headers.'User-Agent' = 'Jukin-Thingamajig'
                response.success = { resp, reader ->
                    ret = reader
                }
            }
            return ret


        } catch (groovyx.net.http.HttpResponseException ex) {
            ex.printStackTrace()
            return null
            //return ex.statusCode
        } catch (java.net.ConnectException ex) {
            ex.printStackTrace()
            return null
        }
    }

    static def getText(String baseUrl, String path, query, ContentType contentType) {
        return postText(baseUrl, path, query, Method.GET, contentType)
    }
}
