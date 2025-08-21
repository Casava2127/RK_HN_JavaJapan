package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cau_6_3 extends JFrame {
    private JTextField txtConnectionInfo;
    private JTextField txtSQLQuery;
    private JTextArea txtResult;
    private JButton btnSubmit;
    private JButton btnReset;
    private JButton btnCancel;
    private JPanel pnlButtons;
    private JLabel lblConnectionInfo;
    private JLabel lblSQL;

    //Hàm dựng
    public cau_6_3() {
    	setTitle("Database Programming");
        txtConnectionInfo = new JTextField("jdbc:mysql://127.0.0.1:3306/data");
        txtSQLQuery = new JTextField("SELECT * FROM Table1");
        txtResult = new JTextArea(20, 200); 
        txtResult.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtResult.setEditable(false);
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnCancel = new JButton("Cancel");
        pnlButtons = new JPanel(); 
        lblConnectionInfo = new JLabel("Input Information:");
        lblSQL = new JLabel("SQL:");

        setLayout(new BorderLayout());
        JPanel pnlNorth = new JPanel(new GridLayout(4, 1));
        pnlNorth.add(lblConnectionInfo);
        pnlNorth.add(txtConnectionInfo);
        pnlNorth.add(lblSQL);
        pnlNorth.add(txtSQLQuery);
        add(pnlNorth, BorderLayout.NORTH);

        txtResult.setRows(5);
        JScrollPane scrollPane = new JScrollPane(txtResult);
        add(scrollPane, BorderLayout.CENTER);

        pnlButtons.setLayout(new GridLayout(1, 3));
        pnlButtons.add(btnSubmit);
        pnlButtons.add(btnReset);
        pnlButtons.add(btnCancel);
        add(pnlButtons, BorderLayout.SOUTH);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performQuery();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtConnectionInfo.setText("jdbc:mysql://127.0.0.1:3306/DATA");
                txtSQLQuery.setText("SELECT * FROM Table1");
                txtResult.setText("");
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cau_6_3.this.dispose();
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setSize(600, 500); 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void performQuery() {
        String connectionUrl = txtConnectionInfo.getText();
        String sqlQuery = txtSQLQuery.getText();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Connect DB
            conn = DriverManager.getConnection(connectionUrl, "root", "123456");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            StringBuilder sb = new StringBuilder();
            while(rs.next()) {
                sb.append(rs.getInt("Id")).append("\t");
                sb.append(rs.getString("Name")).append("\t");
                sb.append(rs.getString("Address")).append("\t");
                sb.append(rs.getDouble("Total")).append("\n");
            }
            txtResult.setText(sb.toString());
        } catch(Exception ex) {
            ex.printStackTrace();
            txtResult.setText("Error in database operation: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new cau_6_3();
    }
}
