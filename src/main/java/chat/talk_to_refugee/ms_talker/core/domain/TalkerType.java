package chat.talk_to_refugee.ms_talker.core.domain;

public class TalkerType {

    private Long id;
    private String description;

    public TalkerType() {
    }

    public TalkerType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Value {

        ADMINISTRATOR(1L, "administrator"),
        COLLABORATOR(2L, "collaborator"),
        IMMIGRANT(3L, "immigrant"),
        REFUGEE(4L, "refugee");

        private final Long id;
        private final String description;

        Value(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public TalkerType get() {
            return new TalkerType(id, description);
        }
    }
}
