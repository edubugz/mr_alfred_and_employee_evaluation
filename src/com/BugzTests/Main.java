package com.BugzTests;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static String [] calculateBlacklisted(TreeSet n)
    {
        //string to hold the blacklist
        String [] employees = new String[2];
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
        // the user enters the number of employees they want and the maximum rank they want

        Scanner input = new Scanner(System.in);

        System.out.println("enter the number of employees you want");

        int employees = input.nextInt();

        System.out.println("enter the maximum rank you want");

        int maxRank = input.nextInt();



        //we want to have random ranks for the number of employees specified by the user
        // since math.random can produce duplicates which are not needed as per the question
        // we use a treeset to eliminate them
        TreeSet<Integer> rank = new TreeSet<>();

        //this is alfred
        rank.add(1);

            while(rank.size() != employees+1)
            {
                int i = 0;

                int randNum = (int) (Math.random() * maxRank) * (i + 1);


                if (randNum <= maxRank && randNum > 1)
                {
                    rank.add(randNum);

                }

                i++;

            }

            //show the employess ranks produced
        System.out.println("List of the employees to be avaluated---> "+rank.toString()+"\n");

            //process the ones blacklisted
        String [] theBlacklist = Main.calculateBlacklisted(rank);

        System.out.println("the list of the blacklisted employess ---> "+ theBlacklist[0]);
        System.out.println("num of employees in the list --->"+theBlacklist[1]);


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
