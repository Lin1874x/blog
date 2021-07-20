package cn.lin1874.blog.utils;

/**
 * 用于统一项目中所有 Ajax 请求的返回值类型
 * @author lin1874
 * @date 2021/7/17 - 22:06
 */

public class ResultEntity<T> {

    public static final Integer SUCCESS = 100;
    public static final Integer FAILED = 200;

    private Integer result;
    private String message;
    private T data;

    public ResultEntity() {
    }
    public ResultEntity(Integer result, String message, T data) {
        super();
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}