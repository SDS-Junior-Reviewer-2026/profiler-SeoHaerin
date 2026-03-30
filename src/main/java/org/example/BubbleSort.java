package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static int[] arr = new int[5];
    private int changeCnt = 0;

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5,2,1,3,1,2,6,9));
        sort.bubbleSort(arr);
        System.out.println(arr);
    }

    public void bubbleSort(ArrayList<Integer> arr) {
        int temp = 0;
        for(int i = 0; i < arr.size() - 1; i++) {
            for(int j= 1 ; j < arr.size()-i; j++) {
                if(arr.get(j)<arr.get(j-1)) {
                    temp = arr.get(j-1);
                    arr.set(j-1, arr.get(j));
                    arr.set(j, temp);
                    changeCnt++;
                }
            }
        }

        System.out.println(getClass().getSimpleName() + " 테스트");
        System.out.println("정렬결과: " + arr);
    }

    public int getChangeCnt() {
        return changeCnt;
    }
}
