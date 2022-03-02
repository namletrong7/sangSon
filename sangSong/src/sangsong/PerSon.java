/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sangsong;

import java.util.Comparator;

/**
 *
 * @author HP
 */
public class PerSon {
    int thoiGian ; 
    boolean type ;
    

    public PerSon() {
    }

    public PerSon(int thoiGian, boolean type) {
        this.thoiGian = thoiGian;
        this.type = type;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    } 
    public int type(){
        if(isType()==true){
            return 0 ;   // là nhân viên
        }
        else{
            return 1 ;    // là hacker
        } 
    }
    public String kieu(){
         if(isType()==true){
            return "nhân viên" ;   // là nhân viên
        }
        else{
            return "hacker" ;    // là hacker
        } 
    }
  
    

    @Override
    public String toString() {
        return "thời gian đến " + thoiGian + " ||   thể loại : " + kieu() ;
    }
    public void hienThi(){
        System.out.printf("\n%10d%20s",thoiGian,kieu());
    }
   

  
    
}
