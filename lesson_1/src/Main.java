
public class Main {

    public static void main(String[] args) {

        Memberable[] member = {new Human(), new Cat(), new Robot()};

        Barrierable[] barrier = {
                new Wall(1),
                new Wall(2),
                new Wall(4),
                new RunningTrack(100),
                new RunningTrack(200),
                new RunningTrack(300)};

        for (Memberable memberable : member) {
            for (Barrierable barrierable : barrier) {
                memberable.participate(barrierable);
            }
        }
    }
}
