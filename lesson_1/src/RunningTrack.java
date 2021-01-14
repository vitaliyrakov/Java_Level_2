public class RunningTrack implements Barrierable {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public void info() {
        System.out.println("RunningTrack is " + length);
    }

    @Override
    public int limit() {
        return this.length;
    }

}
