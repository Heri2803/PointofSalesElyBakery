/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
/**
 *
 * @author Muhammad Heriyanto
 */
public class PopUpPelanggan extends javax.swing.JFrame {
    public static Connection con;
    public static ResultSet res;
    public static Statement stm;
    private Koneksi tb;
    private Pelanggan pelanggan;
    private String[] rowData;

    /**
     * Creates new form NewJFrame
     */
    public PopUpPelanggan(Pelanggan pelanggan,String[] rowData) {
//        Memilih row data yang akan di edit
         this.pelanggan=pelanggan;
         this.rowData = rowData;
        initComponents();
         koneksimysql();
            if (rowData != null) {
         String kode= rowData[0];
         String nama= rowData[1];
         String alamat= rowData[2];
         String hp= rowData[3];
         
         kp.setText(kode);
         np.setText(nama);
         almt.setText(alamat);
         tlp.setText(hp);
                
    } else {
        kp.setText("");
         np.setText("");
         almt.setText("");
         tlp.setText("");
    }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        np = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        almt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tlp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(210, 180, 140));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Kode Pelanggan");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nama Pelanggan");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Alamat");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Telp");

        jButton1.setBackground(new java.awt.Color(204, 133, 63));
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kp)
                            .addComponent(np)
                            .addComponent(almt)
                            .addComponent(tlp, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(kp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(np, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(almt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    tb = new Koneksi();
    tb.koneksimysql();
    java.sql.Connection con = tb.con;
java.sql.PreparedStatement stm=null;
          try {
    
    String sql = "SELECT * FROM pelanggan WHERE KodePelanggan = ?";
stm = con.prepareStatement(sql);
stm.setString(1, kp.getText());
ResultSet res = stm.executeQuery();


if (res != null && res.next()) {
    String count = res.getString(1);

    // Data sudah ada di database, lakukan operasi update
    String updateSql = "UPDATE pelanggan SET KodePelanggan = ?, NamaPelanggan = ?, Alamat = ?, Telp = ? WHERE KodePelanggan = ?";
    stm = con.prepareStatement(updateSql);
    stm.setString(1, kp.getText());
    stm.setString(2, np.getText());
    stm.setString(3, almt.getText());
    stm.setString(4, tlp.getText());
    stm.setString(5, kp.getText());

    int rowsUpdated = stm.executeUpdate();
    if (rowsUpdated > 0) {
        System.out.println("Data diupdate.");
    } else {
        System.out.println("Gagal melakukan update data.");
    }

    stm.close();
} else {
    // Data belum ada di database, lakukan operasi insert
    String insertSql = "INSERT INTO pelanggan (  KodePelanggan, NamaPelanggan, Alamat, Telp) VALUES (?, ?, ?, ?)";
    stm = con.prepareStatement(insertSql);
    stm.setString(1, kp.getText());
    stm.setString(2, np.getText());
    stm.setString(3, almt.getText());
    stm.setString(4, tlp.getText());
    
   

    int rowsInserted = stm.executeUpdate();
    if (rowsInserted > 0) {
        System.out.println("Data diinsert.");
    } else {
        System.out.println("Gagal melakukan insert data.");
    }

    stm.close();
} 
    System.out.println(kp.getText());
    System.out.println(np.getText());
    System.out.println(almt.getText());
    System.out.println(tlp.getText());


    pelanggan.tampiltabel();
    setVisible(false);
    
       
    
} catch (Exception e) {
    e.printStackTrace(); // Ubah ini menjadi tindakan yang lebih spesifik jika diperlukan
}
    
   
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PopUpPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PopUpPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PopUpPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PopUpPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PopUpPelanggan().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField almt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField kp;
    private javax.swing.JTextField np;
    private javax.swing.JTextField tlp;
    // End of variables declaration//GEN-END:variables

    private void koneksimysql() {
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
