package fr.afpa.pompey.cda22045.sparadrap.dao;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import static org.apache.log4j.builders.appender.SocketAppenderBuilder.LOGGER;

public class MedecinDAO extends DAO<Medecin> {

    List<Medecin> medecinss = new ArrayList<>();

    public List<Medecin> getMedecinss() {
        return medecinss;
    }

    @Override
    public int create(Medecin obj) {

        StringBuilder insertMedecin = new StringBuilder();
        insertMedecin.append("insert into medecin ");
        insertMedecin.append("(`med_agreement`, `per_id`) ");
        insertMedecin.append("VALUES (?, ?)");

        int newId = 0;
        try (PreparedStatement ps = connect.prepareStatement(insertMedecin.toString(), PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getNumAgreement());
            ps.setLong(2, obj.getPersonne().getPer_id());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                newId = rs.getInt(1);
            }
        } catch (SQLException e) {
//            LOGGER.warn("RelationWithDB erreur : " + e.getMessage()
//                    + "[SQL error code : " + e.getSQLState() + "]");
        }
        return newId;
    }

    @Override
    public boolean delete(Medecin obj) {
        return false;
    }

    @Override
    public boolean update(Medecin obj) {
        return false;
    }

    @Override
    public Medecin find(Long mID) throws SQLException {
        StringBuilder sqlFindMedecin = new StringBuilder();
        sqlFindMedecin.append("SELECT * FROM personne p JOIN medecin m ON p.per_id = m.per_id");
        sqlFindMedecin.append(" WHERE med_id=?");
        Medecin med = null;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindMedecin.toString())) {
            preparedStatement.setLong(1, mID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                med = new Medecin();
                med.setMed_id(resultSet.getInt("med_id"));
                med.setNom(resultSet.getString("per_nom"));
                med.setPrenom(resultSet.getString("per_prenom"));
                med.setTelephone(resultSet.getString("per_telephone"));
                med.setEmail(resultSet.getString("per_email"));
                med.setAdresse(resultSet.getString("per_adr"));
                med.setCodePostal(resultSet.getString("per_codepostal"));
                med.setVille(resultSet.getString("per_ville"));
                med.setNumAgreement(resultSet.getInt("med_agreement"));
            }
        }
        return med;
    }

    @Override
    public List<Medecin> findAll() throws Exception {
        String query = "SELECT * FROM personne p JOIN medecin m ON p.per_id = m.per_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Medecin med = new Medecin();
            med.setMed_id(resultSet.getInt("med_id"));
            med.setNom(resultSet.getString("per_nom"));
            med.setPrenom(resultSet.getString("per_prenom"));
            med.setAdresse(resultSet.getString("per_adr"));
            med.setCodePostal(resultSet.getString("per_codepostal"));
            med.setVille(resultSet.getString("per_ville"));
            med.setTelephone(resultSet.getString("per_telephone"));
            med.setEmail(resultSet.getString("per_email"));
            med.setNumAgreement(resultSet.getInt("med_agreement"));
            medecinss.add(med);
        }
        resultSet.close();
        return medecinss;
    }
}
