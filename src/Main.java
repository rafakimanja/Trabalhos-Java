import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String login = "postgres";
        String senha = "postgres";
        String url_conexao = "jdbc:postgresql://localhost:5432/java_conexao_bd";

        try{

            //abrindo a conexao
            Connection conexao = DriverManager.getConnection(url_conexao, login, senha);



            //criando a Query
            int id = 3;
            //String query = "SELECT * FROM funcionarios WHERE id =?";
            String query = "SELECT * FROM funcionarios";

            PreparedStatement pstm = conexao.prepareStatement(query);
            //pstm.setInt(1, id);



            //trabalhando com a resposta
            ResultSet resposta = pstm.executeQuery();

            while(resposta.next()){
                System.out.println(resposta.getInt("id") + "-" + resposta.getString(2) + " | " + resposta.getString("email"));
            }


            //fechando o banco
            pstm.close();
            resposta.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}