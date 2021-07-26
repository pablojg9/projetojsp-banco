package dao;

import connection.SingleConnection;
import model.Login;

import java.sql.Connection;

public class LoginDaoRepository {

    private Connection connection = null;

    public LoginDaoRepository() {
        connection = SingleConnection.getConnection();
    }

    public void save(Login login) {

    }

    public boolean validateAuthentication() {

        return false;
    }

}
