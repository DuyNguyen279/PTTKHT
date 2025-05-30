/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.doan.view;

import com.doan.dao.ReservedDAO;
import com.doan.dao.billiardTableDAO;
import com.doan.model.account;
import com.doan.model.billiard_table;
import com.doan.model.reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class BilliarTable extends javax.swing.JInternalFrame {

    /**
     * Creates new form BilliarTable
     */
    Timer golbalTimmer;

    account a;
    DefaultTableModel model;
    public BilliarTable(account acc) {
        initComponents();
        a =acc;
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        if (ui.getNorthPane() != null) {
            ui.setNorthPane(null);        // Ẩn thanh tiêu đề
        }

        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        String [] col={"Mã đặt trước", "Mã khách hàng", "Mã bàn", "Mã Nhân Viên" , "Đặt giờ", "Trạng thái"};
        model.setColumnIdentifiers(col);
        listReserved.setModel(model);
        loadData(new ReservedDAO().getInstance().selectAll());

        MainContent.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        ArrayList<billiard_table> listTAble = new billiardTableDAO().getInstance().selectAll();
        ArrayList<BilliarTableForm> list = new ArrayList<>();

        for (billiard_table x : listTAble) {
            if (!x.isIs_delete()) {
                BilliarTableForm billiarTableForm = new BilliarTableForm(acc);
                billiarTableForm.setTableId(x.getTab_id());
                billiarTableForm.setTableName(x.getTab_name());
                billiarTableForm.setTableType(x.getTab_type());
                billiarTableForm.setBackgroundColor(x.getStatus());
                billiarTableForm.setPreferredSize(new java.awt.Dimension(230, 230)); // Kích thước cố định
                MainContent.add(billiarTableForm);
            }
        }

        String colStatus[] = {"Tất Cả", "Trống", "Đang sử dụng", "Hỏng"};
        String colType[] = {"Tất Cả", "Thường", "VIP"};

        for (String x : colStatus) {
            fillterStatus.addItem(x);
        }
        for (String x : colType) {
            fillterType.addItem(x);
        }

        // Cập nhật giao diện
        MainContent.setPreferredSize(new java.awt.Dimension(1100, 847));
        MainContent.revalidate();
        MainContent.repaint();

        fillterStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillter();
            }
        });
        fillterType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillter();
            }
        });

        startGlobalReservationTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        ReservedDialog = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listReserved = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainContent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fillterType = new javax.swing.JComboBox<>();
        fillterStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        listReservedBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        ReservedDialog.setTitle("Danh Sách Đặt Trước Hôm Nay");
        ReservedDialog.setSize(new java.awt.Dimension(800, 500));

        listReserved.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(listReserved);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ReservedDialogLayout = new javax.swing.GroupLayout(ReservedDialog.getContentPane());
        ReservedDialog.getContentPane().setLayout(ReservedDialogLayout);
        ReservedDialogLayout.setHorizontalGroup(
            ReservedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ReservedDialogLayout.setVerticalGroup(
            ReservedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);

        MainContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MainContentLayout = new javax.swing.GroupLayout(MainContent);
        MainContent.setLayout(MainContentLayout);
        MainContentLayout.setHorizontalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        MainContentLayout.setVerticalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 847, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(MainContent);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 250, 154));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("     ");
        jLabel2.setToolTipText("");
        jLabel2.setEnabled(false);
        jLabel2.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Trống");

        jLabel3.setBackground(new java.awt.Color(100, 149, 237));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("     ");
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Đang Sử Dụng");

        fillterType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fillterType.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại Bàn"));
        fillterType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillterTypeActionPerformed(evt);
            }
        });

        fillterStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fillterStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng Thái"));
        fillterStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillterStatusActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Đặt trước");

        jLabel8.setBackground(new java.awt.Color(255, 215, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("     ");
        jLabel8.setOpaque(true);

        listReservedBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/doan/icon/invoice.png"))); // NOI18N
        listReservedBtn.setText("Danh Sách Đặt Trước");
        listReservedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listReservedBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listReservedBtn)
                .addGap(18, 18, 18)
                .addComponent(fillterType, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(fillterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(fillterType, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addComponent(fillterStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addComponent(listReservedBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void startGlobalReservationTimer(){
        golbalTimmer = new Timer(10000, e -> {
            for (BilliarTableForm form : BilliarTableForm.allForms) {
                
                form.updateReservationStatus();
            }
        });
        golbalTimmer.start();
    }
    private void fillterStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillterStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillterStatusActionPerformed

    private void fillterTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillterTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillterTypeActionPerformed

    private void listReservedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listReservedBtnActionPerformed
        // TODO add your handling code here:
        ReservedDialog.setLocationRelativeTo(null);
        ReservedDialog.setVisible(true);
    }//GEN-LAST:event_listReservedBtnActionPerformed

    // Tìm Kiếm Theo Bộ Lọc
    private void fillter() {
        MainContent.removeAll();
        ArrayList<billiard_table> listTAble = new billiardTableDAO().getInstance().selectAll();
        ArrayList<BilliarTableForm> list = new ArrayList<>();

        String key1 = fillterType.getSelectedItem().toString();
        String key2 = fillterStatus.getSelectedItem().toString();

        for (billiard_table x : listTAble) {
            if ((key1.equals(x.getTab_type()) || key1.equals("Tất Cả")) && (key2.equals(x.getStatus()) || key2.equals("Tất Cả"))) {
                BilliarTableForm billiarTableForm = new BilliarTableForm(a);
                billiarTableForm.setTableName(x.getTab_id());
                billiarTableForm.setTableType(x.getTab_type());
                billiarTableForm.setBackgroundColor(x.getStatus());
                billiarTableForm.setPreferredSize(new java.awt.Dimension(200, 200)); // Kích thước cố định
                MainContent.add(billiarTableForm);
            }
        }

        // Cập nhật giao diện
        MainContent.revalidate();
        MainContent.repaint();
    }

    public void loadData(List<reservation> list) {
        model.setRowCount(0);
        LocalDate today = java.time.LocalDate.now();
        for (reservation re : list) {
            if (re.getStart_time() != null && re.getStart_time().toLocalDate().equals(today)) {
                model.addRow(new Object[]{
                    re.getRes_id(),
                    re.getCus_id(),
                    re.getTab_id(),
                    re.getEmp_id(),
                    re.getStart_time().toString(),
                    re.getStatus()
                });
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainContent;
    private javax.swing.JDialog ReservedDialog;
    private javax.swing.JComboBox<String> fillterStatus;
    private javax.swing.JComboBox<String> fillterType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listReserved;
    private javax.swing.JButton listReservedBtn;
    // End of variables declaration//GEN-END:variables
}
