package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	//@GeneratedValue(generator="estudiante_id_estudiante_seq", strategy=GenerationType.AUTO)
	//@SequenceGenerator(name="estudiante_id_estudiante_seq",sequenceName="public.estudiante_id_estudiante_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estudiante")
	private Integer codigoEstudiante;
	
	@Size(message="El campo no debe contener mas de 30 caractares", max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name="nombre")
	private String Nombre;
	
	@Size(message="El campo no debe contener mas de 30 caractares", max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name="apellido")
	private String Apellido;
	
	@NotNull(message="Este campo no puede estar vacio")
	@Min(value=18, message="No puede ser menor a 18")
	@Column(name="edad")
	private Integer Edad;
	
	@Column(name="estado")
	private Boolean Estado;
	
	public Estudiante() {
		
	}
	
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	
	//Delegate
	public String getEstadoDelegate() {
		if(this.Estado==null) return "";
		else {
			return Estado ==true ? "Activo":"Inactivo";
		}
	}
	

}
