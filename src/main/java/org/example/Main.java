package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            Integer id = -1;
            while(true){
                System.out.println("Which calculator you want to try?");
                System.out.println("1. EMI\n2. Gratuity\nPress any other key to exit\n");
                try{
                    id = scanner.nextInt();
                }
                catch(InputMismatchException exception){
                    return;
                }
                if(id>=0 && id<8){
                    break;
                }
                else{
                    System.out.println("Please enter valid option!");
                }
            }

            if(id==0){
                System.out.println("Thanks!!");
            }
            else if(id==1){
                EMICalculator calc = new EMICalculator();
                calc.init();
            }
            else if(id==2){
                GratuityCalculator calc = new GratuityCalculator();
                calc.init();
            }
        } catch (Exception exception){
            return;
        }
    }
}