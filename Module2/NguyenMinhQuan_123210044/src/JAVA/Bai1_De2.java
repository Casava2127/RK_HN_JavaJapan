package JAVA;

import javax.swing.*;
import java.util.HashMap;

public class Bai1_De2 extends JFrame {

    public Bai1_De2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jLabel3 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhập chuỗi:");

        jLabel2.setText("Thực hiện:");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Đếm từ", "Đếm từ trùng lặp", "Đảo chuỗi" }));

        jLabel3.setText("Kết quả:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Reset");
        jButton1.addActionListener(evt -> resetAction());

        jButton2.setText("View");
        jButton2.addActionListener(evt -> viewAction());

        jButton3.setText("Exit");
        jButton3.addActionListener(evt -> exitAction());

        // UI Layout setup
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1))
                                .addContainerGap(36, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton3)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void viewAction() {
        jTextArea1.setText(null);
        String input = jTextField1.getText().trim();

        if (input.isEmpty()) {
            jTextArea1.append("Vui lòng nhập chuỗi!\n");
            return;
        }

        String[] words = input.split("\\s+");
        int selectedIndex = jComboBox1.getSelectedIndex();

        switch (selectedIndex) {
            case 0 -> jTextArea1.append("Số từ: " + words.length + "\n");
            case 1 -> {
                HashMap<String, Integer> wordCount = new HashMap<>();
                for (String word : words) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
                wordCount.forEach((key, value) ->
                        jTextArea1.append(key + ": " + value + " lần\n"));
            }
            case 2 -> {
                StringBuilder reversed = new StringBuilder(input).reverse();
                jTextArea1.append("Chuỗi đảo ngược: " + reversed + "\n");
            }
        }
    }

    private void resetAction() {
        jTextField1.setText(null);
        jTextArea1.setText(null);
        jComboBox1.setSelectedIndex(0);
    }

    private void exitAction() {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Bai1_De2().setVisible(true));
    }

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
}
