package chat.talk_to_refugee.ms_talker.core.domain;

public class TalkerLocation {

    private Long id;
    private String state;
    private String city;

    public TalkerLocation() {
    }

    public TalkerLocation(Long id, String state, String city) {
        this.id = id;
        this.state = state;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
