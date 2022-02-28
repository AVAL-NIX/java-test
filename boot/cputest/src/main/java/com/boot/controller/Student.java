package com.boot.controller;

import java.time.LocalDate;

public class Student {
    public String username;
    public String id;

    @Override
    public String toString() {
        return this.id + ":" + this.username;
    }

    public Student(String username, String id) {
        this.username = username;
        this.id = id;
    }

    public Student(String username) {
        this.username = username;
    }

    public Student() {
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021, 10, 9);
        LocalDate localDate1 = LocalDate.of(2022, 1, 25);

        //日利率
        double rate = 0.1d / 365d;
        System.out.println((localDate1.toEpochDay() - localDate.toEpochDay()) * 100000 * rate);
    }

}