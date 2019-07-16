import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectSave {

    private JFrame face;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelectSave window = new SelectSave();
                    window.face.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SelectSave() {
        initialize();
    }

    private void initialize() {
        face = new JFrame();
        face.setBounds(400, 200, 500, 350);
        face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        face.getContentPane().setLayout(null);
        face.setVisible(true);

        JLabel label = new JLabel("请选择存储文件的形式及位置:");
        label.setFont(new Font("SimSun", Font.PLAIN, 16));
        label.setBounds(86, 80, 252, 37);
        face.getContentPane().add(label);

        JButton button = new JButton("返回");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                face.setVisible(false);
                new SelectType();
            }
        });
        button.setFont(new Font("SimSun", Font.PLAIN, 16));
        button.setBounds(45, 189, 97, 23);
        face.getContentPane().add(button);

        JButton button_1 = new JButton("确定");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                face.setVisible(false);
                SaveTextAndData.main(null);
            }
        });
        button_1.setFont(new Font("SimSun", Font.PLAIN, 16));
        button_1.setBounds(273, 190, 97, 23);
        face.getContentPane().add(button_1);
    }
}
