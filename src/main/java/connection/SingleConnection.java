package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/bancojsp?autoReconnect=true";
    private static final String USER = "postgres";
    private static final String PASSWORD = "arma1234";

    private static Connection CONNECTION = null;

    static {
        connect();
    }

    public SingleConnection() {
        connect();
    } // Quando tiver uma instancia irá conectar

    private static void connect(){
        try {
            if (CONNECTION == null)
            {
                Class.forName("org.postgresql.Driver"); //Carrega o drive de conexão do banco
                CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
                CONNECTION.setAutoCommit(false); //Para não efetuar alterações do bannco sem a permissão
                System.out.println("O banco foi conectado com sucesso!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Connection getConnection() {
        return CONNECTION;
    }
}
