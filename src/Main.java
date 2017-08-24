
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        q13();
    }

    /**
     * 题目描述
     * 给定n个字符串，请对n个字符串按照字典序排列。
     * 输入描述:
     * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
     * 输出描述:
     * 数据输出n行，输出结果为按照字典序排列的字符串。
     * 示例1
     * 输入
     * 9
     * cap
     * to
     * cat
     * card
     * two
     * too
     * up
     * boat
     * boot
     * 输出
     * boat
     * boot
     * cap
     * card
     * cat
     * to
     * too
     * two
     * up
     */
    public static void q13() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine().trim());
            List<String> lis = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                lis.add(sc.nextLine().trim());
            }
            Collections.sort(lis, new StrComperator());
            for (String s : lis) {
                System.out.println(s);
            }
        }

    }

    static class StrComperator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String base = "abcdefghigklmnopqrstuvwxyz";
            int len = Math.min(a.length(), b.length());
            int res = -1;
            for (int i = 0; i < len; i++) {
                char tmp1 = a.charAt(i);
                char tmp2 = b.charAt(i);

                int index1 = base.indexOf(tmp1);
                int index2 = base.indexOf(tmp2);
                if (index1 > index2) {
                    res = 1;
                } else if (index1 == index2) {
                    continue;
                } else {
                    res = -1;
                }
            }
            return res;
        }
    } //-class

    /**
     * 题目描述
     * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     * 输入描述:
     * 将一个英文语句以单词为单位逆序排放。
     * 输出描述:
     * 得到逆序的句子
     * 示例1
     * 输入
     * I am a boy
     * 输出
     * boy a am I
     */
    public static void q12() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine().trim();
            String[] inArr = in.split(" ");
            for (int i = inArr.length - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.println(inArr[i]);
                } else {
                    System.out.print(inArr[i] + " ");
                }
            }
        }
    }

    /*中兴测试*/
    public static void zte(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        if (sum == n) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    /**
     * 题目描述
     * 描述：
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     *  
     * 输入描述:
     * 输入一个int整数
     * 输出描述:
     * 将这个整数以字符串的形式逆序输出
     * 示例1
     * 输入
     * 1516000
     * 输出
     * 0006151
     */
    public static void q11() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            StringBuffer bf = new StringBuffer(in);
            bf.reverse();
            System.out.println(bf.toString());
        }
    }

    /**
     * 题目描述
     * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
     * 输入描述:
     * 输入N个字符，字符在ACSII码范围内。
     * 输出描述:
     * 输出范围在(0~127)字符的个数。
     * 示例1
     * 输入
     * abc
     * 输出
     * 3
     */
    public static void q10() {
        //uqic^g`(s&jnl(m#vt!onwdj(ru+os&wx
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            char[] cha = in.toCharArray();
            Set<Character> set = new HashSet<>();
            for (char ch : cha) {
                set.add(ch);
            }
            int count = 0;

            for (Character ch : set) {
                if (ch >= 0 && ch <= 127) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    /**
     * 题目描述
     * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 输入描述:
     * 输入一个int型整数
     * 输出描述:
     * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
     * 示例1
     * 输入
     * 9876673
     * 输出
     * 37689
     */
    public static void q9() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.matches("[0-9]+")) {
                StringBuffer bf = new StringBuffer(s);
                Set<Character> set = new LinkedHashSet<>(); // 重点是用这个哈希表

                for (int i = bf.length() - 1; i >= 0; i--) {
                    set.add(bf.charAt(i));
                }
                for (Character ch : set) {
                    System.out.print(ch);
                }
            } else return;
        }
    }

    /**
     * 题目描述
     * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     * 输入描述:
     * 先输入键值对的个数
     * 然后输入成对的index和value值，以空格隔开
     * 输出描述:
     * 输出合并后的键值对（多行）
     * 示例1 s
     * 输入
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     * 输出
     * 0 3
     * 1 2
     * 3 4
     */
    public static void q8() {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int key = sc.nextInt();
                int val = sc.nextInt();

                if (map.containsKey(key)) { // 存在该 key，则相加 val 的值
                    int oldVal = map.get(key);
                    map.put(key, oldVal + val);
                } else { // 不存在该key，则将键值对放入
                    map.put(key, val);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    /**
     * 题目描述
     * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
     * 输入描述:
     * 输入一个正浮点数值
     * 输出描述:
     * 输出该数值的近似整数值
     * 示例1
     * 输入
     * 5.5
     * 输出
     * 6
     */

    public static void q7() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double num = sc.nextDouble();
            System.out.println(Math.round(num));
        }
    }

    /**
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
     * 最后一个数后面也要有空格
     * <p>
     * 详细描述：
     * <p>
     * 函数接口说明：
     * public String getResult(long ulDataInput)
     * 输入参数：
     * long ulDataInput：输入的正整数
     * 返回值：
     * String
     * <p>
     * <p>
     * 输入描述:
     * 输入一个long型整数
     * 输出描述:
     * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
     * 示例1
     * 输入
     * 180
     * 输出
     * 2 2 3 3 5
     */

    /*
    程序分析：对n进行分解质因数，
    1， 先找到一个最小的质数i，然后按下述步骤完成： 
        (1)WHILE n != i，尝试分解因子
           (1-1) n能被i整除，则应打印出i的值，并用n除以i的商,作为新的正整数n,
           (1-2) n不能被i整除，跳出分解。说明 i 因子分解完毕
        (2)IF i = n，则说明分解质因数的过程已经结束，打印出即可。
    2， i+1作为i的值,重复执行 1 。
    * */
    public static void q6() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            Long num = sc.nextLong();
            for (long i = 2; i <= num; i++) {   // 1,先找到一个最小的质数i，
                while (num != i) {  // WHILE n != i，尝试分解因子
                    if (num % i == 0) {     // (1-1) n能被i整除，则应打印出i的值，并用n除以i的商,作为新的正整数n,
                        num = num / i;
                        System.out.print(i + " ");
                    } else break; //(1-2) n不能被i整除，跳出分解。说明使用 i 因子分解完毕
                }

                if (i == num) {     // (2)IF i = n，则说明分解质因数的过程已经结束，打印出即可。
                    System.out.print(num + " ");
                    break;
                }
            }
        }
    }

    /**
     * 题目描述
     * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
     * 输入描述:
     * 输入一个十六进制的数值字符串。
     * 输出描述:
     * 输出该数值的十进制字符串。
     * 示例1
     * 输入
     * 0xA
     * 输出
     * 10
     */
    public static void q5() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            String s2 = in.replace("0x", "");

//        long res  =  Long.parseLong(s2,16);
            BigInteger bres = new BigInteger(s2, 16);
//        System.out.println(res);
            System.out.println(bres);
        }
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
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            q41(s1);
            q41(s2);
        }
//        q41("urivthvtlqqerctlxmjvkgvfclaaduwmaadedpadanl");
    }

    public static void q41(String s1) {

        int len1 = s1.length();
        int posL1 = len1 / 8;
        for (int i = 0; i < posL1; i++) {
            StringBuffer bf = new StringBuffer();

            for (int j = i * 8; j < i * 8 + 8; j++) {
                bf.append(s1.charAt(j));
            }
            System.out.println(bf.toString());
        }

        if (len1 % 8 == 0) {
            return;
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