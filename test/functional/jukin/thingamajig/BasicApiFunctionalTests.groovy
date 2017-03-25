package jukin.thingamajig

import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.TestFor
import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import static org.springframework.http.HttpStatus.*

class BasicApiFunctionalTests extends Specification {
    @Shared
    RESTClient rest

    @Shared
    String baseUrl

    def setup() {
        rest = new RESTClient()
        baseUrl = "http://localhost:8080/"
    }

    def "test API vote listing"() {
        when:
        def response = rest.get(uri: baseUrl, path: "votes")

        then: 'Expect a successful response'
        response.status == 200
    }


    def "test API does not respond to DELETE"() {
        when:
        def response = rest.delete(
                uri: baseUrl,
                path: "votes/1",
                contentType: groovyx.net.http.ContentType.JSON
        )

        then:
        assert response.responseData.status == 405
    }

    def "test Vote can be created"() {

        given:
        String newName = "foo"
        String newRepoUrl = "bar"
        String newVoteValue = "LIKE"
        String newComment = "this is cool..."
        String newRepoId = org.apache.commons.lang.RandomStringUtils.random(7, true, true)

        when:
        def response = rest.post(
                uri: baseUrl,
                path: "votes",
                body: [name: newName, repoUrl: newRepoUrl, voteValue: newVoteValue, comment: newComment, repoId: newRepoId],
                contentType: groovyx.net.http.ContentType.JSON
        )

        then:

        assert response.responseData.status == 201
    }

    def "test Vote can be fetched"() {

        given:
        String newName = "afoo"
        String newRepoUrl = "abar"
        String newVoteValue = "LIKE"
        String newComment = "athis is cool..."
        String newRepoId = org.apache.commons.lang.RandomStringUtils.random(7, true, true)

        def post = rest.post(
                uri: baseUrl,
                path: "votes",
                body: [name: newName, repoUrl: newRepoUrl, voteValue: newVoteValue, comment: newComment, repoId: newRepoId],
                contentType: groovyx.net.http.ContentType.JSON
        )
        when:
        def response = rest.get(uri: baseUrl, path: "votes/${post.data.votes.id}")

        then:
        assert response.status == 200
        assert response.data.votes.name == newName

    }

    def "test Vote can be updated"() {
        when:
        def response = rest.put(
                uri: baseUrl,
                path: "votes/1",
                body: [name: "baz", voteValue: "DISLIKE", comment: "Im updated bro!"],
                contentType: groovyx.net.http.ContentType.JSON
        )

        then:

        response.status == 200
        response.data.votes.name == 'baz'
        response.data.votes.voteValue == 'DISLIKE'
        response.data.votes.comment == 'Im updated bro!'
    }
}
