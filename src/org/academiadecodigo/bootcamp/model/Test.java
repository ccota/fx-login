package org.academiadecodigo.bootcamp.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();

        MockBootcampService bootcampService = new MockBootcampService();

        bootcampService.addBootCamp(t.createBootCampTest());



        addCodeCadetsTest();
        listBootCampTest();
        listCaddetsTest();




    }

    private BootCamp createBootCampTest() {
        BootCamp bootCamp = null;
        try {

            System.out.println("#### CREATE BOOTCAMP \n\n");
            int id = 1;

            String location = "terceira";


            SimpleDateFormat test = new SimpleDateFormat("d MMM yyy");


            Date start = test.parse("15 JAN 2018");


            Date end = test.parse("3 MAR 2018");

            bootCamp = new BootCamp(id, location, start ,end);
            System.out.println(bootCamp.toString());




        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bootCamp;
    }

    private static void addCodeCadetsTest() {
        throw new UnsupportedOperationException();
    }

    private static void listBootCampTest() {
        throw new UnsupportedOperationException();
    }

    private static void listCaddetsTest() {
        throw new UnsupportedOperationException();
    }
}
