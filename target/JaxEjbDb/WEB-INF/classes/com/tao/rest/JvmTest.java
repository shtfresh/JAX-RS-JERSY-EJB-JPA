package com.tao.rest;



import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tao.bean.Person;
import com.tao.service.PersonServiceBean;

import java.util.HashMap;

@Path("myresource")
public class JvmTest {

	//PersonServiceBean personServiceBean = new PersonServiceBean();
	
	@EJB
    private transient PersonServiceBean personServiceBean;
	
    @GET
    @Path("/sayhello")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHelloWorld() {
        return "hello,world!";
    }
    
    @GET
    @Path("/getPersonByIdJson")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByIdJson() {
        return "{\"age\":70,\"gender\":\"M\",\"height\":188,\"id\":1000,\"name\":\"JSON\"}";
    }
    

    
    
    @GET
    @Path("/getPersonById/{personid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("personid") Integer personid) {
    	
    	return personServiceBean.getPerson(personid);
    }
    
    
    @POST
    @Path("/updatePerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
  
    public String updatePerson(Person person) {
     	// System.out.print(person.toString());
    	 personServiceBean.update(person);
  
    	 return "update success";
    }
    
    @POST
    @Path("/insertPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertPerson(Person person) {
    	
    	 personServiceBean.save(person);
    	 
    	 return "insert success";
    }
    
    
}
