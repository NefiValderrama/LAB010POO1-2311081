/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2.nefi_valderrama;

public class Medico {

    int nmroLista = 0;
    private int nroColegiatura;
    private String nombre;
    private String especialidad;
    
    public int getNroColegiatura() {
        return nroColegiatura;
    }

    public Medico (int nroColegiatura, String nombre, String especialidad) {
        this.nroColegiatura = nroColegiatura;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public void setNroColegiatura(int nroColegiatura) {
        this.nroColegiatura = nroColegiatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public int getNmroLista() {
        return nmroLista;
    }

    public void setNmroLista(int nmroLista) {
        this.nmroLista = nmroLista;
    }
}