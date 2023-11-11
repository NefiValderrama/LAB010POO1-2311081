/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2.nefi_valderrama;

import java.util.*;
import javax.swing.*;
import java.io.*;

public class Pacientes {
    private static ArrayList<Paciente> pacientes;
    int nmroLista = 0;
    
    public int getNmroLista() {
        return nmroLista;
    }

    public void setNmroLista(int nmroLista) {
        this.nmroLista = nmroLista;
    }
    
    public Pacientes() {
        pacientes = new ArrayList<>();
        cargarArchivo();
    }

    public void registrar(Paciente paciente) {
        pacientes.add(paciente);
        guardarArchivo();
    }

    public void eliminar(Paciente paciente) {
        pacientes.remove(paciente);
        guardarArchivo();
    }
    
    public void modificarDatos() {
        for (Paciente paciente : pacientes) {
            int dni = paciente.getDni();
            int[] dividirDni = dni.split(" ");
        
            if (dividirNombre.length >= 2) {
                String nombre = dividirNombre[0];
                String apellido = dividirNombre[1];
                
                char primeraLetraApellido = Character.toUpperCase(apellido.charAt(0));
                apellido = primeraLetraApellido + apellido.substring(1);
        
                paciente.setNombre(nombre + " " + apellido);
            }
        }
    }
    
    public Paciente obtener(int pos) {
        if(pos >= 0 && pos < pacientes.size()){
            return pacientes.get(pos);
        }
        return null;
    }

    public Paciente buscar(int nmroLista) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNmroLista() == nmroLista) {
                return paciente;
            }
        }
        return null;
    }

    public int tamano() { 
	    return pacientes.size();
    }
    
    public void listarPacientes(){
        
        for (Paciente paciente : pacientes) {
            System.out.printf("%-30d%-30s%-10d%.2f%n", (nmroLista+1) + paciente.getDni(), paciente.getNombre(), paciente.getDireccion(), paciente.getPeso(), paciente.getTemperatura());
        }
    }

    public Paciente buscarNmroLista(int nmroBuscado) {
        boolean encontrado = false;

        for (Paciente paciente : pacientes) {
            nmroLista = nmroBuscado;

            if (nmroLista.equals(nmroBuscado)) {
                System.out.println(paciente.getNombre());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El paciente no está registrado.");
        }

        return null;
    }

    public void listarPensionEstudiante() {
        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante estudiante1, Estudiante estudiante2) {
                return Double.compare(estudiante1.getPension(), estudiante2.getPension());
            }
        });

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-30s%-30s%-10s%s%n", "DNI", "NOMBRE", "DIRECCION", "PESO", "TEMPERATURA");
        System.out.println("-----------------------------------------------------------------------------------");
        
        for (Paciente paciente : pacientes) {
            System.out.printf("%-30d%-30s%-10d%.2f%n", estudiante.getCodigo(), estudiante.getNombre(), estudiante.getCiclo(), estudiante.getPension());
        }

        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void listarNombresEstudiantes() {
        System.out.println("****** LISTA DE PACIENTES ********");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-30s%-30s%-10s%s%n", "DNI", "NOMBRE", "DIRECCION", "PESO", "TEMPERATURA");
        System.out.println("-----------------------------------------------------------------------------------");
    
        for (Paciente paciente : pacientes) {
            String[] nombreYApellido = paciente.getNombre().split(" ");
            String nombre = nombreYApellido[0];
            System.out.printf("%-30d%-30s%-10d%.2f%n", paciente.getDni(), paciente.getNombre(), paciente.getDireccion(), paciente.getPeso(), paciente.getTemperatura());
            
        }
    
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void listarApellidosEstudiantes() {
        System.out.println("****** LISTA DE ESTUDIANTES ********");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
        System.out.println("-----------------------------------------------------------------------------------");

        for (Paciente paciente : pacientes) {
            String[] nombreYApellido = paciente.getNombre().split(" ");
            String apellido = nombreYApellido[nombreYApellido.length - 1];
            System.out.printf("%-30d%-30s%-10d%.2f%n",paciente.getDni(), paciente.getNombre(), paciente.getDireccion(), paciente.getPeso(), paciente.getTemperatura());
        }

        System.out.println("-----------------------------------------------------------------------------------");
    }
    
    // M todos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            createPatient(st);
        }
        br.close();
    }
    
    
	// M todo que a adir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createPatient(StringTokenizer st){
        int dni = Integer.parseInt(st.nextToken().trim());
        String nombre = st.nextToken().trim();
        String direccion = st.nextToken().trim();
        double peso = Double.parseDouble(st.nextToken().trim());
        double temperatura = Double.parseDouble(st.nextToken().trim());
        Paciente paciente = new Paciente(dni, nombre, direccion, peso, temperatura);
        registrar(paciente);
    }



    // M todos para manipular el archivo de texto
    private void cargarArchivo() {
        try {
            File file = new File("C:\\Users\\Valderrama\\Documents\\NetBeansProjects\\PC2-Nefi_Valderrama\\src\\main\\java\\com\\mycompany\\pc2\\nefi_valderrama");
            Class<Pacientes> clazz = Pacientes.class;
            InputStream inputStream = clazz.getResourceAsStream("pacientes-lista.txt");
            if (file.exists()) {
                readFromInputStream(inputStream);
            } else
                JOptionPane.showMessageDialog(null,
                        "El archivo pacientes-lista.txt no existe");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }

    private void guardarArchivo() {

        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Fabian Maquen\\Desktop\\CICLO 02\\POO\\Actividades\\S11\\LAB009POOI-2311685\\ejerciciosCalificados04\\estudiantes.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            for (Paciente paciente : pacientes) {
                String linea = paciente.getDni() + "," + paciente.getNombre() + "," + paciente.getDireccion() + "," + paciente.getPeso() + "," + paciente.getTemperatura();
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }
            
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo pacientes-lista.txt");
        }
    }
}