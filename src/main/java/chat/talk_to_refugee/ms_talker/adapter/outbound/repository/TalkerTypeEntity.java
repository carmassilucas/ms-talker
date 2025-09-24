package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_talker_type")
public class TalkerTypeEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "description", unique = true, nullable = false, updatable = false)
    private String description;

    public TalkerType toDomain() {
        return new TalkerType(id, description);
    }
}
