package uce.edu.ec.api.repository;

import uce.edu.ec.api.repository.modelo.Persona;

public interface IPersonaRepository {
    public Persona buscarPorId(Integer id);
    public void insertar(Persona persona);
    public void actualizar(Persona persona);
    public void eliminar(Integer id);
}
