package org.academiadecodigo.bootcamp.model;

import java.util.Date;

public class CodeCadet {
    private User user;
    private Gender gender;
    private String address;
    private String city;
    private String phone;
    private BootCamp bootCamp;
    private Date birthDate;

    public CodeCadet(User user, Gender gender, String address,
                     String city, String phone, Date birthDate) {
        this.user = user;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeCadet codeCadet = (CodeCadet) o;

        return user.equals(codeCadet.user);
    }
    public void setBootCamp(BootCamp bootCamp){
        this.bootCamp = bootCamp;
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

    public Date getBirthDate() {
        return birthDate;
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

