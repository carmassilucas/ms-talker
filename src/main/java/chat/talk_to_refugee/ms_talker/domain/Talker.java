package chat.talk_to_refugee.ms_talker.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

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
    private Instant createdAt;
    private Instant updatedAt;

    public Talker() {
    }

    public Talker(UUID id, String fullName, LocalDate birthDate, String profilePhoto, String aboutMe, TalkerLocation location,
                  TalkerType type, String email, String password, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.profilePhoto = profilePhoto;
        this.aboutMe = aboutMe;
        this.location = location;
        this.type = type;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
}
