public class Wall implements Barrierable {
    public int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void info() {
        System.out.println("Wall is " + this.height);
    }

    @Override
    public int limit() {
        return this.height;
    }
}
