package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "machines_faz")
public class MachineFaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ref;
    private String marque;
    private double prix;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private SalleFaz salleFaz;

    public MachineFaz() {}

    public MachineFaz(String ref, String marque, Date dateAchat) {
        this.ref = ref;
        this.marque = marque;
        this.dateAchat = dateAchat;
    }

    public void changerMarqueFaz(String nouvelleMarque) {
        this.marque = nouvelleMarque;
        System.out.println("La marque de la machine " + this.ref + " a été mise à jour vers : " + nouvelleMarque);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }
    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public Date getDateAchat() { return dateAchat; }
    public void setDateAchat(Date dateAchat) { this.dateAchat = dateAchat; }
    public SalleFaz getSalleFaz() { return salleFaz; }
    public void setSalleFaz(SalleFaz salleFaz) { this.salleFaz = salleFaz; }
}