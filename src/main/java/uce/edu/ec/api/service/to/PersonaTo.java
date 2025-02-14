package uce.edu.ec.api.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uce.edu.ec.api.LocalDateTimeAdapter;

@XmlRootElement
public class PersonaTo implements Serializable{
    private Integer id;
    private String nombre;
    private String apellido;
    
    private LocalDateTime fechaNacimiento;
    
    
    public PersonaTo() {
    }
    
    public PersonaTo(Integer id, String nombre, String apellido, LocalDateTime fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters and Setters
    @XmlElement
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    @XmlElement
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
