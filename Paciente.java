/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2.nefi_valderrama;

public class Paciente {
    
    private int dni;
    private String nombre;
    private String direccion;
    private double peso;
    private double temperatura;
    private Médico medicoPaciente;

    public Médico getMedicoPaciente() {
        return medicoPaciente;
    }

    public void setMedicoPaciente(Médico medicoPaciente) {
        this.medicoPaciente = medicoPaciente;
    }
    
    public Paciente (int dni, String nombre, String direccion, double peso, double temperatura) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.peso = peso;
                this.temperatura = temperatura;
	}

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
	return "Paciente:" +
		"DNI=" + dni +
		", nombre=" + nombre +
		", dirección='" + direccion +
		", peso=" + peso +
                ", temperatura= " + temperatura;
	}
}