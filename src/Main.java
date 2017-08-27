
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Souhu03.main1();
    }

    /**
     * 搜狐第三题
     * 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。
     * 每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。
     * 河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，
     * 给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。
     * 如果无法到达输出-1
     * 输入描述:
     * 输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
     * 输出描述:
     * 输出最少的跳数，无法到达输出-1
     * 输入例子1:
     * 5
     * 2 0 1 1 1
     * 输出例子1:
     * 4
     */


    static class Souhu03 {
        static int n; // N个桩子
        static int[] take;//每个桩子跳跃距离
        static boolean[][] like;// 每个桩子，可以跳跃的距离
        static List<Integer[]> jie = new ArrayList<>();//可行解
        static Integer[] bestJie;

        static int res = 2000;//记录最后跳了几次，最小的次数。初始化为最大值

        public static void main2(){

        }

        public static void main1() {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n == 0) {
                    System.out.println(n);
                    return;
                }

                take = new int[n];
                like = new boolean[n][n];

                Arrays.fill(take, 0);    //初始化i桩子跳跃距离,默认没有距离
                for (boolean[] booleans : like) {
                    Arrays.fill(booleans, false);
                }
                for (int i = 0; i < n; i++) { //初始化like
                    int tmp = sc.nextInt();
                    for (int j = 0; j < tmp; j++) {
                        like[i][j] = true;
                    }
                }
                tryNext(0);
                getRes();
            }
        }

        /*

        39
        3 6 6 6 3 8 9 8 5 2 9 7 3 6 5 4 2 3 6 9 9 8 6 4 1 0 4 4 8 9 3 6 0 7 8 1 1 8 4
        */
        public static void tryNext(int i) {

            for (int j = 0; j < n; j++) {
                if (like[i][j]) {//&& take[j] == -1//这个可以一直分配
                    take[i] = j + 1;//把第j个距离，赋值给第i个桩子。
                    if (i == n - 1) {//最后一个桩子分配完毕
                        int sum = 0;
                        Integer[] tmp = new Integer[n];//一个解
                        for (int k = 0; k < n; k++) {
                            sum += take[k];
                            tmp[k] = take[k];
                        }
                        if (sum >= 5) {
                            jie.add(tmp);//记录解

                            /*更新最优解*/
                            int tCount = 0;
                            for (Integer integer : tmp) {
                                if (integer > 0) {
                                    tCount++;
                                }
                            }
                            if (tCount < res) {
                                res = tCount;//更新最小跳跃次数，和对应的解
                                bestJie = tmp;
                            }
                        }

                    } else {

                        tryNext(i + take[i]);
                    }
                    take[i] = 0;
                } else {
                    break;
                }
            }
        }

        public static void getRes() {
            System.out.println(res);
//            System.out.println(Arrays.asList(bestJie).toString());
//            for (Integer[] rec : jie) {
//                System.out.println(Arrays.asList(rec).toString());
//            }
        }

    }


    /**
     * 搜狐第二题
     * 时间限制：1秒
     * 空间限制：32768K
     * 有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
     * 有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，
     * 但是王后很喜欢    红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，
     * 我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。
     * ·如果无法找到则一个也无法带走。
     * 请帮助学者找出如何切分项链才能够拿到最多的宝石。
     * 输入描述:
     * 我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，G代表玻璃等等，
     * 我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。
     * <p>
     * 每行代表一种情况。
     * <p>
     * 输出描述:
     * 输出学者能够拿到的最多的宝石数量。每行一个
     * <p>
     * 输入例子1:
     * ABCYDYE
     * ATTMBQECPD
     * 输出例子1:
     * 1
     * 3
     */
    static class Souhu2{
        public static void main(){
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine()){
                String str = sc.nextLine();

            }
        }

        public static void getRes(String str){
            StringBuffer bf = new StringBuffer(str);
            for (int i = 5; i < str.length(); i++) {//前五个没有

            }
        }

        /*每次拿出n个，旋转*/
        public String getSub(int n ,StringBuffer bf){


        }
    }
    /*逆向思维法
    * 找到要删除的最小字符串，删除
    * 剩下的为最大数字
    * */
    public static void souhu14() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            String strNum = sc.nextLine();

            if (!(in.matches("[0-9]*")) || !(strNum.matches("[0-9]*"))) {
                return;
            }
            StringBuffer bf = new StringBuffer("a");
            bf.append(in);
            short remv = Short.parseShort(strNum);

            StringBuffer maxN = new StringBuffer();
            maxN.append(9);
            for (int i = 0; i < remv; i++) {
                maxN.append(9);
            }
            String best = maxN.toString();

            int index = 0;//记录删除位置
            for (int i = 1; i <= bf.length() - remv; i++) {
                String tmp = bf.substring(i, i + remv);
                if (tmp.compareTo(best) < 0) {
                    best = tmp;
                    index = i;
                }
            }
            bf.delete(index, index + remv);
            bf.delete(0, 1);
            System.out.println(bf.toString());
        }
    }

    /*拼接法*/
    public static void souhu13() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            String strNum = sc.nextLine();

            if (!(in.matches("[0-9]*")) || !(strNum.matches("[0-9]*"))) {
                return;
            }
            StringBuffer bf = new StringBuffer("a");
            bf.append(in);

            short remv = Short.parseShort(strNum);
            String best = "";

            for (int i = 1; i <= bf.length() - remv; i++) {
                String tmp = bf.substring(1, i) + bf.substring(i + remv, bf.length());
                if (tmp.compareTo(best) > 0) {
                    best = tmp;
                }
            }
            bf = null;
            System.out.println(best);
        }
    }

    /*删除法：超空间*/
    public static void souhu12() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            String strNum = sc.nextLine();

            if (!(in.matches("[0-9]*")) || !(strNum.matches("[0-9]*"))) {
                return;
            }
            StringBuffer bf = new StringBuffer("a");
            bf.append(in);

            int remv = Integer.parseInt(strNum);
            String best = "";

            for (int i = 1; i <= bf.length() - remv; i++) {
                StringBuffer tBf = new StringBuffer(bf.toString());
                tBf.delete(i, i + remv);
                tBf.delete(0, 1);
                String tmp = tBf.toString();

                if (tmp.compareTo(best) > 0) {
                    best = tmp;
                }
            }
            System.out.println(best);
        }
    }

    /*搜狐1-01*/
    public static void souhu1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            String strNum = sc.nextLine();

            if (!(in.matches("[0-9]*")) || !(strNum.matches("[0-9]*"))) {
                return;
            }
            StringBuffer bf = new StringBuffer("a");
            bf.append(in);

            int remv = Integer.parseInt(strNum);
            int best = 0;

            for (int i = 1; i <= bf.length() - remv; i++) {
                StringBuffer tBf = new StringBuffer(bf.toString());
                tBf.delete(i, i + remv);
                tBf.delete(0, 1);
                String tmp = tBf.toString();
                int cnum = Integer.parseInt(tmp);
                if (cnum > best) {
                    best = cnum;
                }
            }
            System.out.println(best);
        }
    }

    /*阿里笔试题2，*/
    public static void Ali() {
        Scanner sc = new Scanner(System.in);
        String rexNs = "[0-9A-Za-z]*";
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int r = getRes(n);
            System.out.println(r);
        }
    }

    public static int getRes(int n) {
        int res = 0;
        StringBuffer bf = new StringBuffer();
        bf.append("a");
        for (int i = 1; i <= n; i++) {
            StringBuffer tenBf = new StringBuffer();
            for (int j = 1; j <= i; j++) {
                if (j < 10) {
                    bf.append(j);
                } else {
                    tenBf.append(j);
                }
            }
            if (i >= 10) {
                int remain = i - 9;
                bf.append(tenBf.substring(0, remain));
            }
            System.out.println(i + "  :   " + bf.toString());
        }
        char cRes = bf.charAt(bf.length() - 1);
        res = Integer.parseInt(Character.toString(cRes));
        return res;
    }

    /*链表*/
    static class Node {
        int val;
        Node next = null;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public void showList() {
            Node p = this;
            while (p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();
        }
    }

    public static void listReverse() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;

        n1.showList();
        n1 = doReverse(n1);
        n1.showList();

    }

    public static Node doReverse(Node head) {
        Node h = new Node(0);
        while (head != null) {
            Node p = head;
            head = head.next;

            p.next = h.next;
            h.next = p;

        }

        head = h.next;
        return head;
    }

    /**
     * 题目描述
     * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
     * <p>
     * 所有的IP地址划分为 A,B,C,D,E五类
     * <p>
     * A类地址1.0.0.0~126.255.255.255;
     * <p>
     * B类地址128.0.0.0~191.255.255.255;
     * <p>
     * C类地址192.0.0.0~223.255.255.255;
     * <p>
     * D类地址224.0.0.0~239.255.255.255；
     * <p>
     * E类地址240.0.0.0~255.255.255.255
     * <p>
     * 私网IP范围是：
     * 10.0.0.0～10.255.255.255
     * 172.16.0.0～172.31.255.255
     * 192.168.0.0～192.168.255.255
     * 子网掩码为前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
     * 本题暂时默认以0开头的IP地址是合法的，比如0.1.1.2，是合法地址
     * <p>
     * 输入描述:
     * 多行字符串。每行一个IP地址和掩码，用~隔开。
     * 输出描述:
     * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
     * 示例1
     * 输入
     * 10.70.44.68~255.254.255.0
     * 1.0.0.1~255.0.0.0
     * 192.168.0.2~255.255.255.0
     * 19..0.~255.255.255.0
     * 输出
     * 1 0 1 0 0 2 1
     */

    public static void q17() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            Map<String, Integer> map = new TreeMap<>();
            map.put("A", 0);
            map.put("B", 0);
            map.put("C", 0);
            map.put("D", 0);
            map.put("E", 0);
            map.put("O", 0);
            map.put("P", 0);
        }

    }

    public static boolean isIpWrong(String ip) {


        return false;
    }


    /**
     * 题目描述
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     *  
     * 输入：
     *  
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     *  
     * 坐标之间以;分隔。
     *  
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     *  
     * 下面是一个简单的例子 如：
     *  
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     *  
     * 处理过程：
     *  
     * 起点（0,0）
     *  
     * +   A10   =  （-10,0）
     *  
     * +   S20   =  (-10,-20)
     *  
     * +   W10  =  (-10,-10)
     *  
     * +   D30  =  (20,-10)
     *  
     * +   x    =  无效
     *  
     * +   A1A   =  无效
     *  
     * +   B10A11   =  无效
     *  
     * +  一个空 不影响
     *  
     * +   A10  =  (10,-10)
     * 结果 （10， -10）
     * 输入描述:
     * 一行字符串
     * 输出描述:
     * 最终坐标，以,分隔
     * 示例1
     * 输入
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 输出
     * 10,-10
     */
    /*
    *
    测试用例:
    W49;W92;A84;W33;A32;A52;D97;S14;S33;D79;A14;W25;D97;D21;D31;A66;S67;S4;A59;S62;W40;S26;S65;A58;S17;A67;D48;W23;D68;S99;S97;W63;W27;D12;D83;W8;S3;W6;A88;D23;W30;S91;D58;W74;D45;W3;D19;S72;D8;S79;S76;S49;W16;A29;W93;W99;W92;D82;A10;A4;D25;A90;D83;W45;W20;S68;D59;S48;A18;S0;W24;S48;W75;A39;W29;S28;W76;W78;D94;A57;A5;D51;S61;A39;W77;S70;A2;D8;S58;D51;S86;W30;A27;S62;D56;A51;D0;S58;W34;S39;A64;A68;A96;D37;S91;S16;A17;D35;A85;W88;S57;S61;A28;D12;A87;S39;A85;W22;D65;D72;A5;A78;A59;D75;D57;S66;A55;D84;D72;W87;S46;W64;D49;S46;W34;D60;S39;A30;W86;D20;W93;D25;W44;W86;A16;D4;A86;S86;S27;W7;W89;W93;S17;S39;W66;W72;D81;W93;A88;D46;S57;W45;S84;S57;D27;A11;D54;S8;W15;A50;A69;A4;D19;D69;A3;A28;D47;W18;A39;D47;W14;D77;W59;S84;A32;D56;S16;D99;A33;A51;A24;D65;W37;D98;A13;W6;D94;D28;A12;S18;W40;S23;W76;D6;S40;D26;W97;W7;W90;W75;S12;A89;S46;S36;D96;A49;A73;S53;D84;A87;D75;D48;W84;S14;W65;W79;W51;S9;S77;D51;S76;W16;W77;A90;S96;D78;S7;W71;D17;W10;W4;D96;S58;A88;S89;D41;W47;W13;S75;S85;W63;W87;S19;S80;W92;W95;W73;D43;D35;W60;S31;D72;A73;W90;S51;A55;S82;W81;S56;W83;W41;A77;S37;D63;A72;D44;W81;S26;S53;W32;A24;S90;S83;W34;D10;S53;D69;A87;W84;S32;D72;S63;D97;W27;D23;D25;D18;W86;D74;D42;A31;S1;D98;D76;S46;D67;W94;S6;S97;S40;W71;W12;D62;W57;A92;W59;W59;D15;A16;D21;S33;S45;S83;D89;W77;A93;S60;S6;W24;S93;D69;D79;S13;S8;W63;D99;S36;D35;W53;S5;S44;S19;D76;S14;A86;A86;W43;W65;D20;S19;W66;A54;A98;A17;D2;W98;W2;D77;A90;S8;S55;S67;W88;W19;S59;D9;S75;S56;W75;W54;A61;W47;S19;D67;S39;D55;S6;A89;A5;W58;W7;W88;W92;D85;S32;S32;A27;S42;D52;A55;S26;D27;W40;D76;A55;D38;W13;A71;D79;W59;A76;A33;A12;D1;D63;W63;W62;D7;W48;A84;D27;A80;D42;D27;D49;D4;D71;W90;W39;D24;W71;D16;S1;W88;W88;D25;D66;S39;S43;A99;A92;W19;W20;A90;A31;A6;A79;D4;D80;A77;D71;D36;S64;
    对应输出应该为:
    1207,1244
    你的输出为:
    1896,392
    * */
    public static void q16() {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int x = 0, y = 0;
            String in = sc.nextLine();
            String[] ina = in.split(";");

            for (String s : ina) {
                if (s.length() <= 1) { // ;;这种形式，切出来会有"",或者A
                    continue;
                }
                String dir = s.substring(0, 1);
                String stepArr = s.substring(1, s.length());

                if (!stepArr.matches("[0-9]*")) { //A1A 第一个字符后不是数字
                    continue;
                }
                int step = Integer.parseInt(stepArr);
                switch (dir.charAt(0)) {
                    case 'A':
                        x -= step;
                        break;
                    case 'D':
                        x += step;
                        break;
                    case 'W':
                        y += step;
                        break;
                    case 'S':
                        y -= step;
                        break;
                }
            }
            System.out.println(x + "," + y);
        }//while
    }

    /**
     * 题目描述
     * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
     * 主件
     * 附件
     * 电脑
     * 打印机，扫描仪
     * 书柜
     * 图书
     * 书桌
     * 台灯，文具
     * 工作椅
     * 无
     * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
     *     设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
     * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
     *     请你帮助王强设计一个满足要求的购物单。
     *  
     * <p>
     * 输入描述:
     * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
     * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
     * <p>
     * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
     * <p>
     * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
     *  
     * <p>
     * 输出描述:
     *  输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
     * 示例1
     * 输入
     * 1000 5
     * 800 2 0
     * 400 5 1
     * 300 5 1
     * 400 3 0
     * 500 2 0
     * 输出
     * 2200
     */
    /*动态规划*/
    public static void q15() {

    }

    /**
     * 题目描述
     * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
     * 输入描述:
     *  输入一个整数（int类型）
     * 输出描述:
     *  这个数转换成2进制后，输出1的个数
     * 示例1
     * 输入
     * 5
     * 输出
     * 2
     */
    public static void q14() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int count = 0;
            while (num != 0) {
                count++;
                num = num & (num - 1);
            }
            System.out.println(count);
        }
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
            return a.compareTo(b);
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
         * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
         * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
         * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
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
                List l = new ArrayList();

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
}

