import tekdays.*

class BootStrap {

    def init = { servletContext ->
    
    	
	/* 
	* Initializing two TekUsers.
	* OBS. We create users first to be called in the events below :)
	*/
	new TekUser(fullName: 'John Doe', 
			userName: 'jdoe',
			password: 't0ps3cr3t',
			email: 'jdoe@johnsgroovyshop.com', 
			website: 'blog.johnsgroovyshop.com',
			bio: '''John has been programming for over 40 years. He has worked with every programming language 
				known to man and has settled on Groovy. In his spare time, 
				John dabbles in astro physics and plays shuffleboard.''').save()
	

			
	new TekUser(fullName: 'John Deere', 
			userName: 'tractorman',
			password: 't0ps3cr3t',
			email: 'john.deere@porkproducers.org',
			website: 'www.perl.porkproducers.org',
			bio: '''John is a top notch Perl programmer and a pretty
				good hand around the farm. If he can't program it he can plow it!''').save()


	
	
	/* 
	* Initializing some events
	*/
    	def event1 = new TekEvent(name: 'Gateway Code Camp',
				city: 'Saint Louis, MO',
				organizer: TekUser.findByFullName('John Doe'),
				venue: 'TBD',
				startDate: new Date('11/21/2013'),
				endDate: new Date('11/21/2013'),
				description: '''This conference will bring coders from across platforms, languages, and 
						industries together for an exciting day of tips, tricks, and tech! Stay sharp! Stay at the 
						top of your game! But, dont stay home! Come an join us this fall for the first annual 
						Gateway Code Camp.'''
				)
	
    	if(!event1.save()){ 
		event1.errors.allErrors.each{error ->
    			println "An error occured with event1: ${error}"
		}
   	 }	
				
	def event2 = new TekEvent(name: 'Perl Before Swine',
				city: 'Austin, MN',
				organizer: TekUser.findByFullName('John Deere'),
				venue: 'SPAM Museum',
				startDate: new Date('11/2/2013'),
				endDate: new Date('11/2/2013'),
				description: '''Join the Perl programmers of the Pork Producers
								of America as we hone our skills and ham it up
								a bit.  You can show off your programming chops
								while trying to win a year's supply of pork
								chops in our programming challenge.
								
								Come and join us in historic (and aromatic), Austin, Minnesota. 
								You'll know when you're there!''')			
				
	if(!event2.save()){ 
		event2.errors.allErrors.each{error ->
			println "An error occured with event2: ${error}" 
		}
	}


	/* 
	* adding some volunteers
	*/
	def sampleEvent = TekEvent.findByName('Gateway Code Camp')
	sampleEvent.addToVolunteers(new TekUser(fullName: 'Sarah Martin',
							userName: 'sarah',
							password: '54321',
							email: 'sarah@example.com',
							website: 'www.google.com',
							bio: 'a web desinger'))

	sampleEvent.addToVolunteers(new TekUser(fullName: 'Bill Smith',
							userName: 'Mr_Bill',
							password: '12345',
							email: 'mrbill@email.com',
							website: 'www.yahoo.com',
							bio: 'a savy web developer'))

	sampleEvent.addToRespondents('aaaa@aaaaa.com')						
	sampleEvent.addToRespondents('bbbb@bbbbb.com')						
	sampleEvent.addToRespondents('cccc@ccccc.com')						
	sampleEvent.addToRespondents('dddd@ddddd.com')						
	sampleEvent.addToRespondents('eeee@eeeee.com')						
	
	sampleEvent.save()

	
	/* 
	* adding some sponsors
	*/
	def sponsor1 = new Sponsor(name: 'Google',
				website: 'www.google.com',
				description: 'We are Google!')
	if(!sponsor1.save()){
		sponsorship1.error.allErrors.each{error -> println ${error}}
	}
	
	def sponsor2 = new Sponsor(name: 'Facebook',
				website: 'www.facebook.com',
				description: 'Connect people!')
	
	if(!sponsor2.save()){
		sponsorship1.error.allErrors.each{error -> println ${error}}
	}


	/* 
	* adding some sponsorships
	*/
	def sponsorship1 = new Sponsorship(event: sampleEvent,
					sponsor: sponsor1,
					contributionType: 'Other',
					description: 'Gold sponsor').save()
	if(!sponsorship1.save()){
		sponsorship1.error.allErrors.each{error -> println ${error}}
	}				
	
	def sponsorship2 = new Sponsorship(event: sampleEvent,
					sponsor: sponsor2,
					contributionType: 'Venue',
					description: 'Silver sponser')
	if(!sponsorship2.save()){
		sponsorship1.error.allErrors.each{error -> println ${error}}
	}
    
    
    }
    
    
    def destroy = {
    }
}
