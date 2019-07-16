import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.net.URLConnection;

public class InputURL {
    public static String url;
    private JFrame face;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputURL window = new InputURL();
                    window.face.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputURL() {
        initialize();
    }

    private void initialize() {
        face = new JFrame();
        face.setTitle("HTML解析器");
        face.setBounds(400, 200, 500, 350);
        face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                          //用户单击窗口的关闭按钮时程序执行的操作
        face.getContentPane().setLayout(null);
        face.setVisible(true);

        JLabel lblNewLabel = new JLabel("请输入URL地址：");
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 16));
        lblNewLabel.setBounds(91, 56, 305, 71);
        face.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("SimSun", Font.PLAIN, 16));
        textField.setBounds(91, 130, 305, 32);
        face.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("返回");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                face.setVisible(false);
                new Welcome();
            }
        });
        btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 16));
        btnNewButton.setBounds(45, 237, 97, 23);
        face.getContentPane().add(btnNewButton);

        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                url = textField.getText();
                if(testUrlWithTimeOut(url,2000)) {
                    face.setVisible(false);
                    new Wait();
                }else{
                    JOptionPane.showMessageDialog(null,"连接不可用！","错误",            //弹出错误类型对话框
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button.setFont(new Font("SimSun", Font.PLAIN, 16));
        button.setBounds(316, 238, 97, 23);
        face.getContentPane().add(button);
    }

    public static boolean testUrlWithTimeOut(String urlString,int timeOutMillSeconds){                               //带限时的URL测试函数
        long lo = System.currentTimeMillis();
        URL url;
        try {
            url = new URL(urlString);
            URLConnection co =  url.openConnection();
            co.setConnectTimeout(timeOutMillSeconds);
            co.connect();
            System.out.println("连接可用");
            return true;
        } catch (Exception e1) {
            System.out.println("连接打不开!");
            url = null;
            return false;
        }
    }

    public static String getURL(){
        return url;
    }
}
