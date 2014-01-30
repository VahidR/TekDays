package tekdays

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TekEvent)
class TekEventSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString method"() {
    	when: "TekEvent is requested"
			def tekEvent = new TekEvent(name: 'Groovy One',
							city: 'Stockholm',
							organizer: [fullName : 'John Doe'] as TekUser)

		then: "it prints the name, followed by its city"
			tekEvent.toString() == 'Groovy One, Stockholm'
    }
}
