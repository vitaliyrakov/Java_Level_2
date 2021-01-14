public class Robot implements Runable, Jumpable, Memberable {
    private int runLimit = 290;
    private int jumpLimit = 1;

    @Override
    public void run(Barrierable barrierable) {
        if (barrierable instanceof RunningTrack) {
            if (barrierable.limit() <= this.runLimit)
                System.out.println("Robot run OK");
            else System.out.println("Robot not run");
        }
    }

    @Override
    public void jump(Barrierable barrierable) {
        if (barrierable instanceof Wall) {
            if (barrierable.limit() <= this.jumpLimit)
                System.out.println("Robot jump OK");
            else System.out.println("Robot not jump");
        }
    }

    @Override
    public void participate(Barrierable barrierable) {
        jump(barrierable);
        run(barrierable);
    }
}
