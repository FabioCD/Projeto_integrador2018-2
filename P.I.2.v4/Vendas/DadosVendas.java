package Vendas;
//==============================================================================
import agendatelefonica.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//==============================================================================
public class DadosVendas
{
 // leitura do arquivo contendo dados das vendas
 public static ArrayList<Venda> lerDados(Connection bdConnection)
 {
 ArrayList<Venda> vendas = new ArrayList<>();
 if (bdConnection == null)
 return vendas;

 try
 {
 String sql_str = "SELECT * FROM vendas ORDER BY nomeProduto";
 PreparedStatement stmt = bdConnection.prepareStatement(sql_str);
 ResultSet rs = stmt.executeQuery();
 int id;
 String nomeProduto, nf;
 Venda novaVenda;

 // percorre conjunto de vendas retornadas pelo banco de dados
 while (rs.next())
 {
 // obtém dados da venda corrente
 id = rs.getInt("id");
 nomeProduto = rs.getString("nomeProduto");
 nf = rs.getString("nf");
     
    
 
// cria nova venda e a adiciona na lista
 novaVenda = new Venda(id, nomeProduto, nf );
 vendas.add(novaVenda);
 }

 stmt.close();
 rs.close();

 // retorna lista de pessoas
 return vendas;
 } catch(SQLException ex) {
 JOptionPane.showMessageDialog(null,
 "Erro na consulta SQL\n" + ex.getMessage(),
 "Ler Dados", JOptionPane.ERROR_MESSAGE);
 return vendas;
 }
 }

 //==============================================================================
 //
 // insere nova venda na base de dados e retorna
 // o ID da venda inserida
 //
 public static int inserirVenda(Connection bdConnection, String nomeProduto, String nf, String fone_comercial, String fone_residencial,
                  String CPF, String RG, String Endereco, String Complemento, String Setor, String Cidade, String UF, String Cep)
 {
 if (bdConnection == null)
 return -1;

 PreparedStatement stmt = null;
 try
 {
 // prepara comando a ser executado pelo BD
 stmt = bdConnection.prepareStatement(
 "INSERT INTO vendas (nf, nomeProduto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? )", //inserindo a grid vendas no  Banco de Dados
 Statement.RETURN_GENERATED_KEYS);
 stmt.setString(1, nomeProduto);
 stmt.setString(2, nf);
 stmt.setString(3, fone_comercial);
 stmt.setString(4, fone_residencial);
 stmt.setString(5, CPF);
 stmt.setString(6, RG);
 stmt.setString(7, Endereco);
 stmt.setString(8, Complemento);
 stmt.setString(9, Setor);
 stmt.setString(10, Cidade);
 stmt.setString(11, UF);
 stmt.setString(12, Cep);
 
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
 "Erro ao inserir nova venda na base de dados\n" + ex.getMessage(),
 "Inserir venda", JOptionPane.ERROR_MESSAGE);
 return -1; //indica erro
 }
 }
//==============================================================================
 
 public static boolean alterarTelefone(Connection bdConnection, Venda p)
 {
 if (bdConnection == null)
 return false;

 PreparedStatement stmt = null;
 try
 {
 stmt = bdConnection.prepareStatement(
 "UPDATE venda SET fone = ?  WHERE id = ? " );
 
 stmt = bdConnection.prepareStatement(
 "UPDATE venda SET fone_comercial = ?  WHERE id = ? " );
 
 stmt = bdConnection.prepareStatement(
 "UPDATE  venda SET fone_comercial = ?  WHERE id = ? " );
 
 stmt = bdConnection.prepareStatement(
 "UPDATE venda SET cpf = ?  WHERE id = ? " );
 
 
 
 
 stmt.setString(1, p.getNF());
 
 
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
//==============================================================================
 public static boolean eliminarVenda(Connection bdConnection,  Venda p)
 {
 if (bdConnection == null)
 return false;

 PreparedStatement stmt;
 try
 {
 stmt = bdConnection.prepareStatement("DELETE FROM venda WHERE id = ?");
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