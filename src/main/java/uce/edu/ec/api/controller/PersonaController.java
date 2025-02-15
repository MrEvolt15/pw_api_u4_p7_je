package uce.edu.ec.api.controller;

import java.util.List;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.service.IPersonaService;
import uce.edu.ec.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {
    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    // http://localhost:8081/matriculaAPI/v1.1/personas/1
    public Response buscarPorId(@PathParam("id") Integer id) {

        //                        header, se pone el mensaje referente al codigo de estado personalizado
        return Response.status(240).header("mensaje", "persona creada pero en validacion").header("valor1", 500)
        .entity(this.personaService.buscarPorId(id)).build();
        //return Response.status(Response.Status.OK).entity(this.personaService.buscarPorId(id)).build();
        //return Response.ok(this.personaService.buscarPorId(id)).build();
        //return this.personaService.buscarPorId(id);
    }

    @GET
    @Path("")
    // http://localhost:8080/matriculaAPI/v1.1/personas
    public List<PersonaTo> buscarTodos() {
        return this.personaService.buscarTodos();
    }

    @GET
    @Path("/porNombre")
    // http://localhost:8080/matriculaAPI/v1.1/personas/porNombre?nombre=Estuardo
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
        
        return this.personaService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porNombreYApellido")
    // http://localhost:8080/matriculaAPI/v1.1/personas/porNombreYApellido?nombre=Estuardo&apellido=Achig
    public List<PersonaTo> buscarPorNombreYApellido(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido) {
        return this.personaService.buscarPorNombreYApellido(nombre, apellido);
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    // http://localhost:8080/matriculaAPI/v1.1/personas
    public void guardar(PersonaTo persona){
        this.personaService.guardar(persona);
    }
    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTo persona,@PathParam("id")Integer id){
        persona.setId(id);
        this.personaService.actualizar(persona);
    }
    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonaTo actualizarParcial(PersonaTo persona,@PathParam("id")Integer id){
        PersonaTo tmp = this.personaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
        return tmp;
    }
    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id")Integer id){
        this.personaService.borrar(id);
    }

}
