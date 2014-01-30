package tekdays

class TekEvent {
	String name
	String city 
	String organizer
	String venue
	Date startDate
	Date endDate
	String description 

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
