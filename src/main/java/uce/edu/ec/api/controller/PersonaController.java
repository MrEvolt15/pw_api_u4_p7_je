package uce.edu.ec.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import uce.edu.ec.api.service.IPersonaService;
import uce.edu.ec.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {
    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/{id}")
    public PersonaTo buscarPorId(@PathParam("id") Integer id) {
        
        return this.personaService.buscarPorId(id);
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
    @Path("porNombreYApellido")
    // http://localhost:8080/matriculaAPI/v1.1/personas/porNombreYApellido?nombre=Estuardo&apellido=Achig
    public List<PersonaTo> buscarPorNombreYApellido(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido) {
        return this.personaService.buscarPorNombreYApellido(nombre, apellido);
    }

    @POST
    @Path("")
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
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTo persona,@PathParam("id")Integer id, @PathParam("cedula") String cedula){
        System.out.println("cedula: " + cedula);
        PersonaTo tmp = this.personaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
    }
    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id")Integer id){
        this.personaService.borrar(id);
    }

}
