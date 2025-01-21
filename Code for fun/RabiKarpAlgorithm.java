import java.util.ArrayList;
import java.util.List;

public class RabiKarpAlgorithm {
    public static List<Integer> searchPattern(String s, String p){
        if(s.length() < p.length()) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        int prime = 29;
        int base = 26;
        int highestPower = 1;

        int m = p.length();
        int n = s.length();

        for(int i=0; i<m-1; i++){
            highestPower = (highestPower * base) % prime;
        }

        int textHash = 0;
        int patternHash = 0;

        for(int i=0; i<m; ++i){
            patternHash = (patternHash * base +(p.charAt(i)-'a'))% prime;
            textHash = (textHash * base + (s.charAt(i) - 'a')) % prime;
        }

        for(int i = 0; i<= n-m; ++i){
            if(patternHash == textHash && s.substring(i, i+m).equals(p)){
                res.add(i);
            }

            if(i <n-m){
                textHash = (textHash - (highestPower * (s.charAt(i)-'a')))%prime;
                textHash = (textHash * base + (s.charAt(i+m)-'a'))%prime;
            }

            if(textHash < 0){
                textHash += prime;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abbababcfab";
        String p = "ab";
        System.out.println(searchPattern(s, p));
    }

}
