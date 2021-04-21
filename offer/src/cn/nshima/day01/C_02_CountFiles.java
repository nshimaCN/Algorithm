package cn.nshima.day01;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author:
 * @create: 2021-04-21-16-59
 */
public class C_02_CountFiles {

    public static int countFiles(String filePath) {
        File root = new File(filePath);
        //既不是文件夹也不是文件
        if(!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        //根就是一个文件
        if(root.isFile()) {
            return 1;
        }

        Queue<File> queue = new LinkedList<>();     //队列里放的都是文件夹
        int count = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            File dictionary = queue.poll();
            for(File file : dictionary.listFiles()) {
                if(file.isFile()) {
                    count ++;
                }else if(file.isDirectory()){
                    queue.add(file);
                }
            }
        }


        return count;
    }


    public static void main(String[] args) {
        String filePath = "D:\\学习资料\\学算法";
        System.out.println(countFiles(filePath));
    }
}
