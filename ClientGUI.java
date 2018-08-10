package lesson4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Formatter;


public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
//    File file = new File("Message");
//        try {
//        PrintWriter printWriter = new PrintWriter(file);
//    } catch (FileNotFoundException ex) {
//        ex.printStackTrace();
//    }
    static PrintWriter x;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Alwayson top");
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("Disconnect");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final JList userList = new JList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new ClientGUI();

            }
        });


    }

    private ClientGUI() {

        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUsers = new JScrollPane(userList);
        String[] users = {"user1_with_an_exceptionally_long_nickname", "user2", "user3", "user4", "user5", "user6", "user7", "user8", "user9", "user10"};
        userList.setListData(users);
        scrollUsers.setPreferredSize(new Dimension(100, 0));
        cbAlwaysOnTop.addActionListener(this);
        btnLogin.addActionListener(this);
        btnSend.addActionListener(this);
        tfMessage.addActionListener(this);
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(scrollLog, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        add(scrollUsers, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        if (ste.length == 0) msg = "Empty Stacktrace";
        else {
            msg = e.getClass().getCanonicalName() + ": " + e.getMessage() + "\n\t at " + ste[0];
        }
        JOptionPane.showMessageDialog(null, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            // setAlwaysOnTop(!isAlwaysOnTop());
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        }else if (src == btnSend) {
            File file = new File("Message");
            try {
                x = new PrintWriter(file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            x.println(tfMessage.getText());
            x.close();
            log.append("Ник: " + tfLogin.getText() + "\n" +  tfMessage.getText() + "\n");
            tfMessage.setText(null);
            tfMessage.requestFocus();

        }else if (src == tfMessage){
            log.append("Ник: " + tfLogin.getText() + "\n" +  tfMessage.getText() + "\n");
            tfMessage.setText(null);
        }else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }

}

