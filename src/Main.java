import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        q4();
    }

    /**
     * 题目描述
     * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * 输入描述:
     * 连续输入字符串(输入2次,每个字符串长度小于100)
     * 输出描述:
     * 输出到长度为8的新字符串数组
     * 示例1
     * 输入
     * abc
     * 123456789
     * 输出
     * abc00000
     * 12345678
     * 90000000
     */
    public static void q4() {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//
//            q41(s1);
//            q41(s2);
//        }
        q41("urivthvtlqqerctlxmjvkgvfclaaduwmaadedpadanl");
    }

    public static void q41(String s1) {
        int len1 = s1.length();
        int posL1 = len1 / 8;
        for (int i = 0; i < posL1; i++) {
            StringBuffer bf = new StringBuffer();

            for (int j = i * 8; j < i*8 + 8; j++) {
                bf.append(s1.charAt(j));
            }
            System.out.println(bf.toString());
        }

        char[] last = Arrays.copyOfRange(s1.toCharArray(), posL1 * 8, len1);//剩余的字符串

        char[] s1Last = new char[8]; //填充后的字符串
        Arrays.fill(s1Last, 0, 8, '0');

        for (int i = 0; i < last.length; i++) {
            s1Last[i] = last[i];
        }

        System.out.println(new String(s1Last));
    }

    /**
     * 题目描述
     * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
     *  
     *  
     * Input Param 
     *      n               输入随机数的个数     
     *  inputArray      n个随机整数组成的数组 
     *      
     * Return Value
     *      OutputArray    输出处理后的随机整数
     *  
     * <p>
     * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
     * <p>
     *  
     *  
     * 输入描述:
     * 输入多行，先输入随机整数的个数，再输入相应个数的整数
     * 输出描述:
     * 返回多行，处理后的结果
     * 示例1
     * 输入
     * 11
     * 10
     * 20
     * 40
     * 32
     * 67
     * 40
     * 20
     * 89
     * 300
     * 400
     * 15
     * 输出
     * 10
     * 15
     * 20
     * 32
     * 40
     * 67
     * 89
     * 300
     * 400
     */
    public static void q3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Set<Integer> set = new TreeSet<Integer>();
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                set.add(sc.nextInt());
            }

            for (Integer s : set) {
                System.out.println(s);
            }
        }
    }

    /**
     * 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
     * 输入描述:
     * 输入一个有字母和数字以及空格组成的字符串，和一个字符。
     * 输出描述:
     * 输出输入字符串中含有该字符的个数。
     */
    public static void q2() {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine().trim();
        char[] ca = s1.toCharArray();
        for (char c : ca) {
            if (Character.isLetter(c) || Character.isDigit(c) || Character.isWhitespace(c)) {
                continue;
            } else {
                return;
            }
        }
        ca = s1.toLowerCase().toCharArray();
        String s2 = sc.nextLine().trim();
        char key = s2.toCharArray()[0];

        int res = 0;

        for (char c : ca) {
            if (c == key) {
                res++;
            }
        }
        System.out.println(res);
    }

    /**
     * 题目描述
     * 计算字符串最后一个单词的长度，单词以空格隔开。
     * 输入描述:
     * 一行字符串，非空，长度小于5000。
     * 输出描述:
     * 整数N，最后一个单词的长度。
     * 示例1
     * 输入
     * hello world
     * 输出
     * 5
     */
    public static void q1() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        String[] sarr = s.split(" ");

        System.out.println(sarr[sarr.length - 1].length());
    }

}