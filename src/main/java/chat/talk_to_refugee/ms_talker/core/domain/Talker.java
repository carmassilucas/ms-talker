package chat.talk_to_refugee.ms_talker.core.domain;

import java.time.LocalDate;
import java.util.UUID;

@SuppressWarnings("unused")
public class Talker {

    private UUID id;
    private String fullName;
    private LocalDate birthDate;
    private String aboutMe;
    private String photoUrl;
    private Profile profile;
    private Location location;
    private String email;
    private String password;
    private Boolean active;

    public Talker(String fullName, LocalDate birthDate, Profile profile, String email, String password) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.profile = profile;
        this.email = email;
        this.password = password;
        this.active = true;
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

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
}
