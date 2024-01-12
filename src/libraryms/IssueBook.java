/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package libraryms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    //Fetch the data from database and show the Details in Book Details Panel
    public void getBookDetails()
    {
        int bookId=Integer.parseInt(txt_bookId.getText());
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from book_detail where book_id = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next())
            {
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            }else{
                lbl_bookError.setText("Invalid Book Id");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void getStudentDetails()
    {
        int studentId=Integer.parseInt(txt_studentId.getText());
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from student_details where student_id = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,studentId);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next())
            {
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));  
            }
             else{
                  lbl_studentError.setText("Invalid Student Id");
                    
                }
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //insert issue book Details to Database
    public boolean issueBook()
    {
        boolean isIssued=false;
        int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
        String bookName=lbl_bookName.getText();
        String studentName=lbl_studentName.getText();
        
        java.util.Date uIssueDate = date_issueDate.getDatoFecha();
        java.util.Date uDueDate = date_dueDate.getDatoFecha();
        
        Long l1=uIssueDate.getTime();
        Long l2=uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,bookName);
            pst.setInt(3, studentId);
            pst.setString(4,studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6,sDueDate);
            pst.setString(7,"Pending");
            int rowCount=pst.executeUpdate();

            if(rowCount>0)
            {
                isIssued=true;
            }
            else{
                isIssued=false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return isIssued;
    }
    
    //update book Count
    public void updateBookCount()
    {
        int bookId=Integer.parseInt(txt_bookId.getText());
        try{
            Connection con=DBConnection.getConnection();
            String sql="update book_detail set quantity = quantity -1 where book_id = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            int rowCount=pst.executeUpdate();
            if(rowCount>0)
            {
                JOptionPane.showMessageDialog(this, "book count updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount -1));
            }
            else{
                JOptionPane.showMessageDialog(this, "can not update book count");
            }
            
            }
            catch(Exception e)
                { 
                e.printStackTrace();
                }
    }
    // Check Book is already Alocated or not
    public boolean isAlreadyIssued()
    {
        boolean isAlreadyIssue = false;
        int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
         try{
            Connection con=DBConnection.getConnection();
            String sql="select * from issue_book_details where book_id = ? and student_id = ? and status = ? ";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setInt(2, studentId);
            pst.setString(3,"pending");
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                isAlreadyIssue=true;
            }else{
                isAlreadyIssue=false;
                        
            }
         }  
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return isAlreadyIssue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel8.setText("Back");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 310, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Id :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Author :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 90, -1));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 150, 30));

        lbl_bookId.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 150, 30));

        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 150, 30));

        lbl_author.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 150, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel11.setText("  Book Details");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 250, 90));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 90, -1));

        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(204, 204, 0));
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 260, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 640));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 320, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student Id :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 110, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Student Name :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 140, -1));

        lbl_studentName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jPanel2.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 150, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Course :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 90, -1));

        lbl_branch.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jPanel2.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 150, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Branch :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 110, -1));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 150, 30));

        lbl_studentId.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jPanel2.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 150, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel21.setText("  Student Details");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 300, 90));

        lbl_studentError.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(204, 204, 0));
        jPanel2.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 260, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 360, 640));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("  X");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 70, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1.setText("  Student Details");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 270, -1));

        jPanel7.setBackground(new java.awt.Color(255, 102, 51));
        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 340, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 0));
        jLabel22.setText("Due Date");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 100, 30));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 102, 51)));
        txt_studentId.setPlaceholder("Enter Book id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel6.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 200, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 0));
        jLabel23.setText("Book Id");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 100, 30));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 102, 51)));
        txt_bookId.setPlaceholder("Enter Book id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel6.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 200, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 0));
        jLabel24.setText("Student Id");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 100, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 51, 0));
        jLabel25.setText("Issue Date");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 100, 30));

        date_dueDate.setColorBackground(new java.awt.Color(255, 51, 0));
        date_dueDate.setPlaceholder("Select Due Date");
        jPanel6.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, -1));

        date_issueDate.setColorBackground(new java.awt.Color(255, 51, 0));
        date_issueDate.setPlaceholder("Select Issue Date");
        jPanel6.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle1.setText("Issue Book");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 230, 70));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 450, 640));

        setSize(new java.awt.Dimension(1169, 645));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        System.exit(0); 
    }//GEN-LAST:event_jLabel20MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        
        if(!txt_studentId.getText().equals(""))
       {
           getStudentDetails();
       }
        
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
       if(!txt_bookId.getText().equals(""))
       {
           getBookDetails();
       }
        
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        if(lbl_quantity.getText().equals("0"))
        {
            JOptionPane.showMessageDialog(this, "Book is not available");     
        }else{
                if(isAlreadyIssued()==false)
        {
            if(issueBook()==true)
        {
            JOptionPane.showMessageDialog(this, "Book Issue Successfully");
            updateBookCount();
        }else{
            JOptionPane.showMessageDialog(this, "Operation Failed");
        }
        }
        else{
            JOptionPane.showMessageDialog(this, "This Book is Already Issued");
        }
                }
        
        
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
