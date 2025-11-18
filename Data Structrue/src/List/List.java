package List;

public class List {
    private Person[] elements;
    private int length;
    private final int capacity = 10;

    //初始化列表
    public void initList() {
        elements = new Person[capacity];
        length = 0;
    }

    //获取i对应元素
    public Person getElem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        return elements[i];
    }

    //获取元素位置
    public int locateElem(Person person) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(person)) {
                return i;
            }
        }
        return -1;
    }

    //在i号元素前插入元素
    public void ListInsert(int i, Person person) {
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        if (length >= capacity) {
            throw new IllegalStateException("列表已满");
        }
        for (int j = length; j > i; j--) {
            elements[j] = elements[j - 1];
        }
        elements[i] = person;
        length++;
    }

    //删除i号元素
    public void ListDelete(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        for (int j = i; j < length - 1; j++) {
            elements[j] = elements[j + 1];
        }
        length--;
    }
}
