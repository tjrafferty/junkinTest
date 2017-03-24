package junkin.thingamajig

import grails.transaction.Transactional
import groovy.json.JsonSlurper
import jukin.thingamajig.utils.ApiConsumer

@Transactional
class FeedService {

    /*Get Feed*/

    def getFeed(Map opts = [:]) {
        def url = opts.url
        def path = opts.path
        def query = opts.query
        def contentType = opts.contentType
        //Submit a request via GET
        def response = ApiConsumer.getText(url, path, query, contentType)
        return response
    }
}
