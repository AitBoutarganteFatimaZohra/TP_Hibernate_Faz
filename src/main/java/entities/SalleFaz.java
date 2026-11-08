package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "salles_faz")
public class SalleFaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;
    private String libelle;

    @OneToMany(mappedBy = "salleFaz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MachineFaz> machinesFaz = new ArrayList<>();

    public SalleFaz() {}

    public SalleFaz(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public void ajouterMachineFaz(MachineFaz machine) {
        this.machinesFaz.add(machine);
        machine.setSalleFaz(this);
    }

    public void afficherDetailsSalleFaz() {
        System.out.println("Salle : " + this.code + " - " + this.libelle);
        for (MachineFaz m : machinesFaz) {
            System.out.println("  -> Machine : " + m.getRef() + " (" + m.getMarque() + ")");
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public List<MachineFaz> getMachinesFaz() { return machinesFaz; }
    public void setMachinesFaz(List<MachineFaz> machinesFaz) { this.machinesFaz = machinesFaz; }
}