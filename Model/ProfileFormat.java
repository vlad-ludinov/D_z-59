package model;

import exception.InvalidDataFormatException;

public class ProfileFormat {

    private String name;
    private String surName;
    private String fatherName;
    private String date;
    private Long phone;
    private Character gender;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurName() {
        return surName;
    }
    
    public void setSurName(String surName) {
        this.surName = surName;
    }
    
    public String getFatherName() {
        return fatherName;
    }
    
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) throws InvalidDataFormatException{
        if (date.length() != 10) {
            throw new InvalidDataFormatException("Invalid input format: date format expected dd.mm.yyyy1");
        } else {
            String[] dateArr = date.split("\\.");
            if (dateArr.length != 3 || !Checking.isDate(dateArr[0], dateArr[1], dateArr[2])) {
                throw new InvalidDataFormatException("Invalid input format: date format expected dd.mm.yyyy");
            }
        }
        this.date = date;
    }
    
    public Long getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) throws InvalidDataFormatException{
        if (!Checking.isPhoneNumber(phone)) {
            throw new InvalidDataFormatException("Invalid input format: phone number format expected 11 numbers without signs");
        }
        this.phone = Long.parseLong(phone);
    }
    
    public Character getGender() {
        return gender;
    }
    
    public void setGender(String gender) throws InvalidDataFormatException {
        if (!Checking.isGender(gender)) {
            throw new InvalidDataFormatException("Invalid input format: gender format expected 'f' or 'm' characters");
        }
        this.gender = gender.charAt(0);
    }



}