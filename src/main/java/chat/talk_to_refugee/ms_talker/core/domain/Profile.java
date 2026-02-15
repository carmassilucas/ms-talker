package chat.talk_to_refugee.ms_talker.core.domain;

public class Profile {

    private final Long id;
    private final String name;

    private Profile(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public enum Name {
        ADMIN(1L, "admin"),
        COLLABORATOR(2L, "collaborator"),
        IMMIGRANT(3L, "immigrant"),
        REFUGEE(4L, "refugee");

        private final Long id;
        private final String name;

        Name(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Profile get() {
            return new Profile(this.id, this.name);
        }
    }
}
