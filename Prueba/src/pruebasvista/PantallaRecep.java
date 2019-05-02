/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasvista;

/**
 *
 * @author pedrohdez
 */
public class PantallaRecep extends javax.swing.JFrame {

    /**
     * Creates new form PantallaRecep
     */
    PantallaRegistrarNiño pantallaregistrarniño; 
    PantallaConsultarNiño pantallaconsultarniño;
    public PantallaRecep() {
        initComponents();
        pantallaregistrarniño = new PantallaRegistrarNiño();
        pantallaconsultarniño = new PantallaConsultarNiño();
        
        add(pantallaregistrarniño);
        add(pantallaconsultarniño);
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
        miRegistrarNIño = new javax.swing.JMenuItem();
        miConsultarNiño = new javax.swing.JMenuItem();
        miActualizarNiño = new javax.swing.JMenuItem();
        miEliminarNiño = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miRegistrarTutor = new javax.swing.JMenuItem();
        miConsultarTutor = new javax.swing.JMenuItem();
        miActualizarTutor = new javax.swing.JMenuItem();
        miEliminarTutor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Niños");

        miRegistrarNIño.setText("Registrar");
        miRegistrarNIño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarNIñoActionPerformed(evt);
            }
        });
        jMenu2.add(miRegistrarNIño);

        miConsultarNiño.setText("Consultar");
        miConsultarNiño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultarNiñoActionPerformed(evt);
            }
        });
        jMenu2.add(miConsultarNiño);

        miActualizarNiño.setText("Actualizar");
        miActualizarNiño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miActualizarNiñoActionPerformed(evt);
            }
        });
        jMenu2.add(miActualizarNiño);

        miEliminarNiño.setText("Eliminar");
        jMenu2.add(miEliminarNiño);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tutores");

        miRegistrarTutor.setText("Registrar");
        jMenu3.add(miRegistrarTutor);

        miConsultarTutor.setText("Consultar");
        jMenu3.add(miConsultarTutor);

        miActualizarTutor.setText("Actualizar");
        jMenu3.add(miActualizarTutor);

        miEliminarTutor.setText("Eliminar");
        jMenu3.add(miEliminarTutor);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miRegistrarNIñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarNIñoActionPerformed
        pantallaconsultarniño.setVisible(false);
        pantallaregistrarniño.setVisible(true);
        pantallaregistrarniño.IniciarVentana();
        
        
    }//GEN-LAST:event_miRegistrarNIñoActionPerformed

    private void miConsultarNiñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultarNiñoActionPerformed
        pantallaregistrarniño.setVisible(false);
        pantallaconsultarniño.setVisible(false);
        pantallaconsultarniño.setVisible(true);
        pantallaconsultarniño.IniciarVentana();
    }//GEN-LAST:event_miConsultarNiñoActionPerformed

    private void miActualizarNiñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miActualizarNiñoActionPerformed
        pantallaregistrarniño.setVisible(false);
        pantallaconsultarniño.setVisible(false);
    }//GEN-LAST:event_miActualizarNiñoActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaRecep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRecep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRecep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRecep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRecep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miActualizarNiño;
    private javax.swing.JMenuItem miActualizarTutor;
    private javax.swing.JMenuItem miConsultarNiño;
    private javax.swing.JMenuItem miConsultarTutor;
    private javax.swing.JMenuItem miEliminarNiño;
    private javax.swing.JMenuItem miEliminarTutor;
    private javax.swing.JMenuItem miRegistrarNIño;
    private javax.swing.JMenuItem miRegistrarTutor;
    // End of variables declaration//GEN-END:variables
}
