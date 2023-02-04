package com.alanlearn.IphoneDataPlatform.bean;

public class Iphone {
	private String id;
	private String name;
	private String soc;
    private int releaseYear;
    private double battery;

    public Iphone(String id, String name, String soc, int releaseYear, double battery) {
        this.id = id;
        this.name = name;
        this.soc = soc;
        this.releaseYear = releaseYear;
        this.battery = battery;
    }

    public Iphone(){
        this.id = "1000";
        this.name = "Iphone XX";
        this.soc = "A100";
        this.battery= 1000;
        this.releaseYear= 1000;
    }
    public Iphone(String id, String name, String soc) {
        this.id = id;
        this.name = name;
        this.soc = soc;
        this.battery= 1000;
        this.releaseYear= 1000;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getSoc() {
        return soc;
    }
 
    public void setSoc(String soc) {
        this.soc = soc;
    }

}
