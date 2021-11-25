package com.nttdata.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // Representación de la entidad modelo 
@Table(name="usuarios") //Nombre de la tabla en la bbdd
public class Usuario {
	
	@Id //Clave primaria
	@GeneratedValue(strategy= GenerationType.IDENTITY) //Auto incrementable
	private Long id;
	
	private String nombre;
	private String apellido;
	private String limite;
	private String codigoPostal;
	private String email;
	
	//Relacion 1 a 1
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Celular celular;
	
	//relacion 1 a muchos
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="proyecto_id")
	private Proyecto proyecto;
	
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre, String apellido, String limite, String codigoPostal, String email,
			Celular celular, Proyecto proyecto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.limite = limite;
		this.codigoPostal = codigoPostal;
		this.email = email;
		this.celular = celular;
		this.proyecto = proyecto;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getLimite() {
		return limite;
	}



	public void setLimite(String limite) {
		this.limite = limite;
	}



	public String getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Celular getCelular() {
		return celular;
	}



	public void setCelular(Celular celular) {
		this.celular = celular;
	}



	public Proyecto getProyecto() {
		return proyecto;
	}



	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	
}
