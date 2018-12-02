package com.company;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here


        DataBase dataBase=new DataBase();
        dataBase.add(new Drug("amizone","Company",15.5,20,1,"19.11.2018"));
        dataBase.add(new Drug("amizone","Company",20,100,3,"11.11.2019"));
        dataBase.add(new Drug("levomekol","Company",150,150,1,"11.11.2019"));


        dataBase.printData();
        System.out.println("___________________________________________");

        dataBase.goodsInAPharmacy(1);
        System.out.println("___________________________________________");

        dataBase.inPackingFrom100Pieces();
        System.out.println("___________________________________________");

        dataBase.PriceList();
        System.out.println("___________________________________________");

        dataBase.removeAllExpiredGoods();
        System.out.println("___________________________________________");

        System.out.println("___________________________________________");
        dataBase.printData();

    }
}
