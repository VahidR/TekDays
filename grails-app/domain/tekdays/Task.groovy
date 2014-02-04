package tekdays

/* 
* Task: the list of tasks for making a Event prepared
*/
class Task {
	String title
	String notes
	Date dueDate
	TekUser assignTo
	TekEvent event
	Boolean completed

	static belongsTo = TekEvent

	static constraints = {
		title(blank: false)
		notes(blank: true, nullable: true, maxSize: 5000)
		assignTo(nullable: true)
		dueDate(nullable: true)
		completed(nullable: true)
	}
}
