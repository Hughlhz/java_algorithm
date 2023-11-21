package com.Demo;

import java.util.Stack;

public class Leetcode844 {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> charS = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                charS.pop();
            } else {
                charS.push(s.charAt(i));
            }
        }
        Stack<Character> charT = new Stack<>();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                charT.pop();
            } else {
                charT.push(t.charAt(i));
            }
        }
        StringBuffer s1 = new StringBuffer();
        StringBuffer t1 = new StringBuffer();
        while (!charS.empty()) {
            s1.append(charS.pop());
        }
        while (!charT.empty()) {
            t1.append(charT.pop());
        }
        if (s1.toString() .equals (t1.toString())) {
            return true;
        } else {
            return false;
        }
    }

}
