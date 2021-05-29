package entities;


import javax.persistence.*;


@javax.persistence.Entity
@Table(name = "Offers")
public class Offer extends entities.Entity {

    @Column(name = "offPercent")
    private float off;

    @ManyToOne
    @JoinColumn(name ="clientId")
    private Client client;

    public Offer(){}

    public Offer(float off, Client client) {
        this.off = off;
        this.client = client;
    }

    public float getOff() {
        return off;
    }

    public void setOff(float off) {
        this.off = off;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
