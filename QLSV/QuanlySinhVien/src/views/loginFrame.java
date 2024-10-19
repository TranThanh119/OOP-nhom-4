package views;

import controllers.userController;
import java.awt.Color;
import models.User;
import util.ColorFrame;

public class loginFrame extends javax.swing.JFrame {
    ColorFrame colorFrame = new ColorFrame();
    int statue = 0;
    userController userC1 = new userController();
    User user = new User();
    
    public loginFrame() {
        initComponents();
        setDetail();
    }  
    public void setDetail() {
        
        setTitle("Login");
        resetStatus();
        titleLabel.setForeground(colorFrame.getPrimeryColor());
    }

    public void resetStatus(){
        nameWarningLabel.setText("");
        passWarningLabel.setText("");
        statue = 0;
    }
    
//Ẩn hiện pass
    public void hideOrShow(){
        if(hideSelection.isSelected()){
            hideSelection.setText("Hiện");
            passWordField1.setEchoChar((char)0);
        }
        else{
            hideSelection.setText("Ẩn");
            passWordField1.setEchoChar('*');
        }
    }

//Check tên và mật khẩu
    public void checkLogin() {
        String name = userNameField.getText();
        String pass = passWordField1.getText();
        userC1 = new userController();
// Kiểm tra có tên và mật khẩu không
        if (name.equals("")) {
            resetStatus();
            nameWarningLabel.setText("Chưa điền tài khoản!");
        } 
        else if (pass.equals("")) {
            resetStatus();
            passWarningLabel.setText("Chưa điền mật khẩu!");
        } 
//Truy van CSDL
        else {
            userC1.getUserInfor(name);
            if (userC1.getUser1() != null) {
                if (pass.equals(userC1.getUser1().getPassWord())) {
                    resetStatus();
                    passWordField1.setText("");
                    //Code khi dang nhap thanh cong
                    user = userC1.getUser(name);
                    homeFrame homeFrame1 = new homeFrame(user);
                    homeFrame1.setVisible(true);
                    dispose();
                    
                    System.out.println(name + " is activating!");
                } else {
                    //Mk sai
                    resetStatus();
                    passWarningLabel.setText("Sai mật khẩu!");
                    statue = 1;
                }
            } else {
                //Người dùng chưa đăng kí
                resetStatus();
                nameWarningLabel.setText("Người dùng chưa đăng kí!");
            }
        }
    }
//Xử lý quên mật khẩu
    public void changePass(){
        if(statue == 1){
            String newPass = "123456789";
            userC1.updatePass(userC1.getUser1().getUserName(), newPass);
            passWordField1.setText(newPass);
            passWarningLabel.setText("Mật khẩu mới của bạn là " + newPass);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        forgetLabel = new javax.swing.JLabel();
        loginBTN = new javax.swing.JButton();
        sigUpLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        nameWarningLabel = new javax.swing.JLabel();
        passWarningLabel = new javax.swing.JLabel();
        passWordField1 = new javax.swing.JPasswordField();
        hideSelection = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 100, 0, 0));

        nameLabel.setBackground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Tài Khoản");

        passLabel.setBackground(new java.awt.Color(255, 255, 255));
        passLabel.setText("Mật Khẩu");

        forgetLabel.setBackground(new java.awt.Color(255, 255, 255));
        forgetLabel.setForeground(new java.awt.Color(0, 0, 153));
        forgetLabel.setText("Quên mật khẩu?");
        forgetLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        forgetLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgetLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgetLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgetLabelMouseExited(evt);
            }
        });

        loginBTN.setText("Đăng nhập");
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });

        sigUpLabel.setBackground(new java.awt.Color(255, 255, 255));
        sigUpLabel.setForeground(new java.awt.Color(0, 0, 153));
        sigUpLabel.setText("Đăng ký");
        sigUpLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        sigUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sigUpLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sigUpLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sigUpLabelMouseExited(evt);
            }
        });

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 153, 153));
        titleLabel.setText("Quản lý sinh viên");

        nameWarningLabel.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        nameWarningLabel.setForeground(new java.awt.Color(204, 0, 0));
        nameWarningLabel.setText("Lỗi");

        passWarningLabel.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        passWarningLabel.setForeground(new java.awt.Color(204, 0, 0));
        passWarningLabel.setText("Lỗi");

        passWordField1.setEchoChar('*');

        hideSelection.setText("Ẩn");
        hideSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideSelectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(passLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameField)
                            .addComponent(passWordField1)
                            .addComponent(nameWarningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passWarningLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hideSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(forgetLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sigUpLabel)))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(nameWarningLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passWordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hideSelection))
                .addGap(3, 3, 3)
                .addComponent(passWarningLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forgetLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sigUpLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed
        // TODO add your handling code here:
        checkLogin();
    }//GEN-LAST:event_loginBTNActionPerformed

    private void forgetLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetLabelMouseClicked
        // TODO add your handling code here:
        changePass();
    }//GEN-LAST:event_forgetLabelMouseClicked

    private void forgetLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetLabelMouseEntered
        // TODO add your handling code here:
        forgetLabel.setForeground(Color.GRAY);
    }//GEN-LAST:event_forgetLabelMouseEntered

    private void forgetLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetLabelMouseExited
        // TODO add your handling code here:
        forgetLabel.setForeground(Color.BLUE);
    }//GEN-LAST:event_forgetLabelMouseExited

    private void sigUpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sigUpLabelMouseClicked
        // TODO add your handling code here:
         new signUpFrame().setVisible(true);
    }//GEN-LAST:event_sigUpLabelMouseClicked

    private void sigUpLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sigUpLabelMouseEntered
        // TODO add your handling code here:
        sigUpLabel.setForeground(Color.GRAY);
    }//GEN-LAST:event_sigUpLabelMouseEntered

    private void sigUpLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sigUpLabelMouseExited
        // TODO add your handling code here:
        sigUpLabel.setForeground(Color.BLUE);
    }//GEN-LAST:event_sigUpLabelMouseExited

    private void hideSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideSelectionActionPerformed
        // TODO add your handling code here:
        hideOrShow();
    }//GEN-LAST:event_hideSelectionActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgetLabel;
    private javax.swing.JCheckBox hideSelection;
    private javax.swing.JButton loginBTN;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameWarningLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel passWarningLabel;
    private javax.swing.JPasswordField passWordField1;
    private javax.swing.JLabel sigUpLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
