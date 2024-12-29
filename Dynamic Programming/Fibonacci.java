import java.util.Arrays;
import java.util.Scanner;
public class Fibonacci{
    private int fibonacci(int n, int[] dp){
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fibonacci(n-1, dp)+fibonacci(n-2,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        Fibonacci fb = new Fibonacci();
        System.out.println(fb.fibonacci(n, dp));
    }
}