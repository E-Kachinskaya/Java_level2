package lesson_5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(arr(),arr1()));
    }

    private synchronized static float[] arr() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();
        MyThread t0 = new MyThread(arr,0);
        try {
            t0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " 1 поток");
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    static Object monitor = new Object();

    private static float[] arr1() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr1 = new float[size];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1;
        }
        long start = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr1, 0, a1, 0, h);
        System.arraycopy(arr1, h, a2, 0, h);
        MyThread t1 = new MyThread(a1, 0);
        MyThread t2 = new MyThread(a2, h);
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr1, 0, h);
        System.arraycopy(a2, 0, arr1, h, h);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " 2 потока");
        return arr1;
    }

}
