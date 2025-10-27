package com.ciberfarma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LoginUserDto {

	public String correo;
	public String clave;

	public LoginUserDto(){

	}

	public LoginUserDto(String correo, String clave) {
		this.correo = correo;
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
