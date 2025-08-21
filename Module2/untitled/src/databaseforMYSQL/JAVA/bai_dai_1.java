package databaseforMYSQL.JAVA;

import java.util.HashSet;


public class bai_dai_1 extends javax.swing.JFrame {
    // Lớp bai_dai_1 kế thừa từ javax.swing.JFrame, nghĩa là lớp này là một cửa sổ GUI sử dụng Swing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;

public bai_dai_1() {
    initComponents();  // Gọi phương thức initComponents() để khởi tạo giao diện người dùng
}

@SuppressWarnings("unchecked") // Cảnh báo không kiểm tra loại đối tượng do trình tạo mã của NetBeans tạo ra
private void initComponents() {
    // Phương thức này được tạo ra tự động bởi công cụ GUI Builder của NetBeans để thiết lập giao diện
    jLabel1 = new javax.swing.JLabel(); // Khởi tạo JLabel (label) jLabel1
    jTextField1 = new javax.swing.JTextField(); // Khởi tạo JTextField (ô nhập liệu) jTextField1
    jLabel2 = new javax.swing.JLabel(); // Khởi tạo JLabel (label) jLabel2
    jComboBox1 = new javax.swing.JComboBox<>(); // Khởi tạo JComboBox (hộp chọn) jComboBox1
    jLabel3 = new javax.swing.JLabel(); // Khởi tạo JLabel (label) jLabel3
    jScrollPane1 = new javax.swing.JScrollPane(); // Khởi tạo JScrollPane để cuộn vùng hiển thị văn bản
    jTextArea1 = new javax.swing.JTextArea(); // Khởi tạo JTextArea (vùng hiển thị văn bản đa dòng)
    jButton1 = new javax.swing.JButton(); // Khởi tạo JButton (nút) jButton1
    jButton2 = new javax.swing.JButton(); // Khởi tạo JButton (nút) jButton2
    jButton3 = new javax.swing.JButton(); // Khởi tạo JButton (nút) jButton3

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); // Thiết lập hành động đóng cửa sổ là thoát chương trình

    jLabel1.setText("Nhập chuỗi"); // Thiết lập văn bản cho jLabel1 là "Nhập chuỗi"

    jLabel2.setText("Thực hiện"); // Thiết lập văn bản cho jLabel2 là "Thực hiện"

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đếm từ", "Đếm từ trùng lặp", "Đảo chuỗi" }));
    // Thiết lập các lựa chọn cho JComboBox: "Đếm từ", "Đếm từ trùng lặp", "Đảo chuỗi"

    jLabel3.setText("Kết quả"); // Thiết lập văn bản cho jLabel3 là "Kết quả"

    jTextArea1.setColumns(20); // Thiết lập số cột hiển thị cho JTextArea là 20
    jTextArea1.setRows(5); // Thiết lập số dòng hiển thị cho JTextArea là 5
    jScrollPane1.setViewportView(jTextArea1); // Gắn JTextArea vào JScrollPane để có thể cuộn

    jButton1.setText("Reset"); // Thiết lập văn bản cho nút jButton1 là "Reset"
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt); // Gọi phương thức jButton1ActionPerformed khi nút Reset được nhấn
        }
    });

    jButton2.setText("View"); // Thiết lập văn bản cho nút jButton2 là "View"
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt); // Gọi phương thức jButton2ActionPerformed khi nút View được nhấn
        }
    });

    jButton3.setText("Exit"); // Thiết lập văn bản cho nút jButton3 là "Exit"
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt); // Gọi phương thức jButton3ActionPerformed khi nút Exit được nhấn
        }
    });

    // Thiết lập layout cho các thành phần giao diện (các button, combo box, text field, text area) trong cửa sổ
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                            .addGap(41, 41, 41)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1))
                            .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2))
                            .addContainerGap(20, Short.MAX_VALUE))
    );

    jTextField1.getAccessibleContext().setAccessibleName("tfNhap"); // Đặt tên truy cập cho JTextField
    jLabel2.getAccessibleContext().setAccessibleName("thực hiện"); // Đặt tên truy cập cho JLabel

    pack(); // Đảm bảo các thành phần giao diện có kích thước phù hợp với cửa sổ
}

// Sự kiện khi nút "View" được nhấn
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    jTextArea1.setText(null); // Xóa nội dung cũ trong JTextArea
    String s = jTextField1.getText(); // Lấy chuỗi nhập từ JTextField
    String[] arrStr = s.split("\\s+"); // Tách chuỗi thành các từ dựa trên khoảng trắng
    int select = jComboBox1.getSelectedIndex(); // Lấy lựa chọn của người dùng từ JComboBox

    if (select == 0) {
        jTextArea1.append(String.valueOf(arrStr.length)); // Đếm số từ và hiển thị lên JTextArea
    } else if (select == 1) {
        // Đếm số lần xuất hiện của các từ trùng lặp
        HashSet<String> hashSet = new HashSet<>();
        for (String str : arrStr) hashSet.add(str); // Thêm các từ vào HashSet để loại bỏ trùng lặp
        for (String i : hashSet) {
            int count = 0;
            for (String j : arrStr) {
                if (i.equals(j)) count++; // Đếm số lần xuất hiện của từ i
            }
            jTextArea1.append(i + ": " + count + " lần\n"); // Hiển thị kết quả
        }
    } else if (select == 2) {
        // Đảo chuỗi và hiển thị kết quả
        for (int i = s.length() - 1; i >= 0; i--) {
            jTextArea1.append(String.valueOf(s.charAt(i))); // Hiển thị từng ký tự của chuỗi theo thứ tự đảo ngược
        }
    }
}

// Sự kiện khi nút "Reset" được nhấn
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    jTextField1.setText(null); // Xóa nội dung trong JTextField
    jTextArea1.setText(null); // Xóa nội dung trong JTextArea
    jComboBox1.setSelectedIndex(0); // Đặt lại lựa chọn của JComboBox về mặc định (Đếm từ)
}

// Sự kiện khi nút "Exit" được nhấn
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    this.dispose(); // Đóng cửa sổ chương trình
}

// Phương thức main để chạy ứng dụng
public static void main(String args[]) {
    // Cài đặt giao diện người dùng Nimbus nếu có
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        // Xử lý lỗi nếu không tìm thấy Nimbus
        java.util.logging.Logger.getLogger(bai_dai_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    // Khởi tạo và hiển thị giao diện
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new bai_dai_1().setVisible(true);
        }
    });
}

    // End of variables declaration//GEN-END:variables
}
