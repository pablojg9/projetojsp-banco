package dao;

import connection.SingleConnection;
import model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoRepository {

    private Connection connection = null;

    public LoginDaoRepository() {
        connection = SingleConnection.getConnection();
    }

    public boolean validateAuthentication(Login modelLogin) {
        try {
            String sql = "SELECT * FROM model_login WHERE login = ? AND senha = ? ";

            PreparedStatement validateStatement = connection.prepareStatement(sql);

            validateStatement.setString(1, modelLogin.getLogin());
            validateStatement.setString(2, modelLogin.getPassword());

            ResultSet result = validateStatement.executeQuery();

            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void registerLogin(Login modelLogin) {

        try {
           String sql = "INSERT INTO model_login (login, senha) VALUES (?, ?)";
           PreparedStatement registerStatement = connection.prepareStatement(sql);

           registerStatement.setString(1, modelLogin.getLogin());
           registerStatement.setString(2, modelLogin.getPassword());

           registerStatement.execute();
           connection.commit();

        }catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception roll) {
                roll.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
