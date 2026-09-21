package fr.monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.monprojet.models.Article;

public class TestJdbc {

    public static void main(String[] args) throws Exception {

    	ArrayList<Article> articles = new ArrayList<Article>();
    	
    	try {
    		Class.forName("org.mariadb.jdbc.Driver");	//Enregistre la class auprès du driver manager : autrement dit charge le pilote
    		    		
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	// Récupération de la connection à partir d'une url + id + pwd
        String url = "jdbc:mariadb://localhost:3306/shop";
        String login = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, login, password)) {

            System.out.println("Connexion réussie !");
            
            String strSql = "SELECT * FROM T_Articles";
            try(Statement statement = connection.createStatement()){
            	try(ResultSet resultSet = statement.executeQuery(strSql)){
            		while(resultSet.next()) {
            			int rsIdUser = resultSet.getInt(1); 
            			String rsDescription = resultSet.getString(2);
            			String rsMarque = resultSet.getString(3);
            			double rsPrixUnitaire = resultSet.getDouble(4);
            			articles.add((new Article(rsIdUser, rsDescription, rsMarque, rsPrixUnitaire)));
            		}
            	}
            }
            
            for(Article a : articles) {
            	System.out.println(a.getIdentifiant() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}