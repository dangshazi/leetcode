package com.lmk.leetcode.bishi;

import java.util.Scanner;
public class Main {
	static int wtime;
	static int ttime;
	static int gamex;
	static int gamey;
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int []x=new int[n];
        int []y=new int[n];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < n; j++){
            	if (i==0) {
                	x[j]=in.nextInt();
				}else {
					y[j]=in.nextInt();
				}	
            }
        }
        gamex=in.nextInt();
        gamey=in.nextInt();
        wtime=in.nextInt();
        ttime=in.nextInt();
        
        test(n,x,y); 
    }

	private static void test(int n, int[] x, int[] y) {
		int distance[]=new int[n];
		for (int i = 0; i < n; i++) {
			distance[i]=Math.abs(gamex-x[i])+Math.abs(gamey-y[i]);
		}
		
		int distance2[]=new int[n];
		for (int i = 0; i < n; i++) {
			distance2[i]=Math.abs(x[i])+Math.abs(y[i]);
		}
		
		int count=distance[0]*ttime+distance2[0]*wtime;;
		for (int i = 0; i < n; i++) {
			int time=distance[i]*ttime+distance2[i]*wtime;
			if (time<count) {
				count=time;
			}
		}
		System.out.println(count);
	}
}