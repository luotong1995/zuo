import java.util.Scanner;

public class Main {
    public static int N,K;
    public static int[] an;
    public static int[][] cn;
    public static int[][] graph = new int[100000][100000];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        an = new int[K];
        cn = new int[N-1][2];
        for(int i =0 ;i<K;i++){
            an[i] = scan.nextInt();
        }
        for(int i = 0;i < N -1;i++)
            for(int j=0;j < 2;j++){
                cn[i][j] = scan.nextInt();
            }

    }
}
