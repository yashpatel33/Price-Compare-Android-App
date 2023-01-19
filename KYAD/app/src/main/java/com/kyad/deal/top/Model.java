package com.kyad.deal.top;

import android.media.Image;

public class Model {
    int ID;
    String STORE_NAME;
    String Product_Name;
    int Logo;
    String Start_Date;
    String Rnd_Date;
    String Image;
    String Descriotions;
    String Deals_Type;
    String Product_Type;
    int Isfavourites;
    int IsInshoplist;
    int Discount;
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSTORE_NAME() {
        return STORE_NAME;
    }

    public void setSTORE_NAME(String STORE_NAME) {
        this.STORE_NAME = STORE_NAME;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public int getLogo() {
        return Logo;
    }

    public void setLogo(int logo) {
        Logo = logo;
    }

    public String getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(String start_Date) {
        Start_Date = start_Date;
    }

    public String getRnd_Date() {
        return Rnd_Date;
    }

    public void setRnd_Date(String rnd_Date) {
        Rnd_Date = rnd_Date;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescriotions() {
        return Descriotions;
    }

    public void setDescriotions(String descriotions) {
        Descriotions = descriotions;
    }

    public String getDeals_Type() {
        return Deals_Type;
    }

    public void setDeals_Type(String deals_Type) {
        Deals_Type = deals_Type;
    }

    public String getProduct_Type() {
        return Product_Type;
    }

    public void setProduct_Type(String product_Type) {
        Product_Type = product_Type;
    }

    public int getIsfavourites() {
        return Isfavourites;
    }

    public void setIsfavourites(int isfavourites) {
        Isfavourites = isfavourites;
    }

    public int getIsInshoplist() {
        return IsInshoplist;
    }

    public void setIsInshoplist(int isInshoplist) {
        IsInshoplist = isInshoplist;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }


}
