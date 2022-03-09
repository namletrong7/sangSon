/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sangsong3;

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
public class SangSong3 {

    static boolean flagNV = false, flagHC = false;
    static int thuyen = 0;
    static int soHieuChuyen = 1;
    static int NV_hangCho = 0, hacker_hangCho = 0;    // số lượng nhân viên và số lượng hacker trong phòng chờ để đợi lên thuyền

    static ArrayList<PerSon> list = new ArrayList<>();

    public static void crossRiver(boolean loaiNguoi) {    // khởi hành qua sông khi đủ điều kiện
        if (loaiNguoi == true) {  // true_nhân vien
            if (thuyen == 1) { // thuyền đã có sẵn 2 nhan vien
                System.out.println("\n chuyến thuyền " + soHieuChuyen);
                System.out.println("\t4 nhân viên trong thuyền");
                soHieuChuyen++;
                thuyen = 0; // gán thuyền lại bằng rỗng
            } else {
                System.out.println("\n chuyến thuyền " + soHieuChuyen);
                soHieuChuyen++;
                System.out.println("\t 2 nhân viên, 2 hacker trong thuyền");
                thuyen = 0; // gán thuyền lại bằng rỗng
            }
        } else {      // loainguoi==false tức là hacker

            if (thuyen == 1) {    // thuyền đã có sẵn 2 nhân viên
                System.out.println("\n chuyến thuyền " + soHieuChuyen);
                soHieuChuyen++;
                System.out.println("\t 2 nhân viên, 2 hacker trong thuyền");
                thuyen = 0; // gán thuyền lại bằng rỗng
            } else {
                System.out.println("\n chuyến thuyền " + soHieuChuyen);
                soHieuChuyen++;
                System.out.println("\t 4 hacker trong thuyền ");
                thuyen = 0; // gán thuyền lại bằng rỗng
            }

        }

    }

    public static void hackerArrives() {   //kiểm tra điều kiện xuống thuyền của hacker
        if (flagHC == false) // nếu không có bất kỳ hacker trong hàng chờ hiện tại
        {
            flagHC = true; //thêm hacker đang xét vô  hàng chờ
        } else {    // nếu đang có 1 bất kỳ hacker trên thuyền
            flagHC = false; // cho hacker đang ở trên hàng chờ và hacker đang xét lên thuyền 
            switch (thuyen) {
                case 0: {   //  thuyền đang trống
                    thuyen = 2;  // đưa 2 hacker lên thuyền 
                    break;
                }
                case 1: {
                    crossRiver(false);  // khởi hàng sang sông khi đủ điều kiện
                    break;

                }
                case 2: {
                    crossRiver(false);  // khởi hàng sang sông khi đủ điều kiện
                    break;
                }
            }
        }
    }

    public static void nhanVienArrives() {   //kiểm tra điều kiện xuống thuyền của nhân viên
        if (flagNV == false) // nếu không có nhân viên trong hàng chờ hiện tại
        {
            flagNV = true; //thêm nhân viên vô  hàng chờ
        } else {    // nếu đang có 1 nhân viên trong hàng chờ hiện tại
            flagNV = false; // cho nhân viên đang ở trên hàng chờ và nhân viên đang xét lên thuyền 
            switch (thuyen) {
                case 0: {   //  thuyền đang trống
                    thuyen = 1;  // đưa 2 nhân viên lên thuyền 
                    break;
                }
                case 1: {
                    crossRiver(true);  // khởi hàng sang sông khi đủ điều kiện
                    break;

                }
                case 2: {
                    crossRiver(true);  // khởi hàng sang sông khi đủ điều kiện
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);

        int n = 0;    /// số lượng nhân viên cần đi thuyền
        int m = 0;   // số lượng hacker cần đi thuyền
        while (true) {
            try {
                System.out.println("Nhập số lượng nhân viên cần đi thuyền : ");
                n = Integer.parseInt(nhap.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("sai định dạng xin nhập lại");
                continue;
            }
        }

        while (true) {
            try {
                System.out.println("Nhập số lượng hacker cần đi thuyền : ");
                m = Integer.parseInt(nhap.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("sai định dạng xin nhập lại");
                continue;
            }
        }

        float x = 0;    // biến này dùng để khởi tạo thời gian đến bến tàu của nhân viên hay hacker
        for (int i = 1; i <= n; i++) {   /// vòng lập nhập thời gian đến bến tàu của nhân viên
            PerSon p1 = new PerSon();
            while (true) {
                try {
                    System.out.println("Thời gian đến bến tàu của nhân viên thứ " + i);
                    x = Float.parseFloat(nhap.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("sai định dạng xin nhập lại");
                    continue;
                }
            }

            p1.setThoiGian(x);
            p1.setType(true);    // return 0 
            list.add(p1);
        }

        for (int i = 1; i <= m; i++) {  // vòng lặp thời gian đến bến tàu của các hacker
            PerSon p2 = new PerSon();
            while (true) {
                try {
                    System.out.println("Thời gian đến bến tàu của hacker thứ " + i);
                    x = Float.parseFloat(nhap.nextLine());
                    break;
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

        System.out.printf("\n%20s%30s", "Thời Gian Đến", "Thể Loại");
        for (PerSon p4 : list) {
            p4.hienThi();
        }
        System.out.println("\n\n--------------Thông tin về các chuyến thuyền được sang sông--------------");
        // 0 - nhân viên, 1-hacker
        for (PerSon p3 : list) {  //duyệt từ danh sách tuần tự
            if (p3.Type() == 0) {   // nếu người đang xét là nhân viên
                nhanVienArrives();     // đưa người nhân viên này lên thuyền
            } else {       // nếu người đang xét là hacker
                hackerArrives();
            }
        }   // kết thúc vòng for
        // ngoài vòng for 
        if (flagNV == true) {   // còn nhân viên trong phòng chờ mà chưa được lên thuyền do chưa đủ điều kiện và số lượng
            NV_hangCho++;
        }
        if (flagHC == true) {
            hacker_hangCho++;   // còn hacker trong phòng chờ mà chưa được lên thuyền do chưa đủ điều kiện và số lượng
        }
        switch (thuyen) {
            case 0: {   // không có ai trên thuyền
                break;
            }
            case 1: {   // có 2 nhân viên trên thuyền 
                NV_hangCho += 2;
                break;
            }
            case 2: {   // có 2 hacker trên thuyền
                hacker_hangCho += 2;
                break;
            }
        }
        if (hacker_hangCho >= 0 || NV_hangCho >= 0) {
            System.out.println("\ncòn lại " + NV_hangCho + " nhân viên và " + hacker_hangCho + "  hacker chưa được lên thuyền");
        }
    }
}
