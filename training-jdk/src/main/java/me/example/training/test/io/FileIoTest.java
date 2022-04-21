package me.example.training.test.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * @author zhoujialiang9
 * @date 2022/4/8 1:32 PM
 **/
@Slf4j
public class FileIoTest {

    public static void main(String[] args) {
        try {
            File file = new File( "files/testio.txt");
            log.info("abPath={}, canPath={}", file.getAbsolutePath(), file.getCanonicalPath());

            readByFileInputStream(file);

            readByFileReader(file);

            readByBufferedReader(file);

        } catch(Exception e){

        }
    }

    /**
     * 基于字节
     * @param file
     */
    private static void readByFileInputStream(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            int data;

            while (-1 != (data =  fileInputStream.read())) {
                log.info("read based byte, read data:{}", (char)data);
            }

            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于字符
     * @param file
     */
    private static void readByFileReader(File file){
        try {
            FileReader fileReader = new FileReader(file);

            char[] chars = new char[50];

            // data是数据的实际长度
            int data = fileReader.read(chars, 0, chars.length);

            log.info("data len={}", data);

            for (int i = 0; i < data; i++) {
                log.info("char = {}", chars[i]);
            }

            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void readByBufferedReader(File file){
        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String lineStr = "";

            while (null != (lineStr = bufferedReader.readLine())) {
                log.info("read line={}", lineStr);
            }

            bufferedReader.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
