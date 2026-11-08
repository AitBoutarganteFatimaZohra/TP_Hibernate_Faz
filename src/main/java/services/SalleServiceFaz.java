package services;

import dao.IDaoFaz;
import dao.SalleDaoFaz;
import entities.SalleFaz;
import java.util.List;

public class SalleServiceFaz implements IDaoFaz<SalleFaz> {
    private IDaoFaz<SalleFaz> dao = new SalleDaoFaz();

    @Override
    public boolean insererFaz(SalleFaz entite) { return dao.insererFaz(entite); }

    @Override
    public boolean supprimerFaz(SalleFaz entite) { return dao.supprimerFaz(entite); }

    @Override
    public boolean modifierFaz(SalleFaz entite) { return dao.modifierFaz(entite); }

    @Override
    public SalleFaz chercherParIdFaz(int identifiant) { return dao.chercherParIdFaz(identifiant); }

    @Override
    public List<SalleFaz> listerToutFaz() { return dao.listerToutFaz(); }
}