/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ta;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Muhammad Heriyanto
 */
public class InputPemesanan extends javax.swing.JFrame {
    
    public static Connection con;
    public static ResultSet res;
    public static Statement stm;
    private Koneksi tb;
    private RincianPemesanan RincianPemesanan;
    private String[] rowData;
    
    

    /** Creates new form InputPemesanan */
    public InputPemesanan(RincianPemesanan RincianPemesanan,String[] rowData) {
        this.RincianPemesanan = RincianPemesanan;
        this.rowData = rowData;
        initComponents();
        koneksimysql();
        nampilpelanggan();
        nampiladmin();
        if (rowData != null) {
         String KodeTransaksi = rowData[0];
         String TglTransaksi = rowData[1];
         String TglPemesana = rowData[2];
         String TglPengambila = rowData[3];
         String MetodePembayaran= rowData[4];
         String Total= rowData[5];
         String Bayar= rowData[6];
         String Sisa= rowData[7];
         String StatusPembayaran= rowData[8];
         String KodePelanggan= rowData[9];
         String KodeAdmin= rowData[10];
         
         kt.setText(KodeTransaksi);
         mp.setSelectedItem(MetodePembayaran);
         totalbayar.setText(Total);
         nb.setText(Bayar);
         sb.setText(Sisa);
         sp.setSelectedItem(StatusPembayaran);
         cmbplg.setSelectedItem(KodePelanggan);
         cmbadm.setSelectedItem(KodeAdmin);
         
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date tanggal;
                try {
                tanggal = dateFormat.parse(TglTransaksi);
                tgltrk.setDate(tanggal);
            } catch (Exception e) {
            }
                try {
                tanggal = dateFormat.parse(TglPemesana);
                tgltrk1.setDate(tanggal);
            } catch (Exception e) {
            }
                try {
                tanggal = dateFormat.parse(TglPengambila);
                tglpgm.setDate(tanggal);
            } catch (Exception e) {
            }
                java.sql.PreparedStatement pst=null;
                DefaultTableModel tb1 = new DefaultTableModel();
        //judul kolom
        tb1.addColumn("Kode Trasaksi");
        tb1.addColumn("Kode Produk");
        tb1.addColumn("Produk Order");
        tb1.addColumn("Harga Satuan");
        tb1.addColumn("Jumlah Order");
        tb1.addColumn("TotalDetailOrder");
        detailtable.setModel(tb1);
                try {
                String tampildetail =  "SELECT * FROM detail_transaksi WHERE KodeTransaksi = ?";
                pst = con.prepareStatement(tampildetail);
            pst.setString(1, KodeTransaksi); 
            ResultSet res = pst.executeQuery();
                    while (res.next()){
                tb1.addRow(new Object[]{
                    res.getString("KodeTransaksi"),
                    res.getString("KodeProduk"),
                    res.getString("ProdukOrder"),
                    res.getString("Harga_Satuan"),
                    res.getString("JumlahOrder"),
                    res.getString("TotalDetailOrder"),
                });
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
    } 
//        else {
//        kt.setText("");
//         tgltrk.setDateFormatString("");
//         tgltrk1.setDateFormatString("");
//         tglpgm.setDateFormatString("");
//         mp.setSelectedItem("");
//         totalbayar.setText("");
//         nb.setText("");
//         sb.setText("");
//         sp.setSelectedItem("");
//         cmbplg.setSelectedItem("");
//         cmbadm.setSelectedItem("");
//    }
    
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
    

    public void totalbayar(){
        DefaultTableModel model = (DefaultTableModel) detailtable.getModel();
        int total = 0;
        for (int row = 0; row <model.getRowCount(); row++) {
            String rowTotalString = model.getValueAt(row, 5).toString();
            
            if (!rowTotalString.isEmpty()) {
                int rowtotal = Integer.parseInt(rowTotalString);
                total += rowtotal;
            }
        }
        
        
        totalbayar.setText(Integer.toString(total));
    }
    
    public void nampilpelanggan(){
        try {
            String sql = "SELECT * FROM pelanggan";
            res = stm.executeQuery(sql);
            
            while (res.next()) {
                cmbplg.addItem(res.getString("KodePelanggan")+"-"+res.getString("NamaPelanggan")+"-"+res.getString("Telp"));
            }
            res.last();
            res.first();
        } catch (Exception e) {
        }
    }
    
    
    public void nampiladmin(){
        try {
             String sql = "SELECT * FROM admin";
            res = stm.executeQuery(sql);
            
            while (res.next()) {
                cmbadm.addItem(res.getString("KodeAdmin")+"-"+res.getString("NamaAdmin"));
            }
            res.last();
            res.first();
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button1 = new ta.Button();
        button2 = new ta.Button();
        button3 = new ta.Button();
        button4 = new ta.Button();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailtable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        po = new javax.swing.JTextField();
        hs = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        kt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tgltrk = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tglpgm = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        sp = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        totalbayar = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        nb = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        sb = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tgltrk1 = new com.toedter.calendar.JDateChooser();
        cmbplg = new javax.swing.JComboBox<>();
        cmbadm = new javax.swing.JComboBox<>();
        mp = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        button5 = new ta.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(210, 180, 140));

        button1.setBackground(new java.awt.Color(210, 180, 140));
        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Vector (1).png"))); // NOI18N
        button1.setText("Home");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(210, 180, 140));
        button2.setForeground(new java.awt.Color(0, 0, 0));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/ph_bag-bold (1).png"))); // NOI18N
        button2.setText("Produk");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(210, 180, 140));
        button3.setForeground(new java.awt.Color(0, 0, 0));
        button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/carbon_white-paper.png"))); // NOI18N
        button3.setText("Laporan");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(210, 180, 140));
        button4.setForeground(new java.awt.Color(0, 0, 0));
        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/bx_log-out (1).png"))); // NOI18N
        button4.setText("Log Out");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 130, 768);

