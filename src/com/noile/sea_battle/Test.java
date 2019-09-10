package com.noile.sea_battle;

public class Test {
    public static void main(String[] args) {
        int AIX = (int) (Math.random() * 10);
        int AIY = (int) (Math.random() * 10);
        System.out.println(AIX);
        System.out.println(AIY);
        AIX = (AIX - 1) + (int) (Math.random() * (AIX - 1));
        AIY = (AIY - 1) + (int) (Math.random() * (AIY - 1));
        System.out.println(AIX);
        System.out.println(AIY);
    }
}
