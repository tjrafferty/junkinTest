package jukin.thingamajig

import grails.transaction.Transactional

@Transactional
class QuoteService {

    def getStaticQuote() {
        return new Quote(
                content: "you know, a thing, a thingy, the unrememberable... I think?")
    }

    def getRandomQuote() {
        def allQuotes = Quote.list()
        def randomQuote = null
        if (allQuotes.size() > 0) {
            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]
        } else {
            randomQuote = getStaticQuote()
        }
        return randomQuote
    }


}
