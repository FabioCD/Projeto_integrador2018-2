package Produtos;
public class Produto
{
 private int id;
 private String nomeProduto;
 private String EAN13;
 private String descricaoProduto;
 private String unidMedida;
 private String qtdEstoque;
 private String precoProduto;
 
//==============================================================================
//==============================================================================
// GETTERS e SETTERS
//
 public int getId()
 {
 return id;
 }

 public void setId(int id)
 {
 this.id = id;
 }
//------------------------------------------------------------------------------
 public String getNomeProduto()
 {
 return nomeProduto;
 }
 public void setNomeProduto(String nomeProduto) throws IllegalArgumentException
 {
 // nome não pode ser vazio
 if(nomeProduto.isEmpty())
 {
 throw new IllegalArgumentException();
 }

 
     
 }
 
//------------------------------------------------------------------------------
 public String getEAN13()
 {
 return EAN13;
 }
 public void setEAN13(String EAN13) throws IllegalArgumentException
 {
 // verifica quantos digitos o usuário digitou
 String numeros = soNumeros(EAN13);
 if((numeros.length() < 8) || (numeros.length() > 13))
 {
 throw new IllegalArgumentException();
 }

 // Quantidade de dígitos:
 // 8: Formato: 9999-9999 (telefone fixo sem DDD)
 // 9: Formato: 99999-9999 (telefone celular com DDD)
 // 10: Formato: (99) 9999-9999 (telefone fixo com DDD)
 // 11: Formato: (99) 99999-9999 (telefone celular com DDD)
 this.EAN13 = numeros;
 }
//------------------------------------------------------------------------------

 public String getQTDEstoque()
 {
 return qtdEstoque;
 }
 public void setQTDEstoque(String qtdEstoque) throws IllegalArgumentException
 {
 // verifica quantos digitos o usuário digitou
 String numeros = soNumeros(qtdEstoque);
 
 }
//------------------------------------------------------------------------------

 public String getPrecoProduto()
 {
 return precoProduto;
 }
 public void setPrecoProduto(String precoProduto) throws IllegalArgumentException
 {
 // verifica quantos digitos o usuário digitou
 String numeros = soNumeros(precoProduto);
 
     
 }
 




// final dos GETTERS e SETTERS
//==============================================================================
//==============================================================================
 
 
 // construtores
 public Produto()
 {
 this.id = -1;
 this.nomeProduto = "";
 this.EAN13 = "";
 this.descricaoProduto = "";
 this.unidMedida = "";
 this.qtdEstoque = "";
 this.precoProduto = "";
 }

 
 public Produto(int id, String EAN13 , String nomeProduto, String descricaoProduto ,   
                         String qtdEstoque, String precoProduto ,String unidMedida  )
 {
 this.id = id;
 this.nomeProduto = nomeProduto;
 this.EAN13 = EAN13;
 this.descricaoProduto = descricaoProduto;
 this.unidMedida = unidMedida;
 this.qtdEstoque = qtdEstoque;
 this.precoProduto = precoProduto;
 }

 /*
 public String getFoneFormatado()
 {
 switch(fone.length())
 {
 case 8: // Formato: 9999-9999 (telefone fixo sem DDD)
 return fone.substring(0,4) + "-" + fone.substring(4);
 case 9: // Formato: 99999-9999 (telefone celular com DDD)
 return fone.substring(0,5) + "-" + fone.substring(5);
 case 10: // Formato: (99) 9999-9999 (telefone fixo com DDD)
 return "(" + fone.substring(0,2) + ") " + fone.substring(2,6) + "-" +
 fone.substring(6);
 case 11: // Formato: (99) 99999-9999 (telefone celular com DDD)
 return "(" + fone.substring(0,2) + ") " + fone.substring(2,7) + "-" +
 fone.substring(7);
 }
 // retorna valor sem formatação
 return fone;
 }
*/

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(String unidMedida) {
        this.unidMedida = unidMedida;
    }

    public String getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(String qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
 
 
 
 
 
 
 
 
 
//------------------------------------------------------------------------------

  
  
 /**
 * Este método retira da string passada como parâmetro todos
 * os caracteres que não sejam dígitos ('0' a '9').
 *
 * @param str string contendo dígitos e outros caracteres
 * @return string contendo somente os dígitos da string passada como parâmetro
 */
 public String soNumeros(String str)
 {
 StringBuilder sb = new StringBuilder();
 char [] caracteres = str.toCharArray();

 for (Character caracter : caracteres) {
 if (Character.isDigit(caracter)) {
 sb.append(caracter);
 }
 }

 return sb.toString();
 }
}
