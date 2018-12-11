package Vendas;
import agendatelefonica.*;
import TelaPrincipal.TelaPrincipal;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
public class TelaVenda extends javax.swing.JFrame
{
 private MyPostgreSQL pgBD; // conexão com banco de dados
 private ArrayList<Venda> listaVendas;

 public TelaVenda()
 {
 initComponents();
 
     setDefaultCloseOperation(HIDE_ON_CLOSE); //usar esse código para fechar esse JFRAME e não a tela principal

 // adiciona change listener no campo de texto:
 // o método filtroAlterou() será chamado toda vez que o
 // conteúdo de filtroTextField for alterado.
 filtroTextField.getDocument().addDocumentListener(new DocumentListener() {
 @Override
 public void insertUpdate(DocumentEvent e) {
 filtroAlterou();
 }
 @Override
 public void removeUpdate(DocumentEvent e) {
 filtroAlterou();
 }
 @Override
 public void changedUpdate(DocumentEvent e) {
 filtroAlterou();
 }
 });

 // conecta com base de dados
 pgBD = new MyPostgreSQL();
 pgBD.conecta();

 // recupera dados da base de dados
 listaVendas = DadosVendas.lerDados(pgBD.getConnection());
 mostraDados(listaVendas);

 // centralizar a janela na tela
 this.setLocationRelativeTo(null);
 }

    TelaVenda(TelaPrincipal aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        filtroTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendasTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        novaVendaMenuItem = new javax.swing.JMenuItem();
        sairMenuItem = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emissão de venda");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        filtroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Vendas"));

        vendasTable.setAutoCreateRowSorter(true);
        vendasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Telefone Comercial", "Telefone Residencial", "CPF", "RG", "Endereço", "Complemento", "Setor", "Cidade", "UF", "CEP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vendasTable.getTableHeader().setReorderingAllowed(false);
        vendasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vendasTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(vendasTable);
        if (vendasTable.getColumnModel().getColumnCount() > 0) {
            vendasTable.getColumnModel().getColumn(0).setMinWidth(40);
            vendasTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            vendasTable.getColumnModel().getColumn(0).setMaxWidth(40);
            vendasTable.getColumnModel().getColumn(1).setMinWidth(200);
            vendasTable.getColumnModel().getColumn(2).setMinWidth(110);
            vendasTable.getColumnModel().getColumn(2).setPreferredWidth(110);
            vendasTable.getColumnModel().getColumn(2).setMaxWidth(110);
            vendasTable.getColumnModel().getColumn(5).setMinWidth(100);
            vendasTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            vendasTable.getColumnModel().getColumn(5).setMaxWidth(100);
            vendasTable.getColumnModel().getColumn(11).setMinWidth(30);
            vendasTable.getColumnModel().getColumn(11).setPreferredWidth(30);
            vendasTable.getColumnModel().getColumn(11).setMaxWidth(30);
            vendasTable.getColumnModel().getColumn(12).setMinWidth(80);
            vendasTable.getColumnModel().getColumn(12).setPreferredWidth(80);
            vendasTable.getColumnModel().getColumn(12).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setToolTipText("");

        jMenu1.setText("Vendas");

        novaVendaMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        novaVendaMenuItem.setText("Novo pedido");
        novaVendaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaVendaMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(novaVendaMenuItem);

        sairMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        sairMenuItem.setText("Sair");
        sairMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(sairMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novaVendaMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_novaVendaMenuItemActionPerformed
    {//GEN-HEADEREND:event_novaVendaMenuItemActionPerformed
// ativa janela para editar dados da pessoa selecionada
 
 
  
 
 VendaDialog pDialog = new VendaDialog(this, true);
 pDialog.setVisible(true);
 //pDialog.setConnection(pgBD.getConnection());
 
{ 
 }    }//GEN-LAST:event_novaVendaMenuItemActionPerformed

    private void sairMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sairMenuItemActionPerformed
    {//GEN-HEADEREND:event_sairMenuItemActionPerformed
        
       // System.exit(0);
        
                TelaVenda form = new TelaVenda();
        
        this.dispose();
              
    }//GEN-LAST:event_sairMenuItemActionPerformed

    private void vendasTableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vendasTableMouseClicked
    {//GEN-HEADEREND:event_vendasTableMouseClicked
     // double-click: editar dados da pessoa
 if (evt.getClickCount() >= 2)
 {
 /*
 * IMPORTANTE: quando uma tabela usa um ordenador, os dados que o usuário
 * vê podem estar em uma ordem diferente da que está especificada no modelo
 * interno (data model). Os dados que o usuário vê é conhecido como uma view,
 * e possui seu próprio conjunto de coordenadas. Portanto, é necessário
 * converter as coordenadas do modelo para as coordenadas da view.
 *
 * Quando usar um ordenador, SEMPRE converta as coordenadas das células
 */
 int rowModel = vendasTable.getSelectedRow(); // coordenadas do modelo
 // coordenadas da view
 int rowView = vendasTable.convertRowIndexToModel(rowModel);

 
 // atualiza dados na tabela
 //model.removeRow(rowView);
 //break;
 
 }
    }//GEN-LAST:event_vendasTableMouseClicked

    private void filtroTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroTextFieldActionPerformed
    
    public ArrayList<Venda> buscaNomesTelefones(String procurado)
    {
        if((procurado == null) || procurado.isEmpty())
 return listaVendas;

 ArrayList<Venda> vendasEncontradas = new ArrayList<>();
 String minusculo = procurado.toLowerCase();
 boolean achou = false;

 // percorrer toda a lista de pessoas
 for(Venda p : listaVendas)
 {
 // verifica se dado procurado aparece no nome ou telefone
 if(p.getNome().toLowerCase().contains(minusculo) ||
 p.getFone().contains(procurado)//||
 //p.getFone_Comercial().contains(procurado)
         )
 {
 achou = true;
 vendasEncontradas.add(p);
 }
 }

 if(achou)
 return vendasEncontradas;
 else
 return null;
    }
    
    private void filtroAlterou()
    {
  ArrayList<Venda> filtro = buscaNomesTelefones(filtroTextField.getText());
 mostraDados(filtro);

    }
    
    
    
    private void mostraDados(ArrayList<Venda> dados)
    {
       try
 {
 // limpa dados da tabela
 DefaultTableModel model = (DefaultTableModel) vendasTable.getModel();
 model.setRowCount(0);

 if((dados == null) || (dados.isEmpty()))
 return;

 // percorrer lista de pessoas e mostrar dados
 for (Venda p : dados)
 {                                                                          //=-=-=-=-=-=-=-=-=-//=-=-=-=-=-=-=-=-=-
 model.addRow(new Object[]{p.getId(), p.getNome(), p.getFoneFormatado()   });
// add os 3 campos em pessoa , que é add na lista, que depois joga na tabela da tela gráfica
                                                                        
 }
 }
 catch(Exception ex)
 {
 JOptionPane.showMessageDialog(this,
"Erro ao atualizar tabela\n" + ex.getMessage(),
 "Mostrar dados", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filtroTextField;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem novaVendaMenuItem;
    private javax.swing.JMenuItem sairMenuItem;
    private javax.swing.JTable vendasTable;
    // End of variables declaration//GEN-END:variables
}