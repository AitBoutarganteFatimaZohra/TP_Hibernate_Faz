package services;

import dao.IDaoFaz;
import dao.MachineDaoFaz;
import entities.MachineFaz;
import java.util.List;

public class MachineServiceFaz implements IDaoFaz<MachineFaz> {
    // On type en MachineDaoFaz pour avoir accès aux méthodes HQL avancées
    private MachineDaoFaz dao = new MachineDaoFaz();

    @Override
    public boolean insererFaz(MachineFaz entite) { return dao.insererFaz(entite); }

    @Override
    public boolean supprimerFaz(MachineFaz entite) { return dao.supprimerFaz(entite); }

    @Override
    public boolean modifierFaz(MachineFaz entite) { return dao.modifierFaz(entite); }

    @Override
    public MachineFaz chercherParIdFaz(int identifiant) { return dao.chercherParIdFaz(identifiant); }

    @Override
    public List<MachineFaz> listerToutFaz() { return dao.listerToutFaz(); }

    // Exposition des méthodes HQL via le service
    public List<MachineFaz> trouverMachinesPlusCheresFaz(double montantMax) {
        return dao.trouverMachinesPlusCheresFaz(montantMax);
    }

    public List<MachineFaz> trouverMachinesParCodeSalleFaz(String codeSalle) {
        return dao.trouverMachinesParCodeSalleFaz(codeSalle);
    }
}