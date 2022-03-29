//check
package exceptionsTraningTwo;

public class WorkClass {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        int sizeY = 4;
        int sizeX = 4;
        String[][] arrStr = createArr();
        int[][] arrInt = checkSizeStrArrAndConvertedToIntArr(sizeY, sizeX, arrStr);
        printArr(arrInt);
        System.out.println("\nSumma elements = " + sumElementsOfArr(arrInt));
    }

    private static String[][] createArr() {
        return new String[][]{
                {"1", "2", "3", "4"},
                {"5", "8", "7", "8"},
                {"9", "1", "2", "3"},
                {"4", "5", "6", "7"}
        };
    }

    private static int[][] checkSizeStrArrAndConvertedToIntArr(int sizeY, int sizeX, String[][] arrStr) throws MyArraySizeException, MyArrayDataException {
        int[][] arrInt = new int[sizeY][sizeX];
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < arrStr[i].length; j++) {
                if ((arrStr[i].length != sizeY) || (arrStr.length != sizeX)) {
                    throw new MyArraySizeException("Size array don't 4 x 4!");
                }
                try {
                    arrInt[i][j] = Integer.parseInt(arrStr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException("\nIllegal format data in array.\nIndex incorrect cell = " + i + " " + j);
                }
            }
        }
        return arrInt;
    }

    private static void printArr(int[][] arrInt) {
        for (int[] ints : arrInt) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int sumElementsOfArr(int[][] arrInt) {
        int sum = 0;
        for (int[] ints : arrInt) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }
}

