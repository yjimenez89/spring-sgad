package cu.uci.sgad.domain;


public class Responsible {

    private Long id;

    private String name;

    private String lastName;

    private String ocupation;

    private String email;

    private Long agreementId;


    public Responsible(String name, String lastName, String ocupation, String email, Long agreementId) {
        this(null, name, lastName, ocupation, email, agreementId);
    }

    public Responsible(Long id, String name, String lastName, String ocupation, String email, Long agreementId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.ocupation = ocupation;
        this.email = email;
        this.agreementId = agreementId;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }
}
