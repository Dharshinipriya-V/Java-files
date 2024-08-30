package com.kgisl.csv;

//import java.sql.Date;

import com.opencsv.bean.CsvBindByPosition;
//import com.opencsv.bean.CsvDate;

public class Vehicle {

    @CsvBindByPosition(position = 0)
    private int id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String  date;  // Consider changing to LocalDate for date operations

    @CsvBindByPosition(position = 3)
    private String district;

    @CsvBindByPosition(position = 4)
    private String registrationNumber;

    @CsvBindByPosition(position = 5)
    private int price;

    @CsvBindByPosition(position = 6)
    private int milage;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

   @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +", date='" + date + '\'' +", district='" + district + '\'' +", registrationNumber='" + registrationNumber + '\'' +", price=" + price +", milage=" + milage +'}';
    }
}
