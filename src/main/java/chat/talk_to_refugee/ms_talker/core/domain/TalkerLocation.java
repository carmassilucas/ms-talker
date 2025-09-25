package chat.talk_to_refugee.ms_talker.core.domain;

public class TalkerLocation {

    private String state;
    private String city;

    public TalkerLocation() {
    }

    public TalkerLocation(String state, String city) {
        this.state = state;
        this.city = city;
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
