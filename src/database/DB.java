package database;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class DB {

    // Properties é usada para gerenciar configurações de um aplicação
    // Ela é um HashTable  que armazena chave-valor como string
    // Util para carregar e salvar configs de arquivos

    // Conection é usada para gerenciar a conexão entre um app Java e um DB
    
    // DriveManager é usada para gerenciar uma lista de drives de DB 
    // Pecorre a lista de Driver e chama o metodo connect de cada
    // até encontra um que possa manipular a URl

    private static String PATH = "C:\\Users\\firey\\Documents\\Java\\Udemy\\New folder\\LonfJDBC\\src\\db.properties";
    private static Connection conn = null;

    public static Connection getConnection(){
        if (conn == null) {
            Properties props = loadProperties();
            String url = props.getProperty("dburl");
            try {
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream(PATH)) {
            Properties props = new Properties();
            props.load(fs); // Load faz a leitura do Arquivo db.properties, apontado pelo fs, e guarda no props
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
