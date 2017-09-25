
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kerbe
 */
public class task2 {
    //int n;
    public static void main(String[] args) {
        int n;
        String s = "";
        Scanner in = new Scanner(System.in);
        n =  in.nextInt();
        int si =1, sj = 1;
        int[][] a = new int[n + 2][n + 2];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n; j++){
                a[i][j] = in.nextInt();
                if(a[i][j] ==2) {si = i; sj = j;}
            }
        }
        dfs(a, si, sj, s, n);
    }

    private static void dfs(int[][] a, int si, int sj, String s,int n) {
        if(si > 1 && a[si - 1][sj] == 0){
           // System.out.println("u");
            s = s + "u";
            a[si -1][sj] = -1;
            dfs(a, si - 1, sj, s, n);
            //System.out.println("out");
            s = s.substring(0, s.length() - 1);
            a[si-1][sj] = 0;
        }if(si < n && a[si + 1][sj] == 0){
           // System.out.println("d");
            s = s + "d";
            a[si + 1][sj] = -1;
            dfs(a, si + 1, sj, s, n);
           // System.out.println("out");
            s = s.substring(0, s.length() - 1);
            a[si+1][sj] = 0;
        }if(sj > 1 && a[si][sj - 1] == 0){
          //  System.out.println("l");
            s = s + "l";
            a[si][sj - 1] = -1;
            dfs(a, si, sj - 1, s, n);
           // System.out.println("out");
            s = s.substring(0, s.length() - 1);
            a[si][sj - 1] = 0;
        }if(sj < n && a[si][sj + 1] == 0){
           // System.out.println("r");
            s = s + "r";
            a[si][sj + 1] = -1;
            dfs(a, si, sj + 1, s, n);
            s = s.substring(0, s.length() - 1);
           // System.out.println("out");
            a[si][sj + 1] = 0;
        }
        if(si == 1 || si == n || sj == 1 || sj == n){
            System.out.println(s);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
