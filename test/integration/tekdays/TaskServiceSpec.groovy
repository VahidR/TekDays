package tekdays


import grails.test.mixin.TestFor
import spock.lang.Specification 

/**
 *
 */

@TestFor(TaskService) 
class TaskServiceSpec extends Specification {
	
	def taskService // inject this service class to be tested 

	def setup() {
		// create a TekUser to be injected to an event
		def user1 = new TekUser(fullName:'Tammy Tester', 
				userName:'tester' ,
				password: '12345',
				email:'tester@test.com' , 
				website:'test.com' , 
				bio:'A test person')
		if(!user1.save()){
			user1.errors.each{ println it}
		}		
	}

	def cleanup() {
	}

	void "test addDefaultTasks"() {
		when: "we pass an event to taskService.addDefaultTasks"
			def e = new TekEvent(name: 'Test Event',
				city: 'TestCity, USA',
				description: 'Test Description',
				organizer: TekUser.findByUserName('tester'), // injected TekUser from setup
				//organizer: user1, 
				venue: 'TestCenter',
				startDate: new Date(),
				endDate: new Date() + 1)
			taskService.addDefaultTasks(e)

		then: "the event will have 6 default tasks"
			e.tasks.size() == 6
	}


}
