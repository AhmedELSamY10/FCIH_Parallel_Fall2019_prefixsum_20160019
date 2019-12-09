/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_prefix_sum;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 *
 * @author Ahmed_ELSami
 */
public class Parallel implements Runnable  {
    
    int no_of_elements;
    int our_array[];
    int prefix_sum_array[];
    int temp_array[];
    int loop;
    int start;
    int end;
    int flag;
    CountDownLatch Controler;

public Parallel(int no_of_elements,
    int our_array[],
    int prefix_sum_array[],
    int temp_array[],
    int loop,
    int start,
    int end,
    int flag,
    CountDownLatch Controler)
   {
       this.Controler =  Controler;
       this.end =  end;
       this.loop =  loop;
       this.no_of_elements =  no_of_elements;
       this.our_array =  our_array;
       this.prefix_sum_array =  prefix_sum_array;
       this.start =  start;
       this.flag = flag;
       this.temp_array = temp_array;
      
       
   }
    
    @Override
    public void run() {
        if (flag==0) {
      //  prefix_sum_array[start]=our_array[start];
      if(start < no_of_elements)
            {
                prefix_sum_array[start]=our_array[start];
                                 

            }
        for (int j = start+1 ; j < end ; j++)
            {
                prefix_sum_array[j]=prefix_sum_array[j-1]+our_array[j];

                
            }

             temp_array[loop]=temp_array[loop]+prefix_sum_array[end-1];

            //  temp_array[loop]+=prefix_sum_array[end-1];
             
             Controler.countDown();
             
        }else if (flag==1){
            for(int j = start; j < end ; j++)
            {
              //                  prefix_sum_array[j]+=temp_array[loop];   

                prefix_sum_array[j]=prefix_sum_array[j]+temp_array[loop];   
            }
        }
        
            
    }
    
}
