package me.example.training.test.copy;

/**
 * @author zhoujialiang9
 * @date 2022/4/3 11:19 PM
 **/
public class MyUser implements Cloneable{

    private String name;
    private MyUserAddress address;

    Object object;

    public MyUser(String name, MyUserAddress address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyUserAddress getAddress() {
        return address;
    }

    public void setAddress(MyUserAddress address) {
        this.address = address;
    }

    @Override
    protected MyUser clone(){

        MyUser result = null;
        try {
            result = (MyUser) super.clone();

            // 深拷贝
            result.setAddress(this.address.clone());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
