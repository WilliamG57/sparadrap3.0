package fr.afpa.pompey.cda22045.sparadrap.dao;

import fr.afpa.pompey.cda22045.sparadrap.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO extends DAO<Personne> {

//    List<Personne> Personnes = new ArrayList<>();
//
//    public List<Personne> getPersonnes() {
//        return Personnes;
//    }

    @Override
    public int create(Personne obj) {
        StringBuilder insertPersonne = new StringBuilder();
        insertPersonne.append("insert into personne");
        insertPersonne.append("(`per_nom`, `per_prenom`, `per_telephone`, `per_email`, `per_adr`," +
                " `per_codepostal`, `per_ville`)");
        insertPersonne.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
        System.out.println(insertPersonne);

        int newId = 0;
        try (PreparedStatement ps = this.connect.prepareStatement(insertPersonne.toString(),
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNom());
            ps.setString(2, obj.getPrenom());
            ps.setString(3, obj.getTelephone());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getAdresse());
            ps.setString(6, obj.getCodePostal());
            ps.setString(7, obj.getVille());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                newId = rs.getInt(1);
                System.out.println(newId);
            }
        } catch (SQLException e) {
            System.out.println("RelationWithDB erreur : " + e.getMessage()
                    + "[SQL error code : " + e.getSQLState() + "]");
        }
        return newId;
    }

    @Override
    public boolean delete(Personne obj) {
        StringBuilder sqlDeletePersonne = new StringBuilder();
        sqlDeletePersonne.append("DELETE FROM personne ");
        sqlDeletePersonne.append("WHERE per_id=?");
        boolean requeteOk;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlDeletePersonne.toString())) {
            preparedStatement.setLong(1, obj.getPer_id());
            requeteOk = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return requeteOk;
    }

    @Override
    public boolean update(Personne obj) throws SQLException {
        StringBuilder sqlUpdatePersonne = new StringBuilder();
        sqlUpdatePersonne.append("UPDATE  personne ");
        sqlUpdatePersonne.append("SET `per_nom` = ?, `per_prenom` = ?, `per_telephone` = ?, ");
        sqlUpdatePersonne.append("`per_email` = ?, `per_adr` = ?, `per_codepostal` = ?, `per_ville` = ? ");
        sqlUpdatePersonne.append("WHERE per_id=?");
        PreparedStatement ps = connect.prepareStatement(sqlUpdatePersonne.toString());
        ps.setString(1, obj.getNom());
        ps.setString(2, obj.getPrenom());
        ps.setString(3, obj.getTelephone());
        ps.setString(4, obj.getEmail());
        ps.setString(5, obj.getAdresse());
        ps.setString(6, obj.getCodePostal());
        ps.setString(7, obj.getVille());
        ps.setLong(8,obj.getPer_id());
        ps.executeUpdate();
        return true;
    }

    @Override
    public Personne find(Long pID) throws SQLException {
        return null;
    }

    @Override
    public List<Personne> findAll() {
        return null;
    }

//    public void transactionCreate(Personne obj) throws SQLException {
//        ClientDAO clientDao = new ClientDAO();
//        Client clients = new Client();
//        Specialiste specialistes = new Specialiste();
//        Medecin medecins = new Medecin();
//        Savepoint save = null;
//        try {
//            connect.setAutoCommit(false);
//            save = connect.setSavepoint("depart");
//            // creation
//            int pId = this.create(obj);
//            obj.setPer_id(pId);
//            Boolean creerClient = clients instanceof Client;
//            Boolean creerMedecin = medecins instanceof Medecin;
//            Boolean creerSpecialiste = specialistes instanceof Specialiste;
//            clientDao.create((Client) obj);
//            connect.commit();
//            connect.setAutoCommit(true);
//        } catch (SQLException sqle) {
//            connect.rollback(save);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public void transactionUpdate(Personne obj) throws SQLException {
//        ClientDAO clientDAO = new ClientDAO();
//        Savepoint save = null;
//        try {
//            connect.setAutoCommit(false);
//            save = connect.setSavepoint("départ");
//            clientDAO.update((Client) obj);
//            connect.commit();
//            connect.setAutoCommit(true);
//        } catch (SQLException sqle) {
//            connect.rollback(save);
//        }
//    }
}
































