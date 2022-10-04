package com.yl;

import java.io.*;

public class BigIO {
    public static void main(String[] args) {
        //文件路径
        String path = "G:/AAAAA/WIFI/字典/精装新华字典金刚版压缩包/精装新华字典(金刚版).txt";
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bf = null;
        PrintWriter pw = null;//写流
        //顺序文件名自增值
        int i = 1;
        try {
            fileReader = new FileReader(file);
            bf = new BufferedReader(fileReader);
            String line;
            String name = "精装新华字典(金刚版)";
            long size = 0;
            while ((line = bf.readLine()) != null){
                if (size==0){
                    pw = new PrintWriter("G:/AAAAA/WIFI/字典/精装新华字典金刚版压缩包/分割版/"+name + i + ".txt");
                }
                pw.println(line);
                size++;
                if (size == 180000000){
                    if (pw!=null){
                        pw.close();
                    }
                    System.out.println("成功第"+i+"个文件");
                    i++;
                    size = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw!=null){
                    bf.close();
                }
                if (pw!=null){
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
