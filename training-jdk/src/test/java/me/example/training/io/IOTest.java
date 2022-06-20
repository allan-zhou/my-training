package me.example.training.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * @author zhoujialiang9
 * @date 2021/12/29 9:23
 */
@Slf4j
@SpringBootTest
public class IOTest {

    @Test
    public void test1() {
        try {
            String path = "";
            File file = new File(path);
            InputStream inputStream = new FileInputStream(file.getName());

        } catch (Exception e) {

        }


    }
}
