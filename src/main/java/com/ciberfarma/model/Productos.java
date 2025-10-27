package com.ciberfarma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_productos")
public class Productos {

    @Id
    @Column(name = "id_prod")
    private String idProd;

    @Column(name = "des_prod")
    private String desProd;

    @Column(name = "stk_prod")
    private int stkProd;

    @Column(name = "pre_prod")
    private double preProd;

    @Column(name = "est_prod")
    private int estProd;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;


    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getDesProd() {
        return desProd;
    }

    public void setDesProd(String desProd) {
        this.desProd = desProd;
    }

    public int getStkProd() {
        return stkProd;
    }

    public void setStkProd(int stkProd) {
        this.stkProd = stkProd;
    }

    public double getPreProd() {
        return preProd;
    }

    public void setPreProd(double preProd) {
        this.preProd = preProd;
    }

    public int getEstProd() {
        return estProd;
    }

    public void setEstProd(int estProd) {
        this.estProd = estProd;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
