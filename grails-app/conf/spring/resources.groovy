// Place your Spring DSL code here
import grails.rest.render.hal.*

beans = {
    halVotesRenderer(HalJsonRenderer, jukin.thingamajig.Votes)
}
