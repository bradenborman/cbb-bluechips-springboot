import spock.lang.Specification
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document

class JSoupTest extends Specification {

    def 'JSoupTest Parse Test'() {
        given: ''
            String htmlString = "<html><head><title>My title</title></head><body>Body content</body></html>";
        when: ''
            Document doc = Jsoup.parse(htmlString);
            String title = doc.title();
            String body = doc.body().text();

        then: ''
            title == "My title"
            body == "Body content"
    }

}
