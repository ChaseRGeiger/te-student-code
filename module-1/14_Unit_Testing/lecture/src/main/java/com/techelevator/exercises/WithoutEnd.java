package com.techelevator.exercises;

public class WithoutEnd {

    /*
     Given a string, return a version without both the first and last char of the string. The string
     may be any length, including 0.
     withoutEnd2("Hello") → "ell"
     withoutEnd2("abc") → "b"
     withoutEnd2("ab") → ""
     */
    public String withoutEnd(String str) {
        if (str.length() <= 2) {
            return "";
        }
        return str.substring(1, str.length() - 1);
    }
}
