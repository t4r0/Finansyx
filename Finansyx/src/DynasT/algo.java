/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynasT;

/**
 *  
 * @author t4r0
 */
public class algo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int num = 0;
        int primos = 0;
        boolean primo = true;
        while(primos <= 9)
        {
            primo = true;
            num++;
            for(int i=2; i < num; i++)
            {
		if(num % i == 0)
                   primo = false;
            }
            if(primo)
            {
		System.out.println(num + " es primo");
		primos ++;
            }
        }   
    }
    
}
