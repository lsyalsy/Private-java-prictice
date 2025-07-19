package Triplet;

public class Triplet {
    private int[] elements = new int[3];

    public void initTriplet(int v1, int v2, int v3){
        elements[0] = v1;
        elements[1] = v2;
        elements[2] = v3;
    }

    public void destroyTriplet(){
        //我认为这里可以直接退出虚拟机结束本次运行，因为三元组存在是函数执行的初始条件，三元组被摧毁后不必执行其他所有函数
        System.out.println("三元组已被销毁！");
    }

    public int get(int i) throws Exception {
        if(i >= 1 && i <= 3){
            return elements[i - 1];
        }else {
            throw new Exception("请提供正确的索引");
        }
    }

    public void put(int i, int e) throws Exception{
        if(i >= 1 && i <= 3){
            elements[i - 1] = e;
        }else {
            throw new Exception("请提供正确的索引");
        }
    }

    public boolean isAscending(){
        return elements[0] <= elements[1] && elements[1] <= elements[2];
    }

    public boolean isDescending(){
        return elements[0] >= elements[1] && elements[1] >= elements[2];
    }

    public int max(){
        int max = elements[0];
        if(elements[1] > max){
            max = elements[1];
        }else if(elements[2] > max){
            max = elements[2];
        }
        return max;
    }

    public int min(){
        int min = elements[0];
        if(elements[1] < min){
            min = elements[1];
        }else if(elements[2] < min){
            min = elements[2];
        }
        return min;
    }
}
