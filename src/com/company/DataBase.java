package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DataBase {
    ArrayList<Drug> Data=new ArrayList<Drug>();

    public void add(Drug drug){
        this.Data.add(drug);
    }
    public void printData(){
        for (int i = 0; i <Data.size() ; i++) {
            System.out.println("name Of The Drug:"+this.Data.get(i).nameOfTheDrug);
            System.out.println("manufacturing Company:"+this.Data.get(i).manufacturingCompany);
            System.out.println("pharmacy Number:"+this.Data.get(i).pharmacyNumber);
            System.out.println("Price:"+this.Data.get(i).price);
            System.out.println("the Number Of Units In The Package:"+this.Data.get(i).theNumberOfUnitsInThePackage);
            System.out.println("Shelf life:"+this.Data.get(i).shelfLife);
        }
    }
    public void removeAllExpiredGoods(){
        for (int i = 0; i < Data.size(); i++) {
            Date d=new Date();
            Calendar c=Calendar.getInstance();
            String str[]=Data.get(i).shelfLife.split("[.]");
            int day= Integer.valueOf(str[0]);
            int month=Integer.valueOf(str[1]);
            int year=Integer.valueOf(str[2]);
            int a=1900+d.getYear();
           int m=d.getMonth();
            int dayrrr =c.get(Calendar.DAY_OF_MONTH);
            if(year<(1900+d.getYear()))
            {
                Data.remove(i);

            }
            else if(year==(1900+d.getYear())&&(month)<(1+d.getMonth()))
            {

                Data.remove(i);

            }
            else if(year==(1900+d.getYear())&&month==(1+d.getMonth())&&day<c.get(Calendar.DAY_OF_MONTH)){
                Data.remove(i);
            }

        }
    }
    public void inPackingFrom100Pieces(){
        for (int i = 0; i < Data.size(); i++) {
            if(Data.get(i).theNumberOfUnitsInThePackage>=100){
                System.out.println("Name of the drug  in Packing From 100 Pieces:"+Data.get(i).nameOfTheDrug);
            }
        }
    }
    public void goodsInAPharmacy(int number){
        boolean flag = false;

        for (int i = 0; i <Data.size() ; i++) {

            if (Data.get(i).pharmacyNumber == number) {
                System.out.println(Data.get(i).nameOfTheDrug);
                flag=true;
            }
        }
        if (!flag)
            System.out.println("Такой аптеки нет!");

    }
    public void PriceList(){
        for (int i = 0; i <Data.size() ; i++) {
            System.out.println("pharmacy Number:"+this.Data.get(i).pharmacyNumber);

            System.out.println("name Of The Drug:"+this.Data.get(i).nameOfTheDrug);

            System.out.println("Price:"+this.Data.get(i).price);


        }
    }

    public void outToFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data.dat")))
        {
            oos.writeObject(Data);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Drug> inputFromFile(){
        ArrayList<Drug> Data=null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.dat")))
        {
            Data=(ArrayList) ois.readObject();

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return Data;
    }
}
