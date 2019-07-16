import java.awt.EventQueue;                                                                                            //负责事件的分发
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {

    private JFrame face;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Welcome window = new Welcome();
                    window.face.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();                                                                                //在命令行打印异常信息在程序中出错的位置及原因
                }
            }

        });
    }

    public Welcome() {
        initialize();                                                                                                   //初始化
    }

    private void initialize() {
        face = new JFrame();
        face.setTitle("欢迎");
        face.setBounds(400, 200, 480, 400);
        face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                          //用户单击窗口的关闭按钮时程序执行的操作
        face.setVisible(true);

        JPanel panel = new JPanel();
        face.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblhtml = new JLabel("欢迎使用HTML解析器！");
        lblhtml.setBounds(160, 0, 224, 290);
        lblhtml.setFont(new Font("SimSun", Font.PLAIN, 16));
        panel.add(lblhtml);

        JLabel lblNewLabel = new JLabel("                         ");
        lblNewLabel.setBounds(0, 0, 160, 290);
        panel.add(lblNewLabel);

        JButton button = new JButton("查询");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                face.setVisible(false);
                Search.main(null);
            }
        });
        button.setFont(new Font("SimSun", Font.PLAIN, 16));
        button.setBounds(54, 214, 106, 39);
        panel.add(button);

        JButton button_1 = new JButton("解析");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                face.setVisible(false);
                new InputURL();
            }
        });
        button_1.setFont(new Font("SimSun", Font.PLAIN, 16));
        button_1.setBounds(280, 214, 106, 39);
        panel.add(button_1);
    }
}

