package agendatelefonica;
public class Pessoa
{
 private int id;
 private String nome;
 private String fone;
 private String fone_comercial;
 private String fone_residencial;
 private String CPF;
 private String RG;
 private String Endereco;
 private String Complemento;
 private String Setor;
 private String Cidade;
 private String UF;
 private String Cep;
 
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

 public String getFone_Comercial()
 {
 return fone_comercial;
 }
 public void setFone_Comercial(String fone_comercial) throws IllegalArgumentException
 {
 // verifica quantos digitos o usuário digitou
 String numeros = soNumeros(fone_comercial);
 if((numeros.length() < 8) || (numeros.length() > 11))
 {
 throw new IllegalArgumentException();
 }

 // Quantidade de dígitos:
 // 8: Formato: 9999-9999 (telefone fixo sem DDD)
 // 9: Formato: 99999-9999 (telefone celular com DDD)
 // 10: Formato: (99) 9999-9999 (telefone fixo com DDD)
 // 11: Formato: (99) 99999-9999 (telefone celular com DDD)
 this.fone_comercial = numeros;
 }
//------------------------------------------------------------------------------

 public String getFone_Residencial()
 {
 return fone_residencial;
 }
 public void setFone_Residencial(String fone_residencial) throws IllegalArgumentException
 {
 // verifica quantos digitos o usuário digitou
 String numeros = soNumeros(fone_residencial);
 if((numeros.length() < 8) || (numeros.length() > 11))
 {
 throw new IllegalArgumentException();
 }

 // Quantidade de dígitos:
 // 8: Formato: 9999-9999 (telefone fixo sem DDD)
 // 9: Formato: 99999-9999 (telefone celular com DDD)
 // 10: Formato: (99) 9999-9999 (telefone fixo com DDD)
 // 11: Formato: (99) 99999-9999 (telefone celular com DDD)
 this.fone_residencial = numeros;
 }
 // final dos GETTERS e SETTERS
//==============================================================================
//==============================================================================
 
 
 // construtores
 public Pessoa()
 {
 this.id = -1;
 this.nome = "";
 this.fone = "";
 this.fone_comercial = "";
 this.fone_residencial = "";
 this.CPF = "";
 this.RG = "";
 this.Endereco = "";
 this.Complemento = "";
 this.Setor = "";
 this.Cidade = "";
 this.UF = "";
 this.Cep = "";
 }

 public Pessoa(int id, String nome, String fone, String fone_comercial, String fone_residencial, String CPF, String RG,
                    String Endereco, String Complemento, String Setor, String Cidade, String UF, String Cep)
 {
 this.id = id;
 this.nome = nome;
 this.fone = fone;
 this.fone_comercial = fone_comercial;
 this.fone_residencial = fone_residencial;
 this.CPF = CPF;
 this.RG = RG;
 this.Endereco = Endereco;
 this.Complemento = Complemento;
 this.Setor = Setor;
 this.Cidade = Cidade;
 this.UF = UF;
 this.Cep = Cep;
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

 
 public String getFone_Comercial_Formatado()
 {
 switch(fone_comercial.length())
 {
 case 8: // Formato: 9999-9999 (telefone fixo sem DDD)
 return fone_comercial.substring(0,4) + "-" + fone_comercial.substring(4);
 case 9: // Formato: 99999-9999 (telefone celular com DDD)
 return fone_comercial.substring(0,5) + "-" + fone_comercial.substring(5);
 case 10: // Formato: (99) 9999-9999 (telefone fixo com DDD)
 return "(" + fone_comercial.substring(0,2) + ") " + fone_comercial.substring(2,6) + "-" +fone_comercial.substring(6);
 case 11: // Formato: (99) 99999-9999 (telefone celular com DDD)
 return "(" + fone_comercial.substring(0,2) + ") " + fone_comercial.substring(2,7) + "-" + fone_comercial.substring(7);
 }
 // retorna valor sem formatação
 return fone_comercial;
 }
 
 
  public String getFone_Residencial_Formatado()
 {
 switch(fone_residencial.length())
 {
 case 8: // Formato: 9999-9999 (telefone fixo sem DDD)
 return fone_residencial.substring(0,4) + "-" + fone_residencial.substring(4);
 case 9: // Formato: 99999-9999 (telefone celular com DDD)
 return fone_residencial.substring(0,5) + "-" + fone_residencial.substring(5);
 case 10: // Formato: (99) 9999-9999 (telefone fixo com DDD)
 return "(" + fone_residencial.substring(0,2) + ") " + fone_residencial.substring(2,6) + "-" + fone_residencial.substring(6);
 case 11: // Formato: (99) 99999-9999 (telefone celular com DDD)
 return "(" + fone_residencial.substring(0,2) + ") " + fone_residencial.substring(2,7) + "-" + fone_residencial.substring(7);
 }
 // retorna valor sem formatação
 return fone_residencial;
 }

//------------------------------------------------------------------------------

public String getCPF()
 {
 return CPF;
 }
 public void setCPF(String CPF) throws IllegalArgumentException
 {
 // verifica quantos digitos o usuário digitou
 String numeros = soNumeros(CPF);
 if((numeros.length() < 8) || (numeros.length() > 11))
 {
 throw new IllegalArgumentException();
 }

 // Quantidade de dígitos:
 // 8: Formato: 9999-9999 (telefone fixo sem DDD)
 // 9: Formato: 99999-9999 (telefone celular com DDD)
 // 10: Formato: (99) 9999-9999 (telefone fixo com DDD)
 // 11: Formato: (99) 99999-9999 (telefone celular com DDD)
 this.CPF = numeros;
 }

 
 /*
    public String getFone_comercial() {
        return fone_comercial;
    }

    public void setFone_comercial(String fone_comercial) {
        this.fone_comercial = fone_comercial;
    }

    public String getFone_residencial() {
        return fone_residencial;
    }

    public void setFone_residencial(String fone_residencial) {
        this.fone_residencial = fone_residencial;
    }
*/
    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
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
