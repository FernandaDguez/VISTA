
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernandadominguez
 */
public class LogPanel extends javax.swing.JPanel {
    
    Connection con;
    public String username;
    public String password;
    public enum UserStat {FailUser, AdminFailPass, RecepFailPass, RecepLogged, AdminLogged};
    public UserStat userStatus;
    /**
     * Creates new form LogPanel
     */
    public LogPanel() {
        initComponents();
        
        setBackground(Color.lightGray);
        userStatus = UserStat.AdminFailPass;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            Logger.getLogger(LogPanel.class.getName()).log(Level.SEVERE,null, e);
        }
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        jbLog = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Monaco", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VISTA");

        jLabel2.setText("Bienvenido a VISTA. Por favor inicie sesión para utilizar el software.");

        jLabel3.setText("Nombre de Usuario: ");

        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });
        tfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUsernameKeyPressed(evt);
            }
        });

        jLabel4.setText("Contraseña: ");

        pfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPasswordActionPerformed(evt);
            }
        });
        pfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfPasswordKeyPressed(evt);
            }
        });

        jbLog.setText("Iniciar Sesión");
        jbLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLogMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(236, 236, 236))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbLog)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUsername)
                                .addComponent(pfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbLog)
                .addContainerGap(192, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    /*************************************************************************/
    
    public void Log(){
        username = tfUsername.getText();
        password = new String(pfPassword.getPassword());
        
        /* Username entre 7 y 20 caracteres sin dos caracteres especiales seguidos
        y que no empiece o termine con ellos */
        if(!username.matches("^(?=.{7,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")){
            
           JOptionPane.showMessageDialog(this, "El nombre de usuario debe ser de al menos 7 "
                   + "caracteres alfanuméricos \ny puede incluir los caracteres especiales \"_\" o \".\".", 
                   "ERROR", JOptionPane.PLAIN_MESSAGE);
           tfUsername.setText("");
           pfPassword.setText("");
           
        //Mensaje para que no esté en blanco y validación para que no contenga espacios
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(this, "Por favor introduzca una contraseña.", 
                    "ERROR", JOptionPane.PLAIN_MESSAGE);
        }else if(!password.matches("[^\\s]")){
            JOptionPane.showMessageDialog(this, "La contraseña que ingresaste es incorrecta."
                    + "\nVuelve a intentarlo", "ERROR", JOptionPane.PLAIN_MESSAGE);
            pfPassword.setText("");
        }
        
        /* Consulta */
        
        try{
            con = DriverManager.getConnection("jdbc:mysql//localhost:8080/VISTA", "root", "");
            Statement s = con.createStatement();
            
            /* Para tratar de encontrar si coincide el usuario con uno en la BD */
            ResultSet UserSet = s.executeQuery("SELECT Usuario FROM Recepcionistas WHERE Usuario = '" + username + "';");
            userStatus = UserStat.RecepFailPass;
            if(!UserSet.first()){
                UserSet = s.executeQuery("SELECT Usuario FROM Administradores WHERE Usuario = '" + username + "';");
                userStatus = UserStat.AdminFailPass;
                if(!UserSet.first()){
                    userStatus = UserStat.FailUser;
                    WarningWindow();
                    return;
                } 
            }
            
            /* Para tratar de encontrar si coincide contraseña con la BD */
            String p;
            ResultSet passSet;
            if(userStatus == UserStat.RecepFailPass){
                passSet = s.executeQuery("SELECT Contrasena FROM Recepcionistas WHERE Usuario = '" + username + "';");
            }else
           
        }catch(SQLException e){
            Logger.getLogger(LogPanel.class.getName()).log(Level.SEVERE,null, e);
            JOptionPane.showMessageDialog(this, "Por favor intente de nuevo.", "ERROR", JOptionPane.PLAIN_MESSAGE);
        }
        
    }
    
    /*************************************************************************/
    
    public void WarningWindow()
    {
        if(userStatus == UserStat.AdminFailPass || userStatus == UserStat.RecepFailPass){
            JOptionPane.showMessageDialog(this, "La contraseña que ingresaste es incorrecta."
                    + "\nVuelve a intentarlo", "ERROR", JOptionPane.PLAIN_MESSAGE);
            pfPassword.setText("");
        }else if(userStatus == UserStat.FailUser){
            JOptionPane.showMessageDialog(this, "El nombre de usuario no coincide con ninguna cuenta."
                    + "\nContacte a su administrador", "ERROR", JOptionPane.PLAIN_MESSAGE);
            tfUsername.setText("");
            pfPassword.setText("");
        }
    }
    /*************************************************************************/
    
    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

    /*************************************************************************/
    
    private void pfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPasswordActionPerformed

            
    }//GEN-LAST:event_pfPasswordActionPerformed

    /*************************************************************************/
    
    private void jbLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLogMouseClicked
        Log();
    }//GEN-LAST:event_jbLogMouseClicked

    /*************************************************************************/
    
    private void pfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPasswordKeyPressed
        if(evt.getKeyCode() == 10)
            Log();
    }//GEN-LAST:event_pfPasswordKeyPressed

    private void tfUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsernameKeyPressed
        if(evt.getKeyCode() == 10)
            Log();
    }//GEN-LAST:event_tfUsernameKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbLog;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}