package entities;


import javax.persistence.*;


@javax.persistence.Entity
@Table(name = "Offers")
public class Offer extends entities.Entity {

    @Column(name = "offPercent")
    private float off;
    @Column(name = "clientId")

    @OneToMany(
            mappedBy = "Offers",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Client client;

    public Offer(float off, Client client) {
        this.off = off;
        this.client = client;
    }
}
