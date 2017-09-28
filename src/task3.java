
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
public class task3 {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n + 3];
        for(int i = 1; i <=n; i++){
            arr[i] = in.nextInt();
        }
        Qsort(1, n, arr);
        for(int i = 1; i <=n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] Qsort(int i, int j, int[] arr){
        System.out.println("in Qs i = " + i + " j = " + j);
        int s = i, f = j;
        if(s>=f){
            return arr;
        }
        int cur = (f - s)/2 + s;
        while(s < f){
            while(s < cur && arr[s] <= arr[cur]){
                s++;
            }
            while(cur < f && arr[cur] <= arr[f]){
                f--;
            }
            if(s<f){int temp = arr[s];
            arr[s] = arr[f];
            arr[f] = temp;
                if(cur == s){
                    cur = f;
                }
                else if(cur == f){
                    cur = s;
                }
            }
        }
        int[] ar1 = Qsort(i, cur, arr);
        int[] ar2 = Qsort(cur + 1, j, arr);
        
        for(int k = i; k <=cur; k++){
            arr[k] = ar1[k];
        }
        
        for(int k = cur + 1; k <=j; k++){
            arr[k] = ar1[k];
        }
        return arr;
    }
}
