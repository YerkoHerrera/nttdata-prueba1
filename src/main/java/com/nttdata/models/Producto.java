package com.nttdata.models;

public class Producto {
	
	private Integer codigo;
	private String nombre;
	private String tipo;
	
	public Producto() {
		super();
	}

	public Producto(Integer codigo, String nombre, String tipo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
