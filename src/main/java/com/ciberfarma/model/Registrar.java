package com.ciberfarma.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
public class Registrar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usua")
	private int id;

	@Column(name = "nom_usua", nullable = false, length = 50)
	private String nom_usua;

	@Column(name = "ape_usua", nullable = false, length = 50)
	private String ape_usua;

	@Column(name = "usr_usua", nullable = false, unique = true, length = 100)
	private String correo;

	@Column(name = "cla_usua", nullable = false, length = 100)
	private String clave;

	@Column(name = "fna_usua", nullable = false)
	private Date fna_usua;

	// Constructores
	public Registrar() {
	}

	public Registrar(String nom_usua, String ape_usua, String correo, String clave, Date fna_usua) {
		this.nom_usua = nom_usua;
		this.ape_usua = ape_usua;
		this.correo = correo;
		this.clave = clave;
		this.fna_usua = fna_usua;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getFna_usua() {
		return fna_usua;
	}

	public void setFna_usua(Date fna_usua) {
		this.fna_usua = fna_usua;
	}
}
