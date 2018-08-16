package com.BugzTests;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {


    public static String [] calculateBlacklisted(TreeSet n)
    {
        //array to hold blacklist and their count
        String [] employees = new String[2];
        //string to hold the blacklist
        String theList = "";

        //count the ones in blacklist
        int numOfemp=0;

        //iterate through the set
        Iterator itr = n.iterator();

        while (itr.hasNext())
        {
            int count = 0;
            int extracted = (int)itr.next();

            //take interest in this ---> set.headset method of treeset
            int headSet = n.headSet(extracted).size();

            //if value (set.next) is 1, skip processing. that is alfred
            if(extracted ==1)
            {
                continue;
            }


            //else check if the (num+seniors)is prime
            for(int i=2;i<extracted;i++)
            {


              if ((extracted+headSet)%i == 0)
                 {
                     //if the number is divisible by any number between 2 & num-1.
                     //then it is not prime and count will increase by one and break to outer while loop
                    count++;
                    break;
                 }
            }

            //if count is > 0 that means number was not prime and thus continue evaluating next employee
            if(count>0)
            {
                continue;
            }

            else

            {
                //else if count is 0 that means the number is prime
                //thus add it to theList string
                //increment the blacklist counter by one
                theList = theList+"  "+extracted;
                numOfemp++;
            }

        }

        employees[0] = theList;
        employees[1] = ""+numOfemp;

        // return theList and the blacklist counter
        return employees;
    }

    public static void main(String[] args)
    {
        getUserInput();

    }


    private static void intChecks(String[] userInput) {
        TreeSet<Integer> allEmps;
        try
        {
            if ((Integer.parseInt(userInput[0]) == Double.parseDouble(userInput[0])) &&
                    (Integer.parseInt(userInput[1]) == Double.parseDouble(userInput[1])))
            {
                allEmps = prepareTreeSet(userInput);
                processAndDisplay(allEmps);

            }
            else
            {
                System.out.println("please enter an integer value for both scenarios \n");

                getUserInput();
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("please enter an integer value for both scenarios \n");

            getUserInput();
        }
    }

    private static void processAndDisplay(TreeSet<Integer> allEmps) {
        //show the employess ranks produced
        System.out.println("List of the employees to be avaluated---> "+allEmps.toString()+"\n");

        //process the ones blacklisted
        String [] theBlacklist = Main.calculateBlacklisted(allEmps);

        System.out.println("the list of the blacklisted employess ---> "+ theBlacklist[0]);
        System.out.println("num of employees in the list ---> "+theBlacklist[1]);
    }

    private static TreeSet<Integer> prepareTreeSet(String [] userInput) {
        //we want to have random ranks for the number of employees specified by the user
        // since math.random can produce duplicates which are not needed as per the question
        // we use a treeset to eliminate them
        TreeSet<Integer> rank = new TreeSet<>();

        //this is alfred
        rank.add(1);

        while(rank.size() != Integer.parseInt(userInput[0])+1)
        {
            int i = 0;

            int randNum = (int) (Math.random() * Integer.parseInt(userInput[1])) * (i + 1);


            if (randNum <= Integer.parseInt(userInput[1]) && randNum > 1)
            {
                rank.add(randNum);

            }

            i++;

        }
        return rank;
    }


    private static void getUserInput() {

        // the user enters the number of employees they want and the maximum rank they want
        Scanner input = new Scanner(System.in);

        String [] userInput = new String[2];

        System.out.println("enter the number of employees you want");

        userInput[0] = input.nextLine();

        System.out.println("enter the maximum rank you want");

        userInput[1] = input.nextLine();

        //input vallidation for processing
        intChecks(userInput);
    }
}

//this is for if you only want the user to specify the number of employess and their ranks will be assigned
//sequentially i.e 3 employess, ranks 1,2,3...

//        for(int i=0;i<=n;i++)
//        {
//
//            int count=0;
//            for(int j=2;j<i;j++)
//            {
//                if ((i+(i-1))%j == 0)
//                {
//                    count++;
//                    break;
//                }
//            }
//
//            if(count>0)
//            {
//                continue;
//            }
//
//                theList= theList+", "+i;
//                numOfemp++;
//
//        }
//
//        return "( :"+theList+" :)"+numOfemp;
