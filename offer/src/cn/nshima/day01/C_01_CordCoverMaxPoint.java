package cn.nshima.day01;

/**
 * @description:
 * @author:
 * @create: 2021-04-21-16-31
 */


public class C_01_CordCoverMaxPoint {


    public static int  maxPoint_1(int[] arr, int L) {
        int left = 0;
        int right = 0;
        int len = arr.length;
        int max = 0;
        while(left < len) {
            while(right < len && arr[right] - arr[left] <= L) {
                right ++;
            }
            max = Math.max(max,right - left);
            left++;
        }

        return max;
    }


    public static void main(String[] args) {
        int[] arr = {3,16,32,47,50,100};
        int L = 50;
        System.out.println(maxPoint_1(arr,L));
    }
}
