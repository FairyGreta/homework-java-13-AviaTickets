package ru.netology.homework;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int time;


    public Ticket() {
    }

    public Ticket(int id, int price, String airportDeparture, String airportArrival, int time) {
        this.id = id;
        this.price = price;
        this.from = airportDeparture;
        this.to = airportArrival;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String airportDeparture) {
        this.from = airportDeparture;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String airportArrival) {
        this.to = airportArrival;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}