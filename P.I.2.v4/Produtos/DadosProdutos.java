package Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DadosProdutos
{
 // leitura do arquivo contendo dados da agenda
 public static ArrayList<Produto> lerDados(Connection bdConnection)
 {
 ArrayList<Produto> produtos = new ArrayList<>();
 if (bdConnection == null)
 return produtos;

 try
 {
 String sql_str = "SELECT * FROM produtos ORDER BY nomeProduto";
 PreparedStatement stmt = bdConnection.prepareStatement(sql_str);
 ResultSet rs = stmt.executeQuery();
 int id;
 String EAN13, nomeProduto,  descricaoProduto , qtdEstoque , precoProduto, unidMedida ;
 Produto novoProduto;

 // percorre conjunto de produtos retornadas pelo banco de dados
 while (rs.next())
 {
 // obtém dados do produto corrente
 id = rs.getInt("id");
 EAN13 = rs.getString("EAN13");
 nomeProduto = rs.getString("nomeProduto");
 descricaoProduto = rs.getString("descricaoProduto");
 qtdEstoque = rs.getString("qtdEstoque");
 precoProduto = rs.getString("valorProduto");
 unidMedida = rs.getString("unidMedida");
 
 //Endereco = rs.getString("Endereco");
 //Complemento = rs.getString("Complemento"); 
 //Setor = rs.getString("Setor");
 //Cidade = rs.getString("Cidade"); 
 //UF = rs.getString("UF");
 //Cep = rs.getString("Cep");
          
    
 
// cria novo produto e a adiciona na lista
 novoProduto = new Produto(id, EAN13 , nomeProduto ,  descricaoProduto , qtdEstoque , precoProduto, unidMedida );
 produtos.add(novoProduto);
 }

 stmt.close();
 rs.close();

 // retorna lista de pessoas
 return produtos;
 } catch(SQLException ex) {
 JOptionPane.showMessageDialog(null,
 "Erro na consulta SQL\n" + ex.getMessage(),
 "Ler Dados", JOptionPane.ERROR_MESSAGE);
 return produtos;
 }
 }

 //
 // insere nova pessoa na base de dados e retorna
 // o ID da pessoa inserida
 //
 public static int inserirProduto(Connection bdConnection, String EAN13 , String nomeProduto , String descricaoProduto,
                                                           String qtdEstoque , String precoProduto , String unidMedida
                                  )
 {
 if (bdConnection == null)
 return -1;

 PreparedStatement stmt = null;
 try
 {
 // prepara comando a ser executado pelo BD
 stmt = bdConnection.prepareStatement(
 "INSERT INTO produtos (EAN13, nomeProduto, descricaoProduto, qtdEstoque, valorProduto, unidMedida) VALUES (?, ?, ?, ?, ?, ?)", //inserindo pessoa no  Banco de Dados
 
Statement.RETURN_GENERATED_KEYS);
 
 stmt.setString(1, EAN13);
 stmt.setString(2, nomeProduto);
 stmt.setString(3, descricaoProduto);
 stmt.setString(4, qtdEstoque);
 stmt.setString(5, precoProduto);
 stmt.setString(6, unidMedida);
 

 
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
 "Erro ao inserir novo produto na base de dados\n" + ex.getMessage(),
 "Inserir produto", JOptionPane.ERROR_MESSAGE);
 return -1; //indica erro
 }
 }

 public static boolean alterarTelefone(Connection bdConnection, Produto p)
 {
 if (bdConnection == null)
 return false;

 PreparedStatement stmt = null;
 try
 {
 stmt = bdConnection.prepareStatement(
 "UPDATE produtos SET fone = ?  WHERE id = ? " );
 
 stmt = bdConnection.prepareStatement(
 "UPDATE produtos SET fone_comercial = ?  WHERE id = ? " );
 
 stmt = bdConnection.prepareStatement(
 "UPDATE pessoas SET fone_comercial = ?  WHERE id = ? " );
 
 stmt = bdConnection.prepareStatement(
 "UPDATE pessoas SET cpf = ?  WHERE id = ? " );
 
 
 
 
 stmt.setString(1, p.getNomeProduto());
 stmt.setString(3, p.getEAN13());
 stmt.setString(4, p.getDescricaoProduto());
 stmt.setString(5, p.getPrecoProduto());
 stmt.setString(6, p.getQTDEstoque());
 stmt.setString(7, p.getUnidMedida());
 
 
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

 public static boolean eliminarProduto(Connection bdConnection, Produto p)
 {
 if (bdConnection == null)
 return false;

 PreparedStatement stmt;
 try
 {
 stmt = bdConnection.prepareStatement("DELETE FROM produtos WHERE id = ?");
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