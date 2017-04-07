package net.solooo.template.base.exception;

/**
 * Description:
 * Author:Eric
 * Date:17/3/30-030
 */
public class WebException extends RuntimeException {

    private static final long serialVersionUID = 2771587260580067612L;

    private String error;

    public WebException(String message) {
        super(message);
    }

    public WebException(String message, String error) {
        super(message);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
