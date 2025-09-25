package chat.talk_to_refugee.ms_talker.core.exception;

public class CommonException extends RuntimeException {

    private final int httpStatusCode;
    private final String title;
    private final String detail;

    public CommonException(int httpStatusCode, String title, String detail) {
        this.httpStatusCode = httpStatusCode;
        this.title = title;
        this.detail = detail;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
}
