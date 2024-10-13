package quanlyphong;

import java.util.ArrayList;
import quanlyphong.Phong;
import quanlyphong.PhongHop;

public class QuanlyPhong {

    private ArrayList<Phong> dsPhong;

    public QuanlyPhong() {
        dsPhong = new ArrayList<>();
    }

    public void addphong(Phong phong) {
        dsPhong.add(phong);
    }

    public void deletePhong(String id) {
        dsPhong.removeIf(Phong -> Phong.getId().equals(id));
    }

    public void updatePhong(String id) {
        for (Phong phong : dsPhong) {
            if (phong instanceof PhongNgu) {
                if (phong.getId().equals(id)) {
                    ((PhongNgu) phong).input();
                }
            } else if (phong instanceof PhongHop) {
                if (phong.getId().equals(id)) {
                    ((PhongHop) phong).input();
                }

            }
        }
    }
    public void thongKeSoLuongTheoHang() {
        int soPhongA = 0;
        int soPhongB = 0;
        int soPhongC = 0;
        for (Phong phong : dsPhong) {
            if (phong.getRank().equals("A"))
                    {
                        soPhongA++;
                    }else if (phong.getRank().equals("B"))
                    {
                        soPhongB++;
                    }else if (phong.getRank().equals("C"))
                    {
                        soPhongC++;
                    }
        }

        System.out.println("Phong A:: " + soPhongA);
        System.out.println("Phong B: " + soPhongB);
        System.out.println("Phong C: " + soPhongC);
    }
    
    public double tinhTongTienThue() {
        double tongTien = 0;
        for (Phong phong : dsPhong) {
            tongTien += phong.caculateroomrent();
        }
        return tongTien;
    }}
