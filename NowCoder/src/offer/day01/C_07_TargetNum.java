package offer.day01;

import java.util.HashMap;

/**
 * @description:力扣题  https://leetcode-cn.com/problems/target-sum/
 * @author:
 * @create: 2021-04-21-17-58
 */
public class C_07_TargetNum {

    /**
     * 方法1，暴力递归
     *
     * 用时567ms  内存消耗36.2MB
     * */
    public static int findTargetNumWays1(int[] arr, int target){
        if(arr == null) return 0;
        return process1(arr,0,target);
    }

    public static int process1(int[] arr,int index,int result){
        //base case
        if(index == arr.length) {
            return result == 0 ? 1 : 0; //result==0说明此种方法可行，方法数+1
        }

        return process1(arr,index +1,result + arr[index]) + process1(arr, index + 1,result - arr[index]);
    }



    /**方法2，在暴力递归的基础上加一个简单的缓存
     * HashMap<Integer, HashMap<Integer,Integer>> dp
     *
     * < index, <result,ans> >
     *
     * 用时71ms  内存消耗38.6MB
     * */
    public static int findTargetNumWay2(int[] arr,int target) {
        if(arr == null) return 0;
        return process2(arr,0,target,new HashMap<>());
    }

    public static int process2(int[] arr, int index, int result, HashMap<Integer, HashMap<Integer,Integer>> dp) {
        if(dp.containsKey(index) && dp.get(index).containsKey(result)) {
            return dp.get(index).get(result);
        }

        //没命中的话走下面
        int ans = 0;
        if(index == arr.length) {
            ans = result == 0 ? 1 : 0;
        }else {
            ans = process2(arr,index + 1,result + arr[index],dp) +
                  process2(arr,index + 1,result - arr[index], dp);
        }

        if(!dp.containsKey(index)) {
            dp.put(index,new HashMap<>());
        }
        dp.get(index).put(result,ans);
        return ans;
    }


}
