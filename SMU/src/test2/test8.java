package test2;

public class test8 {
    private static long ans = 0;
    private static int[] a = new int[25]; // Stores the current solution (1D array representation)
    private static int[][] b1 = new int[5][5]; // Row constraints (b1[row][num])
    private static int[][] b2 = new int[5][5]; // Column constraints (b2[col][num])
    private static int[][] b3 = new int[5][5]; // Sub-square constraints (b3[square][num])
    private static final int n = 4; // Size of the Sudoku (4x4)

    // Helper methods to calculate row, column and sub-square from 1D index
    private static int row(int x) {
        return (x - 1) / 4 + 1;
    }

    private static int col(int x) {
        return (x - 1) % 4 + 1;
    }

    private static int num(int x) {
        int r = row(x);
        int c = col(x);
        return (r - 1) / 2 * 2 + (c - 1) / 2 + 1;
    }

    // Depth-first search to solve the Sudoku
    private static void dfs(int x) {
        if (x > n * n) { // All cells filled (4x4=16)
            ans++;
            // Print the solution
            for (int i = 1; i <= n * n; i++) {
                System.out.print(a[i] + " ");
                if (i % n == 0) {
                    System.out.println();
                }
            }
            System.out.println();
            return;
        }

        // Try numbers from 1 to 4
        for (int i = 1; i <= 4; i++) {
            int r = row(x);
            int c = col(x);
            int s = num(x);

            if (b1[r][i] == 0 && b2[c][i] == 0 && b3[s][i] == 0) {
                a[x] = i; // Place the number
                b1[r][i] = 1; // Mark row constraint
                b2[c][i] = 1; // Mark column constraint
                b3[s][i] = 1; // Mark sub-square constraint

                dfs(x + 1); // Recurse to next cell

                // Backtrack
                b1[r][i] = 0;
                b2[c][i] = 0;
                b3[s][i] = 0;
            }
        }
    }

    public static void solve() {
        dfs(1); // Start with the first cell
        System.out.println("Total solutions: " + ans);
    }

    public static void main(String[] args) {
        solve();
    }
}

