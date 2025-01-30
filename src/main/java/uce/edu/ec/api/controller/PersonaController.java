package uce.edu.ec.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.service.IPersonaService;
import uce.edu.ec.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController{
    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/buscar")
    public Response buscarPorId(){
        Integer id = 1;
        PersonaTo persona= this.personaService.buscarPorId(id);
        System.out.println(persona.getNombre());
        return Response.ok(this.personaService.buscarPorId(id)).build();
    }
    
    public void guardar(PersonaTo persona){
        this.personaService.guardar(persona);
    }
    
    public void actualizar(PersonaTo persona){
        this.personaService.actualizar(persona);
    }
    
    public void borrar(Integer id){
        this.personaService.borrar(id);
    }


}
