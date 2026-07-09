/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetobancario;

import java.util.Scanner;

/**
 *
 * @author pc gamer
 */
public class ProjetoBancario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean running = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao Banco S.D.M");

        while (running) {
            //chama o método primeiro menu da classe menu
            running=Menu.menu();

        }
      

    }

}
