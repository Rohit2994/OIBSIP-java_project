import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class task1 {
    static Scanner sc=new Scanner(System.in);
    static Operation op=new Operation();
    public static void main(String[] args) {

        {
            System.out.println("-------------------Please Login-----------------------");
            System.out.println("Enter Username");
            String username = sc.next();
            System.out.println("Enter Password");
            String password = sc.next();
            op.Login(username,password);

            while (true) {
                System.out.println("Enter Your Choice");
                System.out.println("1.TICKET RESERVATION");
                System.out.println("2.TICKET CANCELLATION");
                System.out.println("3.DISPLAY ");
                System.out.println("4.EXIT");

                int choice = sc.nextInt();

                if (choice == 1) {
                    insertRecord();
                } else if (choice == 2) {
                    removeRecord();
                } else if (choice == 3) {
                    displayRecord();
                } else if (choice == 4) {
                    System.out.println("Exiting the program.\n");
                    break;
                } else {
                    System.out.println("Invalid Choice Entered.\n");
                }
            }
        }
    }

    static void insertRecord(){
        //accept pass_name, train_no......
        System.out.println("ENTER PASSENGER NAME : ");
        String name= sc.next();
        System.out.println("ENTER TRAIN NUMBER : ");
        String trainNo= sc.next();
        System.out.println("ENTER CLASS TYPE : " );
        String cType= sc.next();
        System.out.println("ENTER JOURNEY DATE IN YYYY-MM-DD : ");
        String date=sc.next();
        System.out.println("ENTER JOURNEY FROM ");
        String from= sc.next();
        System.out.println("ENTER JOURNEY TO");
        String jto=sc.next();

        //add info to passengerRecord class object
        passengerRecord pr=new passengerRecord();
        pr.setPassengerName(name);
        pr.setTrainNumber(trainNo);
        pr.setClassType(cType);
        pr.setJourneyDate(date);
        pr.setFrom(from);
        pr.setTo(jto);

        //call addRecord method from Operation
        int count= 0;
        try {
            count = op.addRecord(pr);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count+"TICKET HAS BEEN BOOKED SUCCESSFULLY");

    }

    static void removeRecord(){
        System.out.println("Enter PNR Number:");
        int pnr= sc.nextInt();
        passengerRecord pr=new passengerRecord();
        pr.setPrnNumber(pnr);
        int count= op.removeRecord(pr);
        System.out.println(count+"********* TICKET CANCELLED **********");
    }

    static void displayRecord(){
        //call showRecord()
        System.out.println("PNR_Number\tPassenger_Name\t\tTrain_No\tClass_Type\t\tJourney_Date\tJourney_from\tJourney_To");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        ArrayList<passengerRecord> data=op.showRecord();
        for(passengerRecord p:data)
            System.out.println(p);
    }
}
