package jukin.thingamajig

class Votes {
    String voteValue
    String comment
    String repoUrl
    String name
    String repoId

    //Dates
    Date dateCreated
    Date lastUpdated

    static mapping = {
        comment sqlType: 'text'
    }

    static constraints = {
        comment size: 1..5000, nullable: true
    }

}
