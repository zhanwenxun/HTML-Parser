import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Search extends JFrame {
    public String lineTxt;
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Search frame = new Search();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Search() {
        setTitle("HTML解析器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 689, 476);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblurl = new JLabel("请选择需要查询的URL:");
        lblurl.setFont(new Font("SimSun", Font.PLAIN, 16));
        lblurl.setBounds(17, 20, 243, 43);
        contentPane.add(lblurl);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(25, 77, 343, 316);
        textArea.setText(readText()+"");
        contentPane.add(textArea);

        textField = new JTextField();
        textField.setBounds(397, 80, 270, 32);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("查询");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PrintTable.main(textField.getText()+"");
            }
        });
        button.setFont(new Font("SimSun", Font.PLAIN, 16));
        button.setBounds(492, 225, 116, 43);
        contentPane.add(button);
    }

    public String readText() {
        try {
            String encoding = "GBK";
            File file = new File("C:\\Users\\Administrator\\Desktop\\URL.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String txt;
                while ((txt = bufferedReader.readLine()) != null) {
                    lineTxt=lineTxt+"\n"+txt;
                }
                read.close();
            } else {
                JOptionPane.showMessageDialog(null, "找不到指定的文件！", "错误",            //弹出错误类型对话框
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "读取文件内容出错！", "错误",            //弹出错误类型对话框
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return lineTxt;
    }
}