        jPanel2.setBackground(new java.awt.Color(245, 222, 179));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Input Pemesanan");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 50, -1, -1));

        detailtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Transaksi", "Kode Produk", "Produk Order", "Harga Satuan", "Jumlah Order", "Total Detail Order"
            }
        ));
        jScrollPane1.setViewportView(detailtable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1240, 250));

        jPanel4.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Kode Produk");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Jumlah Order");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Harga Satuan");

        jo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Produk Order");

        kp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kpActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(205, 133, 63));
        jButton1.setText("TAMBAH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        po.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(po))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kp, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hs, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jo))
                .addGap(758, 758, 758))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(kp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(po, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1240, 150));

        jPanel5.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Kode Transaksi");

        kt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ktActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Tanggal Transaksi");

        tgltrk.setDateFormatString("yyyy-MM-dd");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Tanggal Pemesanan");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Tanggal Pengambilan");

        tglpgm.setDateFormatString("yyyy-MM-dd");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Status Pembayaran");

        sp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DP", "LUNAS" }));
        sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Total Bayar");

        totalbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalbayarActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Nominal Bayar");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Sisa Bayar");

        jButton2.setBackground(new java.awt.Color(205, 133, 63));
        jButton2.setText("SIMPAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 133, 63));
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tgltrk1.setDateFormatString("yyyy-MM-dd");

        cmbplg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbplgActionPerformed(evt);
            }
        });

        cmbadm.setToolTipText("");
        cmbadm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbadmActionPerformed(evt);
            }
        });

        mp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TUNAI", "NON TUNAI" }));
        mp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpActionPerformed(evt);
            }
        });

        jButton4.setText("Simpan dan Cetak");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cetak");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(kt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addComponent(tgltrk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tgltrk1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tglpgm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalbayar)
                    .addComponent(nb)
                    .addComponent(sb)
                    .addComponent(sp, 0, 100, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(mp, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbplg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbadm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(kt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(totalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbadm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tgltrk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(tgltrk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tglpgm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(nb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel19)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(sb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(47, 47, 47))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 560, 1240, 210));

        button5.setBackground(new java.awt.Color(204, 133, 63));
        button5.setForeground(new java.awt.Color(0, 0, 0));
        button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/mdi_user.png"))); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        jPanel2.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 50, 50, 50));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(130, 0, 1240, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         DefaultTableModel model = (DefaultTableModel) detailtable.getModel();
         int jumlahorder = Integer.parseInt(jo.getText());
         int hargasatuan = Integer.parseInt(hs.getText());
         int total = hargasatuan * jumlahorder;
         Object[] row = {kt.getText(),kp.getText(),po.getText(),hs.getText(),jo.getText(),total};
         model.addRow(row);
    
         totalbayar();
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void joActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joActionPerformed

    private void kpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kpActionPerformed
        try {
            String cr= kp.getText();
            String cariproduk = "CALL cari_produk ('"+cr+"');";
            res = stm.executeQuery(cariproduk);
            if(res.next()){
                String kodeproduk = res.getString("KodeProduk");
                String namaproduk = res.getString("NamaProduk");
                String hargasatuan = res.getString("HargaSatuan");
                kp.setText(kodeproduk);
                po.setText(namaproduk);
                hs.setText(hargasatuan);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_kpActionPerformed

    private void ktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ktActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ktActionPerformed

    private void poActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poActionPerformed
         try {
            String cr= po.getText();
            String cariproduk = "CALL cari_produk ('"+cr+"');";
            res = stm.executeQuery(cariproduk);
            if(res.next()){
                String kodeproduk = res.getString("KodeProduk");
                String namaproduk = res.getString("NamaProduk");
                String hargasatuan = res.getString("HargaSatuan");
                kp.setText(kodeproduk);
                po.setText(namaproduk);
                hs.setText(hargasatuan);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_poActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
        DefaultTableModel model = (DefaultTableModel) detailtable.getModel();
            java.sql.PreparedStatement pst=null;
            int row = detailtable.getSelectedRow();
      String Kodetransaksi = detailtable.getValueAt(row, 0).toString();
            String sql = "select * from transaksi where KodeTransaksi = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, Kodetransaksi);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
      
                String sql1 = "delete from detail_transaksi where KodeTransaksi ='"+Kodetransaksi+"'";
          stm = con.createStatement();
          stm.execute(sql1);
          
           JOptionPane.showMessageDialog(null,"terhapus");
           
           stm.close();
     model.removeRow(row);
             totalbayar();

            } else {
        
        model.removeRow(row);
        totalbayar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       DefaultTableModel model = (DefaultTableModel) detailtable.getModel();
       int rowCount = model.getRowCount();
        System.out.println(rowCount);
        
        java.sql.PreparedStatement pst=null;
        
        String kodetransaksi = kt.getText();
        Date tanggaltransaksi = tgltrk.getDate();
        Date tanggalpemesanan = tgltrk1.getDate();
        Date tanggalpengambilan = tglpgm.getDate();
        String statuspembayaran = (String)sp.getSelectedItem(); 
        String tbayar = totalbayar.getText();
        String nominalbayar = nb.getText();
        String sisabayar = sb.getText();
        String metodepembayaran = (String)mp.getSelectedItem();
        String kodepelanggan = (String)cmbplg.getSelectedItem();
        String kodeadmin = (String)cmbadm.getSelectedItem();
       SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd");
       String t= d.format(tanggaltransaksi);
       String g= d.format(tanggalpemesanan);
       String z= d.format(tanggalpengambilan);
       String[]parts = kodepelanggan.split("-");
       String[]parts1 = kodeadmin.split("-");
       String peid = parts[0].trim();
       String peid2 = parts1[0].trim();
      
    
       System.out.println("tgltrk: " + t);
System.out.println("tglpms: " + g);
System.out.println("tglpgm: " + z);
        System.out.println(kodetransaksi);
        System.out.println(statuspembayaran);
        System.out.println(tb);
        System.out.println(nominalbayar);
        System.out.println(sisabayar);
        System.out.println(metodepembayaran);
        System.out.println(kodepelanggan);
        System.out.println(kodeadmin);
        
        try {
            String sql = "select * from transaksi where KodeTransaksi = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, kodetransaksi);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                String inputtransaksi1 = "UPDATE`transaksi` set  `TglTransaksi`= ?, `TglPemesanan`= ?, `TglPengambilan`= ?, `MetodePembayaran`= ?, `Total`= ?, `Bayar`= ?, `Sisa`= ?, `StatusPembayaran`= ?, `KodePelanggan`= ?, `KodeAdmin`= ? WHERE KodeTransaksi = ? ";
            pst = con.prepareStatement(inputtransaksi1);
            pst.setString(1,t);
            pst.setString(2,g);
            pst.setString(3,z);
            pst.setString(4,metodepembayaran);
            pst.setString(5,tbayar);
            pst.setString(6,nominalbayar);
            pst.setString(7,sisabayar);
            pst.setString(8,statuspembayaran);
            pst.setString(9,peid);
            pst.setString(10,peid2);
            pst.setString(11,kodetransaksi);
            
            pst.executeUpdate();
            System.out.println("Data Transaksi Terupdate");
            
            for (int i = 0; i < rowCount; i++) {
                String id = (String) model.getValueAt(i, 0);
                String kode = (String) model.getValueAt(i, 1);
                String prdordr = (String) model.getValueAt(i, 2);
                String hrgstn = (String) model.getValueAt(i, 3);
                String jmlhordr = (String) model.getValueAt(i, 4);
                String total = (String) model.getValueAt(i, 5).toString();
                
                String inputdetail = "UPDATE `detail_transaksi` SET  `ProdukOrder`= ?, `Harga_Satuan`= ?, `JumlahOrder`= ?, `TotalDetailOrder`= ? WHERE KodeTransaksi = ? and KodeProduk = ?";
                pst = con.prepareStatement(inputdetail);
                pst.setString(1, prdordr);
                pst.setString(2, hrgstn);
                pst.setString(3, jmlhordr);
                pst.setString(4, total);
                pst.setString(5, id);
                pst.setString(6, kode);
                System.out.println("terupdate");
                
                
                
                pst.executeUpdate();
                System.out.println("Data Berhasil Diupdate");
                
            }
            }else {
                
            String inputtransaksi = "INSERT INTO `transaksi` (`KodeTransaksi`, `TglTransaksi`, `TglPemesanan`, `TglPengambilan`, `MetodePembayaran`, `Total`, `Bayar`, `Sisa`, `StatusPembayaran`, `KodePelanggan`, `KodeAdmin`) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
            pst = con.prepareStatement(inputtransaksi);
            pst.setString(1,kodetransaksi);
            pst.setString(2,t);
            pst.setString(3,g);
            pst.setString(4,z);
            pst.setString(5,metodepembayaran);
            pst.setString(6,tbayar);
            pst.setString(7,nominalbayar);
            pst.setString(8,sisabayar);
            pst.setString(9,statuspembayaran);
            pst.setString(10,peid);
            pst.setString(11,peid2);
            
            pst.executeUpdate();
            System.out.println("Data Transaksi Tersimpan");
            
            for (int i = 0; i < rowCount; i++) {
                String id = (String) model.getValueAt(i, 0);
                String kode = (String) model.getValueAt(i, 1);
                String prdordr = (String) model.getValueAt(i, 2);
                String hrgstn = (String) model.getValueAt(i, 3);
                String jmlhordr = (String) model.getValueAt(i, 4);
                String total = (String) model.getValueAt(i, 5).toString();
                
                String inputdetail = "INSERT INTO `detail_transaksi` (`KodeTransaksi`, `KodeProduk`, `ProdukOrder`, `Harga_Satuan`, `JumlahOrder`, `TotalDetailOrder`) VALUES (?, ?, ?, ?, ?, ?);";
                pst = con.prepareStatement(inputdetail);
                pst.setString(1, id);
                pst.setString(2, kode);
                pst.setString(3, prdordr);
                pst.setString(4, hrgstn);
                pst.setString(5, jmlhordr);
                pst.setString(6, total);
                System.out.println("terkirim");
                
                
                
                pst.executeUpdate();
                System.out.println("Data Berhasil Disimpan");
            }
            
                
            }
        
                RincianPemesanan p = new RincianPemesanan();
        p.setVisible(true);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(pst !=null){
                try {
                    pst.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbplgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbplgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbplgActionPerformed

    private void cmbadmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbadmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbadmActionPerformed

    private void spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spActionPerformed

    private void mpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mpActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         DefaultTableModel model = (DefaultTableModel) detailtable.getModel();
       int rowCount = model.getRowCount();
        System.out.println(rowCount);
        
        java.sql.PreparedStatement pst=null;
        
        String kodetransaksi = kt.getText();
        Date tanggaltransaksi = tgltrk.getDate();
        Date tanggalpemesanan = tgltrk1.getDate();
        Date tanggalpengambilan = tglpgm.getDate();
        String statuspembayaran = (String)sp.getSelectedItem();
        String tbayar = totalbayar.getText();
        String nominalbayar = nb.getText();
        String sisabayar = sb.getText();
        String metodepembayaran = (String)mp.getSelectedItem();
        String kodepelanggan = (String)cmbplg.getSelectedItem();
        String kodeadmin = (String)cmbadm.getSelectedItem();
       SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd");
       String t= d.format(tanggaltransaksi);
       String g= d.format(tanggalpemesanan);
       String z= d.format(tanggalpengambilan);
       String[]parts = kodepelanggan.split("-");
       String[]parts1 = kodeadmin.split("-");
       String peid = parts[0].trim();
       String peid2 = parts1[0].trim();
      
    
       System.out.println("tgltrk: " + t);
System.out.println("tglpms: " + g);
System.out.println("tglpgm: " + z);
        System.out.println(kodetransaksi);
        System.out.println(statuspembayaran);
        System.out.println(tb);
        System.out.println(nominalbayar);
        System.out.println(sisabayar);
        System.out.println(metodepembayaran);
        System.out.println(kodepelanggan);
        System.out.println(kodeadmin);
        
        try {
            String sql = "select * from transaksi where KodeTransaksi = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, kodetransaksi);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                String inputtransaksi1 = "UPDATE`transaksi` set  `TglTransaksi`= ?, `TglPemesanan`= ?, `TglPengambilan`= ?, `MetodePembayaran`= ?, `Total`= ?, `Bayar`= ?, `Sisa`= ?, `StatusPembayaran`= ?, `KodePelanggan`= ?, `KodeAdmin`= ? WHERE KodeTransaksi = ? ";
            pst = con.prepareStatement(inputtransaksi1);
            pst.setString(1,t);
            pst.setString(2,g);
            pst.setString(3,z);
            pst.setString(4,metodepembayaran);
            pst.setString(5,tbayar);
            pst.setString(6,nominalbayar);
            pst.setString(7,sisabayar);
            pst.setString(8,statuspembayaran);
            pst.setString(9,peid);
            pst.setString(10,peid2);
            pst.setString(11,kodetransaksi);
            
            pst.executeUpdate();
            System.out.println("Data Transaksi Terupdate");
            
            for (int i = 0; i < rowCount; i++) {
                String id = (String) model.getValueAt(i, 0);
                String kode = (String) model.getValueAt(i, 1);
                String prdordr = (String) model.getValueAt(i, 2);
                String hrgstn = (String) model.getValueAt(i, 3);
                String jmlhordr = (String) model.getValueAt(i, 4);
                String total = (String) model.getValueAt(i, 5).toString();
                
                String inputdetail = "UPDATE `detail_transaksi` SET  `ProdukOrder`= ?, `Harga_Satuan`= ?, `JumlahOrder`= ?, `TotalDetailOrder`= ? WHERE KodeTransaksi = ? and KodeProduk = ?";
                pst = con.prepareStatement(inputdetail);
                pst.setString(1, prdordr);
                pst.setString(2, hrgstn);
                pst.setString(3, jmlhordr);
                pst.setString(4, total);
                pst.setString(5, id);
                pst.setString(6, kode);
                System.out.println("terupdate");
                
                
                
                pst.executeUpdate();
                System.out.println("Data Berhasil Diupdate");
                
            }
            }else {
                
            String inputtransaksi = "INSERT INTO `transaksi` (`KodeTransaksi`, `TglTransaksi`, `TglPemesanan`, `TglPengambilan`, `MetodePembayaran`, `Total`, `Bayar`, `Sisa`, `StatusPembayaran`, `KodePelanggan`, `KodeAdmin`) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
            pst = con.prepareStatement(inputtransaksi);
            pst.setString(1,kodetransaksi);
            pst.setString(2,t);
            pst.setString(3,g);
            pst.setString(4,z);
            pst.setString(5,metodepembayaran);
            pst.setString(6,tbayar);
            pst.setString(7,nominalbayar);
            pst.setString(8,sisabayar);
            pst.setString(9,statuspembayaran);
            pst.setString(10,peid);
            pst.setString(11,peid2);
            
            pst.executeUpdate();
            System.out.println("Data Transaksi Tersimpan");
            
            for (int i = 0; i < rowCount; i++) {
                String id = (String) model.getValueAt(i, 0);
                String kode = (String) model.getValueAt(i, 1);
                String prdordr = (String) model.getValueAt(i, 2);
                String hrgstn = (String) model.getValueAt(i, 3);
                String jmlhordr = (String) model.getValueAt(i, 4);
                String total = (String) model.getValueAt(i, 5).toString();
                
                String inputdetail = "INSERT INTO `detail_transaksi` (`KodeTransaksi`, `KodeProduk`, `ProdukOrder`, `Harga_Satuan`, `JumlahOrder`, `TotalDetailOrder`) VALUES (?, ?, ?, ?, ?, ?);";
                pst = con.prepareStatement(inputdetail);
                pst.setString(1, id);
                pst.setString(2, kode);
                pst.setString(3, prdordr);
                pst.setString(4, hrgstn);
                pst.setString(5, jmlhordr);
                pst.setString(6, total);
                System.out.println("terkirim");
                
                
                
                pst.executeUpdate();
                System.out.println("Data Berhasil Disimpan");
            }
            
                
            }
        
                RincianPemesanan p = new RincianPemesanan();
        p.setVisible(true);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(pst !=null){
                try {
                    pst.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        cetak();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       cetak();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
       new Dashboard().setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
      new DetailProduk().setVisible(true);
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
       new Laporan().setVisible(true);
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
       new LoginFrame().setVisible(true);
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
     new Admin().setVisible(true);
    }//GEN-LAST:event_button5ActionPerformed

    private void totalbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalbayarActionPerformed

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
//            java.util.logging.Logger.getLogger(InputPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InputPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InputPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InputPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InputPemesanan(RincianPemesanan, rowData);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ta.Button button1;
    private ta.Button button2;
    private ta.Button button3;
    private ta.Button button4;
    private ta.Button button5;
    private javax.swing.JComboBox<String> cmbadm;
    private javax.swing.JComboBox<String> cmbplg;
    private javax.swing.JTable detailtable;
    private javax.swing.JTextField hs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jo;
    private javax.swing.JTextField kp;
    private javax.swing.JTextField kt;
    private javax.swing.JComboBox<String> mp;
    private javax.swing.JTextField nb;
    private javax.swing.JTextField po;
    private javax.swing.JTextField sb;
    private javax.swing.JComboBox<String> sp;
    private com.toedter.calendar.JDateChooser tglpgm;
    private com.toedter.calendar.JDateChooser tgltrk;
    private com.toedter.calendar.JDateChooser tgltrk1;
    private javax.swing.JTextField totalbayar;
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
public void cetak(){
          String idtran = kt.getText();


try {
    
    InputStream inputStream = getClass().getResourceAsStream("/Jasper/report1.jrxml");
JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

    // Buat objek parameter
        Map<String, Object> parameters = new HashMap<>();
    parameters.put("KodeTransaksi(transaksi)", idtran);


Koneksi koneksi = new Koneksi();
            koneksi.koneksimysql();
    // Isi laporan dengan data menggunakan parameter
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, koneksi.con);

    // Tampilkan laporan di JasperViewer
    JasperViewer.viewReport(jasperPrint, false);
} catch (JRException e) {
    e.printStackTrace();
}

}
    }


