public class TowerOfHanoi {

    public static void toh(int n, char from_rod, char to_rod, char aux_rod)
    {
        if(n==1)
        {
            System.out.println("Move  disk 1 from "+ from_rod+" to "+ to_rod);
            return;
        }
        toh(n-1, from_rod, aux_rod ,to_rod);
        System.out.println("Move disk "+ n +" from "+ from_rod+" to "+to_rod);
        toh(n-1, aux_rod, from_rod ,to_rod);
    }
    public static void main(String[] args) {

        toh(3,'A','B','C');
        
    }
    
}
