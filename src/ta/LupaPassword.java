/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Heriyanto
 */
public class LupaPassword extends javax.swing.JFrame {
 public static Connection con;
    public static ResultSet res;
    public static Statement stm;
    /**
     * Creates new form LupaPassword
     */
    public LupaPassword() {
        initComponents();
       
        new LoginFrame().setVisible(false);
        Koneksimysql();
    }

   private boolean isUsernameExists(String username) {
    try {
       
        java.sql.Connection conn = con;

        String query = "SELECT * FROM admin WHERE Username = ?";
        java.sql.PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, username);
        java.sql.ResultSet resultSet = statement.executeQuery();

        return resultSet.next(); // Mengembalikan nilai true jika username sudah ada, false jika tidak ditemukan
    } catch (Exception e) {
        e.printStackTrace();
        return false; // Jika terjadi kesalahan, mengembalikan false
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        psw = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        button1 = new ta.Button();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1368, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 222, 179, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 370, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        psw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswActionPerformed(evt);
            }
        });
        jPanel1.add(psw, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 370, 30));

        jButton1.setBackground(new java.awt.Color(210, 180, 140));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 90, 40));

        button1.setBackground(new java.awt.Color(245, 222, 179, 80));
        button1.setBorder(null);
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Vector (3).png"))); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/registrasi-removebg-preview 1.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 450, 470));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/dashboard 2 (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
new LoginFrame().setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void pswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswActionPerformed
       
    }//GEN-LAST:event_pswActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
        if (!isUsernameExists(user.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Kode Harus Di isi");
        } else {
            Koneksimysql();
            stm.executeUpdate("UPDATE admin SET Password = '"+psw.getText()+"' WHERE Username = '"+user.getText()+"'"); // Tambahkan tanda kutip pada nilai string dalam kueri SQL
            JOptionPane.showMessageDialog(rootPane, "Username dan Password anda telah diubah");
       new LoginFrame().setVisible(true);   
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Gagal ubah data" + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line argument
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
            java.util.logging.Logger.getLogger(LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LupaPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ta.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField psw;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

//  public void tampildata() {
//    try {
//        if (res.next()) {
//            kode.setText(res.getString("KodeAdmin"));
//            user.setText(res.getString("Username"));
//            psw.setText(res.getString("Password"));
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Data tidak ditemukan");
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(rootPane, "Gagal menampilkan data");
//         e.printStackTrace();
//    }
//}


//   private void gantipsw() {
//    try {
//        if (!isUsernam) {
//            JOptionPane.showMessageDialog(rootPane, "Kode Harus Di isi");
//        } else {
//            stm.executeUpdate("UPDATE admin SET Password = '"+psw.getText()+"' WHERE Username = '"+user.getText()+"'"); // Tambahkan tanda kutip pada nilai string dalam kueri SQL
//            JOptionPane.showMessageDialog(rootPane, "Username dan Password anda telah diubah");
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(rootPane, "Gagal ubah data" + e.getMessage());
//    }
//}

    
//   private void form_data() {
//    try {
//       Koneksi koneksi =new Koneksi();
//       koneksi.koneksimysql();
//       stm = koneksi.con.createStatement();
//        res = stm.executeQuery("SELECT * FROM admin");
//        if (res.next()) {
//            tampildata();
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(rootPane, "Gagal tampilkan data" + e.getMessage());
//    }
//}


    private void Koneksimysql() {
      try{
        String url="jdbc:mysql://localhost/jajanan_buely";
        String user="root";
        String pass="";
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(url, user, pass);
        stm = (Statement) con.createStatement();
    }catch (Exception e){
        System.err.println("koneksi Gagal"+e.getMessage());
    }
    }
}
