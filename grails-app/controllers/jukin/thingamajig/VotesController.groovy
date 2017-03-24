package jukin.thingamajig

import grails.rest.RestfulController
import grails.transaction.Transactional

class VotesController extends RestfulController {

    static responseFormats = ['json']
    VotesController( ) {
        super(Votes)
    }

/*
    def index(Integer max) {
        respond Votes.list(params), model: [VotesCount: Votes.count()]
    }

    def show(Votes votes) {
        if (votes == null) {
            render status: 404
        } else {
            return [votes: votes]
        }
    }

    @Transactional
    def save(Votes votes) {

    }

    @Transactional
    def update(Votes votes) {

    }
*/

}
