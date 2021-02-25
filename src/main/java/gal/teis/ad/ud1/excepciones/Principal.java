/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ad.ud1.excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Esther Ferreiro
 * Ejemplo de lanzamiento de exceciones por parte del programador (throw)
 * Ejemplo de propagación de excepciones (throws)
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    static int minutos;
    static boolean correcto = false;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            try {
                leerMinuto();
            } catch (InputMismatchException e) { //Se recoge la excepción que se puede producir en leerMinuto()
                System.out.println("El tipo de datos introducidos no es correcto,"
                        + " se debe introducir un entero");
            } catch (Exception e) { //Se recoge la excepción que es lanzada de forma manual por leerMinuto() en ciertos casos
                System.out.println("El valor introducido debe estar entre 1 y 60");
            }finally{
                sc.nextLine();
            }
        } while (!correcto);
    }

    /**
     * En este método se pueden producir dos excepciones:
     * 1- InputMismatchException, al leer por teclado un entero con nextInt 
     *    si el valor no se corresponde con un entero.
     * 2- Si los minutos no están dentro del rango establecido lanzo Exception
     * Las dos excepciones son enviadas al método que llama a este método mediante 
     * throws
     * 
     * Ejemplo de lanzamiento de una excepción existente cuando quiera el usuario
     * 
     * @throws InputMismatchException
     * @throws Exception 
     */
    public static void leerMinuto() throws InputMismatchException, Exception {

        System.out.println("Introduce los minutos");
        minutos = sc.nextInt();
        if (minutos < 1 || minutos >= 60) {
            throw new Exception();
        }
        correcto = true;
    }
}
