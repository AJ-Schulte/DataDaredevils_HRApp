/* 
 * Generates unique positive IDs, the same way Demographics does.
 * Hopefully will help with id parity between objects.
*/
package com.example.HR_AppJava.models;
import java.util.Stack;
public class IDGen {
    private static int memberIDBoundary = 0;
    private static Stack<Integer> nextID = new Stack<>();
    //private static int lastGivenID;

    public static void startIDGenerator() {
        nextID.push(0);
    }

    public static int getID() {
        int memberID = nextID.pop();
        if(memberID < memberIDBoundary) {
            System.out.println(nextID.toString());
            return memberID;
        } else {
            memberIDBoundary++;
            nextID.push(memberIDBoundary);
            //System.out.println(nextID.toString());
            return memberID;
        }
    }

    public static void markFreeIndex(int i) {
        nextID.push(i);
        System.out.println(nextID.toString());
    }

    public static int getVolatileID() {
        return nextID.peek();
    }

    public static int verifyIndex(int i, int arraySize) {
        //System.out.println(arraySize);
        //System.out.println(memberIDBoundary);
        arraySize++;
        if((arraySize != memberIDBoundary)) {
            i = i-(memberIDBoundary-arraySize);
            if(i<0) i = 0;
            return i;
        } else return i;
    }
}