package org.example;

import java.util.List;

public class Practice {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int num : array){
            if(num == 4){
                System.out.println(num);
                break;
            }
        }
    }
}
