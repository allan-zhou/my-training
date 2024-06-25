package me.example.training.test.io;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.net.URLDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

/**
 * @author zhoujialiang9
 * @date 2022/4/8 1:32 PM
 **/
@Slf4j
public class ParseAddCartSkuTest {

    public static void main(String[] args) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);

            //  2b6f977699aa44c39633a5f0be612158.log
            String fileName = "2b6f977699aa44c39633a5f0be612158.log";

            String fullFileName = ParseAddCartSkuTest.class.getClassLoader().getResource(fileName).getPath();
            log.info("fullFileName={}", fullFileName);

            Path path = Paths.get(fullFileName);

            log.info("path={}", path.toUri().getPath());

            Stream<String> lines = Files.lines(path);

            parseLines(lines);

            countDownLatch.await();

        } catch(Exception e){

            log.error("err",e);

        }
    }


    private static void parseLines(Stream<String> lines) {

        Map<String, Integer> map = new HashMap<>();

        lines.filter(item->item.indexOf("commlist") > 0).forEach(item -> {

            String decodeString = URLDecoder.decode(item, Charset.defaultCharset());
            log.info("decodeString={}", decodeString);

            int start = decodeString.indexOf("commlist") + 11;
            String tempStr = decodeString.substring(start);
            log.info("start={}, tempStr={}", start, tempStr);
            start = tempStr.indexOf(",");
            tempStr = tempStr.substring(0, start);
            log.info("start={},tempStr={}", start, tempStr);

            String skuId = tempStr;
            log.info("skuID={}", skuId);

            if (StringUtils.isNotBlank(skuId)) {

                if (map.keySet().contains(skuId)) {
                    int count = map.get(skuId);
                    map.put(skuId, count + 1);
                } else {
                    map.put(skuId, 1);
                }
            }

        });

        Map result = MapUtil.sortByValue(map, true);

        log.info("{}", result);
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
