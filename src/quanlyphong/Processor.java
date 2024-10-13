package quanlyphong;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        QuanlyPhong roomManager = new QuanlyPhong();
        while (true) {
            System.out.println("1. Add new bed room");
            System.out.println("2. Add new meeting room");
            System.out.println("3. Remove room");
            System.out.println("4. Update room");
            System.out.println("5. Display room count by type");
            System.out.println("6. Calculate total rental");
            System.out.println("0. Exit");
            System.out.print("Choose option:");
            int choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    PhongNgu pn = new PhongNgu();
                    pn.input();
                    roomManager.addphong(pn);
                    break;

                case 2:
                    PhongHop ph = new PhongHop();
                    ph.input();
                    roomManager.addphong(ph);
                    break;
                case 3:
                    System.out.print("Enter the id of the room to remove: ");
                    String roomToRemove = keyboard.nextLine();
                    roomManager.deletePhong(roomToRemove);
                    break;

                case 4:
                    System.out.print("Enter the id of the room to update: ");
                    String id = keyboard.nextLine();
                    roomManager.updatePhong(id);
                    break;

                case 5:
                    roomManager.thongKeSoLuongTheoHang();
                    break;

                case 6:
                    System.out.println("Total rental of all rooms: " + roomManager.tinhTongTienThue());
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

            }
        }
    }
}
