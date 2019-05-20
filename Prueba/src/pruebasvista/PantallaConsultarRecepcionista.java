/*VERSION DE WINDOWS*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasvista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedrohdez
 */
public class PantallaConsultarRecepcionista extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaRecepcionista
     */
    Connection con;
    String linkbd = "jdbc:mysql://localhost:3306/VISTA?useTimezone=true&serverTimezone=UTC";
    
    public PantallaConsultarRecepcionista() {
        initComponents();
        
    }
    
    public void borraTabla(){
        DefaultTableModel modelo = (DefaultTableModel)TbRecepcionistas.getModel();
        modelo.setRowCount(0);
    }
    
    public void IniciarVentana(){
        CbTodo.setSelected(false);
        CbBuscar.setSelected(true);
        LblNombre.setVisible(true);
        LblApellido.setVisible(true);
        BConsultar.setVisible(true);
        tfNombre.setVisible(true);
        tfNombre.setText("");
        tfApellido.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        LblNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbRecepcionistas = new javax.swing.JTable();
        BConsultar = new javax.swing.JButton();
        LblApellido = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        CbTodo = new javax.swing.JCheckBox();
        CbBuscar = new javax.swing.JCheckBox();

        jLabel1.setText("Consulta de recepcionistas");

        LblNombre.setText("Nombre:");

        TbRecepcionistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Contraseña", "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(TbRecepcionistas);

        BConsultar.setText("Consultar");
        BConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConsultarActionPerformed(evt);
            }
        });

        LblApellido.setText("Apellido:");

        CbTodo.setText("Mostrar todo");
        CbTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbTodoActionPerformed(evt);
            }
        });

        CbBuscar.setText("Buscar");
        CbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(109, 109, 109))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(BConsultar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(CbTodo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CbBuscar))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LblApellido)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbTodo)
                    .addComponent(CbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BConsultar)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConsultarActionPerformed
      
        borraTabla();
        
        if(tfNombre.getText().equals("") && tfApellido.getText().equals("") ){
           JOptionPane.showMessageDialog(null, "Error. Rellene los dos campos e inténtelo de nuevo.");
        }
        
        else{
            try {
      
                DefaultTableModel modelo = (DefaultTableModel)TbRecepcionistas.getModel();

                con = DriverManager.getConnection(linkbd, "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs;
                
                if(tfNombre.getText().equals("")){
                    rs = stmt.executeQuery("SELECT * FROM Recepcionistas WHERE Apellido = '"+tfApellido.getText()+"'");
                }
                else if(tfApellido.getText().equals("")){
                    rs = stmt.executeQuery("SELECT * FROM Recepcionistas WHERE Nombre = '"+tfNombre.getText()+"'");
                }
                else{
                    rs = stmt.executeQuery("SELECT * FROM Recepcionistas WHERE Apellido = '"+tfApellido.getText()+"' AND Nombre = '"+tfNombre.getText()+"'");
                }

                rs.first();

                do{
                    String[] fila = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                    modelo.addRow(fila);
                }while(rs.next());

            } 
            catch (SQLException ex) {
                Logger.getLogger(PantallaConsultarRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "El/La recepcionista no existe. Inténtelo de nuevo.");
            }
        }    
        
    }//GEN-LAST:event_BConsultarActionPerformed

    private void CbTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbTodoActionPerformed
        borraTabla();
        CbBuscar.setSelected(false);
        LblNombre.setVisible(false);
        LblApellido.setVisible(false);
        tfNombre.setVisible(false);
        tfNombre.setText("");
        tfApellido.setVisible(false);
        tfApellido.setText("");
        BConsultar.setVisible(false);
        try {  
             DefaultTableModel modelo = (DefaultTableModel)TbRecepcionistas.getModel();
            
            con = DriverManager.getConnection(linkbd, "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Recepcionistas");
            
            rs.first();
            
            do{
                String[] fila = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                modelo.addRow(fila);
            }while(rs.next());
                    
        } catch (SQLException ex) {
            Logger.getLogger(PantallaConsultarRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
        }
    }//GEN-LAST:event_CbTodoActionPerformed

    private void CbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbBuscarActionPerformed

        CbTodo.setSelected(false);
        LblNombre.setVisible(true);
        LblApellido.setVisible(true);
        tfNombre.setVisible(true);
        tfApellido.setVisible(true);
        BConsultar.setVisible(true);
    }//GEN-LAST:event_CbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BConsultar;
    private javax.swing.JCheckBox CbBuscar;
    private javax.swing.JCheckBox CbTodo;
    private javax.swing.JLabel LblApellido;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JTable TbRecepcionistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
