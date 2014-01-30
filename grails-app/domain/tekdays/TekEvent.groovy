package tekdays

class TekEvent {
	String name
	String city 
	String venue
	Date startDate
	Date endDate
	String description 
	TekUser organizer

	static hasMany = [volunteers: TekUser]

	static constraints = {
		name()
		city()
		description(maxSize: 5000)
		organizer()
		venue()
		startDate()
		endDate()

	}

	String toString(){
		"$name, $city"
	}
}
