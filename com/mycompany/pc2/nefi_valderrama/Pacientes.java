/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2.nefi_valderrama;

import java.util.*;

public class Pacientes {
    private static ArrayList<Paciente> pacientes;
    
    public Pacientes() {
        pacientes = new ArrayList<>();
        cargarData();
    }

    public void registrar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void eliminar(Paciente paciente) {
        pacientes.remove(paciente);
    }
    
    public Paciente obtener(int pos) {
        if(pos >= 0 && pos < pacientes.size()){
            return pacientes.get(pos);
        }
        return null;
    }

    public ArrayList<Paciente> listar(){
        return pacientes;
    }

    public Paciente buscar(int nmroLista) {
        return obtener(nmroLista);
    }

    public void cargarData() {
        pacientes.add(new Paciente(12345678, "Ana Pérez", "Av. Principal 123 San Isidro", 65, 36.8));
        pacientes.add(new Paciente(23456789, "Juan Rodríguez", "Jr. Secundario 456 Miraflores", 70, 37.0));
        pacientes.add(new Paciente(34567890, "María Gómez", "Calle Norte 789 Surco", 65, 36.5));
        pacientes.add(new Paciente(45678901, "Laura Ruiz", "Pasaje Este 234 La Molina", 75, 37.2));
        pacientes.add(new Paciente(56789012, "Luis Torres", "Alameda Oeste 567 Barranco", 68, 36.9));
    }

    public int tamano() { 
	    return pacientes.size();
    }
    
    public void listarPacientes(){
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%-12s%-20s%-35s%-7s%s%n", "DNI", "NOMBRE", "DIRECCIÓN", "PESO", "TEMPERATURA");
        System.out.println("---------------------------------------------------------------------------------------");
        
        int nmroLista = 0;
        for (Paciente paciente : pacientes) {
            System.out.printf("%-2s%-10s%-20s%-35s%-7s%-7s%n", (nmroLista+1), paciente.getDni(), paciente.getNombre(), paciente.getDireccion(), paciente.getPeso(), paciente.getTemperatura());
            nmroLista++;
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public Paciente buscarNmroLista(int nmroBuscado) {
        boolean encontrado = false;

        for (Paciente paciente : pacientes) {

            if (paciente.getNmroLista()==nmroBuscado) {
                System.out.println(paciente.getNmroLista());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El paciente no está registrado.");
        }

        return null;
    }

    public void listarNombresPacientes() {
        System.out.println("****** LISTA DE PACIENTES POR NOMBRES ******");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-12s%-20s%-35s%-7s%s%n", "DNI", "NOMBRE", "DIRECCIÓN", "PESO", "TEMPERATURA");
        System.out.println("-----------------------------------------------------------------------------------");
        
        int nmroLista = 0;
        for (Paciente paciente : pacientes) {
            String[] nombres = paciente.getNombre().split(" ");
            String nombre = nombres[0];
            System.out.printf("%-2s%-10s%-20s%-35s%-7s%-7s%n", (nmroLista+1), paciente.getDni(), nombre, paciente.getDireccion(), paciente.getPeso(), paciente.getTemperatura());
            nmroLista++;
        }
    
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public Medico medicoPaciente(Paciente paciente) {
        Medico medico = paciente.getMedicoPaciente();
        return medico;
    }
}