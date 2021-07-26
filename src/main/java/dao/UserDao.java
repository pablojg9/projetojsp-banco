package dao;

import connection.SingleConnection;
import model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {

    private Connection connection = null;

    public UserDao(){
        connection = SingleConnection.getConnection();
    }

    public void save(Login login) {
        try {
            String sql = "INSERT INTO bancojsplinux (login, senha) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Preprando o login e senha que irá ser passado pelo o usuario, e colocando no banco de dados
            preparedStatement.setString(1, login.getLogin());
            preparedStatement.setString(2, login.getPassword());
            preparedStatement.execute();

            connection.commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(Login login) {

        try {
            String sql = "UPDATE bancojsplinux SET login = ?, senha = ? WHERE ";
            PreparedStatement updateStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }





    }



}
