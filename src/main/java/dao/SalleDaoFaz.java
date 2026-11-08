package dao;

import entities.SalleFaz;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtilFaz;
import util.TransactionFazException;
import java.util.List;

public class SalleDaoFaz implements IDaoFaz<SalleFaz> {

    @Override
    public boolean insererFaz(SalleFaz entite) {
        Transaction tx = null;
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(entite);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new TransactionFazException("Erreur lors de l'insertion de la salle : " + e.getMessage(), e);
        }
    }

    @Override
    public boolean supprimerFaz(SalleFaz entite) {
        Transaction tx = null;
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(entite);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new TransactionFazException("Erreur lors de la suppression de la salle", e);
        }
    }

    @Override
    public boolean modifierFaz(SalleFaz entite) {
        Transaction tx = null;
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(entite);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new TransactionFazException("Erreur lors de la modification de la salle", e);
        }
    }

    @Override
    public SalleFaz chercherParIdFaz(int identifiant) {
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            return session.get(SalleFaz.class, identifiant);
        }
    }

    @Override
    public List<SalleFaz> listerToutFaz() {
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            return session.createQuery("from SalleFaz", SalleFaz.class).list();
        }
    }
}