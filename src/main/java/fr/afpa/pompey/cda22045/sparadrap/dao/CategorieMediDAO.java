package fr.afpa.pompey.cda22045.sparadrap.dao;

import fr.afpa.pompey.cda22045.sparadrap.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CategorieMediDAO extends DAO<CategorieMedi> {

    List<CategorieMedi> categorieMedis = new ArrayList<>();

    public List<CategorieMedi> getCategorieMedis() {
        return categorieMedis;
    }

    @Override
    public int create(CategorieMedi obj) throws ParseException {
        return 0;
    }

    @Override
    public boolean delete(CategorieMedi obj) {
        return false;
    }

    @Override
    public boolean update(CategorieMedi obj) {
        return false;
    }

    @Override
    public CategorieMedi find(Long mediID) throws SQLException {
        StringBuilder sqlFindCategorieMedi = new StringBuilder();
        sqlFindCategorieMedi.append("SELECT * FROM categorie c");
        sqlFindCategorieMedi.append("JOIN medicament m ON m.cat_id = c.cat_id");
        sqlFindCategorieMedi.append(" WHERE cat_id = ?");
        CategorieMedi catMedi = null;
        try (PreparedStatement preparedStatement = connect.prepareStatement(sqlFindCategorieMedi.toString())) {
            preparedStatement.setLong(1, mediID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                catMedi = new CategorieMedi();
                catMedi.setCat_id(resultSet.getInt("cat_id"));
                catMedi.setCategorie(resultSet.getString("cat_categorie"));
            }
        }
        return catMedi;
    }

    @Override
    public List<CategorieMedi> findAll() throws Exception {
        String query = "SELECT * FROM categorie c JOIN medicament m ON m.cat_id = c.cat_id";
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        CategorieMedi catMedi = null;
        while (resultSet.next()) {
            catMedi = new CategorieMedi();
            catMedi.setCatId(resultSet.getInt("cat_id"));
            catMedi.setCategorie(resultSet.getString("cat_categorie"));
        }
        categorieMedis.add(catMedi);
        return categorieMedis;
    }
}
