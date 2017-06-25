package com.lmk.leetcode;

import java.util.Scanner;

public class Ali {

    /*������������������ʵ����ĿҪ��Ĺ���*/
    /*��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^ */
    /******************************��ʼд����******************************/
    private static int [] compute(int queueNums, int msgNums, int expandTime, int sendSpeed, int consumeSpeed, int targetTime) { 
    	int queueTotalNums = queueNums;
    	if (expandTime<=targetTime){
    		queueTotalNums = queueNums*2;
    	}
    	int queueNumsNow = queueNums;
    	int[] msgNumInQuene = new int[queueTotalNums]; 
    	int[] pos=new int[queueTotalNums];
    	for(int time = 1;time<=targetTime;time++){
    		if (time>=expandTime){
    			queueNumsNow = 2*queueNums;
    		}
    		for(int i = 0;i< queueNumsNow;i++){
    			if(i<=sendSpeed%queueNumsNow){
    				msgNumInQuene[i]+=sendSpeed/queueNumsNow+1;
    			}
    			msgNumInQuene[i]+=sendSpeed/queueNumsNow;
    			if(msgNumInQuene[i]<consumeSpeed){
    				msgNumInQuene[i]=0;
    				pos[i]+=msgNumInQuene[i];
    				
    			}else{
    				msgNumInQuene[i]-= consumeSpeed;
    				pos[i]+=consumeSpeed;
    			}
    		}
    		
    	}
    	
       return pos;
    }
    /******************************����д����******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int queueNums = in.nextInt(), msgNums = in.nextInt(), expandTime = in.nextInt();
        in.nextLine();
        int sendSpeed = in.nextInt(), consumeSpeed = in.nextInt();
        in.nextLine();
        int targetTime = in.nextInt();
        in.close();

        int [] result = compute(queueNums, msgNums, expandTime, sendSpeed, consumeSpeed, targetTime);
        for (int i = 0; i < result.length; i++) {
            System.out.println(String.format("%d %d", i,  result[i]));
        }
    }
}