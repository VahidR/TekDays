package tekdays

class TekEvent {
	String name
	String city 
	String venue
	Date startDate
	Date endDate
	String description 
	TekUser organizer

	static hasMany = [volunteers: TekUser, 
			respondents: String, 
			sponsorships: Sponsorship]

	static constraints = {
		name()
		city()
		description(maxSize: 5000)
		organizer()
		venue()
		startDate()
		endDate()
		volunteers(nullable: true)
		sponsorships(nullable: true)

	}

	String toString(){
		"$name, $city"
	}
}
