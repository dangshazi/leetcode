package com.lmk.offer;

/**
 * Created by limingkun on 2017/5/8.
 */
public class Print1Ton_NO12 {

    public static void main(String[] args){
        Print1Ton_NO12 ob = new Print1Ton_NO12();
        ob.soluntion(2);

    }

    public void soluntion(int n){
        StringBuffer sb = new StringBuffer();
        recrusiveGenerate(sb,n,0);
    }

    private void recrusiveGenerate(StringBuffer sb, int n, int index) {
        if (index>n-1){
            printNumber(sb,n);
            return;
        }
        for (int i = 0;i<10;i++){
            if (i == 0){
                sb.append('0');
            }else {
                sb.setCharAt(index,(char) (i+'0'));
            }
            recrusiveGenerate(sb,n,index+1);
        }
    }

    private void printNumber(StringBuffer sb,int n) {
        int head = n-1;
        while (sb.charAt(head) =='0' && head >0){
            head --;
        }
        for(int i = head;i>-1;i--){
            System.out.print(sb.charAt(i));
        }
        System.out.println();
    }
}
