package Triplet;

public class Main {
    public static void main(String[] args) throws Exception {
        Triplet triplet = new Triplet();
        System.out.println("----构建三元组----");
        triplet.initTriplet(1, 2, 3);
        System.out.println("----获取三元组----");
        for (int i = 1; i <= 3; i++) {
            System.out.print(triplet.get(i) + " ");
        }
        System.out.println();
        System.out.println("----更改三元组----");
        triplet.put(3,5);
        System.out.println("新三元组为：");
        for (int i = 1; i <= 3; i++) {
            System.out.print(triplet.get(i) + " ");
        }
        System.out.println();
        System.out.println("----摧毁三元组----");
        triplet.destroyTriplet();
        System.out.println("----检查三元组是否为升序----");
        System.out.println(triplet.isAscending());
        System.out.println("----检查三元组是否为降序----");
        System.out.println(triplet.isDescending());
        System.out.println("----查询三元组的最大值----");
        System.out.println(triplet.max());
        System.out.println("----查询三元组的最小值----");
        System.out.println(triplet.min());

    }
}
