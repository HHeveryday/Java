package com.nqc.bean;

public class Business extends User{
    private String shopName;
    private String address;

    public Business(String shopName, String address) {
        this.shopName = shopName;
        this.address = address;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Business() {
    }
}
