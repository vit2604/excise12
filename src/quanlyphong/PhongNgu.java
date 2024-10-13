package quanlyphong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class PhongNgu extends Phong {

    private int numberOfBed;

    public PhongNgu() {
    }

    public PhongNgu(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public PhongNgu(int numberOfBed, String id, String rank, Date daterent, Date datereturn, double price) {
        super(id, rank, daterent, datereturn, price);
        this.numberOfBed = numberOfBed;
    }

    public int getnumberOfBed() {
        return numberOfBed;
    }

    public void setnumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public void input() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("==Enter bedroom information==");
        System.out.print("Enter room ID: ");
        String id = keyboard.nextLine();
        setId(id);
        System.out.print("Enter room rank: ");
        String rank = keyboard.nextLine();
        setRank(rank);
        System.out.print("Enter rent day: ");
        String rentDate = keyboard.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date rentD = sdf.parse(rentDate);
            setDaterent(rentD);
        } catch (ParseException e) {
            System.out.println("Error!!");
        }
        System.out.print("Enter return day:");
        String returnDate = keyboard.nextLine();
        try {
            Date returnD = sdf.parse(returnDate);
            setDatereturn(returnD);
        } catch (Exception e) {
            System.out.println("Error!!");
        }
        System.out.print("Enter number of Bed:");
        int numberbed = keyboard.nextInt();
        setnumberOfBed(numberbed);
    }

    public int daysrent() {
        if (getDaterent().equals(getDatereturn())) {
            return 1;
        }
        long diff = getDatereturn().getTime() - getDaterent().getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }
    public void display(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID: " + getId());
        System.out.println("Rank: " + getRank());
        System.out.println("Rent day: " +sdf.format(getDaterent()));
        System.out.println("Check out day: " + sdf.format(getDatereturn()));
        System.out.println("Number of bed: " + getnumberOfBed());
        
    }
    public double phanloai()
    {
        if(getRank().equals("A"))
                {
                 return 1200000;   
                }else if(getRank().equals("B"))
                {
                    return 1000000;
                }else if(getRank().equals("C"))
                {
                    return 750000;
                }
        return 0;
    }
    @Override
    public double caculateroomrent() {
        return phanloai()* daysrent();
    }
}
