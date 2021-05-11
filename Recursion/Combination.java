public class Combination {

    public static int combi(int n, int r)
    {
        return (fact(n)/(fact(r)*fact(n-r)));
    }

    public static int fact(int n)
    {
        if(n>=1)
            return n*fact(n-1);
        else
            return 1;
    }
    public static void main(String[] args)
    {
        int n = 5;
        int r = 3;
        System.out.println(combi(5,3));
    }
    
}
