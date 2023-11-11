/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pc2.nefi_valderrama;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner; 

public class PC2Nefi_Valderrama {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        int accion;
        Pacientes pacientes = new Pacientes();

        Medicos medicos = new Medicos();

        System.out.print("\n** BIENVENIDO(A) AL SISTEMA DE GESTIÓN DE PACIENTES. SELECCIONE LA OPERACIÓN A REALIZAR **\n");
        
        try{           
            System.out.print("OPERACIÓN 1-REGISTRAR PACIENTE\n" +
            "OPERACIÓN 2-ELIMINAR PACIENTE\n" +
            "OPERACIÓN 3-MODIFICAR PACIENTE\n" +
            "OPERACIÓN 4-MOSTRAR PESO MÁS REPETIDO\n" +
            "OPERACIÓN 5-MOSTRAR CANTIDAD DE PACIENTES CON PESO MÁS REPETIDO\n" +
            "OPERACIÓN 6-MOSTRAR MAYOR Y MENOR PESO\n" +
            "OPERACIÓN 7-MOSTRAR RANGOS DE PACIENTES POR PESO\n" +
            "OPERACIÓN 8-MOSTRAR PACIENTES ORDENADOS POR NOMBRES\n" +
            "OPERACIÓN 9-DOCTOR ENCARGADO\n" +
            "OPERACIÓN 10-ESPECIALIDAD DE DOCTORES\n" + 
            "\n¿Qué operación desea ejecutar?\n\n");
            
            accion = cs.nextInt();
            while (accion<1 || accion >10 ) {
                System.out.println("Ingresa nuevamente una operación válida: ");
                accion=cs.nextInt();
            }

            switch (accion) {
                
                case 1: 
                    System.out.println("****** REGISTRAR A UN NUEVO PACIENTE ******");
                    pacientes.listarPacientes();

                    int dni;
                    String nombre, direccion;
                    double peso, temperatura;

                    try {
                        System.out.print("INGRESE DNI: ");
                        cs.nextLine();
                        dni = cs.nextInt();
                        
                        System.out.print("INGRESE NOMBRE: ");
                        cs.nextLine();
                        nombre = cs.nextLine();
                            
                        System.out.print("INGRESE DIRECCIÓN: ");
                        direccion = cs.nextLine();
                        
                        System.out.print("INGRESE PESO: ");
                        peso = cs.nextDouble();
                            
                        System.out.print("INGRESE TEMPERATURA: "); 
                        temperatura = cs.nextDouble();
                                                    
                        Paciente nuevoPaciente = new Paciente(dni, nombre, direccion, peso, temperatura);
                        pacientes.registrar(nuevoPaciente);

                        System.out.println("\n¡Se añadió con éxito!");
                        
                        pacientes.listarPacientes();
                    } catch (Exception e) {
                        System.out.println("Error al ingresar datos. Asegúrese de ingresar los datos correctamente.");
                    }

                    break;

                case 2:

                    System.out.println("****** ELIMINACIÓN DEL PACIENTE ******");
                    pacientes.listarPacientes();
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("INDIQUE LA POSICIÓN EN LA LISTA DEL PACIENTE A ELIMINAR:");
                    int nmroLista=cs.nextInt()-1;
                    Paciente eliminarPaciente = pacientes.buscar(nmroLista);
                    pacientes.eliminar(eliminarPaciente);
                    System.out.println("¡Se eliminó con éxito!");
                    pacientes.listarPacientes();

                    break;
                        
                case 3: 
                    
                	System.out.println("****** MODIFICACIÓN  DEL PACIENTE ******");
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("%-30s%-30s%-10s%s%n", "DNI", "NOMBRE", "DIRECCION", "PESO", "TEMPERATURA");
                    System.out.println("-----------------------------------------------------------------------------------");
                    pacientes.listarPacientes();
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.print("INDIQUE LA POSICIÓN EN LISTA DEL PACIENTE A MODIFICAR: ");

                    int colocarNmroLista = cs.nextInt()-1;
                    if(colocarNmroLista<pacientes.tamano()){
                        //NUEVO DNI
                        System.out.print("INGRESE DNI: ");
                        int nuevoDni = cs.nextInt();
                        pacientes.buscar(colocarNmroLista).setDni(nuevoDni);
                        
                        //NOMBRE
                        System.out.print("INGRESE NOMBRE: ");
                        String nuevoNombre = cs.next();
                        pacientes.buscar(colocarNmroLista).setNombre(nuevoNombre);

                        //DIRECCIÓN
                        System.out.print("INGRESE DIRECCIÓN: ");
                        String nuevaDireccion = cs.next();
                        pacientes.buscar(colocarNmroLista).setDireccion(nuevaDireccion);

                        //PESO
                        System.out.print("INGRESE PESO: ");
                        double nuevoPeso = cs.nextDouble();
                        pacientes.buscar(colocarNmroLista).setPeso(nuevoPeso);

                        //TEMPERATURA
                        System.out.print("INGRESE TEMPERATURA: ");
                        double nuevaTemperatura = cs.nextDouble();
                        pacientes.buscar(colocarNmroLista).setTemperatura(nuevaTemperatura);
                        System.out.println("¡Se modificó con éxito!");
                        pacientes.listarPacientes();
                    }else{
                        System.out.println("Error al ingresar posición del paciente.");
                    }
                    break;

                case 4: 
                    
                    Map<Double, Integer> pesoFrecuencia = new HashMap<>();
                    
                    for (Paciente paciente : pacientes.listar()) {
                        double pesoModa = paciente.getPeso();
                        pesoFrecuencia.put(pesoModa, pesoFrecuencia.getOrDefault(pesoModa, 0) + 1);
                    }
                    double pesoMasRepetido = 0;
                    int cantidadMasRepetido = 0;

                    for (Map.Entry<Double, Integer> entry : pesoFrecuencia.entrySet()) {
                        double pesoModa = entry.getKey();
                        int cantidad = entry.getValue();

                        if (cantidad > cantidadMasRepetido) {
                            pesoMasRepetido = pesoModa;
                            cantidadMasRepetido = cantidad;
                        }
                    }

                    // Imprimir resultados
                    System.out.println("PESO MÁS REPETIDO: " + pesoMasRepetido);

                    break;

                case 5: 
                    Map<Double, Integer> pesoFrecuency = new HashMap<>();
                    for (Paciente paciente : pacientes.listar()) {
                        double pesoModa = paciente.getPeso();
                        pesoFrecuency.put(pesoModa, pesoFrecuency.getOrDefault(pesoModa, 0) + 1);
                    }

                    int cantidadMasRepetido2 = 0;

                    for (Map.Entry<Double, Integer> entry : pesoFrecuency.entrySet()) {
                        int cantidad = entry.getValue();

                        if (cantidad > cantidadMasRepetido2) {
                            cantidadMasRepetido2 = cantidad;
                        }
                    }

                    // Imprimir resultados
                    System.out.println("CANTIDAD DE PACIENTES CON PESO MÁS REPETIDO: " + cantidadMasRepetido2);

                    break;

                case 6:

                    double mayorPeso = pacientes.listar().get(0).getPeso();
                    for (Paciente paciente : pacientes.listar()) {
                        double pesoActual = paciente.getPeso();
                        if (pesoActual > mayorPeso) {
                            mayorPeso = pesoActual;
                        }
                    }
                    System.out.println("MAYOR PESO ENTRE PACIENTES:" + mayorPeso);

                    double menorPeso = pacientes.listar().get(0).getPeso();
                    for (Paciente paciente : pacientes.listar()) {
                        double pesoActual = paciente.getPeso();
                        if (pesoActual < menorPeso) {
                            menorPeso = pesoActual;
                        }
                    }
                    System.out.println("MENOR PESO ENTRE PACIENTES:" + menorPeso);

                    break;

                case 7:

                    double pesoMinimo = encontrarPesoMinimo(pacientes.listar());
                    double pesoMaximo = encontrarPesoMaximo(pacientes.listar());
        
                    double rango = (pesoMaximo - pesoMinimo) / 4;
        
                    int rango1 = 0, rango2 = 0, rango3 = 0, rango4 = 0;
        
                    for (Paciente paciente : pacientes.listar()) {
                        double pesoRangos = paciente.getPeso();
        
                        if (pesoRangos >= pesoMinimo && pesoRangos < pesoMinimo + rango) {
                            rango1++;
                        } else if (pesoRangos >= pesoMinimo + rango && pesoRangos < pesoMinimo + 2 * rango) {
                            rango2++;
                        } else if (pesoRangos >= pesoMinimo + 2 * rango && pesoRangos < pesoMinimo + 3 * rango) {
                            rango3++;
                        } else if (pesoRangos >= pesoMinimo + 3 * rango && pesoRangos <= pesoMaximo) {
                            rango4++;
                        }
                    }
        
                    System.out.println("Cantidad de personas en el rango " + pesoMinimo + " - " + (pesoMinimo + rango) + ": " + rango1);
                    System.out.println("Cantidad de personas en el rango " + (pesoMinimo + rango) + " - " + (pesoMinimo + 2 * rango) + ": " + rango2);
                    System.out.println("Cantidad de personas en el rango " + (pesoMinimo + 2 * rango) + " - " + (pesoMinimo + 3 * rango) + ": " + rango3);
                    System.out.println("Cantidad de personas en el rango " + (pesoMinimo + 3 * rango) + " - " + pesoMaximo + ": " + rango4);
                    
                    break;

                case 8:

                    pacientes.listarNombresPacientes();
                    
                    break;

                case 9:

                    System.out.println("****** SELECCIONE EL PACIENTE PARA VER EL DOCTOR QUE LO ATENDIÓ ********");
                    pacientes.listarPacientes();
                    int nmroEnLista = cs.nextInt() - 1;
                    
                    while (nmroEnLista >= 0 && nmroEnLista < pacientes.tamano()){
                        Paciente paciente = pacientes.listar().get(nmroEnLista);
                        Medico medico = pacientes.medicoPaciente(paciente);
                        
                        if (medico != null) {
                            System.out.println("El paciente " + paciente.getNombre() + " fue atendido por el médico " + medico.getNombre() + ".\n");
                        } else {
                            System.out.println("No tiene asignado un médico. Seleccione un médico de la lista:");
                            medicos.listarMedicos();
                            int nmroMedico = cs.nextInt() - 1;

                            if (nmroMedico >= 0 && nmroMedico < medicos.tamano()) {
                                medico = medicos.listar().get(nmroMedico);
                                paciente.setMedicoPaciente(medico);
                                System.out.println("El nombre del médico es " + medico.getNombre() + "\n");
                            } else {
                                System.out.println("Posición no válida.");
                            }
                        }
                        System.out.println("¿Desea continuar?\n1. Continuar \n2. Salir");
                        int continuar = cs.nextInt();
                        if(continuar == 1){
                            pacientes.listarPacientes();
                            nmroEnLista = cs.nextInt() - 1;
                        }else{
                            break;
                        }
                    } 

                    if (nmroEnLista < 0 || nmroEnLista >= medicos.tamano()) {
                        System.out.println("Posición no válida.");
                    }
                    
                    break;
                
                case 10:

                    System.out.println("MÉDICOS POR ESPECIALIDAD:\n");
                    System.out.println("Seleccione una especialidad:");
                    medicos.imprimirEspecialidades();

                    int nroLista = cs.nextInt() - 1;
                    ArrayList<String> nombreMedicos = medicos.medicosXEspecialidad(nroLista);
                    System.out.println("\nMédicos:");
                    for (String nombreMedico : nombreMedicos){
                        System.out.println(nombreMedico);
                    }
                    break;
                
                default: 
                    break;
            }
            cs.close();
        } catch (Exception e) {
            System.out.println("ERROR! ");
            System.out.println(e);
        }
    }
    private static double encontrarPesoMinimo(List<Paciente> pacientes) {
        double pesoMinimo = pacientes.get(0).getPeso();
        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            if (peso < pesoMinimo) {
                pesoMinimo = peso;
            }
        }
        return pesoMinimo;
    }

    // Método para encontrar el peso máximo
    private static double encontrarPesoMaximo(List<Paciente> pacientes) {
        double pesoMaximo = pacientes.get(0).getPeso();
        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            if (peso > pesoMaximo) {
                pesoMaximo = peso;
            }
        }
        return pesoMaximo;
    }
}