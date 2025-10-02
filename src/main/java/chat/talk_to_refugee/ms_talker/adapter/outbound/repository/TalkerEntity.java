package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerLocation;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_talker")
@SuppressWarnings("unused")
public class TalkerEntity {

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
    @JoinColumn(name = "talker_type_id", nullable = false)
    private TalkerTypeEntity type;

    @Column(name = "email", unique = true, nullable = false, updatable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public TalkerEntity() {
    }

    public TalkerEntity(Talker talker) {
        this.id = talker.getId();
        this.fullName = talker.getFullName();
        this.birthDate = talker.getBirthDate();
        this.profilePhoto = talker.getProfilePhoto();
        this.aboutMe = talker.getAboutMe();
        this.currentlyState = talker.getLocation().getState();
        this.currentlyCity = talker.getLocation().getCity();
        this.type = new TalkerTypeEntity(talker.getType());
        this.email = talker.getEmail();
        this.password = talker.getPassword();
        this.createdAt = talker.getCreatedAt();
        this.updatedAt = talker.getUpdatedAt();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getCurrentlyState() {
        return currentlyState;
    }

    public void setCurrentlyState(String currentlyState) {
        this.currentlyState = currentlyState;
    }

    public String getCurrentlyCity() {
        return currentlyCity;
    }

    public void setCurrentlyCity(String currentlyCity) {
        this.currentlyCity = currentlyCity;
    }

    public TalkerTypeEntity getType() {
        return type;
    }

    public void setType(TalkerTypeEntity type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Talker toDomain() {
        return new Talker(
                this.id,
                this.fullName,
                this.birthDate,
                this.profilePhoto,
                this.aboutMe,
                new TalkerLocation(
                        this.currentlyState,
                        this.currentlyCity
                ),
                this.type.toDomain(),
                this.email,
                this.password,
                this.createdAt,
                this.updatedAt
        );
    }
}
