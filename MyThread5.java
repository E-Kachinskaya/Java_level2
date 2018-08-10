package lesson_5;

public class MyThread extends Thread {
    private float[] arr;
    private int index;

    public MyThread(float[] arr, int index) {
        this.arr = arr;
        this.index = index;
        start();


    }
    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + index) / 5) * Math.cos(0.2f + (i + index) / 5) * Math.cos(0.4f + (i + index)/ 2));
        }
    }
}
