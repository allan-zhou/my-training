package me.example.training.test.copy;

/**
 * @author zhoujialiang9
 * @date 2022/4/3 11:19 PM
 **/
public class MyUserAddress implements Cloneable{

    private String city;

    public MyUserAddress(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "MyUserAddress{" +
                "city='" + city + '\'' +
                '}';
    }

    @Override
    protected MyUserAddress clone() throws CloneNotSupportedException {
        return (MyUserAddress)super.clone();
    }
}