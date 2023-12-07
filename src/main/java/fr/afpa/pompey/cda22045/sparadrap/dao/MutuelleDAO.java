//package fr.afpa.pompey.cda22045.sparadrap.dao;
//
//import fr.afpa.pompey.cda22045.sparadrap.model.*;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MutuelleDAO extends DAO<Mutuelle> {
//
//    List<Mutuelle> mutuelles = new ArrayList<>();
//
//    public List<Mutuelle> getMutuelles() {
//        return mutuelles;
//    }
//
//    @Override
//    public int create(Mutuelle obj) {
//
//        return 0;
//    }
//
//    @Override
//    public boolean delete(Mutuelle obj) {
//        return false;
//    }
//
//    @Override
//    public boolean update(Mutuelle obj) {
//        return false;
//    }
//
//    @Override
//    public Mutuelle find(Long muID) throws SQLException {
//        StringBuilder sqlFindMutuelle = new StringBuilder();
//        sqlFindMutuelle.append("SELECT * FROM mutuelle ");
//        sqlFindMutuelle.append("WHERE mut_id = ?");
//        Mutuelle mut = null;
//        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindMutuelle.toString())) {
//            preparedStatement.setLong(1, muID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                mut = new Mutuelle();
//                mut.setMut_id(resultSet.getInt("mut_id"));
//                mut.setNom(resultSet.getString("mut_nom"));
//            }
//        }
//        return mut;
//    }
//
//    @Override
//    public List<Mutuelle> findAll() throws Exception {
//        PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM mutuelle");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Mutuelle mut = new Mutuelle();
//            mut.setMut_id(resultSet.getInt("mut_id"));
//            mut.setNom(resultSet.getString("mut_nom"));
//            mutuelles.add(mut);
//        }
//        resultSet.close();
//        return mutuelles;
//    }
//}
