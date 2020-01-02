package com.example.djcustomerapp;

public class DjHistoryListData {
    private String shopname;
    private String djname;
    private String price;
    private String datentime;
    private String location;

    private int imgId;
    private static DjHistoryListData[] currentDJList;

    public static DjHistoryListData[] getCurrentDJList() {
        return currentDJList;
    }

    public static void setCurrentDJList(DjHistoryListData[] currentDJList) {
        DjHistoryListData.currentDJList = currentDJList;
    }

    public DjHistoryListData(String shopname, String djname, String price, String location, String datentime, int imgId) {
        this.shopname = shopname;
        this.djname = djname;
        this.price = price;
        this.location = location;
        this.datentime = datentime;
        this.imgId = imgId;
    }

    public String getShopname(){
        return shopname;
    }
    public void setShopname(String shopname){
        this.shopname = shopname;
    }

    public String getDjname() {
        return djname;
    }
    public void setDjname(String djname) {
        this.djname = djname;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price){
        this.price=price;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    public String getDatentime(){return datentime;}
    public void setDatentime(String datentime){this.datentime = datentime;}

    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

}
