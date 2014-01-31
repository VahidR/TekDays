package tekdays

/*
* TekMessage: the message that volunteers and sopnsors send in a forum to talk about the events, etc.
*/
class TekMessage {
	String subject
	String content
	TekMessage parent // interesting .. for a hierechical replying stuff 
	TekEvent event
	TekUser author

	static belongsTo = TekEvent

	static constraints = {
		subject(blank: false)
		content(blank: false, maxSize: 2000)
		parent(nullable: true) // the fist message without reply
		author(nullable: false)
	}


}
