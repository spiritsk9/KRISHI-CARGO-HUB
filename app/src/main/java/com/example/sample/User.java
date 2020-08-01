package com.example.sample;

public class User {
    private String Name;
    private String Email;
    private String Address;
    private String Pincode;
    private String Password;
    private String Mobile;
    private String Date;
    private String Time;
    private String Quantity;
    private String Type;
    private String Source;
    private String Destination;
    private String Vehicle;
    private String License;
    private String Distance;
    private String Space;
    private String WeightperKm;



    public User() {
    }

    public User(String name, String email, String address, String pincode, String password) {
        Name = name;
        Email = email;
        Address = address;
        Pincode = pincode;
        Password = password;


    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {

        return Name;
    }


    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }


    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {

        return Address;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public String getPincode() {

        return Pincode;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getMobile() {

        return Mobile;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {

        return Password;
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
    public void setSource(String source) {
        Source = source;
    }

    public String getSource() {

        return Source;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getDestination() {

        return Destination;
    }

    public void setVehicle(String vehicle) {
        Vehicle = vehicle;
    }

    public String getVehicle() {

        return Vehicle;
    }

    public void setLicense(String license) {
        License = license;
    }

    public String getLicense() {

        return License;
    }
    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getDistance() {

        return Distance;
    }

    public void setSpace(String space) {
        Space = space;
    }

    public String getSpace() {

        return Space;
    }

    public void setWeightperKm(String weightperKm) {
        WeightperKm = weightperKm;
    }

    public String getWeightperKm() {

        return WeightperKm;
    }
}

