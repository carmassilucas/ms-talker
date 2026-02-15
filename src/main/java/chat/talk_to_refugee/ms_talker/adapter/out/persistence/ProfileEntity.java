package chat.talk_to_refugee.ms_talker.adapter.out.persistence;

import chat.talk_to_refugee.ms_talker.core.domain.Profile;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_profile")
@SuppressWarnings("unused")
public class ProfileEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, updatable = false, length = 16)
    private String name;

    public ProfileEntity() {
    }

    public ProfileEntity(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
