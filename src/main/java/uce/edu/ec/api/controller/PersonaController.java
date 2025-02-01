package uce.edu.ec.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

import uce.edu.ec.api.service.IPersonaService;
import uce.edu.ec.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController{
    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/buscar")
    public PersonaTo buscarPorId() {
        Integer id = 1;
        PersonaTo persona = this.personaService.buscarPorId(id);
        return persona;
    }

    @POST
    @Path("/guardar")
    public void guardar(PersonaTo persona) {
        this.personaService.guardar(persona);
    }

    @PUT
    @Path("/actualizar")
    public void actualizar(PersonaTo persona) {
        this.personaService.actualizar(persona);
    }
    
    @PATCH
    @Path("/actualizar/parcial")   //Request body, solo puede haber uno, si quiero tener varios debo tener un objeto wraper
    //el retorno de la capacidad se pone la respuesta del body del response
    public void actualizarParcial(PersonaTo persona) {
        PersonaTo tmp = this.personaService.buscarPorId(persona.getId());
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
    }

    @DELETE
    @Path("/borrar")
    public void borrar() {
        Integer id = 1;
        this.personaService.borrar(id);
    }


}
