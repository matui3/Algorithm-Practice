package GeeksForGeeks;

import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        String str = "Geeks";
        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
        String result = "";
        for (int i = str.length()-1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
