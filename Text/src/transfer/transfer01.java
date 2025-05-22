package transfer;

public class transfer01 {
    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[][] arr2 =new int[4][4];
        for (int i = 0; i < 16; i++) {
            arr2[i / 4][i % 4] = arr1[i];
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr2[i][j] + " ");
            }
        }
    }
}
