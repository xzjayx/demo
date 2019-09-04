package com.xz.demo.util;


/**
 * 测试== 和equals 的相关实践
 * */
public class Car {

    private int batch;

    private Car(int batch) {
        this.batch = batch;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return batch == car.batch;
    }

    @Override
    public int hashCode() {
        return batch;
    }

    public static void main(String[] args) {
        Car c1 = new Car(1);
        Car c2 = new Car(1);
        System.out.println(c1.equals(c2));
        System.out.println(c1 == c2);
    }

}
