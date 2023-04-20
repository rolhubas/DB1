package org.example;

public class Airport {
    private int bizId;
    private String bizName;
    private String address;
    private String city;

    public Airport(){}
    //konstruktorius skirtas esamų įrašų redagavimui ir esamų įrašų paieškos grąžinimui
    public Airport(int bizId, String bizName, String address, String city) {
        this.bizId = bizId;
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }
//konstruktorius skirtas naujų įrašų kūrimui
    public Airport(String bizName, String address, String city) {
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

    public int getBizId() {
        return bizId;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "bizId=" + bizId +
                ", bizName='" + bizName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
