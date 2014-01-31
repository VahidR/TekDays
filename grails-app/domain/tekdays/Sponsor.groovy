package tekdays

class Sponsor {
	String name
	String website
	String description
	byte[] logo // logo is an image and will be kept in DB as blob

	static hasMany = [sponsorships: Sponsorship]
	//static belongsTo = TekEvent
	
	static constraints = {
		name(blank: false)
		website(blank: false, url: true) // URL field only
		description(nullable: true, maxSize: 5000)
		logo(nullable: true, maxSize: 1000000) // maxSize is for 'blob' field size in DB 
		sponsorships(nullable: true) // we can have some sponsoprs without sponsorship info
	}

	String toString(){
		name
	}
}
