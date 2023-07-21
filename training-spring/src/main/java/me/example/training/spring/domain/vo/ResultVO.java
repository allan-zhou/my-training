package me.example.training.spring.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhoujialiang9
 * @date 2023/7/18 19:46
 **/
@Getter
@Setter
public class ResultVO<T> {
    private String code;
    private String message;
    private T data;
    private List<ABResultVO> abPower;

    public static final String SUCCESS = "0";
    public static final String ERROR = "-1";

    public ResultVO(String code, String message){
        this.code = code;
        this.message = message;
    }

    public ResultVO(String code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultVO<T> success(){
        return new ResultVO<>(SUCCESS, "");
    }

    public static <T> ResultVO<T> success(T data){
        return new ResultVO<>(SUCCESS, "", data);
    }

    public static <T> ResultVO<T> error(){
        return new ResultVO<>(ERROR, "err");
    }

    public static <T> ResultVO<T> error(String message){
        return new ResultVO<>(ERROR, message);
    }

}
