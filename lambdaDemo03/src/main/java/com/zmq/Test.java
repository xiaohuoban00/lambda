package com.zmq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 * 1. 静态方法引用的使用
 *  类型名称.方法名称() --> 类型名称::方法名称
 * 2. 实例方法引用的使用
 *  创建类型对应的一个对象 --> 对象应用::实例方法名称
 * 3. 构造方法引用的使用
 * 类型对象的构建过程 --> 类型名称::new
 */
public class Test {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("tom","男",16));
        personList.add(new Person("xiaobai","男",17));
        personList.add(new Person("xiaohei","男",16));
        personList.add(new Person("xiaohuang","男",33));
        personList.add(new Person("xiaogou","女",23));
        //1.使用匿名内部类的形式进行排序
        /*Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(personList);*/
        // 2.lambda表达式的实现
        //Collections.sort(personList,(p1,p2)->p1.getAge()-p2.getAge());
        //3. 静态方法引用
        //Collections.sort(personList,Person::compareByAge);
        //4. 实例方法引用
//        PersonUtil personUtil = new PersonUtil();
//        Collections.sort(personList,personUtil::compareByName);
//        System.out.println(personList);
        //5. 构造方法引用：绑定函数式接口
        IPerson iPerson = Person::new;
        Person person = iPerson.initPerson("tom", "男", 16);
        System.out.println(person);
    }
}


class Person{
    private String name;
    private String gender;
    private int age;

    public static int compareByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Person() {
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class PersonUtil{
    public int compareByName(Person p1,Person p2){
        return p1.getName().hashCode()-p2.getName().hashCode();
    }
}

@FunctionalInterface
interface IPerson{
    Person initPerson(String name,String gender,int age);
}

