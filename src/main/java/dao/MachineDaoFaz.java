package dao;

import entities.MachineFaz;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtilFaz;
import util.TransactionFazException;
import java.util.List;

public class MachineDaoFaz implements IDaoFaz<MachineFaz> {

    @Override
    public boolean insererFaz(MachineFaz entite) {
        Transaction tx = null;
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(entite);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new TransactionFazException("Erreur lors de l'insertion de la machine", e);
        }
    }

    @Override
    public boolean supprimerFaz(MachineFaz entite) {
        Transaction tx = null;
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(entite);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new TransactionFazException("Erreur lors de la suppression de la machine", e);
        }
    }

    @Override
    public boolean modifierFaz(MachineFaz entite) {
        Transaction tx = null;
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(entite);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new TransactionFazException("Erreur lors de la modification de la machine", e);
        }
    }

    @Override
    public MachineFaz chercherParIdFaz(int identifiant) {
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            return session.get(MachineFaz.class, identifiant);
        }
    }

    @Override
    public List<MachineFaz> listerToutFaz() {
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            return session.createQuery("from MachineFaz", MachineFaz.class).list();
        }
    }

    // --- REQUÊTES HQL AVANCÉES ---
    public List<MachineFaz> trouverMachinesPlusCheresFaz(double montantMax) {
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            String hql = "FROM MachineFaz m WHERE m.prix > :montantMax ORDER BY m.prix DESC";
            Query<MachineFaz> query = session.createQuery(hql, MachineFaz.class);
            query.setParameter("montantMax", montantMax);
            return query.list();
        }
    }

    public List<MachineFaz> trouverMachinesParCodeSalleFaz(String codeSalle) {
        try (Session session = HibernateUtilFaz.getSessionFactory().openSession()) {
            String hql = "FROM MachineFaz m WHERE m.salleFaz.code = :codeSalle";
            Query<MachineFaz> query = session.createQuery(hql, MachineFaz.class);
            query.setParameter("codeSalle", codeSalle);
            return query.list();
        }
    }
}