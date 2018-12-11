package Vendas;

import agendatelefonica.*;

public class Venda
{
 private int id;
 private String nome;
 private String fone;
 
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
 public String getNome()
 {
 return nome;
 }
 public void setNome(String nome) throws IllegalArgumentException
 {
 // nome não pode ser vazio
 if(nome.isEmpty())
 {
 throw new IllegalArgumentException();
 }

 // nome pode conter somente letras, espaços e caracteres acentuados
 if(nome.matches("[a-zA-Z\\u00C0-\\u00FF ]+") == false)
 {
 throw new IllegalArgumentException();
 }
 // primeira letra de cada palavra maiúscula e demais letras minúsculas
 String[] arr = nome.split(" ");
 StringBuilder sb = new StringBuilder();
 for (String arr1 : arr)
 {
 sb.append(Character.toUpperCase(arr1.charAt(0))).append(arr1.substring(1).
toLowerCase()).append(" ");
 }

 this.nome = sb.toString().trim();
 }
 
 
//------------------------------------------------------------------------------
 public String getFone()
 {
 return fone;
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
 this.fone = numeros;
 }
//------------------------------------------------------------------------------

 
//------------------------------------------------------------------------------

 
 // final dos GETTERS e SETTERS
//==============================================================================
//==============================================================================
 
 
 // construtores
 public Venda()
 {
 this.id = -1;
 this.nome = "";
 this.fone = "";
 
 }

 public Venda(int id, String nome, String fone)
 {
 this.id = id;
 this.nome = nome;
 this.fone = fone;
 
 }

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
