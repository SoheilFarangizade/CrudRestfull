package api;

import dao.StudentDAO;
import model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/student")
public class StudentResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(Student s){
        StudentDAO.save(s);
    }

    @DELETE
    @Path("/{id}")
    public void Delete(@PathParam("id") String id){
        StudentDAO.delete(Integer.parseInt(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void Update(Student t){
        StudentDAO.update(t);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void get(@PathParam("id") String id){
        StudentDAO.getEmployeeById(Integer.parseInt(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getAll(){
        StudentDAO.getAllEmployees();
    }
}
