public class MyThread extends Thread {

    private float[] arr;
    private int correct;

    public MyThread(float[] arr, int correct) {
        this.arr = arr;
        this.correct = correct;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i +correct)/ 5) * Math.cos(0.2f + (i+correct) / 5)
                    * Math.cos(0.4f + (i+correct) / 2));
        }
    }
}