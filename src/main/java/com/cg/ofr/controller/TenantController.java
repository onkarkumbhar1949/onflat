package com.cg.ofr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.service.TenantService;

import io.swagger.annotations.Api;



/*
 * Description     It is a controller class that controls the
 *                 data flow into model object and used to get response for
 *                 add,update,delete and view the tenant detail. 
*/
@Api(value = "SwaggerDemoRestController")
@RestController
public class TenantController {

	@Autowired
	private TenantService iTenantService;
	
	/*
	 * Method: 					 addTenant
	 * Description: 			 This method is used for add the tenant.
	 * @param tenant: 		     Tenant's reference variable.
	 * @returns tenant           It returns Tenant with details
	 * @PostMapping:             It is used to handle POST type of request method
	 * @RequestBody:             It maps the HttpRequest body to a transfer or domain object
	 */

	@PostMapping("/tenant")
	public Tenant addTenant(@Valid @RequestBody Tenant tenant) {
		Tenant tenant2 = null;
		tenant2 = this.iTenantService.addTenant(tenant);
		return tenant2;
	}
	
	/*
	 * Method: 					 updateTenant
	 * Description: 		   	 This method is used for update the tenant
	 * @param tenant: 		     Tenant's reference variable.
	 * @returns tenant           It returns updated details of existed Tenant 
	 * @PuttMapping: 		     It is used to handle PUT type of request method
	 * @RequestBody: 		     It maps the HttpRequest body to a transfer or domain object
	 */

	@PutMapping("/tenant")
	public Tenant updateTenant(@Valid @RequestBody Tenant tenant) {
		Tenant tenant2 = null;
		tenant2 = this.iTenantService.updateTenant(tenant);
		return tenant2;
	}
	
	/*
	 * Method: 					 deleteTenant
	 * Description: 			 This method is used to delete the tenant
	 * @param tenant: 		     Tenant's reference variable.
	 * @returns tenant           It returns Tenant that has been deleted 
	 * @DeleteMapping:           It is used to handle DELETE type of request method.
	 * @RequestBody:             It maps the HttpRequest body to a transfer 
	 						     or domain object
	 */
	
	@DeleteMapping("/tenant")
	public Tenant deleteTenant(@Valid @RequestBody Tenant tenant) {
		Tenant tenant2 = null;
		tenant2 = this.iTenantService.deleteTenant(tenant);
		return tenant2;
	}
	
	/*
	 * Method: 			                          viewTenant
	 * Description: 	                          This method is used for find tenant id and it return the details for specific id 
	 * @param id: 		                          id of the Tenant.
	 * @returns tenant                            It returns Tenant if tenant with id present else throws EntityNotFoundException
	 * @throws TenantNotFoundException            It is raised due to invalid TenantId
	 * @GetMapping:                               It is used to handle GET type of request method.
	 * @PathVariable:                             It is used for data passed in the URI and transfer its values
	                                              to parameter variables. 
	 */

	@GetMapping("/tenant/{id}")
	public Tenant viewTenant(@PathVariable("id") Integer id) throws TenantNotFoundException {
		return this.iTenantService.viewTenant(id);
	}

		/*
		 * Method: 				       viewAllTenants 
		 * Description: 		       This method is used for view all tenant details
		 * @returns List<Tenant >      It returns all the tenants present in database
		 * @GetMapping: 		       It is used to handle GET type of request method.
		 */

	@GetMapping("/tenants")
	public List<Tenant> viewAllTenant() {
		return this.iTenantService.viewAllTenant();
	}

	/*
	 * Method: 						   validateTenant
	 * Description: 				   This method is used for find exists tenant id
	 * @param tenant: 		           Tenant's reference variable.
	 * @throws TenantNotFoundException 
	 * @returns tenant                 It returns Tenant if it exist in database
	 * @DeleteMapping:                 It is used to handle GET type of request method.
	 * @RequestBody:                   It maps the HttpRequest body to a transfer 
	 								   or domain object
	 */
	@PutMapping("/tenantexist")
	public Tenant validateTenant(@RequestBody Tenant tenant) throws TenantNotFoundException {
		Tenant tenant2 = null;
		tenant2 = this.iTenantService.validateTenant(tenant);
		return tenant2;
	}

}