/* 
 * Generates unique positive IDs, the same way Demographics does.
 * Hopefully will help with id parity between objects.
*/
package com.example.HR_AppJava.models;
import java.util.Stack;
//import java.util.EmptyStackException;
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
            nextID.push(memberID+1);
            memberIDBoundary++;
            return memberID;
        }
    }

    public static void markFreeIndex(int i) {
        nextID.push(i);
    }

    public static void manualDecrement() {
        memberIDBoundary--;
        nextID.pop();
        nextID.push(memberIDBoundary);
    }

    public static void manualIncrement() {
        memberIDBoundary++;
        nextID.push(memberIDBoundary);
    }
}