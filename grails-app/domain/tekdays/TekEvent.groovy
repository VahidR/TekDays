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
	}

	String toString(){
		"$name, $city"
	}
}
