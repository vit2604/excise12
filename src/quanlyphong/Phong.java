package quanlyphong;

import java.util.Date;

public abstract class Phong implements IPhong {

    private String id;
    private String rank;
    private Date daterent;
    private Date datereturn;
    private double price;

    public Phong() {
    }

    public Phong(String id, String rank, Date daterent, Date datereturn, double price) {
        this.id = id;
        this.rank = rank;
        this.daterent = daterent;
        this.datereturn = datereturn;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getDaterent() {
        return daterent;
    }

    public void setDaterent(Date daterent) {
        this.daterent = daterent;
    }

    public Date getDatereturn() {
        return datereturn;
    }

    public void setDatereturn(Date datereturn) {
        this.datereturn = datereturn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double caculateroomrent();

}
