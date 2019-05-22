package vista;



import java.awt.Window;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class MainWindow extends javax.swing.JFrame {
    
    Connection con;
    public String username;
    public String password;
    public enum UserStat {AdminFailPass, RecepFailPass, RecepLogged, AdminLogged};
    public static UserStat userStatus;
    public Timer timer;
    
    /* Administrador */
    PantallaRegistrarRecepcionista pantallaregistro;
    PantallaConsultarRecepcionista consultarecepcionista;
    PantallaActualizarRecepcionista actualizarecepcionista;
    PantallaEliminarRecepcionista eliminarecepcionista;
    
    /* Recepcionista */
    
    PantallaRegistrarNiño pantallaregistrarniño; 
    PantallaConsultarNiño pantallaconsultarniño;
    
    
    public MainWindow() {
        initComponents();
        setTitle("VISTA");
        setSize(1000,800);    
        setLocation(200,100);    
        
        /* Administrador */
        pantallaregistro = new PantallaRegistrarRecepcionista();
        consultarecepcionista = new PantallaConsultarRecepcionista();
        actualizarecepcionista = new PantallaActualizarRecepcionista();
        eliminarecepcionista = new PantallaEliminarRecepcionista();
        
        add(consultarecepcionista);
        add(pantallaregistro);
        add(actualizarecepcionista);
        add(eliminarecepcionista);
      
        
        
        /* Recepcionista */
        pantallaregistrarniño = new PantallaRegistrarNiño();
        pantallaconsultarniño = new PantallaConsultarNiño();
        
        add(pantallaregistrarniño);
        add(pantallaconsultarniño);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE,null, e);
        }
        userWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        miRegistrar = new javax.swing.JMenuItem();
        miConsultar = new javax.swing.JMenuItem();
        miActualizar = new javax.swing.JMenuItem();
        miEliminar = new javax.swing.JMenuItem();
        jMSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Niños");

        miRegistrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        miRegistrar.setText("Registrar");
        miRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarActionPerformed(evt);
            }
        });
        jMenu2.add(miRegistrar);

        miConsultar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        miConsultar.setText("Consultar");
        miConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultarActionPerformed(evt);
            }
        });
        jMenu2.add(miConsultar);

        miActualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        miActualizar.setText("Actualizar");
        miActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miActualizarActionPerformed(evt);
            }
        });
        jMenu2.add(miActualizar);

        miEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        miEliminar.setText("Eliminar");
        miEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEliminarActionPerformed(evt);
            }
        });
        jMenu2.add(miEliminar);

        jMenuBar1.add(jMenu2);

        jMSalir.setText("Salir");
        jMSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMSalirMouseClicked(evt);
            }
        });
        jMSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Salir(){
        Main.lw = new LoginWindow();
        Main.lw.setVisible(true);
        userStatus = UserStat.AdminFailPass;
        this.dispose();
    }
    /*************************************************************************/
    
    public void userWindow(){
        
        if(userStatus == UserStat.AdminLogged){
            setTitle("VISTA para Administrador");
            jMenu2.setText("Recepcionistas");
        }else{
            miEliminar.setVisible(false);
            miActualizar.setVisible(false);
        }
        jMenuBar1.setVisible(true);
    }

    /*************************************************************************/
     


    private void miRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarActionPerformed
        if(userStatus == UserStat.AdminLogged){
            pantallaregistro.IniciarVentana();
            pantallaregistro.setVisible(true);
            eliminarecepcionista.setVisible(false);
            actualizarecepcionista.setVisible(false);
            consultarecepcionista.setVisible(false);
            consultarecepcionista.borraTabla();
        }else{
            pantallaconsultarniño.setVisible(false);
            pantallaregistrarniño.setVisible(true);
            pantallaregistrarniño.IniciarVentana();
        }
    }//GEN-LAST:event_miRegistrarActionPerformed

    private void miEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEliminarActionPerformed
        if(userStatus == UserStat.AdminLogged){
            eliminarecepcionista.IniciarVentana();
            eliminarecepcionista.setVisible(true);
            pantallaregistro.setVisible(false);
            actualizarecepcionista.setVisible(false);
            consultarecepcionista.setVisible(false);
            
        }
    }//GEN-LAST:event_miEliminarActionPerformed

    private void miActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miActualizarActionPerformed
        if(userStatus == UserStat.AdminLogged){
            actualizarecepcionista.IniciarVentana();
        eliminarecepcionista.setVisible(false);
        pantallaregistro.setVisible(false);
        actualizarecepcionista.setVisible(true);
        consultarecepcionista.setVisible(false);
        }
    }//GEN-LAST:event_miActualizarActionPerformed

    private void miConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultarActionPerformed
        if(userStatus == UserStat.AdminLogged){
            consultarecepcionista.setVisible(true);
            eliminarecepcionista.setVisible(false);
            actualizarecepcionista.setVisible(false);
            pantallaregistro.setVisible(false);
            consultarecepcionista.borraTabla();
            consultarecepcionista.IniciarVentana();
        }else{
             pantallaregistrarniño.setVisible(false);
             pantallaconsultarniño.setVisible(true);
             pantallaconsultarniño.IniciarVentana();
        }
        
    }//GEN-LAST:event_miConsultarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void jMSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSalirActionPerformed

    }//GEN-LAST:event_jMSalirActionPerformed

    private void jMSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMSalirMouseClicked
        Salir();
    }//GEN-LAST:event_jMSalirMouseClicked
 
    /*************************************************************************/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miActualizar;
    private javax.swing.JMenuItem miConsultar;
    private javax.swing.JMenuItem miEliminar;
    private javax.swing.JMenuItem miRegistrar;
    // End of variables declaration//GEN-END:variables
}
