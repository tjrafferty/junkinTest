package junkin.thingamajig

class ThingaTagLib {
    static defaultEncodeAs = "raw"
    static namespace = 'thinga'
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]


    def truncateHtml = { attrs, body ->
        def content = attrs.value ?: ''
        content = content.decodeHTML().replaceAll("<(.|\n)*?>", '')

        def contentLength = attrs.length?.toInteger() ?: 500
        if (content.size() > contentLength) {
            out << content.substring(0, contentLength) + "..."
            // works like an "if" tag with test = is content too long
            def bodyContent = body(size: content.size())
            out << bodyContent
        } else {
            out << content

        }
    }

}
