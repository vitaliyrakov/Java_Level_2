import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];

        set1toArr(arr);
        methOneThread(arr);

        set1toArr(arr);
        methTwoThread(arr);
    }

    public static void methOneThread(float[] arr) {
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("methOneThread: " + (System.currentTimeMillis() - a));
        System.out.println(arr[HALF]);
    }

    public static void methTwoThread(float[] arr) {
        long a = System.currentTimeMillis();

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        MyThread t1 = new MyThread(a1, 0);
        MyThread t2 = new MyThread(a2, HALF);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println("methTwoThread: " + (System.currentTimeMillis() - a));
        System.out.println(arr[HALF]);
    }

    public static void set1toArr(float[] arr) { Arrays.fill(arr, 1); }
}

