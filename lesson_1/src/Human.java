public class Human implements Runable, Jumpable, Memberable {
    private int runLimit = 200;
    private int jumpLimit = 1;

    @Override
    public void run(Barrierable barrierable) {
        if (barrierable instanceof RunningTrack) {
            if (barrierable.limit() <= this.runLimit)
                System.out.println("Human run OK");
            else System.out.println("Human not run");
        }
    }

    @Override
    public void jump(Barrierable barrierable) {
        if (barrierable instanceof Wall) {
            if (barrierable.limit() <= this.jumpLimit)
                System.out.println("Human jump OK");
            else System.out.println("Human not jump");
        }
    }

    @Override
    public void participate(Barrierable barrierable) {
        jump(barrierable);
        run(barrierable);
    }
}
