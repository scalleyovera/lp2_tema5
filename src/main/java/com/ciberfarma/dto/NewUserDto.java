package com.ciberfarma.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class NewUserDto {
	private String nom_usua;
	private String ape_usua;
	private String correo;
	private String clave;

	public NewUserDto(){

	}

	public NewUserDto(String nom_usua, String clave, String correo, String ape_usua) {
		this.nom_usua = nom_usua;
		this.clave = clave;
		this.correo = correo;
		this.ape_usua = ape_usua;
	}

	public String getNom_usua() {
		return nom_usua;
	}

	public void setNom_usua(String nom_usua) {
		this.nom_usua = nom_usua;
	}

	public String getApe_usua() {
		return ape_usua;
	}

	public void setApe_usua(String ape_usua) {
		this.ape_usua = ape_usua;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
