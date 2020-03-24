package me.upp.libreria;

import me.upp.libreria.hemeroteca.Libro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class Libreria {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        final Scanner scanner = new Scanner(System.in);
        final Libreria libreria = new Libreria();
        final Libro libro = new Libro();
        int opc;
        String regresar = "null";

        do {
            System.out.println(
                    "  M  E  N  U  \n" +
                            "1) Insertar datos del libro\n" +
                            "2) Prestar\n" +
                            "3) Devolver\n" +
                            "4) Mostrar datos"
            );
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    libreria.agregarDatos(libro, scanner);
                    break;
                case 2:
                    libro.prestar();
                    break;
                case 3:
                    libro.devolver();
                    break;
                case 4:
                    libreria.mostrarDatos(libro);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

            System.out.println("Regresar al menu? (si/no)");
            regresar = scanner.next();
            clear();

        } while (!(regresar.equalsIgnoreCase("no")));

    }

    //Reflection | Mostrar
    public void mostrarDatos(Libro libro) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = libro.getClass().getMethods();

        for (Method method : methods) {
            if (!(method.getName().contains("get")) ||
                method.getName().contains("Class")) continue;
            System.out.println(method.getName().replace("get", "") + ": ");
            System.out.println(method.invoke(libro, null));
        }

        System.out.println("Prestado: ");

        if (libro.isPrestado()) {
            System.out.println("El libro esta prestado");
            return;
        }
        System.out.println("El libro no esta prestado");
            
    }

    //Reflection | Agregar
    public void agregarDatos(Libro libro, Scanner scanner) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = libro.getClass().getMethods();
        String datoS = "null";
        int datoI = 0;

        for (Method method : methods) {
            if (!(method.getName().contains("set")) ||
                method.getName().contains("Prestado")) continue;

            System.out.println(method.getName().replace("set", "") + ": ");

            for (Parameter parameter : method.getParameters()) {
                if (parameter.getParameterizedType().getTypeName().contains("String")) {
                    datoS = scanner.next();
                    method.invoke(libro, datoS);
                } else if (parameter.getParameterizedType().getTypeName().contains("int")) {
                    datoI = scanner.nextInt();
                    method.invoke(libro, datoI);
                }
            }

        }

    }

    public static void clear() {
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }
    }

}
