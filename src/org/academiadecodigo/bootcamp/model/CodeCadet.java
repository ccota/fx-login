package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.utils.Gender;

import java.util.Calendar;

public class CodeCadet {
    private User user;
    private Gender gender;
    private String address;
    private String city;
    private String phone;
    private BootCamp bootCamp;
    private Calendar birthDate;
    private String birthDateString;

    public CodeCadet(User user, Gender gender, String address,
                     String city, String phone, Calendar birthDate) {
        this.user = user;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.birthDate = birthDate;

        birthDateString = Integer.toString( birthDate.get(Calendar.DAY_OF_MONTH)) + "/" + Integer.toString(birthDate.get(Calendar.MONTH)) + "/" + Integer.toString(birthDate.get(Calendar.YEAR));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeCadet codeCadet = (CodeCadet) o;

        return user.equals(codeCadet.user);
    }

    public void setBootCamp(BootCamp bootCamp) {
        this.bootCamp = bootCamp;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }

    public User getUser() {
        return user;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public BootCamp getBootCamp() {
        return bootCamp;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public String getBirthDateString() {
        return birthDateString;
    }

    @Override
    public String toString() {
        return "CodeCadet{" +
                "user=" + user.toString() +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", bootCamp=" + bootCamp +
                ", birthDate=" + birthDate +
                '}';
    }


}

