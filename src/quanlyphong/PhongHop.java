package quanlyphong;
    
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhongHop extends Phong{
    private int numberChair;

    public PhongHop() {
    }

    public PhongHop(int numberChair) {
        this.numberChair = numberChair;
    }

    public PhongHop(int numberChair, String id, String rank, Date daterent, Date datereturn, double price) {
        super(id, rank, daterent, datereturn, price);
        this.numberChair = numberChair;
    }

    public int getNumberChair() {
        return numberChair;
    }

    public void setNumberChair(int numberChair) {
        this.numberChair = numberChair;
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
        System.out.print("Enter number of chair:");
        int numberchair = keyboard.nextInt();
        setNumberChair(numberchair);
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
        System.out.println("Number of chair: " + getNumberChair());
        
    }
    @Override
    public double caculateroomrent() {
        return phanloai()*daysrent();
    }
    
}
