package chat.talk_to_refugee.ms_talker.core.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Profile profile)) return false;
        return Objects.equals(getId(), profile.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
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
