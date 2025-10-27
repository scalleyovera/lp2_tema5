package com.ciberfarma.model;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_usua;

	private String nom_usua;
	private String ape_usua;

	@Column(name = "usr_usua")
	private String correo;

	@Column(name = "cla_usua")
	private String clave;

	private Date fna_usua;
	private int idtipo = 2;
	private int est_usua = 1;

	public Usuario() {
	}

	public Usuario(String nom_usua, String ape_usua, String correo, String clave) {
		this.nom_usua = nom_usua;
		this.ape_usua = ape_usua;
		this.correo = correo;
		this.clave = clave;
	}

	public int getCod_usua() {
		return cod_usua;
	}

	public void setCod_usua(int cod_usua) {
		this.cod_usua = cod_usua;
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

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public int getEst_usua() {
		return est_usua;
	}

	public void setEst_usua(int est_usua) {
		this.est_usua = est_usua;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"cod_usua=" + cod_usua +
				", nom_usua='" + nom_usua + '\'' +
				", ape_usua='" + ape_usua + '\'' +
				", correo='" + correo + '\'' +
				", clave='" + clave + '\'' +
				", fna_usua=" + fna_usua +
				", idtipo=" + idtipo +
				", est_usua=" + est_usua +
				'}';
	}
}
