package uce.edu.ec.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IPersonaRepository;
import uce.edu.ec.api.repository.modelo.Persona;
import uce.edu.ec.api.service.to.PersonaTo;

@ApplicationScoped
public class PersonaServiceImpl implements IPersonaService {
    @Inject
    private IPersonaRepository personaRepository;

    @Override
    public PersonaTo buscarPorId(Integer id) {
        Persona persona = this.personaRepository.buscarPorId(id);
        return this.mapTo.apply(persona);
    }

    @Override
    public void guardar(PersonaTo persona) {
        Persona per = this.mapPersona.apply(persona);
        this.personaRepository.insertar(per);
    }

    private Function<Persona, PersonaTo> mapTo = (p) -> {
        return new PersonaTo(p.getId(), p.getNombre(), p.getApellido(), p.getFechaNacimiento());
    };
    private Function<PersonaTo, Persona> mapPersona = (p) -> {
        Persona persona = new Persona();
        persona.setId(p.getId());
        persona.setNombre(p.getNombre());
        persona.setApellido(p.getApellido());
        persona.setFechaNacimiento(p.getFechaNacimiento());
        return persona;
    };

    @Override
    public void actualizar(PersonaTo persona) {
        Persona per = this.mapPersona.apply(persona);
        this.personaRepository.actualizar(per);
    }

    @Override
    public void borrar(Integer id) {
        this.personaRepository.eliminar(id);
    }

    @Override
    public List<PersonaTo> buscarTodos() {
        List<Persona> personas = this.personaRepository.buscarTodos();
        List<PersonaTo> personasTo = new ArrayList<>();
        for(Persona p : personas){
            personasTo.add(this.mapTo.apply(p));
        }
        return personasTo;
    }

    @Override
    public List<PersonaTo> buscarPorNombre(String nombre) {
        List<Persona> personas = this.personaRepository.buscarPorNombre(nombre);
        return personas.stream().map(this.mapTo).toList();
    }

    @Override
    public List<PersonaTo> buscarPorNombreYApellido(String nombre, String apellido) {
        List<Persona> personas = this.personaRepository.buscarPorNombreYApellido(nombre, apellido);
        return personas.stream().map(this.mapTo).toList();
    }

}
