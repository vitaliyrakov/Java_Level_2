public class Cat implements Runable, Jumpable, Memberable {
    private int runLimit = 100;
    private int jumpLimit = 3;

    @Override
    public void run(Barrierable barrierable) {
        if (barrierable instanceof RunningTrack) {
            if (barrierable.limit() <= this.runLimit)
                System.out.println("Cat run OK");
            else System.out.println("Cat not run");
        }
    }

    @Override
    public void jump(Barrierable barrierable) {
        if (barrierable instanceof Wall) {
            if (barrierable.limit() <= this.jumpLimit)
                System.out.println("Cat jump OK");
            else System.out.println("Cat not jump");
        }
    }

    @Override
    public void participate(Barrierable barrierable) {
        jump(barrierable);
        run(barrierable);
    }
}
