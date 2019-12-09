/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_prefix_sum;

/**
 *
 * @author Ahmed_ELSami
 */

import java.util.*;  

public class The_Serial_Prefix_Sum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner in = new Scanner(System.in);  
        
         System.out.print("Enter the size of the array: ");  
          int size = in.nextInt();  
          int array[] = new int[size];
          
          
          System.out.println("Enter the elements of the array:");
          for (int i =0 ; i<size ;i++)
          {
            array[i] = in.nextInt();   
          }
                    System.out.println("the array is:");

                    
           System.out.println(Arrays.toString(array)); 
           int new_array[]= new int[size];
           
               new_array[0]=array[0];

           
           for (int i =1 ; i<size ;i++)
          {
              new_array[i] = new_array[i-1] + array[i];
          }
           
         System.out.println("the prefix array is:");

            System.out.println(Arrays.toString(new_array));
    }
    
   
    
}
