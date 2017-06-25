package com.lmk.leetcode.bishi;
import java.util.Scanner;
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
		String s=in.nextLine();
		int n=Math.min(Blfunction(s), Glfunction(s));
		System.out.println(n);
		
	}
	public static int Blfunction(String s)
	{
		int count=0;
		char[] a=s.toCharArray();
		for(int i=a.length-1;i>0;i--)
		{
			for(int j=a.length-1;j>0;j--)
			{
				if(a[j]=='B'&&a[j-1]=='G')
				{
					char temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
					count++;
				}
			}
		}
		return count;
	}
	public static int Glfunction(String s)
	{
		int count=0;
		char[] a=s.toCharArray();
		for(int i=a.length-1;i>0;i--)
		{
			for(int j=a.length-1;j>0;j--)
			{
				if(a[j]=='G'&&a[j-1]=='B')
				{
					char temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
					count++;
				}
			}
		}
		return count;
	}
}
