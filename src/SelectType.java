import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectType {

    private JFrame face;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelectType window = new SelectType();
                    window.face.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SelectType() {
        initialize();
    }

    private void initialize() {
        face = new JFrame();
        face.setBounds(400,200,500,350);
        face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        face.getContentPane().setLayout(null);
        face.setVisible(true);

        JLabel lblNewLabel = new JLabel("请选择所需存储内容类型:");
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 16));
        lblNewLabel.setBounds(43, 25, 436, 53);
        face.getContentPane().add(lblNewLabel);

        JCheckBox chckbxTable = new JCheckBox("table（表格）");
        chckbxTable.setFont(new Font("SimSun", Font.PLAIN, 16));
        chckbxTable.setBounds(90, 80, 160, 25);
        face.getContentPane().add(chckbxTable);

        JCheckBox chckbxText = new JCheckBox("text（文本）");
        chckbxText.setFont(new Font("SimSun", Font.PLAIN, 16));
        chckbxText.setBounds(90, 130, 160, 25);
        face.getContentPane().add(chckbxText);

        JCheckBox chckbxImage = new JCheckBox("image（图片）");
        chckbxImage.setFont(new Font("SimSun", Font.PLAIN, 16));
        chckbxImage.setBounds(90, 180, 160, 25);
        face.getContentPane().add(chckbxImage);

        JButton button = new JButton("确认");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                face.setVisible(false);
                PrintTable.main(InputURL.getURL()+"");
                new SelectSave();
            }
        });
        button.setFont(new Font("SimSun", Font.PLAIN, 16));
        button.setBounds(298, 212, 97, 23);
        face.getContentPane().add(button);
    }
}
