package cn.nshima.day01;

/**
 * @description:
 * @author:
 * @create: 2021-04-21-17-14
 */
public class C_03_Near2Power {

    //给定一个整数n,返回最接近n的且大于等于n的2的某次方的值
    public static int getNum(int n){
        if(n <= 1) return 1;

        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return n +1;
    }

    public static void main(String[] args) {
        int n = 66;
        System.out.println(getNum(n));
    }
}
