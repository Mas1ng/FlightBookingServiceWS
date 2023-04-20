package com.flight.model;

import com.flight.exceptions.InvalidDataException;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month; // 1- january, ... 12- December
    private int year;
    private boolean isLeapYear(int year){
        // If a year is multiple of 400,
        // then it is a leap year
        if (year % 400 == 0)
            return true;
        // Else If a year is multiple of 100,
        // then it is not a leap year
        if (year % 100 == 0)
            return false;
        // Else If a year is multiple of 4,
        // then it is a leap year
        if (year % 4 == 0)
            return true;
        return false;

    }
    private boolean isValid(int day, int month, int year){
        boolean result = true;
        if(day <= 0 || day > 31 || month <= 0 || month > 12){
            result = false;
        }else{
            switch(month){
                case 2:
                    if(isLeapYear(year) == true){
                        if(day > 29){
                            result = false;
                        }
                    }else{
                        if(day > 28){
                            result = false;
                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(day > 30){
                        result = false;
                    }
                    break;
            }
        }
        return result;
    }
    public Date(){
        //default date
        setDate(1,1, 1900);
    }
    public Date(int day, int month, int year){
        setDate(day,month, year);
    }

    public void setDate(int day, int month, int year){
        if(isValid(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        else{
            String msg = day + "/" + month +"/"+ year;
            throw new InvalidDataException(msg);
        }
    }
    public void getDate(int [] dmy) {
        dmy[0] = this.day;
        dmy[1] = this.month;
        dmy[2] = this.year;
    };

    public boolean isEqualTo(Date obj) {
        if(this.day == obj.day && this.month == obj.month && this.year == obj.year){
            return true;
        }
        return false;
    }
    public boolean isGreaterThan (Date obj) {
        if(this.year > obj.year){
            return true;
        }
        if(this.month > obj.month){
            return true;
        }
        if(this.day > obj.day){
            return true;
        }
        return false;
    }

    public boolean isSmallerThan (Date obj){
        if(this.isEqualTo(obj)){
            return false;
        }
        if(this.isGreaterThan(obj)){
            return false;
        }
        return true;
    }

}
