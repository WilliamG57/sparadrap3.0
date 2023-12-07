//package fr.afpa.pompey.cda22045.sparadrap.dao;
//
//import fr.afpa.pompey.cda22045.sparadrap.model.*;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SpecialisteDAO extends DAO<Specialiste> {
//
//
//    List<Specialiste> specialistess = new ArrayList<>();
//    public List<Specialiste> getSpecialistess() {
//        return specialistess;
//    }
//
//    @Override
//    public int create(Specialiste obj) {
//
//        return 0;
//    }
//
//    @Override
//    public boolean delete(Specialiste obj) {
//        return false;
//    }
//
//    @Override
//    public boolean update(Specialiste obj) {
//        return false;
//    }
//
//    @Override
//    public Specialiste find(Long sID) {
//        StringBuilder sqlFindSpecialiste = new StringBuilder();
//        sqlFindSpecialiste.append("SELECT * FROM personne p JOIN specialiste s ON p.per_id = s.per_id");
//        sqlFindSpecialiste.append(" WHERE spe_id=?");
//        Specialiste spe = null;
//        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindSpecialiste.toString())) {
//            preparedStatement.setLong(1, sID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                spe = new Specialiste();
//                spe.setSpe_id(resultSet.getInt("spe_id"));
//                spe.setNom(resultSet.getString("per_nom"));
//                spe.setPrenom(resultSet.getString("per_prenom"));
//                spe.setAdresse(resultSet.getString("per_adr"));
//                spe.setCodePostal(resultSet.getString("per_codepostal"));
//                spe.setVille(resultSet.getString("per_ville"));
//                spe.setTelephone(resultSet.getString("per_telephone"));
//                spe.setEmail(resultSet.getString("per_email"));
//                spe.setSpecialite(resultSet.getString("spe_specialite"));
//            }
//            resultSet.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return spe;
//    }
//
//        @Override
//    public List<Specialiste> findAll() throws Exception {
//        String query = "SELECT * FROM personne p JOIN specialiste s ON p.per_id = s.per_id";
//        PreparedStatement statement = connect.prepareStatement(query);
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            Specialiste spe = new Specialiste();
//            spe.setSpe_id(resultSet.getInt("spe_id"));
//            spe.setNom(resultSet.getString("per_nom"));
//            spe.setPrenom(resultSet.getString("per_prenom"));
//            spe.setAdresse(resultSet.getString("per_adr"));
//            spe.setCodePostal(resultSet.getString("per_codepostal"));
//            spe.setVille(resultSet.getString("per_ville"));
//            spe.setTelephone(resultSet.getString("per_telephone"));
//            spe.setEmail(resultSet.getString("per_email"));
//            spe.setSpecialite(resultSet.getString("spe_specialite"));
//            specialistess.add(spe);
//        }
//        resultSet.close();
//        return specialistess;
//    }
//}
