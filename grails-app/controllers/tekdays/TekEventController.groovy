package tekdays



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

// Transactional means that it has to deal with DB
@Transactional(readOnly = true)
class TekEventController {

    def taskService // declaring and injecting TaskService
    
    //RESTful controller ?
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100) // making sure that we get 100 entries in max
        // view: index
	// By convention, Grails creates tekEventInstance as the contex variable;
	// so for instance, tekEventInstanceList is also a convention.
	//tekEventInstanceCount : another context variable derived from model, for pagination
	respond TekEvent.list(params), model:[tekEventInstanceCount: TekEvent.count()]
    }

    def show(TekEvent tekEventInstance) {
	// view: show
	// tekEventInstace == tekEventInstance.id in tekEvent/index.gsp page
        respond tekEventInstance
    }

    def create() {
	// view: create
        respond new TekEvent(params)
    }

    @Transactional // it is NOT read-only anymore
    def save(TekEvent tekEventInstance) {
        if (tekEventInstance == null) {
            notFound()
            return
        }

        if (tekEventInstance.hasErrors()) {
            respond tekEventInstance.errors, view:'create' // pass the errors to create view, with Error messages.
            return
        }

        tekEventInstance.save flush:true
	taskService.addDefaultTasks(tekEventInstance) // now add the default tasks for each event after being sure that event has created and has no error

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tekEventInstance.label', default: 'TekEvent'), tekEventInstance.id])
                redirect tekEventInstance
            }
            '*' { respond tekEventInstance, [status: CREATED] }
        }
    }

    def edit(TekEvent tekEventInstance) {
        respond tekEventInstance
    }

    @Transactional
    def update(TekEvent tekEventInstance) {
        if (tekEventInstance == null) {
            notFound()
            return
        }

        if (tekEventInstance.hasErrors()) {
            respond tekEventInstance.errors, view:'edit'
            return
        }

        tekEventInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TekEvent.label', default: 'TekEvent'), tekEventInstance.id])
                redirect tekEventInstance
            }
            '*'{ respond tekEventInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TekEvent tekEventInstance) {

        if (tekEventInstance == null) {
            notFound()
            return
        }

        tekEventInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TekEvent.label', default: 'TekEvent'), tekEventInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekEventInstance.label', default: 'TekEvent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
