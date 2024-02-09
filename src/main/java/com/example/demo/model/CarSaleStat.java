package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "car_sales_by_month")
public class CarSaleStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "month")
    private String month;

    @Column(name = "numberofsales")
    private long numberOfSales;

    public CarSaleStat() {
    }

    public CarSaleStat(String month, long numberOfSales) {
        this.month = month;
        this.numberOfSales = numberOfSales;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public long getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(long numberOfSales) {
        this.numberOfSales = numberOfSales;
    }
}
