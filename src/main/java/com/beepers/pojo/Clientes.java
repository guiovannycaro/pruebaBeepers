package com.beepers.pojo;

public class Clientes {
	Integer id;
	String tipo;
	String númeroDocumento;
	String priNombre;
	String segNombre;
	String telefono;
	String direccion;
	String ciudad;
	
	
	public Clientes() {
	}
	
	

	public Clientes(Integer id, String tipo, String númeroDocumento, String priNombre, String segNombre,
			String telefono, String direccion, String ciudad) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.númeroDocumento = númeroDocumento;
		this.priNombre = priNombre;
		this.segNombre = segNombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getNúmeroDocumento() {
		return númeroDocumento;
	}



	public void setNúmeroDocumento(String númeroDocumento) {
		this.númeroDocumento = númeroDocumento;
	}



	public String getPriNombre() {
		return priNombre;
	}



	public void setPriNombre(String priNombre) {
		this.priNombre = priNombre;
	}



	public String getSegNombre() {
		return segNombre;
	}



	public void setSegNombre(String segNombre) {
		this.segNombre = segNombre;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	@Override
	public String toString() {
		return "Clientes [id=" + id + ", tipo=" + tipo + ", númeroDocumento=" + númeroDocumento + ", priNombre="
				+ priNombre + ", segNombre=" + segNombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", ciudad=" + ciudad + "]";
	}





	
	
	
	
}
