package List;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.initList();
        list.ListInsert(0, new Person(1, 20, 1000, "高中"));
        list.ListInsert(1, new Person(2, 21, 2000, "本科"));
        list.ListInsert(2, new Person(3, 22, 3000, "硕士"));
        System.out.println(list.getElem(0));
        System.out.println(list.getElem(1));
        System.out.println(list.getElem(2));
        list.ListInsert(1, new Person(4, 23, 4000, "博士"));
        System.out.println(list.getElem(1));
        list.ListDelete(1);
        System.out.println(list.getElem(1));
    }
    }
