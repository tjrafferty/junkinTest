package jukin.thingamajig

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VotesController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        def rtn = [:]
        rtn.vote = Votes.list()
        rtn.status = OK
        render rtn as JSON
    }

    def show(Votes votes) {
        def rtn = [:]
        if (!votes) {
            rtn.status = NOT_FOUND
        } else {
            rtn.votes = votes
            rtn.status = 200
        }
        render rtn as JSON
    }

    @Transactional
    def save(Votes votes) {
        def rtn = [:]

        if (votes == null) {
            rtn.status = NOT_FOUND
        }

        if (votes.validate() && votes.hasErrors()) {
            rtn.status = NOT_ACCEPTABLE
        }
        if (votes.save(flush: true)) {
            rtn.status = 201
            rtn.votes = votes
        }
        render rtn as JSON
    }

    @Transactional
    def update(Votes votes) {
        votes.properties = request
        def rtn = [:]
        if (votes == null) {
            rtn.status = NOT_FOUND
        }

        if (votes.validate() && votes.hasErrors()) {
            rtn.status = NOT_ACCEPTABLE
        }

        if (votes.save(failOnError: true, flush: true)) {
            rtn.status = OK
            rtn.votes = votes
        }

        render rtn as JSON
    }

    @Transactional
    def delete(Votes votes) {
        def rtn = [:]
        rtn.status = 405

        render rtn as JSON
    }
}
