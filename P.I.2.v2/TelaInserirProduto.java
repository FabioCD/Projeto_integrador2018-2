package agendatelefonica;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class TelaInserirProduto extends javax.swing.JDialog
{
 // operacao feita pelo usuario
 public static final int OPERACAO_OK = 0;
 public static final int OPERACAO_ELIMINAR = 1;
 public static final int OPERACAO_CANCELAR = 2;
 
 private Connection bdConnection;
 private Pessoa pCurrent; // dados da pessoa corrente
 private int operacao;
 private boolean estaInserindo;
 private final FramePrincipal janelaPai;

 public TelaInserirProduto(java.awt.Frame parent, boolean modal)
 {
 super(parent, modal);
 initComponents();

 pCurrent = new Pessoa();
 estaInserindo = true;
 janelaPai = (FramePrincipal)parent;

 bdConnection = null;

 // centraliza janela na tela
 this.setLocationRelativeTo(null);
 }

 public void setConnection(Connection bdConnection)
 {
 this.bdConnection = bdConnection;
 }

 public int getOperacao()
 {
 return operacao;
 }

 public Pessoa getPessoa()
 {
 return pCurrent;
 }

 public void setPessoa(Pessoa p)
 {
 if(p != null)
 {
 pCurrent = new Pessoa(p.getId(), p.getNome(), p.getFone(), p.getFone_Comercial(), p.getFone_Residencial(), p.getCPF(), p.getRG(),
                       p.getEndereco(), p.getComplemento(), p.getSetor(), p.getCidade(), p.getUF(), p.getCep());
 
 nomeTextField.setText(p.getNome());
 foneTextField.setText(p.getFone());
 fone_comercialTextField.setText(p.getFone_Comercial());
 fone_residencialTextField.setText(p.getFone_Residencial());
 CPFTextField.setText(p.getCPF());
 RGTextField.setText(p.getRG());
 EnderecoTextField.setText(p.getEndereco());
 ComplementoTextField.setText(p.getComplemento());
 SetorTextField.setText(p.getSetor());
 CidadeTextField.setText(p.getCidade());
 UFTextField.setText(p.getUF());
 CepTextField.setText(p.getCep());
 }
 }

 public void inserindoNovo(boolean novaPessoa)
 {
 estaInserindo = novaPessoa;

 if (novaPessoa)
 {
 eliminaButton.setEnabled(false);
 }
 else
 {
 nomeTextField.setEditable(false);
 nomeTextField.setFocusable(false);
 eliminaButton.setEnabled(true);
 }
 }
 
 
    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        foneTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        eliminaButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fone_comercialTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fone_residencialTextField = new javax.swing.JFormattedTextField();
        RGTextField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        CPFTextField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EnderecoTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ComplementoTextField = new javax.swing.JTextField();
        SetorTextField = new javax.swing.JTextField();
        UFTextField = new javax.swing.JTextField();
        CidadeTextField = new javax.swing.JTextField();
        CepTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Telefone:");

        foneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                foneTextFieldKeyTyped(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        eliminaButton.setText("Eliminar");
        eliminaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Telefone:");

        fone_comercialTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fone_comercialTextFieldKeyTyped(evt);
            }
        });

        jLabel4.setText("Telefone:");

        RGTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGTextFieldActionPerformed(evt);
            }
        });
        RGTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RGTextFieldKeyTyped(evt);
            }
        });

        jLabel5.setText("CPF:");

        CPFTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPFTextFieldActionPerformed(evt);
            }
        });
        CPFTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CPFTextFieldKeyTyped(evt);
            }
        });

        jLabel6.setText("RG:");

        jLabel7.setText("Endereço:");

        jLabel8.setText("Cep:");

        jLabel9.setText("Setor:");

        jLabel10.setText("Complemento:");

        jLabel11.setText("Cidade:");

        jLabel12.setText("UF:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(nomeTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(foneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fone_comercialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fone_residencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CPFTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                        .addComponent(RGTextField)))))
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EnderecoTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComplementoTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SetorTextField)
                                    .addComponent(CidadeTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CepTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(eliminaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(foneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(EnderecoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fone_comercialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(ComplementoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fone_residencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(SetorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(CidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel12)
                        .addComponent(UFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(CepTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton)
                    .addComponent(eliminaButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void foneTextFieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_foneTextFieldKeyTyped
    {//GEN-HEADEREND:event_foneTextFieldKeyTyped
        // permitir que somente números sejam digitados no campo telefone
 char c = evt.getKeyChar();
 if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||
 (c == KeyEvent.VK_DELETE)))
 {
 evt.consume();
 }

    }//GEN-LAST:event_foneTextFieldKeyTyped

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
 operacao = OPERACAO_CANCELAR;
 setVisible(false);
 dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_okButtonActionPerformed
    {//GEN-HEADEREND:event_okButtonActionPerformed
      // valida dados
 if(estaInserindo)
 {
 try
 {
 pCurrent.setNome(nomeTextField.getText());
 }
 catch(IllegalArgumentException ex)
 {
 String msg = "Nome não pode ser vazio e deve conter somente letras";
 JOptionPane.showMessageDialog(this, msg,
 "Dados das Pessoas",
 JOptionPane.ERROR_MESSAGE);
 nomeTextField.requestFocus();
 return;
 }
 }
 try
 {
 pCurrent.setFone(foneTextField.getText());
 }
 catch(IllegalArgumentException ex)
 {
 String msg = "Telefone Inválido.\n" +
 "Formatos Válidos:\n" +
 " Sem DDD: 9999-9999 ou 99999-9999\n" +
 " Com DDD: 99 9999-9999 ou 99 99999-9999";
 JOptionPane.showMessageDialog(this, msg,
 "Dados das Pessoas",
 JOptionPane.ERROR_MESSAGE);
 foneTextField.requestFocus();
 return;
 }

 // verifica se nome já foi inserido
 if(estaInserindo)
 {
 ArrayList<Pessoa> pessoas =
janelaPai.buscaNomesTelefones(nomeTextField.getText());
 if((pessoas != null) && (pessoas.size() > 0))
 {
 JOptionPane.showMessageDialog(this, "Pessoa já cadastrada!",
 "Dados das Pessoas",
 JOptionPane.ERROR_MESSAGE);
 nomeTextField.requestFocus();
 return;
 }
 }

 // adiciona ou atualiza dados pessoa na base de dados
 if (estaInserindo)
 {
int id = DadosPessoas.inserirPessoa(bdConnection, nomeTextField.getText(),foneTextField.getText(), fone_comercialTextField.getText(),
        fone_residencialTextField.getText(), CPFTextField.getText(), RGTextField.getText(), EnderecoTextField.getText() , 
ComplementoTextField.getText(), SetorTextField.getText(), CidadeTextField.getText(), UFTextField.getText(), CepTextField.getText());
 
if(id < 0)
 return;
 //atualiza ID da pessoa inserida na base de dados;
 pCurrent.setId(id);
 }
 else
 {
 DadosPessoas.alterarTelefone(bdConnection, pCurrent);
 }

 // indica que operação de inserção foi feita e fecha janaela
 operacao = OPERACAO_OK;
 setVisible(false);
 dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    
    
    private void eliminaButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_eliminaButtonActionPerformed
    {//GEN-HEADEREND:event_eliminaButtonActionPerformed
        
 // elimina pessoa da base de dados
 DadosPessoas.eliminarPessoa(bdConnection, pCurrent);

 // indica que operação de inserção foi feita e fecha janela
 operacao = OPERACAO_ELIMINAR;
 setVisible(false);
 dispose();
    }//GEN-LAST:event_eliminaButtonActionPerformed

    
    private void fone_comercialTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fone_comercialTextFieldKeyTyped
                      
        // permitir que somente números sejam digitados no campo telefone
 char c = evt.getKeyChar();
 if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||
 (c == KeyEvent.VK_DELETE)))
 {
 evt.consume();
    }//GEN-LAST:event_fone_comercialTextFieldKeyTyped
    }
    
    
    private void RGTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGTextFieldActionPerformed
           // TODO add your handling code here:
    }//GEN-LAST:event_RGTextFieldActionPerformed

    private void RGTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RGTextFieldKeyTyped
//        permitir que somente números sejam digitados no campo CPF
 char c = evt.getKeyChar();
 if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||
 (c == KeyEvent.VK_DELETE)))
 {
 evt.consume();
    }          // TODO add your handling code here:
    }//GEN-LAST:event_RGTextFieldKeyTyped

    private void CPFTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPFTextFieldActionPerformed

    private void CPFTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CPFTextFieldKeyTyped
 
    
    
    
    
    
    private void fone_residencialTextFieldKeyTyped(java.awt.event.KeyEvent evt) {                                                 
                      
        // permitir que somente números sejam digitados no campo telefone
 char c = evt.getKeyChar();
 if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||
 (c == KeyEvent.VK_DELETE)))
 {
 evt.consume();
    }                                                
 }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TelaInserirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaInserirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaInserirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaInserirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                TelaInserirProduto dialog = new TelaInserirProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CPFTextField;
    private javax.swing.JTextField CepTextField;
    private javax.swing.JTextField CidadeTextField;
    private javax.swing.JTextField ComplementoTextField;
    private javax.swing.JTextField EnderecoTextField;
    private javax.swing.JFormattedTextField RGTextField;
    private javax.swing.JTextField SetorTextField;
    private javax.swing.JTextField UFTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton eliminaButton;
    private javax.swing.JTextField foneTextField;
    private javax.swing.JTextField fone_comercialTextField;
    private javax.swing.JFormattedTextField fone_residencialTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
