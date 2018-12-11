package agendatelefonica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DadosPessoas
{
 // leitura do arquivo contendo dados da agenda
 public static ArrayList<Pessoa> lerDados(Connection bdConnection)
 {
 ArrayList<Pessoa> pessoas = new ArrayList<>();
 if (bdConnection == null)
 return pessoas;

 try
 {
 String sql_str = "SELECT * FROM pessoas ORDER BY nome";
 PreparedStatement stmt = bdConnection.prepareStatement(sql_str);
 ResultSet rs = stmt.executeQuery();
 int id;
 String nome, fone;
 Pessoa novaPessoa;

 // percorre conjunto de pessoas retornadas pelo banco de dados
 while (rs.next())
 {
 // obtém dados da pessoa corrente
 id = rs.getInt("id");
 nome = rs.getString("nome");
 fone = rs.getString("fone");

 // cria nova pessoa e a adiciona na lista
 novaPessoa = new Pessoa(id, nome, fone);
 pessoas.add(novaPessoa);
 }

 stmt.close();
 rs.close();

 // retorna lista de pessoas
 return pessoas;
 } catch(SQLException ex) {
 JOptionPane.showMessageDialog(null,
 "Erro na consulta SQL\n" + ex.getMessage(),
 "Ler Dados", JOptionPane.ERROR_MESSAGE);
 return pessoas;
 }
 }

 //
 // insere nova pessoa na base de dados e retorna
 // o ID da pessoa inserida
 //
 public static int inserirPessoa(Connection bdConnection, String nome, String fone)
 {
 if (bdConnection == null)
 return -1;

 PreparedStatement stmt = null;
 try
 {
 // prepara comando a ser executado pelo BD
 stmt = bdConnection.prepareStatement(
 "INSERT INTO pessoas (nome, fone) VALUES (?, ?)",
 Statement.RETURN_GENERATED_KEYS);
 stmt.setString(1, nome);
 stmt.setString(2, fone);

 // executa comando
 stmt.executeUpdate();

 // obtem chave gerada para o registro inserido
 int id = -1;
 ResultSet rsID = stmt.getGeneratedKeys();
 if(rsID.next())
 id = rsID.getInt("id");

 stmt.close();
 return id;
 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null,
 "Erro ao inserir nova pessoa na base de dados\n" + ex.getMessage(),
 "Inserir pessoa", JOptionPane.ERROR_MESSAGE);
 return -1; //indica erro
 }
 }

 public static boolean alterarTelefone(Connection bdConnection, Pessoa p)
 {
 if (bdConnection == null)
 return false;

 PreparedStatement stmt = null;
 try
 {
 stmt = bdConnection.prepareStatement(
"UPDATE pessoas SET fone = ? WHERE id = ?");
 stmt.setString(1, p.getFone());
 stmt.setInt(2, p.getId());
 stmt.executeUpdate();
 stmt.close();
 return true;
 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null,
 "Erro ao gravar arquivo de dados\n" + ex.getMessage(),
 "Gravar dados", JOptionPane.ERROR_MESSAGE);
 return false;
 }
 }

 public static boolean eliminarPessoa(Connection bdConnection, Pessoa p)
 {
 if (bdConnection == null)
 return false;

 PreparedStatement stmt;
 try
 {
 stmt = bdConnection.prepareStatement("DELETE FROM pessoas WHERE id = ?");
 stmt.setInt(1, p.getId());
 stmt.executeUpdate();
 stmt.close();
 return true;
 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null,
 "Erro ao gravar arquivo de dados\n" + ex.getMessage(),
 "Gravar dados", JOptionPane.ERROR_MESSAGE);
 return false;
 }
 }
}