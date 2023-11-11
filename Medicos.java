/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2.nefi_valderrama;

import java.util.*;

public class Medicos {
    private static ArrayList<Medico> medicos;
    
    public Medicos() {
        medicos = new ArrayList<>();
        cargarData();
    }
    
    public Medico obtener(int pos) {
        if(pos >= 0 && pos < medicos.size()){
            return medicos.get(pos);
        }
        return null;
    }

    public ArrayList<Medico> listar(){
        return medicos;
    }

    public Medico buscar(int nmroLista) {
        return obtener(nmroLista);
    }

    public void cargarData() {
        medicos.add(new Medico(12345, "Dr. Ana Ramírez", "Cardiología"));
        medicos.add(new Medico(23456, "Dr. Juan Martínez", "Dermatología"));
        medicos.add(new Medico(34567, "Dra. María González", "Gastroenterología"));
        medicos.add(new Medico(45678, "Dr. Luis Rodríguez", "Ortopedia"));
        medicos.add(new Medico(56789, "Dra. Laura Pérez", "Pediatría"));
    }

    public int tamano() { 
	    return medicos.size();
    }
    
    public void listarMedicos(){
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-15s%-7s%n", "NRO. COLEGIATURA", "NOMBRE", "ESPECIALIDAD");
        System.out.println("---------------------------------------------------------------------------------------");
        
        int nmroLista = 0;
        for (Medico medico : medicos) {
            System.out.printf("%-2s%-20s%-20s%-20s%n", (nmroLista+1), medico.getNroColegiatura(), medico.getNombre(), medico.getEspecialidad());
            nmroLista++;
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public ArrayList<String> listarEspecialidades(){
        ArrayList<String> especialidades = new ArrayList<String>();
        for (Medico medico: medicos) {
            especialidades.add(medico.getEspecialidad());
        }
        return especialidades;
    }

    public void imprimirEspecialidades(){
        int nmroLista = 1;
        ArrayList<String> especialidades = listarEspecialidades();
        for (String especialidad : especialidades) {
            System.out.println(nmroLista + " " + especialidad);
            nmroLista++;
        }
    }

    public String buscarEspecialidad(int nroLista){
        ArrayList<String> especialidades = listarEspecialidades();
        String especialidad = especialidades.get(nroLista);
        return especialidad;
    }

    public ArrayList<String> medicosXEspecialidad(int nroLista){
        ArrayList<String> medicosEspecialidades = new ArrayList<String>();
        String especialidad = buscarEspecialidad(nroLista);
        for (Medico medico: medicos) {
            if(medico.getEspecialidad() == especialidad){
                medicosEspecialidades.add(medico.getNombre());
            }
        }
        return medicosEspecialidades;
    }

    public Medico buscarNmroLista(int nmroBuscado) {
        boolean encontrado = false;

        for (Medico medico : medicos) {

            if (medico.getNmroLista()==nmroBuscado) {
                System.out.println(medico.getNmroLista());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El médico no está registrado.");
        }

        return null;
    }
}