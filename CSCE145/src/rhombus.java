

import java.util.*;  
public class rhombus {  
    void hollow(int s) {  //  
        int i,k;   
        for (k = 0; k < s ; k++ ){  
            for (i = 0; i < s-k-1 ;i++ ){  
            System.out.print(" ");     
            }  
            for (i = 0; i <= k; i++ ) {  
                if (i == 0 || i == k){  
                    System.out.print("* ");  
                }  
                else  
                    System.out.print("  ");       
            }  
            System.out.println();  
        }  
        for (k = 0; k < s-1; k ++ ){  
            for (i = 0; i <= k ; i++ ){  
                System.out.print(" ");  
            }  
            for (i = 0; i < s-k-1 ;i++ ) {  
                if (i == 0 || i == s-k-2)   {  
                    System.out.print("* ");  
                }  
                else  
                    System.out.print("  ");       
            }  
            System.out.println();  
        }         
    }  
     void solid(int s) { //   
        int i,k;  
        for (k = 0; k < s ; k++ )    {  
            for (i = 0; i < s-k-1 ;i++ )  
           {  
            System.out.print(" ");  
            }  
            for (i = 0; i <= k; i++ )  
           {  
            System.out.print("* ");  
            }  
            System.out.println();  
        }  
          
        for (k = 0; k < s; k ++ )  
        {  
            for (i = 0; i <= k ; i++ )  
            {  
                System.out.print(" ");  
            }  
            for (i = 0; i < s-k-1 ;i++ )  
            {  
                System.out.print("* ");  
            }  
            System.out.println();  
        }  
          
    }  
    public static void main(String[] args)  
    {  
        System.out.println(":");  
        Scanner cin = new Scanner(System.in);  
        int num = cin.nextInt();  
        rhombus rb = new rhombus();  
  
        rb.hollow(num);  
        System.out.println();  
        rb.solid(num);    
    }  
}  
