/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5version1;
import java.util.*;
/**
 *
 * @author Elizabeth
 */
public class Project5version1 {

    
public static double [][] table(){
    
    double[][] chillTable  = new double [8][6]; // array as specified from instructions is 8 rows and 6 columns
    int temp = -20, vel = 5; // intial values for table set by instructions are a temperature of -20, and wind velocity of 5
    for (int rows = 0;rows < 8; rows++){//creates 8 rows of data
        
        for (int cols = 0; cols < 6; cols++){//creates 6 colomns of data for each row in the array
            
           chillTable [rows][cols] = 35.74 + (0.6125 * temp) - (35.75 * Math.pow(vel, 0.16)) + (0.4275 * temp * Math.pow(vel, 0.16));
           //run velocity and temp through the above equation and assigns data to the array
        
           vel += 5; //increment velocity by 5 at the end of each inner loop
           
        }
        
        temp += 5; //incriment temperature by five at the end of each outer loop until temp reaches 15
        vel =5; //reset velocity to 5 at the end of each outer loop
        
    }
    
    return chillTable; //returns the table to the main method
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       double temp, vel;
       int col, row;
       boolean q = false;
       double[][] table2;
      table2 = table();
       for(int i= 0; i < 8; i++){
           for(int j=0; j < 6; j++){
               System.out.printf("%5d",(int)table2[i][j]);
              
           }
           System.out.println(" ");
       }
      
       
       Scanner input = new Scanner(System.in);//create scanner object
       do{
       System.out.print("Enter Temperature: ");//prompt for temperature input
       
       temp = input.nextDouble();//read input
       
       if(temp % 5 == 0 && temp <= 15 && temp >= -20){//verify valid input. if divisible by five, <= 15, and >= -20 it is valid
           q = true;//if input is valid q becomes true
          
       }
       else{
           System.out.print("Input invalid, try again \n\n");//if input is not true, print this message
       q = false;//q remains false
       }
       }
       while (q == false);//if input is valid exits loop , else restarts the loop (
       
      
       
       do{
       System.out.print("Enter Wind Velocity: ");//prompt for wind velocity input
       
       vel = input.nextDouble();//read input
       
       
       if(vel % 5 == 0 && vel <= 30 && vel >= 5){//set up input verification.  must be divisible by five and between 5 and 30
           q = true;//if input is valid q becomes true
          
       }
       else{
           System.out.print("Input invalid, try again \n\n");//non valid input prints out this message
       
       q = false;//and q becomes false
       
       }
       }
       
       while (q == false);//when q is true loop ends (note had to change it to false)
       
       row = (int)(temp + 20)/5;
       col = (int)(vel /5) - 1;
       
     
      System.out.println("The row index is " + row + " and the colomn index is " + col + "\n");
      
       System.out.println( "The Wind Chill factor is " + (int) table2[row][col]);
       
      
    }
    
}
