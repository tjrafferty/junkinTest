package jukin.thingamajig

class Quote {

    String content

    static constraints = {
        content(blank: false)
    }
}
