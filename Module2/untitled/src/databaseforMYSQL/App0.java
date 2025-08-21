package databaseforMYSQL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// import jdk.internal.org.objectweb.asm.Label;
// dangnhap
public class App0 extends JFrame {
    public static void main(String[] args) throws Exception {
        new App0();
    }

    App0(){
        this.setDefaultCloseOperation(3);
        JLabel l = new JLabel("user");
        l.setBounds(50, 50, 100, 30);
        this.add(l);
        JTextField tx = new JTextField();
        tx.setBounds(150, 50, 200, 30);
        this.add(tx);
        JLabel passLabel = new JLabel("Pass");
        passLabel.setBounds(50, 120, 100, 30);
        this.add(passLabel);
        JPasswordField pass = new JPasswordField();
        pass.setBounds(150, 120, 200, 30);
        JButton bt = new JButton("Login");
        bt.setBounds(200, 160, 80, 50);
        bt.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){ 
                try { 
                    boolean oke = false;
                    File f = new File("D:\\java\\LoginEx\\src\\User.txt");
                    FileReader ff = new FileReader(f);
                    BufferedReader bf = new BufferedReader(ff);
                    while (bf.ready()){
                        String s = bf.readLine();
                        System.out.println(s);
                        String[] txt = s.split("\\s");
                        String a = tx.getText();
                        char[] ss = pass.getPassword();
                        String conKhung = pass.getText();
                        String xxx = new String(ss);

                        if (txt[0].equals(a) && txt[1].equals(xxx)) {
                            JFrame newFrame = new JFrame();
                            newFrame.setDefaultCloseOperation(3);
                            JLabel lb = new JLabel("Đăng nhập thành công");
                            lb.setHorizontalAlignment(SwingConstants.CENTER);
                            newFrame.add(lb);
                            newFrame.setSize(500,300);
                            newFrame.setVisible(true);
                            oke = true;
                            break;
                        }
                    }
                    if (oke == false){
                        JFrame fff = new JFrame();
                        JOptionPane.showMessageDialog(fff, "Nhập sai tài khoản hoặc mật khẩu", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                catch (IOException ex){}
            }  
        });
        this.add(bt);
        this.add(pass);
        this.setSize(500,300);
        this.setLayout(null);
        this.setVisible(true);
    }
}
