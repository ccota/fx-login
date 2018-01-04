package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.Navigation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();

        t.start();


    }


    private void start() {
        MockBootcampService bootcampService = new MockBootcampService();

        BootCamp bootCamp = null;

        System.out.println("Create bootcamp test : ");

        bootCamp = new BootCamp(1, "location", new GregorianCalendar(2018, 1, 1),new GregorianCalendar(2018, 4 ,1));

        if (bootCamp == null) {
            System.out.println("FAIL");
            return;
        }
        System.out.println("OK \n");


        System.out.println("Add  bootcamp test:");
        System.out.println("add a null bootcamp test:");
        bootcampService.addBootCamp(null);
        if (bootcampService.listAllBootcamps().size() != 0) {
            System.out.println("FAIL");
            return;
        }
        System.out.println("OK \n");

        System.out.println("add a bootcamp test");
        bootcampService.addBootCamp(bootCamp);
        if (bootcampService.listAllBootcamps().size() == 0){
            System.out.println("FAIL");
            return;
        }
        System.out.println("OK \n");

        System.out.println("Try to add the same bootcamp test");
        bootcampService.addBootCamp(bootCamp);
        if (bootcampService.listAllBootcamps().size() != 1){
            System.out.println("FAIL");
            return;
        }
        System.out.println("OK \n");



        User user1 = new User("user1", "pass", "email");
        User user2 = new User("user2", "pass", "email2");
        User user3 = new User("user1", "pass", "email3");
        User user4 = new User("user4", "pass", "email");


        CodeCadet codeCadet1 = new CodeCadet(user1, Gender.FEMALE, "adress", "city", "1234", new GregorianCalendar(1995, 01, 12));
        CodeCadet codeCadet2 = new CodeCadet(user2, Gender.FEMALE, "adress", "city", "1234", new GregorianCalendar(1995, 01, 12));
        CodeCadet codeCadet3 = new CodeCadet(user3, Gender.FEMALE, "adress", "city", "1234", new GregorianCalendar(1995, 01, 12));
        CodeCadet codeCadet4 = new CodeCadet(user4, Gender.FEMALE, "adress", "city", "1234", new GregorianCalendar(1995, 01, 12));


        System.out.println("Compare codecadet test 1: ");
        System.out.println("Code cadets are different?");
        if (codeCadet1.equals(codeCadet2)) {
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("Compare code cadet test 2: ");
        System.out.println("check if code cadet has same user name");
        if (codeCadet1.equals(codeCadet3)) {
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("Compare code cadet test 3: ");
        System.out.println("check if code cadet has same e-mail");
        System.out.println("Code cadet 1: " + codeCadet1.toString());
        System.out.println("Code cadet 4: " + codeCadet4.toString());

        if (codeCadet1.equals(codeCadet4)) {
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");


        System.out.println("Add code cadet to bootcamp test:");

        System.out.println("Can not add a null code cadet");
        bootcampService.addCodeCaddet(bootCamp, null);
        if (bootcampService.findById(bootCamp.getId()).getCadets().size() != 0){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("Cadet doesn't have a bootcamp before being added to one:");
        if (codeCadet1.getBootCamp() != null){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("add a new code cadet test");
        bootcampService.addCodeCaddet(bootCamp, codeCadet1);
        if (bootcampService.findById(bootCamp.getId()).getCadets().size() != 1){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("add annother cadet to same bootcamp");
        bootcampService.addCodeCaddet(bootCamp, codeCadet2);
        if (bootcampService.findById(bootCamp.getId()).getCadets().size() != 2){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("remove a caddet from bootcamp:");
        bootcampService.findById(bootCamp.getId()).removeCadet(codeCadet2);
        if (bootcampService.findById(bootCamp.getId()).getCadets().size() != 1){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("Cadet has a bootcamp after being added to one:");
        if (codeCadet1.getBootCamp() == null){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");



        System.out.println("Can not add the same cadet");
        bootcampService.addCodeCaddet(bootCamp, codeCadet1);
        if (bootcampService.findById(bootCamp.getId()).getCadets().size() != 1){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("if the added cadet is in another bootcamp, removes the cadet from that bootcamp and adds in the new one:");
        BootCamp bootCamp2 = new BootCamp(2,"location", new GregorianCalendar(2018, 2,5), new GregorianCalendar(2018, 5, 4));
        bootcampService.addBootCamp(bootCamp2) ;
        bootcampService.addCodeCaddet(bootCamp2, codeCadet1);
        if (bootcampService.findById(bootCamp2.getId()).getCadets().size() != 1 && bootcampService.findById(bootCamp.getId()).getCadets().size() != 0 ){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");


        System.out.println("list bootcamps test:");
        if (bootcampService.listAllBootcamps().size() != 2){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");

        System.out.println("list caddets test:");
        bootcampService.addCodeCaddet(bootCamp2, codeCadet2);
        if (bootcampService.listAllCodeCadets(bootCamp2).size() != 2){
            System.out.println("Fail");
            return;
        }
        System.out.println("OK \n");


        System.out.println("NO MORE TESTS");
    }

}
