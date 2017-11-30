package cu.uci.sgad.domain;


import java.util.Date;

public class Agreement {

    private Long id;

    private String title;

    private String description;

    private Date date_compliance;

    private String observation;

    private String state;

    public Agreement(String title, String description, Date date_compliance, String observation, String state) {
        this(null, title, description, date_compliance, observation, state);
    }

    public Agreement(Long id, String title, String description, Date date_compliance, String observation, String state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date_compliance = date_compliance;
        this.observation = observation;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_compliance() {
        return date_compliance;
    }

    public void setDate_compliance(Date date_compliance) {
        this.date_compliance = date_compliance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
