package com.IceCoLa.domain;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import java.util.Arrays;
import java.util.Set;

public class People {
    private int id;
    private String name;
    private Set<String> sets;

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sets=" + sets +
                '}';
    }

    public Set<String> getSets() {
        return sets;
    }

    public People() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("有参构造方法");
    }

}
