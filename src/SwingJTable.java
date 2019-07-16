import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;                                                                                       //引入滚动面板
import javax.swing.JPanel;
import javax.swing.JTable;

public class SwingJTable {
    public static void main (Object[][] data) {

        final Object[] columnNames = {"监测点","AQI","空气质量指数类别","首要污染物","PM2.5细颗粒物","PM10可吸入颗粒物","CO一氧化碳",
                        "NO2二氧化氮","03臭氧1小时平均","O3臭氧8小时平均","SO2二氧化硫"};

        Object[][] rowData = data;                                                                                     //获取Table的表格数据

        JTable friends = new JTable (rowData, columnNames);
        friends.setPreferredScrollableViewportSize(new Dimension(400, 100));
        friends.setRowHeight (30);
        friends.setRowHeight (0, 20);
        friends.setRowMargin (5);
        friends.setRowSelectionAllowed (true);
        friends.setSelectionBackground (Color.white);
        friends.selectAll ();
        friends.setRowSelectionInterval (0,2);
        friends.clearSelection ();
        friends.setDragEnabled (false);
        friends.setShowGrid (false);
        friends.setShowHorizontalLines (false);
        friends.setShowVerticalLines (true);
        friends.doLayout ();
        friends.setBackground (Color.lightGray);

        JScrollPane pane1 = new JScrollPane (friends);

        JPanel pane2= new JPanel (new GridLayout (0, 1));
        pane2.setPreferredSize (new Dimension (1000,800));
        pane2.setBackground (Color.black);
        pane1.add (pane2);

        JFrame frame = new JFrame ("PM2.5及空气质量表格");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        frame.setContentPane (pane1);

        frame.pack();                                                                                                   //设置frame的最佳大小
        frame.setVisible(true);
    }
}