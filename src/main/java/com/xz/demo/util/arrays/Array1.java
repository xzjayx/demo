package com.xz.demo.util.arrays;

public class Array1 {



    /*
     * 创建一个数组，并且自己实现CURD 和 扩容等
     * */

    private int[] data;

    private int size ;

    public Array1(int capacity){
        data = new int[capacity];
        size = 0;
    }

    public Array1(){
        this(10);
    }
    /**
     * 获得数组的个数size
     * */
    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }
    /**
     * true 标识空，false 表示非空
     * */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * 向数组里面去添加一个元素，并且返回所在位置的角标
     * */
    private int add(int e){
        //如果加入得时候数组容量不足，则需要扩容
        if(size == data.length){
            //扩容
            dilatation(size);
        }
        data[size] = e;
        size++;
        return size-1;
    }


    private void dilatation(int size){
        int[] old = data;
        data = new int[size<<1];
        System.arraycopy(old, 0, data, 0, old.length);
    }

    /**
     * 向数组里面去查询一个元素，根据角标查询
     * */
    private  int findSize(int size){
        if(size >= data.length){
            return -1;
        }
        return data[size];
    }

    private  void  update(int size,int element){
        if(size >= data.length){
            return;
        }
         data[size] = element;
    }




    public static void main(String[] args) {
     /*   Array1 array = new Array1();
        for (int i = 0; i<15;i++){
            array.add(i);
        }
        array.update(8,90);
        System.out.println(array.findSize(8));*/

    }

}
