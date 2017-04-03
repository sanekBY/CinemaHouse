package com.sashqua.cinema.entity;

/**
 * CinemaHouse project
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
public class Ticket {

    private Integer id;
    private Double price;
    private Integer row;
    private Integer seat;

    public Ticket() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
