package dao;

import connection.SingleConnection;
import model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginDaoRepository {

    private Connection connection = null;

    public LoginDaoRepository() {
        connection = SingleConnection.getConnection();
    }

    public void save(Login login) {

    }

    public boolean validateAuthentication(Login modelLogin) {
        try {
            String sql = "SELECT * FROM model_login WHERE login = ?, senha = ?";
            PreparedStatement validateStatement = connection.prepareStatement(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }




        return false;
    }

}
