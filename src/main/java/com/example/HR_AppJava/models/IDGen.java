/* 
 * Generates unique positive IDs, the same way Demographics does.
 * Hopefully will help with id parity between objects.
*/
package com.example.HR_AppJava.models;
public class IDGen {
    private static int memberIDPosition = 0;

    public static int getID() {
        int memberID = memberIDPosition;
        memberIDPosition++;
        return memberID;
    }

    //A stack that normally has the last index of the array but gets updated with indices of removed entries would help with deletion integrity.
}