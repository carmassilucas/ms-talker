package chat.talk_to_refugee.ms_talker.core.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("unused")
public class Talker {

    private UUID id;
    private String fullName;
    private LocalDate birthDate;
    private String profilePhoto;
    private String aboutMe;
    private TalkerLocation location;
    private TalkerType type;
    private String email;
    private String password;
    private Boolean active;
    private Instant createdAt;
    private Instant updatedAt;

    public Talker() {
    }

    public Talker(UUID id,
                  String fullName,
                  LocalDate birthDate,
                  String profilePhoto,
                  String aboutMe,
                  TalkerLocation location,
                  TalkerType type,
                  String email,
                  String password,
                  Boolean active,
                  Instant createdAt,
                  Instant updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.profilePhoto = profilePhoto;
        this.aboutMe = aboutMe;
        this.location = location;
        this.type = type;
        this.email = email;
        this.password = password;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Talker(String fullName,
                  LocalDate birthDate,
                  TalkerLocation location,
                  TalkerType.Value type,
                  String email,
                  String password) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.location = location;
        this.type = type.get();
        this.email = email;
        this.password = password;
        this.active = true;
    }

    public Talker(String fullName,
                  LocalDate birthDate,
                  String aboutMe,
                  TalkerLocation location,
                  TalkerType type) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.aboutMe = aboutMe;
        this.location = location;
        this.type = type;
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

    public TalkerLocation getLocation() {
        return location;
    }

    public void setLocation(TalkerLocation location) {
        this.location = location;
    }

    public TalkerType getType() {
        return type;
    }

    public void setType(TalkerType type) {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    @Override
    public String toString() {
        return "Talker{" +
                "id=" + id +
                ", fullName='" + fullName +
                ", birthDate=" + birthDate +
                ", profilePhoto='" + profilePhoto +
                ", aboutMe='" + aboutMe +
                ", location=" + location +
                ", type=" + type +
                ", email='" + email +
                ", password='" + password +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Talker talker = (Talker) o;
        return Objects.equals(id, talker.id) && Objects.equals(fullName, talker.fullName) &&
                Objects.equals(birthDate, talker.birthDate) && Objects.equals(profilePhoto, talker.profilePhoto) &&
                Objects.equals(aboutMe, talker.aboutMe) && Objects.equals(location, talker.location) &&
                Objects.equals(type, talker.type) && Objects.equals(email, talker.email) &&
                Objects.equals(password, talker.password) && Objects.equals(active, talker.active) &&
                Objects.equals(createdAt, talker.createdAt) && Objects.equals(updatedAt, talker.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                fullName,
                birthDate,
                profilePhoto,
                aboutMe,
                location,
                type,
                email,
                password,
                active,
                createdAt,
                updatedAt
        );
    }
}
