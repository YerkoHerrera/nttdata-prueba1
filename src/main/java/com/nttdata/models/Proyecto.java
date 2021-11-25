package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto {
	
	@Id //Clave primaria
	@GeneratedValue(strategy= GenerationType.IDENTITY) //Auto incrementable
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	@Column(updatable = false)
	private Date createAt;
	private Date updateAt;
	//relacion 1 a muchos
	@OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;
	
	//constructores
	public Proyecto() {
		super();
	}
	
	public Proyecto(String nombre, String descripcion, Date createAt, Date updateAt) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.createAt = createAt;
		this.updateAt = updateAt;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createAt = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updateAt = new Date();
    }

}
