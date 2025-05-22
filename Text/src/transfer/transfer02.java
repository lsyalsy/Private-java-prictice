package transfer;

public class transfer02 {
    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[][] arr2 =new int[4][4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr2[i][j] = arr1[index];
                index++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr2[i][j] + " ");
            }
        }
    }
}
