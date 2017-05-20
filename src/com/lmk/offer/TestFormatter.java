package com.lmk.offer;

/**
 * Created by limingkun on 2017/4/30.
 */
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

/**
 * Formatter测试
 *
 * @author leizhimin 2009-7-16 16:31:02
 */
public class TestFormatter {

    public static void main(String[] args) {
        //%[argument_index$][flags][width][.precision]conversion
        Formatter f1 = new Formatter(System.out);
        //格式化输出字符串和数字
        f1.format("格式化输出：%s %d", "a", 1235);
        System.out.println("\n--------");
        //日期的格式化
        Calendar c = new GregorianCalendar();
        f1.format("当前日期:%1$tY-%1$tm-%1$te", c);
        System.out.println("\n--------");
        //日期的格式化，并将格式化结果存储到一个字符串变量中
        String s = String.format("当前日期:%1$tY-%1$tm-%1$te", c);
        System.out.println(s);
        //2$：取第二个参数
        //-: 指定为左对齐，默认右对齐
        //5：最大输出宽度为20,不够会补空格，实际若超过则全部输出
        //.2：在此表示输出参数2的最大字符数量，如果是浮点数字，则表示小数部分显示的位数
        //s ：表示输入参数是字符串
        f1.format("%2$-5.2s %1$2s", "123", "456");
        f1.format("%2$5.2s %1$2s", "123", "456");
        //将格式化的结果存储到字符串
        System.out.println("\n--------");
        String fs = String.format("身高体重(%.2f , %d)", 173.2, 65);
        System.out.println(fs);

        //printf()本质上也是用System.out作为输出目标构造Formatter对象
        //调用format方法，并将printf的参数传给format方法而得。
        System.out.println("\n--------");
        System.out.printf("身高体重(%.2f , %d)", 180.2, 65);

        //DecimalFormat 的使用
        double pi=3.1415927;//圆周率
        //取一位整数
        System.out.print("\n");
        System.out.println(new DecimalFormat("0").format(pi));//
        //取两位整数
        System.out.println(new DecimalFormat("00").format(pi));//3
        //取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));// 03.142
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3
        //以百分比方式计数，并取两位小数
        // System.out.println(new DecimalFormat("#.##%").format(pi));　//314.16%

        long lightspeed = 299792458;//光速
        // 显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(lightspeed));//2.99792E8
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(lightspeed));//29.9792E7
        //每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(lightspeed));//299,792,458
        //将格式嵌入文本
        System.out.println(new DecimalFormat("光速大小为每秒,###米。").format(lightspeed));
    }
}
