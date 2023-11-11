/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pc2.nefi_valderrama;

import java.util.Scanner; 

public class PC2Nefi_Valderrama {
    private static final Scanner cs = new Scanner(System.in);
    public static void main(String[] args) {
        int accion;
        Pacientes estudiantes = new Pacientes();
        
        System.out.print("\n** BIENVENIDO(A) AL SISTEMA DE GESTIÓN DE PACIENTES. SELECCIONE LA OPERACIÓN A REALIZAR **\n");

        try {
            do {
                System.out.print("OPERACIÓN 1-REGISTRAR PACIENTE\n" +
                "OPERACIÓN 2-ELIMINAR PACIENTE\n" +
                "OPERACIÓN 3-MODIFICAR PACIENTE\n" +
                "OPERACIÓN 4-BUSCAR PACIENTE\n" +
                "OPERACIÓN 5-MOSTRAR PESO MÁS REPETIDO\n" +
                "OPERACIÓN 6-MOSTRAR CANTIDAD DE PACIENTES CON PESO MÁS REPETIDO\n" +
                "OPERACIÓN 7-MOSTRAR MAYOR Y MENOR PESO\n" +
                "OPERACIÓN 8-TOTAL DE PENSIONES\n" +
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
                        System.out.println("****** REGISTRAR A UN NUEVO PACIENTE ********");

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
                            estudiantes.registrar(nuevoPaciente);
                            
                            System.out.println("¡Se añadió con éxito!");
                            
                        } catch (Exception e) {
                            System.out.println("Error al ingresar datos. Asegúrese de ingresar los datos correctamente.");
                        }

                        break;

                    case 2:

                        System.out.println("****** ELIMINACIÓN DEL PACIENTE ********");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "DNI", "NOMBRE", "DIRECCION", "PESO", "TEMPERATURA");
                        System.out.println("-----------------------------------------------------------------------------------");
                        estudiantes.listarPacientes();
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("INDIQUE LA POSICIÓN EN LA LISTA DEL PACIENTE A ELIMINAR:");
                        // Código del estudiante a eliminar
                        int nmroLista=cs.nextInt();
                        Paciente pacienteEncontrado = pacientes.buscarNmroLista(nmroLista);
                        Paciente eliminarPaciente = pacientes.buscar(nmroLista);
                        estudiantes.eliminar(eliminarPaciente);
                        System.out.println("¡Se eliminó con éxito!");

                        break;
                        
                    case 3: 
                        
                    	System.out.println("****** MODIFICACIÓN  DEL PACIENTE ********");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "DNI", "NOMBRE", "DIRECCION", "PESO", "TEMPERATURA");
                        System.out.println("-----------------------------------------------------------------------------------");
                        pacientes.listarPacientes();
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.print("INDIQUE LA POSICIÓN EN LISTA DEL PACIENTE A MODIFICAR: ");

                        int colocarNmroLista = cs.nextInt();

                        System.out.print("INGRESE DNI: ");
                        int nuevoDni= cs.nextInt();
                        pacientes.buscar(colocarNmroLista).setDni(nuevoDni);
                        System.out.print("INGRESE NOMBRE: ");
                        String nuevaDireccion = cs.next();
                        System.out.print("INGRESE DIRECCION: ");
                        String nuevoApellido= cs.next();
                        String nombreYapellido = nuevoNombre +" " +  nuevoApellido;
                        estudiantes.buscar(colocarNmroLista).setNombre(nombreYapellido);
                        //CICLO
                        System.out.print("INGRESE CICLO: ");
                        int nuevoCiclo= cs.nextInt();
                        estudiantes.buscar(colocarNmroLista).setCiclo(nuevoCiclo);

                        //PENSION
                        System.out.print("INGRESE PENSIÓN: ");
                        double nuevaPension= cs.nextDouble();
                        estudiantes.buscar(buscarNmroLista).setPension(nuevaPension);
                        System.out.println("¡Se modificó con éxito!");
                        estudiantes.listarPacientes();

                        break;

                    case 4: 

                        System.out.println("****** BUSCAR A UN ESTUDIANTE ********");
                    	System.out.println("PUEDE BUSCAR POR NOMBRE O CODIGO. ELEGIR UNA OPCIÓN:");
                    	System.out.println("A - APELLIDO");
                    	System.out.println("B - CODIGO");

                    	char opcion = cs.next().charAt(0);

                    	if (opcion == 'A') {
                    	    System.out.print("INGRESE EL APELLIDO DEL ALUMNO: ");
                            cs.nextLine();
                    	    String nombre1 = cs.nextLine();
                    	    
                    	    Estudiante estudianteEncontrado = estudiantes.buscarNombre(nombre1);
                            
                            if (estudianteEncontrado != null) {
                                System.out.println("El alumno es: " + estudianteEncontrado.getNombre());
                            } else {
                                System.out.println("El alumno no está registrado.");
                            }
                    	 
                    	} else if (opcion == 'B') {
                    	    System.out.println("INGRESE EL CÓDIGO DEL ALUMNO:");

                    	    try {
                    	        int codigo = Integer.parseInt(cs.nextLine());

                    	        Estudiante estudianteEncontrado = estudiantes.buscar(codigo);

                    	        if (estudianteEncontrado != null) {
                    	            System.out.println("El alumno es: " + estudianteEncontrado.getNombre() + " " + estudianteEncontrado.getCodigo());
                    	        } else {
                    	            System.out.println("El alumno no está registrado.");
                    	        }
                    	    } catch (NumberFormatException e) {
                    	        System.out.println("Error con el codigo del alumno: " + e.getMessage());
                    	    }
                    	} else {
                    	    System.out.println("Opción no válida.");
                    	}

                        break;

                    case 5: 
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "DNI", "NOMBRE", "DIRECCION", "PESO", "TEMPERATURA");
                        System.out.println("-----------------------------------------------------------------------------------");
                        estudiantes.listarEstudiantes();
                        System.out.println("-----------------------------------------------------------------------------------");
                        
                        estudiantes.modificarApellidos();
                        System.out.println("LA NUEVA LISTA:");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
                        System.out.println("-----------------------------------------------------------------------------------");
                        estudiantes.listarEstudiantes();
                        System.out.println("-----------------------------------------------------------------------------------");
                        break;

                    case 6:
                        estudiantes.listarNombresEstudiantes();
                        break;

                    case 7:
                        estudiantes.listarApellidosEstudiantes();
                        break;

                    case 8: 
                        System.out.println("Estudiantes ordenados por pensión:");
                        estudiantes.listarPensionEstudiante();
                        break;

                    case 9:
                        System.out.println("\n\n****** SUMATORIA DE PENSIONES ********");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
                        System.out.println("-----------------------------------------------------------------------------------");
                        estudiantes.listarEstudiantes();
                        System.out.println("-----------------------------------------------------------------------------------");

                        double sumaPensiones = 0.0;
                        for (int i = 0; i < estudiantes.tamano(); i++) {
                            Estudiante estudiante = estudiantes.obtener(i);
                            sumaPensiones += estudiante.getPension();
                        }

                        System.out.printf("LA SUMA TOTAL ES: S/ %.2f%n", sumaPensiones );
                        break;

                    default:
                        break;
                } 
            } while (accion > 0 && accion < 10);
        } catch (Exception e) {
            System.out.println("ERROR! ");
        }
    }
}