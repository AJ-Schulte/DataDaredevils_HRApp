/*
 * A class for stress testing the arrays.
 * So far I've noticed a performance drop between 10,000 & 100,000 entries, but that's about it.
 * Feel free to add your own tests as needed.
 */
package com.example.HR_AppJava.models;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class Testing {
    private static Random rnd = new Random();

    // Converts an int 0-25 to a char.
    private static char lookup(int in) {
        switch (in + 1) {
            case 1:
                return 'a';

            case 2:
                return 'b';

            case 3:
                return 'c';

            case 4:
                return 'd';

            case 5:
                return 'e';

            case 6:
                return 'f';

            case 7:
                return 'g';

            case 8:
                return 'h';

            case 9:
                return 'i';

            case 10:
                return 'j';

            case 11:
                return 'k';

            case 12:
                return 'l';

            case 13:
                return 'm';

            case 14:
                return 'n';

            case 15:
                return 'o';

            case 16:
                return 'p';

            case 17:
                return 'q';

            case 18:
                return 'r';

            case 19:
                return 's';

            case 20:
                return 't';

            case 21:
                return 'u';

            case 22:
                return 'v';

            case 23:
                return 'w';

            case 24:
                return 'x';

            case 25:
                return 'y';

            default:
                return 'z';
        }
    }

    /* Fills an array with objects initialized with 5-character dummy strings andrandom integers.
     * Modes: 1=EmployeeDemographics, 2=EmployeeJobHistory, 3=User, 4=EmployeeEvaluation
     * Theoretical max size without duplicates is 26^5=11,881,376 entries. Any more would need more chars.*/
    public static void arrayGen(int mode) {
        System.out.println("Generating array...");
        long t1 = System.currentTimeMillis();
        char p1 = 'a';
        char p2 = 'a';
        char p3 = 'a';
        char p4 = 'a';
        char p5 = 'a';
        String fullString;
        for (int i = 1; i < 1000000; i++) {
            fullString = "" + p1 + p2 + p3 + p4 + p5;
            switch (mode) {
                case 1:
                    new EmployeeDemographics(fullString, fullString, fullString, fullString, fullString);
                    break;

                case 2:
                    TempArrays.addToJobHistory(
                            new EmployeeJobHistory(fullString, fullString, rnd.nextInt(40), fullString, fullString,
                                    i - 1));
                    break;

                case 3:
                    TempArrays.addUser(new User(fullString, fullString, fullString, fullString, false));
                    break;

                case 4:
                    TempArrays.addToEmployeeEvaluation(
                            new EmployeeEvaluation(fullString, Date.from(Instant.now()), fullString, fullString,
                                    i - 1));
            }
            // What follows is the base-26 wizardry to make the chars increment correctly.
            p5 = lookup(i % 26);
            if (i % 26 == 0) {
                p4 = lookup(i / 26 % 26); // /26 for how many TIMES it's wrapped, +1 because lookup starts at 1, %26 to force the answer to be 1-26.
            }
            if (i % 676 == 0) {
                p3 = lookup(i / 676 % 26); // Then the divisor has to be multipled by 26 for each position up.
            }
            if (i % 17576 == 0) {
                p2 = lookup(i / 17576 % 26);
            }
            if (i % 456976 == 0) {
                p1 = lookup(i / 456976 % 26);
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Array generation time: " + (t2 - t1) + "ms");
    }
    /* 
    public static void main(String[] args) throws Exception {
        //EmployeeDemographics tests
        arrayGen(1);
        long t1 = System.currentTimeMillis();
        System.out.println(TempArrays.searchDemographic(rnd.nextInt(1000000-2)).toString());
        long t2 = System.currentTimeMillis();
        System.out.println("Demographics array search time: " + (t2-t1) + "ms");
     

       
        // EmployeeJobHistory tests
        //arrayGen(2);
       
        //User tests  
        //arrayGen(3);
        User boss = new User("JDoe", "jdoe@email.com", "1234", "Industry Inc.", true);
        User employee = new User("JDoeJr", "jdoejr@email.com", "password", "Industry Inc.", false);
        boss.setId(1);
        employee.setId(2);
        TempArrays.addUser(boss);
        TempArrays.addUser(employee);
        boss.createReview(boss, employee, "Cheery", "Slightly late");

         
        // EmployeeEvaluation tests
        //arrayGen(4);
    } */
}