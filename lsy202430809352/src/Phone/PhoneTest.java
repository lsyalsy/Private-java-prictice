package Phone;

import java.util.ArrayList;

public class PhoneTest {
    public static void main(String[] args) {
        ArrayList<Phone> list = new ArrayList<>();
        Phone p1 = new Phone("小米", 1000);
        Phone p2 = new Phone("苹果", 8000);
        Phone p3 = new Phone("锤子", 2999);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        ArrayList<Phone> list1 = PhoneInfo(list);
        for (int i = 0; i < list1.size(); i++) {
            Phone p = list1.get(i);
            System.out.println("商品"+(i+1)+":"+p.getBrand()+", "+p.getPrice());
        }
    }
    //需要集合，判断价格，合成新的集合，返回新的集合
    public static ArrayList<Phone> PhoneInfo(ArrayList<Phone> list){
        ArrayList<Phone> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Phone p = list.get(i);
            if(p.getPrice() < 3000){
                list1.add(p);
            }
        }
        return list1;
    }
}
