package offer.day01;

/**
 * @description:
 * @author:
 * @create: 2021-04-21-17-35
 */
public class C_04_MinSwapStep {

    //给定一串由字符G和字符B组成的字符串,要求将所有的G放在一侧,所有的B放在一侧
    //每次只能在相邻的字符之间进行交换操作,求最少的交换次数?
    public static int getMinSwapStep(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        /**将G全放在左边，B全放在右边*/
        int gi = 0;
        int res1 = 0;
        for(int i = 0;i < str.length(); ++i) {
            if(str.charAt(i) == 'G') {
                res1 += i - (gi++);
            }
        }

        /**将全部的B放在左侧*/
        int bi = 0;
        int res2 = 0;
        for(int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) == 'B') {
                res2 += i - (bi++);
            }
        }

        return Math.min(res1,res2);
    }



    public static void main(String[] args) {

    }

}
