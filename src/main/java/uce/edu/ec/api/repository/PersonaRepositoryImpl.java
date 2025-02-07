package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.modelo.Persona;

@Transactional
@ApplicationScoped
public class PersonaRepositoryImpl implements IPersonaRepository {
    @PersistenceContext
    private EntityManager  entityManager;

    @Override
    public Persona buscarPorId(Integer id) {
        return this.entityManager.find(Persona.class, id);
    }

    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public void eliminar(Integer id) {
        Persona persona = this.entityManager.find(Persona.class, id);
        this.entityManager.remove(persona);
    }

    @Override
    public List<Persona> buscarTodos() {
        return this.entityManager.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
    }
    @Override
    public List<Persona> buscarPorNombre(String nombre) {
        return this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre", Persona.class)
                .setParameter("nombre", nombre).getResultList();
    }

    @Override
    public List<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre AND p.apellido = :apellido", Persona.class)
                .setParameter("nombre", nombre)
                .setParameter("apellido", apellido)
                .getResultList();
    }
}
