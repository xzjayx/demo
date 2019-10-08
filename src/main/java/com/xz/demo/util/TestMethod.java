package com.xz.demo.util;

public class TestMethod {


    public static void main(String[] args) {




        TestMethod testMethod = new TestMethod();

        Stu stu = new TestMethod().new Stu(213,"hahaha");

        TestMethod.Stu stu1 = new TestMethod().new Stu(11,"fsaf" +
                "" +
                "as");

    }


    public class Stu{
        private int age;

        private String name;

        public Stu(int age,String name){
            this.age = age;
            this.name = name;
        }

        void get(){

        }
    }

    public void get(){

        final  int old = 30;
        Stu stu = new Stu(30,"hahah");
    }

    private void get(int a){
        System.out.println(1111);
    }




}
