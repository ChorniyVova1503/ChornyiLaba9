package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.*;

public class Drug {
    String nameOfTheDrug;
    String manufacturingCompany;
    double price;
    int theNumberOfUnitsInThePackage;
    int pharmacyNumber;
    String shelfLife;



    public void Drug(){}
    public  Drug(String nameOfTheDrug, String manufacturingCompany, double price,
                     int theNumberOfUnitsInThePackage, int pharmacyNumber, String shelfLife) {
        this.nameOfTheDrug=nameOfTheDrug;
        this.manufacturingCompany=manufacturingCompany;
        this.price=price;
        this.theNumberOfUnitsInThePackage=theNumberOfUnitsInThePackage;
        this.pharmacyNumber=pharmacyNumber;
        this.shelfLife=shelfLife;
    }

    public String getNameOfTheDrug() {
        return this.nameOfTheDrug;
    }

    public String getManufacturingCompany() {
        return this.manufacturingCompany;
    }

    public double getPrice() {
        return this.price;
    }

    public int getTheNumberOfUnitsInThePackage() {
        return this.theNumberOfUnitsInThePackage;
    }

    public int getPharmacyNumber() {
        return this.pharmacyNumber;
    }

    public String getShelfLife() {
        return this.shelfLife;
    }

    public void setNameOfTheDrug(String s) {
        boolean f = false;
        for (drugNames n : drugNames.values()) {
            if (n.toString().equals(s)) {
                this.nameOfTheDrug = s;
                f = true;
                break;
            }
        }
        if (f == false)
            System.out.println("Ощибка! Данный препарат не зарегестрирован!!!");
    }

    public void setManufacturingCompany(String s) {
        boolean f = false;
        Pattern p = Pattern.compile("^([A-Z][a-z]+)$");
        Matcher m = p.matcher(s);
        if (m.matches() == true) {
            this.manufacturingCompany = s;
            f = true;
        }
        if (f == false)
            System.out.println("Имя компании-производителя должно Начинаться с большой буквы и содержать минимум 2 символа!!!");
    }

    public void setPrice(int p) {
        boolean f = false;
        if (p > 0) {
            this.price = p;
            f = true;
        }
        if (!f) {
            System.out.println("Цена не может быть меньше либо равна нулю!");
        }
    }

    public void setTheNumberOfUnitsInThePackage(int n) {
        boolean f = false;
        if (n > 0) {
            this.price = n;
            f = true;
        }
        if (!f) {
            System.out.println("Количество едениц в упаковке не может быть меньше либо равна нулю!");
        }
    }

    public void setPharmacyNumber(int n) {


        boolean f = false;
        if (n > 0) {
            this.price = n;
            f = true;
        }
        if (!f) {
            System.out.println("Номер аптеки не может быть минусвым!");
        }
    }

    public void setShelfLife(String s) {//s ="22.33.1341 "
        //проверка через регулярное выражение
        Pattern p = Pattern.compile("^([0-3][0-9][.][0-1][0-2][.][0-9][0-9][0-9][0-9])$");
        Matcher m = p.matcher(s);
        Calendar calendar = Calendar.getInstance();
        if (m.matches() == true) {


            String str[] = s.split("[.]");
            int newday = Integer.valueOf(str[0]);
            int newmonth = Integer.valueOf(str[1]);
            int newyear = Integer.valueOf(str[2]);
            Date d = new Date();

            if (newyear > (1900 + d.getYear())) {
                this.shelfLife = newday + ".";
                this.shelfLife += newmonth + ".";
                this.shelfLife += newyear;
            } else if (newyear == (1900 + d.getYear()) && newmonth > (1 + d.getMonth())) {
                this.shelfLife = newday + ".";
                this.shelfLife += newmonth + ".";
                this.shelfLife += newyear;
            } else if (newyear == (1900 + d.getYear()) && newmonth == (1 + d.getMonth()) && newday > calendar.get(Calendar.DAY_OF_MONTH)) {
                this.shelfLife = newday + ".";
                this.shelfLife += newmonth + ".";
                this.shelfLife += newyear;
            } else
                System.out.println("Продукт уже просрочен!");
        } else
            System.out.println("Дата введена некорректно.Требуемый формат: dd.mm.yyyy");
    }

    enum drugNames {
        paracetamol,
        citramon,
        amizone,
        noshpa,
        mezin,
        levomekol,
        penicillin
    }

}


