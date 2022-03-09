/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sangsong3;

import java.util.Comparator;

/**
 *
 * @author HP
 */
public class PerSon {
    float thoiGian ; // thời gian đến của mỗi người
    boolean type ;    // sử dụng để xác định người đó là nhân viên Microsoft hay linux hacker
    

    public PerSon() {
    }

    public PerSon(float thoiGian, boolean type) {
        this.thoiGian = thoiGian;
        this.type = type;
    }

    public float getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(float thoiGian) {
        this.thoiGian = thoiGian;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    } 
    public int Type(){
        if(isType()==true){
            return 0 ;   // là nhân viên
        }
        else{
            return 1 ;    // là hacker
        } 
    }
    public String theLOai(){
         if(isType()==true){
            return "Nhân viên Microsoft" ;   // là nhân viên
        }
        else{
            return " Linux Hacker" ;    // là hacker
        } 
    }
  
    

    // hàm hiển thị
    public void hienThi(){
   
        System.out.printf("\n%20s%30s",thoiGian+" s",theLOai());
    }
   

  
    
}
