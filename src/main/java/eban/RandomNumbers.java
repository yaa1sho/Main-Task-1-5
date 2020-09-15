package eban;

import java.util.Random;

class RandomNumbers {

    private int n = 0;
    private int[] mArray;

    public RandomNumbers(int count){
        n = count;
        mArray = new int[n];

        for(int i = 0; i < n; i++)
            mArray[i] = new Random().nextInt() % 100 + 1;
    }

    public void printArray(){
        for (int i = 0; i< mArray.length; i++){
            System.out.print(mArray[i] + " ");
        }
        System.out.println();
    }

    public void printlnArray(){
        for (int i = 0; i< mArray.length; i++){
            System.out.println(mArray[i]);
        }
    }

}
