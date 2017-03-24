package jukin.thingamajig

import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import spock.lang.Shared
import spock.lang.Specification

class BasicApiFunctionalTests extends Specification {
    @Shared
    RestBuilder rest

    @Shared
    String baseUrl

    def setup() {
        rest = new RestBuilder()
        baseUrl = "http://localhost:8080"
    }

    def "test API vote listing"() {
        when:
        def response = rest.get("http://localhost:8080/votes") {
            accept JSON
        }

        then: 'Expect a successful response'
        response.status == 200
    }


    def "test API does not respond to DELETE"() {
        when:
        def response = rest.delete("http://localhost:8080/votes/1") {
            accept JSON
        }

        print response.body

        then:
        response.status == 405
    }

    def "test Vote can be created"() {
        when:
        def response = rest.post("http://localhost:8080/votes") {
            header 'Content-Type', 'application/json'
            accept JSON
            json {
                name = 'foo'
                repoUrl = 'bar'
                voteValue = 'LIKE'
                comment = 'This is cool...'
            }
        }

        println response.body

        then:
        response.status == 201
    }

    def "test Vote can be fetched"() {
        when:
        def response = rest.put("http://localhost:8080/votes/1") {
            accept JSON
        }

        println response.body

        then:
        response.status == 200
        response.json.name == 'foo'
        response.json.repoUrl == 'bar'
        response.json.voteValue == 'LIKE'
        response.json.comment == 'This is cool...'

    }
    def "test Vote can be updated"() {
        when:
        def response = rest.put("http://localhost:8080/votes/1") {
            accept JSON
            json {
                name = 'baz'
                voteValue = 'DISLIKE'
            }
        }

        println response.body
        then:
        response.status == 200
        response.json.name == 'baz'
        response.json.voteValue == 'DISLIKE'
    }
}
