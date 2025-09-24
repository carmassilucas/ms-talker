package chat.talk_to_refugee.ms_talker.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_talker")
public @Data class TalkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "profile_photo", unique = true)
    private String profilePhoto;

    @Column(name = "about_me", columnDefinition = "text")
    private String aboutMe;

    @Column(name = "currently_state")
    private String currentlyState;

    @Column(name = "currently_city")
    private String currentlyCity;

    @ManyToOne
    @JoinColumn(name = "talker_type_id")
    private TalkerTypeEntity type;

    @Column(name = "email", unique = true, nullable = false, updatable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
