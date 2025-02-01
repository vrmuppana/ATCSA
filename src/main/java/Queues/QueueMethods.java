//package Queues;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
//
//public class QueueMethods {
//
//    // Returns a new queue that is the clone of one.
//    public static Queue<String> clone(Queue<String> one) {
//        Queue<String> temp = one;
//        Queue<String> result = new LinkedList<String>();
//        while (!temp.isEmpty()) {
//            result.add(temp.poll());
//        }
//        return result;
//    }
//    // Try a different approach to clone (hint: one is longer, one is short)
//    public static Queue<String> clone2(Queue<String> one) {
//        return new LinkedList<>(one);
//    }
//
//    // Returns a new Queue that is the reverse of one.
//    public static Queue<String> reverse(Queue<String> x) {
//        Queue<String> q1 = x;
//        Stack<String> st = new Stack<String>();
//        while (!q1.isEmpty()) {
//            st.push(q1.poll());
//        }
//        while (!st.isEmpty()) {
//            q1.add(st.pop());
//        }
//        return q1;
//    }
//
//    // add Queue y to the end of Queue x. Return the new queue
//    public static Queue<String> append(Queue<String> x, Queue<String> y) {
//        Queue<String> result = new LinkedList<String>(x);
//        Queue<String> temp = new LinkedList<String>(y);
////        while (!temp.isEmpty()) {
//////            result.add(temp.poll());
//////        }
//        result.addAll(temp);
//        return result;
//    }
//
//    // Return a new queue with alternating values from one and two
//    public static Queue<String> alternate(Queue<String> one, Queue<String> two) {
//        Queue<String> result = new LinkedList<>();
//        int i = 0;
//        while (!one.isEmpty() && !two.isEmpty()) {
//            if (!one.isEmpty()) {
//                result.add(one.poll());
//            }
//            if (!two.isEmpty()) {
//                result.add(two.poll());
//            }
//        }
//        return result;
//    }
//
//    // Determines if a queue of strings is a palindrome. Return True/False
//    public static boolean isPalindrome(Queue<String> x) {
//        Queue<String> temp = x;
//        Stack<String> st = new Stack<String>();
//        for (int i = 0; i < x.size()/2; i++) {
//            st.push(temp.poll());
//        }
//        if (x.size()%2==1) {
//            temp.poll();
//        }
//        while (!st.isEmpty()) {
//            if (st.pop() != temp.poll()) {
//                return false;
//            }
//        }
//        return true;
//    }
//    // Try a different approach to palindrome (hint: one is longer, one is short)
//    public static boolean isPalindrome2(Queue<String> x) {
//
//    }
//
//    // Determines if a queue of strings are in alphanumeric order. Return True/False
//    public static boolean isAlphabetical(Queue<String> x) {
//        Queue<String> temp = x;
//        String prev = temp.poll();
//        while (!temp.isEmpty()) {
//            if (temp.poll().compareTo(prev) < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // Calculates the average of a queue of integers.
//    public static double average(Queue<Integer> x) {
//        Queue<Integer> temp = x;
//        int num = 0;
//        while (!temp.isEmpty()) {
//            num+=temp.poll();
//        }
//        return num/x.size();
//    }
//
//    // Determines whether string lookFor is in the Queue lookIn . Return True/False
//    public static boolean search(String lookFor, Queue<String> lookIn) {
//        Queue<String> temp = lookIn;
//        while (!temp.isEmpty()) {
//            if (temp.poll()==lookFor) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // remove all of the occurrences of lookFor in Queue lookIn
//    public static Queue<String> remove(String lookFor, Queue<String> lookIn) {
//        Queue<String> temp = new LinkedList<String>();
//        while (!lookIn.isEmpty()) {
//            if (lookIn.peek()==lookFor) {
//                temp.add(lookIn.poll());
//            }
//        }
//        return false;
//    }
//
//    // Remove every other element of one starting with the first
//    public static Queue<String> removeEveryOther(Queue<String> one) {
//
//    }
//
//    // return a string of the first n binary numbers.... 1 10 11 100 101 110 111
//    // 1000...
//    public static String generateBinary(int n) {
//
//    }
//
//    public static void main(String[] args) {
//
//        Queue<String> one = new LinkedList<String>();
//
//        one.offer("A");
//        one.offer("B");
//        one.offer("C");
//        one.offer("D");
//        one.offer("E");
//        one.offer("Z");
//        System.out.println("ONE: " + one);
//        System.out.println("REMOVE EVERY OTHER:" + removeEveryOther(one));
//        System.out.println("REVERSE:" + reverse(one));
//        System.out.println("SEARCH for E:" + search("E", one));
//        System.out.println("SEARCH for Q:" + search("Q", one));
//        Queue<String> two = new LinkedList<String>();
//        two.offer("1");
//        two.offer("2");
//        two.offer("2");
//        two.offer("1");
//        System.out.println("TWO: " + two);
//        System.out.println("APPEND " + append(one, two));
//        System.out.println("REMOVE 1: " + remove("1", two));
//        System.out.println("TWO: " + two);
//        System.out.println("REMOVE 7: " + remove("7", two));
//        System.out.println("TWO: " + two);
//        System.out.println("COPY: " + clone(one));
//        System.out.println("ALTERNATE: " + alternate(one, two));
//        System.out.println("ONE: " + one);
//        System.out.println("TWO: " + two);
//        System.out.println("ISPALINDROME ONE? " + isPalindrome(one));
//        System.out.println("ISPALINDROME TWO? " + isPalindrome(two));
//        System.out.println("ISALPHABETICAL ONE? " + isAlphabetical(one));
//        System.out.println("ISALPHABETICAL TWO? " + isAlphabetical(two));
//        System.out.println(isPalindrome2(one));
//        System.out.println(reverse(one));
//        System.out.println(one);
//        Queue<Integer> three = new LinkedList<Integer>();
//        three.offer(11);
//        three.offer(12);
//        three.offer(2);
//        three.offer(71);
//        System.out.println("AVERAGE: " + average(three));
//        System.out.println("THREE: " + three);
//        System.out.println(generateBinary(16));
//    }
//
//}