public class MyArrayDataException extends Exception{
    public int col;
    public int row;

    public MyArrayDataException(String str, int col, int row) {
        super(str);
        this.row = row;
        this.col = col;
    }

}
