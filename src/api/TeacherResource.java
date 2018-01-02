package api;

import dao.TeacherDAO;
import model.Teacher;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/teacher")
public class TeacherResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(Teacher t){
        TeacherDAO.save(t);
    }

    @DELETE
    @Path("/{id}")
    public void Delete(@PathParam("id") String id){
        TeacherDAO.delete(Integer.parseInt(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void Update(Teacher t){
        TeacherDAO.update(t);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void get(@PathParam("id") String id){
        TeacherDAO.getEmployeeById(Integer.parseInt(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getAll(){
        TeacherDAO.getAllEmployees();
    }
}
