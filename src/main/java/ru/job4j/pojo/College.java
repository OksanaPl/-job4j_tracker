package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Plavinskaya Oksana ");
        student.setGroup("Стажер ");
        student.setReceipt(new Date(1670878800000L));
        System.out.println(student.getName() + student.getGroup() + student.getReceipt());
    }
}
