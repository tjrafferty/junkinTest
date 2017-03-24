package jukin.thingamajig

import jukin.thingamajig.Votes

class Repo {

    static hasMany = [votes: Votes]

    String repoId
    String name

    //Dates
    Date dateCreated
    Date lastUpdated

    static constraints = {
        repoId unique: true
    }
}
