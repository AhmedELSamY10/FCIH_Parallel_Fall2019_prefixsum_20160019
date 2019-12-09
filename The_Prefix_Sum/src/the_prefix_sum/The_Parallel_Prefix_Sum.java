/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_prefix_sum;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Ahmed_ELSami
 */
public class The_Parallel_Prefix_Sum {
    
    static ThreadPoolExecutor executor;
    
    
       public static void main(String[] args) throws InterruptedException {
           
           while(1==1){
              Scanner in = new Scanner(System.in);  
        
         System.out.print("Enter the size of the array x: ");  
          int size = in.nextInt();  
          while (size < 4){
               System.out.print("Enter the size of the array:(at least 4 numbers) ");
                 size = in.nextInt();  
          }
          int our_array[] = new int[size];
          int rest = size -(size % 4);
                System.out.println(rest);
          
          
          System.out.println("Enter the elements of the array:");
          for (int i =0 ; i<size ;i++)
          {
            our_array[i] = in.nextInt();   
          }
                    System.out.println("the array is:");

                    
           System.out.println(Arrays.toString(our_array)); 
           
          int prefix_sum_array[]= new int[size];

          ///////////////////////////////////////////////////////////////////////////////////////////////////////
           
         int thread_number = Runtime.getRuntime().availableProcessors();
         
         executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(thread_number);
         
         CountDownLatch Controler = new CountDownLatch(thread_number);
         
         CountDownLatch Controler2 = new CountDownLatch(thread_number);
         /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
         
        int number_of_slices = size/thread_number;
                
        int temp_array[] = new int[thread_number];
        
         int start=0, end=number_of_slices;
         
         
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
         for(int i = 0 ; i < thread_number ; i++)
        {
            Parallel p = new Parallel( size,our_array,prefix_sum_array,temp_array,i,start,end,0,Controler);
            
            
    
            executor.execute(p);

            start=end;
            
            if (i<thread_number-1) {
                    end=end+number_of_slices; 
            } else {
                    end=size;
            }
            
            
        }
       Controler.await();
               System.out.println(Arrays.toString(temp_array));
        System.out.println(Arrays.toString(prefix_sum_array));

       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        for(int i = 1 ; i<thread_number; i++)
        {
            temp_array[i]=temp_array[i]+temp_array[i-1];
        }
                System.out.println(Arrays.toString(temp_array));
        System.out.println(Arrays.toString(prefix_sum_array));

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        start=number_of_slices;
        
        end=start+number_of_slices;
        
        for(int i = 0 ; i < thread_number-1 ; i++)
        {
                    System.out.println(Arrays.toString(temp_array));
                            System.out.println(Arrays.toString(prefix_sum_array));


            Parallel p = new Parallel( size,our_array,prefix_sum_array,temp_array,i,start,end,1,Controler2);
        System.out.println(Arrays.toString(temp_array));
        System.out.println(Arrays.toString(prefix_sum_array));

            executor.execute(p);
                                System.out.println("ba333333333333333333333333");
        System.out.println(Arrays.toString(temp_array));
        System.out.println(Arrays.toString(prefix_sum_array));

            
            start=end;
             
            if (i<thread_number-1) {
                    end=end+number_of_slices; 
            } else {
                    end=size;
            }
      }
        

//        if (size > 8)
//        {
        for( int i = rest ; i<size ; i++)
        {
                    System.out.println(Arrays.toString(prefix_sum_array));

              prefix_sum_array[i] = prefix_sum_array[i-1] + our_array[i];
                      System.out.println(Arrays.toString(prefix_sum_array));


        }
  //      }
      
             //System.out.println("prefix_sum_array is:");
             
        System.out.println(Arrays.toString(prefix_sum_array));
        
            

              executor.shutdown();

       }
       
       }
}


