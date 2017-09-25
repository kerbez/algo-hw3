
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *s
 * @author kerbe
 */

public class task1 {
    int as = 0, bs = 0, cs = 0;
    private static int findall(String s, int[] ss) {
        System.out.println("findall " + s);
        int[] arr = new int[10];
        int sin = 0;
        
        for(int i = 0; i <s.length(); i++){
            arr[i] = s.charAt(i) - '0';
            System.out.println(s.charAt(i) + " " + (s.charAt(i) - '0'));
            
        }
        Arrays.sort(arr, 0, s.length() - 1);
        for(int i = 0; i < s.length(); i++){
            System.out.print(arr[i] + " ");
        }
        int ok = 1;
                    int hh = 0;
                    for(int j = 0; j < s.length(); j++){
                        hh = hh * 10 + arr[j];
                    }
                    ss[sin] = hh;
                    System.out.println(" " + hh);
                    sin++;
        while(true){
            System.out.println("in while");
            if(ok == 0) break;
            ok = 0;
            for(int i = s.length() - 1; i >0; i--){
                if(arr[i] > arr[i - 1]){
                    System.out.println("found " + arr[i] + " " + arr[i - 1]);
                    int min = arr[i], minin = i;
                    for(int j = i; j < s.length(); j++){
                        if(arr[j] < min && arr[j] > arr[i - 1]) {min = arr[j]; minin = j;}
                    }
                    System.out.println("min = " + min + ", minin = " + minin);
                    int d;
                    d = arr[i - 1];
                    arr[i - 1] = arr[minin];
                    arr[minin] = d;
                    System.out.println("indexes: " + (i - 1) + " " + minin);
                    Arrays.sort(arr, i, s.length());
                    int h = 0;
                    for(int j = 0; j < s.length(); j++){
                        h = h * 10 + arr[j];
                    }
                    ss[sin] = h;
                    System.out.println(" " + h);
                    sin++;
                    ok = 1;
                    break;
                }
            }
        }
        return sin;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        int N = 10000;
        int[] aa = new int[N];
        int[] bb = new int[N];
        int[] cc = new int[N];
        String a, b, c;
        int m;
        Scanner in = new Scanner(System.in);
        a = in.next();
        b = in.next();
        c = in.next();
        if(a.length()>b.length()) m = a.length();
        else m = b.length();
        if(c.length()>m) m = c.length();
        if(a.length()<m){
            for(int i = a.length(); i <m; i++){
                a = "0" + a;
            }
        }if(b.length()<m){
            for(int i = b.length(); i <m; i++){
                b = "0" + b;
            }
        }if(c.length()<m){
            for(int i = c.length(); i <m; i++){
                c = "0" + c;
            }
        }
        System.out.println(a + " "  + b + " " + c);
        
        int as = findall(a, aa);
        int bs = findall(b, bb);
        int cs = findall(c, cc);
        for(int i = 0 ; i < as; i++){
            for(int j = 0 ; j < bs; j++){
                for(int h = 0; h < cs; h++){
                    if(aa[i] + bb[j] == cc[h]){
                        System.out.println(aa[i] + " + " + bb[j] + " = " + cc[h]);
                    }
                }
            }
        }
        
        
    }
    
}
