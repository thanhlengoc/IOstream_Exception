/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOStream_Exception;

/**
 *
 * @author ThanhLe
 */
import java.util.Scanner;
//import java.io.*;

class ThrowArrayException extends Exception {
    public void showError() {
        System.out.println("ArrayException: Please enter argument at terminal");
    }
}

public class BaiTap1 {
    public static void main(String as[]) {
        try {
            input();
        } catch (ThrowArrayException ex) {
            ex.showError();
        }   
    }
    public static void input() throws ThrowArrayException{
        Scanner sc = new Scanner(System.in);
        //InputStreamReader cin = new InputStreamReader(System.in);
        System.out.print("Java ThrowArrayException ");
        int size = 0;
        String s = sc.nextLine();
        String str[] = s.split(" ");
        int arr[] = new int[str.length];
        for (String temp : str){
            try{
                arr[size] = Integer.parseInt(temp);
                size ++;
            }
            catch(Exception e){               
            }
        }  
        if(size <= 0){
            throw new ThrowArrayException();
        }
        else{
            System.out.println("Array size is " + size);
        }
    }
}
