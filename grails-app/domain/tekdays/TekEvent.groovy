package tekdays

/* 
* TekEvent: the HEART of system. The actual event of each conference..
*/
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
			sponsorships: Sponsorship,
			tasks: Task,
			messages: TekMessage]

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
		tasks(nullalbe: true)
		messages(nullable: true)

	}

	String toString(){
		"$name, $city"
	}
}
