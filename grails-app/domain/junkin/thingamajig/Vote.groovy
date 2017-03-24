package junkin.thingamajig

class Vote {

    Integer vote
    String comments

    //Dates
    Date dateCreated
    Date lastUpdated

    static mapping = {
        comments sqlType: 'text'
    }

    static constraints = {
        comments size: 1..5000, nullable: true
    }
}
