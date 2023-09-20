package main.week3;
import java.util.Scanner;
import java.util.Arrays;

public class Bai2 {
    public static int binarySearch(int[] a, int number, int m, int n) {
        if(n >= m) {
            int mid = m + (n-m) / 2;
            if (a[mid] == number) return mid;
            else if (a[mid] > number)    return binarySearch(a, number, m, mid-1);
            else if (a[mid] < number)   return binarySearch(a, number, mid+1, n);
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so phan tu cua mang: ");
        int n = input.nextInt();
        int[] a = new int[n];
        System.out.println("Nhap cac phan tu cua mang: ");
        for (int i=0; i<n; i++) {
            a[i] = input.nextInt();
        }
        System.out.println("Nhap so nguyen can tim: ");
        int number = input.nextInt();
        Arrays.sort(a); //Sap xep mang
        System.out.println("Chi so phan tu can tim: ");
        System.out.print(binarySearch(a,number, 0, n));
    }
}
