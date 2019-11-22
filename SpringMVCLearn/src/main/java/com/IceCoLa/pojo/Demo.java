package com.IceCoLa.pojo;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import java.util.List;

public class Demo {
    private List<People> people;
    private String address;

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "people=" + people +
                ", address='" + address + '\'' +
                '}';
    }
}
