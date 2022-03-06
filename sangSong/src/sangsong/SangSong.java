/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sangsong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;

/**
 *
 * @author HP
 */
public class SangSong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        ArrayList<PerSon> list = new ArrayList<>();
        System.out.println("Nhập số lượng nhân viên cần đi thuyền : ");
        int n = nhap.nextInt();nhap.nextLine();
        System.out.println("Nhập số lượng hacker cần đi thuyền : ");
        int m = nhap.nextInt();nhap.nextLine();
        PerSon p = new PerSon();
        float x = 0;    // biến này dùng để khởi tạo thời gian đến bến tàu của nhân viên hay hacker
        for (int i = 1; i <= n; i++) {
            PerSon p1 = new PerSon();
            while (true) {                
                try {
                     System.out.println("Thời gian đến bến tàu của nhân viên thứ " + i);
                     x = Float.parseFloat(nhap.nextLine());
                     break ;
                } catch (Exception e) {
                    System.out.println("sai định dạng xin nhập lại");
                    continue;
                }
            }
           
            p1.setThoiGian(x);
            p1.setType(true);    // return 0 
            list.add(p1);
        }
        for (int i = 1; i <= m; i++) {
            PerSon p2 = new PerSon();
              while (true) {                
                try {
                     System.out.println("Thời gian đến bến tàu của hacker thứ " + i);
                      x = Float.parseFloat(nhap.nextLine());
                     break ;
                } catch (Exception e) {
                    System.out.println("sai định dạng xin nhập lại");
                    continue;
                }
            }
            p2.setThoiGian(x);
            p2.setType(false);   //return 1
            list.add(p2);
        }
        Collections.sort(list, (a, b) -> (int) (a.getThoiGian() - b.getThoiGian()));    // phương thức sắp xếp theo chiều tăng giần

        System.out.printf("\n%10s%20s", "Thời Gian Đến", "Thể Loại");
        for (PerSon p4 : list) {
            p4.hienThi();
        }
        /// 0 - nhan viên ,   1-hacker
        int soLuongNV = 0, soLuongHC = 0;    // số lượng nhân viên và số lượng hacker trong phòng chờ để đợi lên thuyền
        boolean flagNV = false, flagHC = false;    //
        int soHieuChuyen = 1;
        int thuyen = 0;
        System.out.println("\n-------------Thông tin về các chuyến tàu----");
        for (PerSon p3 : list) {
            if (p3.type() == 0) {     // nếu người đang xét là nhân viên 
                if (flagNV == false) {    // neus chưa có nhan vien trong hàng chờ
                    flagNV = true;      // thêm nhân viên vô hàng chờ
                } else {                 // nếu đã có nhân viên trong hàng chờ trước đó
                    flagNV = false;
                    switch (thuyen) {
                        case 0: {    // thuyền chưa có ai 
                            thuyen = 1; // thêm 2 nhân viên vô thuyền
                            break;
                        }
                        case 1: {     // thuyền đã có 2 nhân viên ở trong
                            System.out.println(" \nchuyến : " + soHieuChuyen);
                            System.out.println("\n 4 nhân viên trong thuyền");
                            thuyen = 0;  // sau khi thuyefn đi gán lại thuyền cho rỗng
                            soHieuChuyen++;
                            break;
                        }
                        case 2: {   // có 2 hacker trong thuyền
                            System.out.println(" \nchuyến : " + soHieuChuyen);
                            System.out.println("\n 2 nhân viên, 2 hacker trong thuyền");
                            thuyen = 0;  // sau khi thuyefn đi gán lại thuyền cho rỗng
                            soHieuChuyen++;
                            break;
                        }

                    }
                }
            } /// 0 - nhan viên ,   1-hacker   // gán cho nhớ thôi 
            else {    /// nếu người đang xét là hacker
                if (flagHC == false) // nếu chưa có hacker trong hàng chờ trước đó
                {
                    flagHC = true;   // thêm hacker  vô hàng chờ

                } else {    // nếu đã có hacker trong hàng chờ trước đó
                    flagHC = false;
                    switch (thuyen) {
                        case 0: {      // trên thuyền chưa có ai 
                            thuyen = 2;   // thêm 2 hacker vô thuyền
                            break;
                        }
                        case 1: {    // trên thuyền đã có 2 nhân viên 
                            System.out.println(" \nchuyến : " + soHieuChuyen);
                            System.out.println("\n2 hacker, 2 nhân viên trong thuyền");
                            thuyen = 0; // sau khi thuyefn đi gán lại thuyền cho rỗng
                            soHieuChuyen++;
                            break;
                        }
                        case 2: {   // trên thuyền đã có 2 hacker  rồi 
                            System.out.println(" \nchuyến : " + soHieuChuyen);
                            System.out.println("\n4 hacker trong thuyền ");
                            thuyen = 0;
                            soHieuChuyen++;
                            break;
                        }
                    }
                }

            }

        }

        // ngoài vòng for 
        if (flagNV == true) {   // còn nhân viên trong phòng chờ mà chưa được lên thuyền do chưa đủ điều kiện và số lượng
            soLuongNV++;
        }
        if (flagHC == true) {
            soLuongHC++;   // còn hacker trong phòng chờ mà chưa được lên thuyền do chưa đủ điều kiện và số lượng
        }
        switch (thuyen) {
            case 0: {   // không có ai trên thuyền
                break;
            }
            case 1: {   // có 2 nhân viên trên thuyền 
                soLuongNV += 2;
                break;
            }
            case 2: {   // có 2 hacker trên thuyền
                soLuongHC += 2;
                break;
            }

        }
        if (soLuongHC >= 0 || soLuongNV >= 0) {
            System.out.println("\ncòn lại " + soLuongNV + " nhân viên và " + soLuongHC + "  hacker chưa được lên thuyền");
        }

    }

}
