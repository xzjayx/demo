package com.xz.demo.util.circle;

public class Switch01 {

    public static void main(String[] args) {
        int num =5;
        switch (num){
            case 3:
                System.out.println("A");
                break;
            case 5:
                System.out.println("B");
            default:
                System.out.println("D");
            case 6:
                System.out.println("C");
                break;
        }
        /*
        * 输出BDC
        *
        * switch的特点就是先执行 case -> 如果case全部不满足 则执行default /如果满足，则执行case 里面 语句，如果没有break ，
        * 会一直向下执行到break,或者推出switch为止 ，ps ：如果 所有case / default 已经比较过了，不会在执行比较，就算穿透switch也只会执行内容
        *
        * switch 比较的byte / short / char / int 基本类型  Integer  jdk1.7 String类型  1.5 enum 枚举类型
        *
        * **/

        switch (Type.THREE){
            case ONE:
                System.out.println("a");
                break;
            default:
                System.out.println("b");
                break;
        }
    }





    public enum  Type{
        ONE,
        TWO,
        THREE,
        FOUR
    }
}
