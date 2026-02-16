package chat.talk_to_refugee.ms_talker.core.exception;

@SuppressWarnings("unused")
public class CommonException extends RuntimeException {

    private final Integer statusCode;
    private final String title;
    private final String detail;

    public CommonException(Integer statusCode, String title, String detail) {
        super(title);

        this.statusCode = statusCode;
        this.title = title;
        this.detail = detail;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
}
