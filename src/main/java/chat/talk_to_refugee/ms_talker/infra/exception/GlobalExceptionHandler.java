package chat.talk_to_refugee.ms_talker.infra.exception;

import chat.talk_to_refugee.ms_talker.core.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ProblemDetail commonException(CommonException ex) {
        var problem = ProblemDetail.forStatus(ex.getHttpStatusCode());
        problem.setTitle(ex.getTitle());
        problem.setDetail(ex.getDetail());

        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var invalidParams = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new InvalidParam(fieldError.getField(), fieldError.getDefaultMessage()));

        var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Your request parameters didn't validate");
        problem.setProperty("invalid-params", invalidParams);

        return problem;
    }

    private record InvalidParam(String name, String reason) {
    }
}
