package chat.talk_to_refugee.ms_talker.core.exception;

public class AdminProfileNotAllowedException extends CommonException {

    public AdminProfileNotAllowedException() {
        super(422, "Admin profile not allowed", "Registration of administrator users is not allowed");
    }
}
