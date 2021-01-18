public class Main {
    public static void main(String[] args) {
        String[][] strArr = {{"1", "2","3","4"},
                {"3", "4"},
                {"5", "6", "4"},
                {"7", "8"}};
        try {
            System.out.println("Сумма элементов массива равна: " + checkArr(strArr));
        } catch (MyArraySizeException ex) {
            System.out.println("Ошибка размера массива: " + ex.getMessage());
        } catch (MyArrayDataException ex) {
            System.out.println("Ошибка данных массива: " + ex.getMessage() + ex.col + " " + ex.row);
        }
    }

    public static int checkArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0, i = 0, j = 0;
        try {
            for (i = 0; i < arr.length; i++) {
                if (arr.length > 4 || arr[i].length > 4)
                    throw new MyArraySizeException("Размер массива более 4 ");
                for (j = 0; j < arr[i].length; j++) {
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException("Не удалось преобразовать значение в ячейке: ", i, j);
        }
        return sum;
    }
}
