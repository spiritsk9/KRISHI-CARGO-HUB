package com.example.sample.Model;

public class LoadDetail {
    private String Date;
    private String Time;
    private String Quantity;
    private String Type;

    public LoadDetail() {
    }

    public LoadDetail(String date, String time, String quantity, String type) {
        Date = date;
        Time = time;
        Quantity = quantity;
        Type = type;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDate() {

        return Date;
    }


    public void setTime(String time) {
        Time = time;
    }

    public String getTime() {
        return Time;
    }



    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getQuantity() {

        return Quantity;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getType() {

        return Type;
    }
}
