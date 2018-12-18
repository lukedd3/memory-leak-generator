package com.luke.main;

import com.luke.instanceListener.ListenersOwnerCaller;
import com.luke.staticListener.StaticListenersOwnerCaller;

import java.util.Scanner;

public class App {
    private static String WRONG_NUMBER_WARNING = "Wrong number! Execution aborted.";

    public static void main( String[] args )
    {
        System.out.print("1: Static listeners memory leak (listeners list is static field of a class)\n" +
                "2: Listeners memory leak (listeners list is an instance field of object)\n" +
                "Please enter the number and press enter: ");
        Scanner scanner = new Scanner(System.in);
        Integer input;
        try {
            input = scanner.nextInt();
        }
        catch (Exception e) {
            input = -1;
        }
        switch (input) {
            case 1:
                new StaticListenersOwnerCaller(1,5);
                break;
            case 2:
                new ListenersOwnerCaller(1,5);
                break;
            default:
                System.out.println(WRONG_NUMBER_WARNING);
                return;
        }
        System.out.println("** Now wait for OutOfMemoryError (OOM). You might use profiler like VisualVM to observe memory leak effects **");
        System.out.println("** Remember to put -XX:+HeapDumpOnOutOfMemoryError JVM option as parameter when running this app **");
    }
}
