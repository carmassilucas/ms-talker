package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_talker_type")
public class TalkerTypeEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "description", unique = true, nullable = false, updatable = false)
    private String description;

    public TalkerTypeEntity() {
    }

    public TalkerTypeEntity(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public TalkerTypeEntity(TalkerType type) {
        this.id = type.getId();
        this.description = type.getDescription();
    }

    public TalkerType toDomain() {
        return new TalkerType(id, description);
    }
}
