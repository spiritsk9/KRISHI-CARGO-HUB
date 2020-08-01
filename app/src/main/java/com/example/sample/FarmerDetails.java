package com.example.sample;

public class FarmerDetails {


    private String name;
    private String email;
    private String address;
    private String pincode;

    public FarmerDetails() {
        // This is default constructor.
    }

    public String getFarmerName() {

        return name;
    }

    public void setFarmerName(String name) {

        this.name = name;
    }

    public String getFarmeremail() {

        return email;
    }

    public void setFarmeremail(String email) {

        this.email = email;
    }

    public String getFarmeraddress() {

        return address;
    }

    public void setFarmeraddress(String address) {

        this.address = address;
    }

    public String getFarmerpincode() {

        return pincode;
    }

    public void setFarmerpincode(String pincode) {

        this.pincode = pincode;
    }


}