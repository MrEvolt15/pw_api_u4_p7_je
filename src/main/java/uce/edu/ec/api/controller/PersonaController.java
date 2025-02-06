package uce.edu.ec.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

    @POST
    @Path("")
    public void guardar(PersonaTo persona) {
        this.personaService.guardar(persona);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTo persona, @PathParam("id") Integer id) {
        PersonaTo tmp = this.personaService.buscarPorId(id);
        tmp.setId(persona.getId());
        this.personaService.actualizar(tmp);
    }
    
    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTo persona, @PathParam("id") Integer id,@PathParam("cedula") String cedula) {
        PersonaTo tmp = this.personaService.buscarPorId(persona.getId());
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
    }

    @DELETE
    @Path("")
    public void borrar() {
        Integer id = 1;
        this.personaService.borrar(id);
    }

}
