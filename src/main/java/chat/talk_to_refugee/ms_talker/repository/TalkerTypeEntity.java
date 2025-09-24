package chat.talk_to_refugee.ms_talker.repository;

import jakarta.persistence.*;
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

}
