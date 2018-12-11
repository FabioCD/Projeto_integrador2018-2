package Vendas;
//==============================================================================
import agendatelefonica.*;

public class Venda
{
 private int id;
 private String nomeProduto;
 private String nf;

  
 
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
//==============================================================================
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

 // nome pode conter somente letras, espaços e caracteres acentuados
 if(nomeProduto.matches("[a-zA-Z\\u00C0-\\u00FF ]+") == false)
 {
 throw new IllegalArgumentException();
 }
 // primeira letra de cada palavra maiúscula e demais letras minúsculas
 String[] arr = nomeProduto.split(" ");
 StringBuilder sb = new StringBuilder();
 for (String arr1 : arr)
 {
 sb.append(Character.toUpperCase(arr1.charAt(0))).append(arr1.substring(1).
toLowerCase()).append(" ");
 }

 this.nomeProduto = sb.toString().trim();
 }
 
 
//==============================================================================
 public String getNF()
 {
 return nf;
 }
 public void setFone(String fone) throws IllegalArgumentException
 {
 // verifica quantos digitos o usuário digitou
 String numeros = soNumeros(fone);
 if((numeros.length() < 8) || (numeros.length() > 11))
 {
 throw new IllegalArgumentException();
 }

 // Quantidade de dígitos:
 // 8: Formato: 9999-9999 (telefone fixo sem DDD)
 // 9: Formato: 99999-9999 (telefone celular com DDD)
 // 10: Formato: (99) 9999-9999 (telefone fixo com DDD)
 // 11: Formato: (99) 99999-9999 (telefone celular com DDD)
 this.nf = numeros;
 }
//==============================================================================
 
//==============================================================================

 
 // final dos GETTERS e SETTERS
//==============================================================================
//==============================================================================
 
 
 // construtores
 public Venda()
 {
 this.id = -1;
 this.nomeProduto = "";
 this.nf = "";
 
 }

 public Venda(int id, String nomeProduto, String nf)
 {
 this.id = id;
 this.nomeProduto = nomeProduto;
 this.nf = nf;
 
 }

 /*
 public String getNFFormatado()
 {
 switch(nf.length())
 {
 case 8: // Formato: 9999-9999 (telefone fixo sem DDD)
 return fone.substring(0,4) + "-" + nf.substring(4);
 case 9: // Formato: 99999-9999 (telefone celular com DDD)
 return fone.substring(0,5) + "-" + nf.substring(5);
 case 10: // Formato: (99) 9999-9999 (telefone fixo com DDD)
 return "(" + fone.substring(0,2) + ") " + nf.substring(2,6) + "-" +
 fone.substring(6);
 case 11: // Formato: (99) 99999-9999 (telefone celular com DDD)
 return "(" + fone.substring(0,2) + ") " + fone.substring(2,7) + "-" +
 fsubstring(7);
 }
 // retorna valor sem formatação
 return fone;
 }

 */
 
 
 
 
 
 
 
 
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
