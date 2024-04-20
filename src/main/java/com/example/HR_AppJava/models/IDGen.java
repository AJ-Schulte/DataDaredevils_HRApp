/* 
 * Generates unique positive IDs, the same way Demographics does.
 * Hopefully approaching id parity between objects.
*/
package com.example.HR_AppJava.models;

public class IDGen {
    private static int memberIDPosition = 0;

    public static int getID() {
        int memberID = memberIDPosition;
        memberIDPosition++;
        return memberID;
    }
}
