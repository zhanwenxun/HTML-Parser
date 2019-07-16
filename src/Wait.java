import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wait {

    private JFrame face;

    public static void main(String url) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Wait window = new Wait();
                    window.face.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Wait() {
        initialize();
    }

    private void initialize() {
        face = new JFrame();
        face.setTitle("HTML解析器");
        face.setBounds(400, 200, 500,350);
        face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        face.getContentPane().setLayout(null);
        face.setVisible(true);

        JLabel label = new JLabel("正在连接并解析请耐心等待...");
        label.setFont(new Font("SimSun", Font.PLAIN, 16));
        label.setBounds(69, 51, 266, 36);
        face.getContentPane().add(label);

        JProgressBar progressBar = new JProgressBar();                                                                  //设置进度条
        progressBar.setStringPainted(true);                                                                             //确定进度条是否应该呈现进度字符串
        progressBar.setBounds(110, 145, 259, 23);
        new Thread(){
            public void run(){
                for(int i=0;i<=100;i+=5){
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);
                }
                progressBar.setString("解析完成！");
                face.setVisible(false);
                new SelectType();
            }
        }.start();
        face.getContentPane().add(progressBar);

        JButton button = new JButton("停止");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                face.setVisible(false);
                JOptionPane.showMessageDialog(null,"解析失败","错误",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        button.setFont(new Font("SimSun", Font.PLAIN, 16));
        button.setBounds(44, 231, 97, 23);
        face.getContentPane().add(button);
    }
}
