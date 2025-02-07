package Interface;

import Executor.ItemEx;
import Executor.SalesEx;
import Object.ItemObj;
import Object.SalesObj;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Rahat
 * sales update and list form
 */
public class SalesRegister extends javax.swing.JInternalFrame {

    /** Creates new form SalesRegister */
    public SalesRegister() {
        initComponents();
       
      // Get item name in comobox  
      ItemEx blItem = new ItemEx();
      try {          
           ArrayList<ItemObj> itmName = blItem.getItemList();
           for(int i=0; i<itmName.size(); ++i )           
           {     
             cmbItemName.addItem(itmName.get(i).getitemName());             
           }
      }catch(Exception e){
          JOptionPane.showMessageDialog(this, "No Item Name.\n" + e);
      }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSaleCustomerName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSaleCustomerAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSalesDate = new com.toedter.calendar.JDateChooser();
        txtBillNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSalesRate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSalesQuantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbItemName = new javax.swing.JComboBox();
        btnSalesRegister = new javax.swing.JButton();
        btnSalesReset = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sales Register Form");
        setPreferredSize(new java.awt.Dimension(815, 635));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Register New Sales Record");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Customer Name : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Customer Address : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Sales Date : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Bill No : ");

        txtSalesDate.setDateFormatString("yyyy-MM-dd");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Sales Rate : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Sales Quantity : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Item Name : ");

        btnSalesRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalesRegister.setText("Register ");
        btnSalesRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesRegisterActionPerformed(evt);
            }
        });

        btnSalesReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalesReset.setText("Reset");
        btnSalesReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesResetActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Sales.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSaleCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaleCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalesDate, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBillNo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalesRate, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalesQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalesRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalesReset, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(jLabel1)))
                .addContainerGap(394, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSaleCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaleCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtBillNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtSalesDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSalesRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalesQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalesRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalesReset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalesRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesRegisterActionPerformed
// TODO add your handling code here:
    try{
       String errorMsg = "";
        if("".equals(txtSaleCustomerName.getText())){
          errorMsg +=  "Customer Name cannot be empty \n";
        }
        if("".equals(txtBillNo.getText())){
          errorMsg +=  "Bill No. cannot be empty \n";
        }
        if("".equals(txtSalesRate.getText())){
          errorMsg += "Sales Rate cannot be empty \n";
        }
        if("".equals(txtSalesQuantity.getText())){
          errorMsg += "Sales Quantity cannot be empty \n";
        }
        
        else{
            Validation v = new Validation();
            
            if (!v.checkValidation("text", txtSaleCustomerName.getText()))
                errorMsg += "Customer Name supports only Character \n";   
            
            if(!v.checkValidation("number", txtBillNo.getText()))
                errorMsg += "Bill No. supports only number \n";
            
            if(!v.checkValidation("number", txtSalesRate.getText()))
                errorMsg += "Sale Rate supports only number \n";            
            
            if(!v.checkValidation("number", txtSalesQuantity.getText()))
                errorMsg += "Sale Quantity supports only number \n";            
        }
      if(errorMsg.isEmpty()){ 
                
        sales = new SalesObj();
        sales.setsalesId(0);
        sales.setsalesCustomerName(txtSaleCustomerName.getText());
        sales.setsalesCustomerAddress(txtSaleCustomerAddress.getText());

        Date sd = txtSalesDate.getDate();
        SimpleDateFormat saleDate =new SimpleDateFormat("yyyy-MM-dd");
        sales.setsalesDate(saleDate.format(sd).toString());
        
        sales.setsalesBillNo(Integer.parseInt(txtBillNo.getText()));
        sales.setsalesRate(Integer.parseInt(txtSalesRate.getText()));
        sales.setsalesQuantity(Integer.parseInt(txtSalesQuantity.getText()));
        sales.setitemName(cmbItemName.getSelectedItem().toString());        

        blSales = new SalesEx(sales);
        if(blSales.insertSales()){
          JOptionPane.showMessageDialog(this, "Sales Created Successfully", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
        }else{
          JOptionPane.showMessageDialog(this, "Unable to add Sales", "Error Occured", JOptionPane.ERROR_MESSAGE);
        }
      }else{
          JOptionPane.showMessageDialog(this, errorMsg, "Error Occured", JOptionPane.ERROR_MESSAGE);
      }
    }catch(Exception ex){
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnSalesRegisterActionPerformed

private void btnSalesResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesResetActionPerformed
// TODO add your handling code here:\
        txtSaleCustomerName.setText("");
        txtSaleCustomerAddress.setText("");
        txtSalesDate.setDate(null);
        txtBillNo.setText("");
        txtSalesRate.setText("");
        txtSalesQuantity.setText(""); 
        cmbItemName.setSelectedIndex(0);
}//GEN-LAST:event_btnSalesResetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalesRegister;
    private javax.swing.JButton btnSalesReset;
    private javax.swing.JComboBox cmbItemName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBillNo;
    private javax.swing.JTextField txtSaleCustomerAddress;
    private javax.swing.JTextField txtSaleCustomerName;
    private com.toedter.calendar.JDateChooser txtSalesDate;
    private javax.swing.JTextField txtSalesQuantity;
    private javax.swing.JTextField txtSalesRate;
    // End of variables declaration//GEN-END:variables
    private SalesEx blSales;
    private SalesObj sales;
}
