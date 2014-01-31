package tekdays

class Sponsorship {
	TekEvent event
	Sponsor sponsor
	String contributionType
	String description
	String notes

	static constraints = {
		event(nullable: false)
		sponsor(nullable: false)
		contributionType(inList: ["Other", "Venue", "A/V", "Promotion", "Cash"]) // just one of these types. types are Stings
		description(nullable: true, blank: true, maxSize: 500)
		notes(nullable:true, blank: true, maxSize: 5000)
	}
}
