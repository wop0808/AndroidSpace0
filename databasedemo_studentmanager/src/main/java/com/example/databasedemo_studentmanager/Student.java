package com.example.databasedemo_studentmanager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Student implements Serializable {
    private String name;
    private int number;

    public Student(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    /**
     * 将对象转化为二进制数组
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static byte[] Object2Bytes(Object obj) throws Exception {
        byte[] data = null;

        if (obj instanceof Serializable) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            ObjectOutputStream objectOutputStream = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                data = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            throw new Exception("obj can not cast to byte[] because is is not implements Serializable");
        }
        return data;
    }

    /**
     * 将二进制数组转化为对象<br/>
     * 百度java泛型方法
     *
     * @param clazz
     * @param data
     * @param <T>
     * @return
     */
    public static  <T> T Bytes2Object(Class<T> clazz, byte[] data) {
        T t = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(data);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            t = (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
