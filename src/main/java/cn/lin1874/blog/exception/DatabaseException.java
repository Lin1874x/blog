package cn.lin1874.blog.exception;

/**
 * @author lin1874
 * @date 2021/7/20 - 19:17
 */
public class DatabaseException extends RuntimeException{
    static final long serialVersionUID = 1L;

    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }

    public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
