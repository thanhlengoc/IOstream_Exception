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
import java.io.*;

class SinhVien {
    public String MaSV = null;
    public String HoTen = null;
    public double DiemTB = 0;
    public void SinhVien() {}  
    public void Nhap() {
        System.out.println("Nhap thong tin sinh vien: ");
    } 
    public void Xuat() {
        System.out.println("Xuat thong tin sinh vien");
    }   
}

class MarkOutOfBoundException extends Exception {
    public void showError() {
        System.out.println("MarkOutOfBoundException");       
    }
    
}

class OutOf8LettersException extends Exception {
    public void showError() {
        System.out.println("OutOf8LettersException");
    }
}

public class BaiTap2 {
    public static void main(String as[]) throws Exception {
        SinhVien sv = new SinhVien();
        sv.Nhap();
        InputStreamReader ip = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);   
        try {
            System.out.print("Nhap MaSV: ");
            sv.MaSV = br.readLine();
            if(sv.MaSV.length() > 8)
                throw new OutOf8LettersException();
        }
        catch(OutOf8LettersException ex) {
            ex.showError();
            do {
                System.out.print("Nhap lai MaSV: ");
                sv.MaSV = br.readLine();
            } while(sv.MaSV.length() > 8);
        } 
        System.out.print("Nhap Ho Ten: ");
        sv.HoTen = br.readLine();
        try {
            System.out.print("Nhap DiemTB: ");
            sv.DiemTB = Double.parseDouble(br.readLine());
            if (sv.DiemTB > 10 || sv.DiemTB < 0)
                throw new MarkOutOfBoundException();
        }
        catch(MarkOutOfBoundException e){
            e.showError();
            do {
                System.out.print("Nhap lai DiemTB: ");
                sv.DiemTB = Double.parseDouble(br.readLine());
            } while (sv.DiemTB>10 || sv.DiemTB<0);
        }
        sv.Xuat();
        System.out.println("Sinh vien: "+sv.HoTen+" co ma so: "+sv.MaSV
                            +" co diem trung binh: "+sv.DiemTB);
    }
}
