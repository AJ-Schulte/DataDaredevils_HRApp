/* 
 * Generates unique positive IDs, the same way Demographics does.
 * Hopefully will help with id parity between objects.
*/
package com.example.HR_AppJava.models;
import java.util.Stack;
public class IDGen {
    private static int memberIDBoundary = 0;
    private static Stack<Integer> nextID = new Stack<>();

    public static void startIDGenerator() {
        nextID.push(0);
    }

    public static int getID() {
        int memberID = nextID.pop();
        if(memberID < memberIDBoundary) {
            return memberID;
        } else {
            memberIDBoundary++;
            nextID.push(memberIDBoundary);
            return memberID;
        }
    }

    public static void markFreeIndex(int i) {
        nextID.push(i);
    }

    public static int getVolatileID() {
        return nextID.peek();
    }

    public static int verifyIndex(int i, int arraySize) {
        arraySize++;
        if((arraySize < memberIDBoundary) && (nextID.elementAt(nextID.size()-2)<i)) {
            i = i-(memberIDBoundary-arraySize);
            if(i<0) i = 0;
            return i;
        } else return i;
    }
}