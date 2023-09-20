import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Closest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dat = new int[n];
        for(int i = 0; i < n; i++) {
            dat[i] = in.nextInt();
        }
        Arrays.sort(dat);
        int minDiff = Integer.MAX_VALUE;
        String out = "";
        for(int i = 0; i < n - 1; i++) {
            if(dat[i + 1] - dat[i] <= minDiff) {
                if(dat[i + 1] - dat[i] == minDiff) {
                    out += " " + dat[i] + " " + dat[i + 1];
                } else {
                    out = dat[i] + " " + dat[i + 1];
                }
                minDiff = dat[i + 1] - dat[i];
            }
        }
        System.out.println(out);
    }
}