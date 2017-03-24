package junkin.thingamajig

class Repo {

    static hasMany = [votes: Vote]

    String repoId
    String name

    //Dates
    Date dateCreated
    Date lastUpdated

    static constraints = {
        repoId unique: true
    }
}
