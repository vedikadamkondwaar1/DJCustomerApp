package com.example.djcustomerapp;

public class DjbookListData {
    private String shopname;
    private String djname;
    private String price;
    private String location;
    private int imgId;
    private static DjbookListData[] currentDJList;

    public static DjbookListData[] getCurrentDJList() {
        return currentDJList;
    }

    public static void setCurrentDJList(DjbookListData[] currentDJList) {
        DjbookListData.currentDJList = currentDJList;
    }

    public DjbookListData(String shopname, String djname, String price, String location, int imgId) {
        this.shopname = shopname;
        this.djname = djname;
        this.price = price;
        this.location = location;
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

    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

}
