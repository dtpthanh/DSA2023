import java.util.Scanner;

public class SherlockArray{
    public static String balancedSums(int []arr, int n){
        int totalSum = 0;
        int runningSum = 0;
        for(int i = 0; i < n; i++){
            totalSum+= arr[i];
        }
        for(int i = 0; i < n; i++){
            if(runningSum == totalSum - runningSum - arr[i]){
                return "YES";
            }
            runningSum += arr[i];
        }
        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int [] arr;
            arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(balancedSums(arr, n));
        }
    }
}