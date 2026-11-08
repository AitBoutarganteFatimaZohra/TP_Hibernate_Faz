package dao;

import java.util.List;

public interface IDaoFaz<T> {
    boolean insererFaz(T entite);
    boolean supprimerFaz(T entite);
    boolean modifierFaz(T entite);
    T chercherParIdFaz(int identifiant);
    List<T> listerToutFaz();
}