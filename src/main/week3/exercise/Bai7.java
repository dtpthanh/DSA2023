package main.week3;

import java.util.Arrays;
import java.util.Scanner;

public class Bai7 {
    public static void ThreeSum (int[] a) {
        int n = a.length;
        Arrays.sort(a);
        for(int i=0; i< n; i++) {
            int left = i+1, right = n-1;
            while (left < right) {
                int total = a[i] + a[left] +a[right];
                if(total>0) right--;
                if(total<0) left++;
                if(total==0) {
                    System.out.println(a[i]+ " " + a[left] + " " + a[right]);
                    left++;
                    right--;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = in.nextInt();
        }
        ThreeSum(a);
    }
}
