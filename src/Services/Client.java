package Services;

public class Client {
    private long id;
    private String name;
    private String industry;
    private String contactPerson;
    private double revenue;
    private String status;

    public Client(long id, String name, String industry, String contactPerson, double revenue) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
        this.status = "active";
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public double getRevenue() {
        return revenue;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.id + ","
                + this.name + ","
                + this.industry + ","
                + this.contactPerson + ","
                + this.revenue;
    }
}
