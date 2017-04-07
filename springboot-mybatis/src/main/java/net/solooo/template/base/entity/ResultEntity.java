package net.solooo.template.base.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Description:
 * Author:Eric
 * Date:17/3/30-030
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultEntity {

    private int code;

    private Object data;

    private String message;

    private String url;

    private MyError error;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MyError getError() {
        return error;
    }

    public void setError(MyError error) {
        this.error = error;
    }

    public static class MyError {
        private String message;

        private Throwable throwable;

        public MyError(String message) {
            this.message = message;
        }

        public MyError(String message, Throwable throwable) {
            this.message = message;
            this.throwable = throwable;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        public void setThrowable(Throwable throwable) {
            this.throwable = throwable;
        }
    }
}
