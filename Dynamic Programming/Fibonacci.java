import java.util.Arrays;
import java.util.Scanner;
public class Fibonacci{
    private int fibonacci(int n, int[] dpMemo){
        if(n <= 1) return n;
        if(dpMemo[n] != -1) return dpMemo[n];
        return dpMemo[n] = fibonacci(n-1, dpMemo)+fibonacci(n-2,dpMemo);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        /* Using memoization - Computing Fibonacci */
        int[] dpMemo = new int[n+1];
        Arrays.fill(dpMemo,-1);
        Fibonacci fb = new Fibonacci();
        System.out.println("Memoization:"+fb.fibonacci(n, dpMemo));

        /* Using Tabulation - Computing Fibonacci */
        int[] dpTab = new int[n+1];
        dpTab[0] = 0;
        dpTab[1] = 1;
        for(int i=2; i<=n; ++i){
            dpTab[i] = dpTab[i-1]+dpTab[i-2];
        }
        System.out.println("Tabulation:"+dpTab[n]);

        /* Using Tabulation - Even optimized */

        int prev2 = 0;
        int prev = 1;

        for(int i=2; i<=n; i++){
            int curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }

        System.out.println("Most oprimized:"+prev);

    }
}