package JV_GUI.BTGiaoDien;

@SuppressWarnings("serial")
public class Bai5_Calculator extends javax.swing.JFrame {
    String operandl = "";
    String operator = "";
    
    public Bai5_Calculator() {
        initComponents();
    }
                         
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        txtNum = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        div = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        mul = new javax.swing.JButton();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        sub = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        point = new javax.swing.JButton();
        del = new javax.swing.JButton();
        plus = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        result = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.setLayout(new java.awt.GridLayout());

        txtNum.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtNum);

        jPanel3.setPreferredSize(new java.awt.Dimension(150, 300));
        jPanel3.setLayout(new java.awt.GridLayout(4, 4, 5, 5));

        seven.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        seven.setText("7");
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(seven);

        eight.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        eight.setText("8");
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(eight);

        nine.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nine.setText("9");
        nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(nine);

        div.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        div.setText("/");
        div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplyActionPerformed(evt);
            }
        });
        jPanel3.add(div);

        four.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        four.setText("4");
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(four);

        five.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        five.setText("5");
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(five);

        six.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        six.setText("6");
        six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(six);

        mul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        mul.setText("*");
        mul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplyActionPerformed(evt);
            }
        });
        jPanel3.add(mul);

        one.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        one.setText("1");
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(one);

        two.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        two.setText("2");
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(two);

        three.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        three.setText("3");
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(three);

        sub.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        sub.setText("-");
        sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplyActionPerformed(evt);
            }
        });
        jPanel3.add(sub);

        zero.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        zero.setText("0");
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel3.add(zero);

        point.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        point.setText(".");
        jPanel3.add(point);

        del.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        del.setText("C");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        jPanel3.add(del);

        plus.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        plus.setText("+");
        plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplyActionPerformed(evt);
            }
        });
        jPanel3.add(plus);

        jPanel4.setPreferredSize(new java.awt.Dimension(120, 200));
        jPanel4.setLayout(new java.awt.GridLayout());

        result.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        result.setText("=");
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });
        jPanel4.add(result);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {                                     
        String cmd = evt.getActionCommand();
        txtNum.setText(txtNum.getText() + cmd);
    }                                    

    private void btnMultiplyActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String cmd = evt.getActionCommand();
        operator = cmd;
        operandl = txtNum.getText();
        txtNum.setText("");
    }                                           

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (txtNum.getText().equals("") || operandl.equals("")){
            return;
        }
        try {
            double oprand1 = Double.parseDouble(operandl);
            double oprand2 = Double.parseDouble(txtNum.getText());
            double result = 0;
            if(operator.equals("+")){
                result = oprand1 + oprand2;
            }
            else if (operator.equals("-")) {
                result = oprand1 - oprand2;
            }
            else if(operator.equals("*")){
                result = oprand1 * oprand2;
            }
            else if(operator.equals("/")){
                result = oprand1 / oprand2;
            }
            txtNum.setText("" + result);
        } catch (Exception e) {
        }
    }                                      

    private void delActionPerformed(java.awt.event.ActionEvent evt) {                                    
        txtNum.setText("");
        operandl = "";
        operator = "";
    }                                   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bai5_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai5_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai5_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai5_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai5_Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton del;
    private javax.swing.JButton div;
    private javax.swing.JButton eight;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton mul;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JButton plus;
    private javax.swing.JButton point;
    private javax.swing.JButton result;
    private javax.swing.JButton seven;
    private javax.swing.JButton six;
    private javax.swing.JButton sub;
    private javax.swing.JButton three;
    private javax.swing.JButton two;
    private javax.swing.JTextField txtNum;
    private javax.swing.JButton zero;
    // End of variables declaration                   
}
