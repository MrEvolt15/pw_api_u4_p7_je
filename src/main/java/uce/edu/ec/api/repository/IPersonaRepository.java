package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Persona;

public interface IPersonaRepository {
    public Persona buscarPorId(Integer id);
    public List<Persona> buscarTodos();
    public List<Persona> buscarPorNombre(String nombre);
    public List<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    public void insertar(Persona persona);
    public void actualizar(Persona persona);
    public void eliminar(Integer id);
}
