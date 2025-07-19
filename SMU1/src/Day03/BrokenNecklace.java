package Day03;
import java.util.Scanner;

public class BrokenNecklace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        scanner.close();

        String doubled = s + s;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            // 向右收集珠子
            int right = collect(doubled, i, i + n, true);
            // 向左收集珠子
            int left = collect(doubled, i - 1, i - n, false);

            int total = Math.min(right + left, n);
            maxCount = Math.max(maxCount, total);
        }

        System.out.println(maxCount);
    }

    /**
     * 收集珠子的函数
     * @param s 项链字符串（已翻倍处理）
     * @param start 起始位置
     * @param boundary 边界位置（不能越过）
     * @param isRight 是否向右收集
     * @return 收集到的珠子数量
     */
    private static int collect(String s, int start, int boundary, boolean isRight) {
        // 起始位置越界，返回0
        if (start < 0 || start >= s.length()) {
            return 0;
        }

        char color = s.charAt(start);
        // 非白色，直接按该颜色收集
        if (color != 'w') {
            return countSame(s, start, boundary, color, isRight);
        }

        // 白色，尝试两种颜色并取最大值
        int redCount = countSame(s, start, boundary, 'r', isRight);
        int blueCount = countSame(s, start, boundary, 'b', isRight);
        return Math.max(redCount, blueCount);
    }

    /**
     * 按指定颜色收集珠子
     * @param s 项链字符串
     * @param start 起始位置
     * @param boundary 边界位置
     * @param target 目标颜色
     * @param isRight 收集方向
     * @return 收集到的珠子数量
     */
    private static int countSame(String s, int start, int boundary, char target, boolean isRight) {
        int count = 0;
        int current = start;

        while (true) {
            // 检查是否超出边界
            if (isRight) {
                if (current >= boundary) break;
            } else {
                if (current < boundary) break;
            }

            // 检查是否越界
            if (current < 0 || current >= s.length()) break;

            // 检查当前珠子是否符合（目标颜色或白色）
            char c = s.charAt(current);
            if (c == target || c == 'w') {
                count++;
                current += isRight ? 1 : -1;
            } else {
                break;
            }
        }

        return count;
    }
}
