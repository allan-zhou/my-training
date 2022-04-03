package me.example.training.test.copy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/4/3 11:10 PM
 **/
@Slf4j
public class CopyTest {

    public static void main(String[] args) {
        MyUserAddress address = new MyUserAddress("beijing");
        MyUser user1 = new MyUser("zhang san", address);

        MyUser user2 = user1.clone();
        user2.setName("li si");
        user2.getAddress().setCity("shang hai");

        log.info("user1 = {}", user1);
        log.info("user2 = {}", user2);

    }


}
