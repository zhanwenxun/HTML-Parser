import org.htmlparser.filters.NodeClassFilter;                                                                         //HTMLParser中的一种Filter
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableHeader;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;                                                                                   //parser存储的Node列表
import org.htmlparser.NodeFilter;                                                                                      //HTMLParser中的一种Filter
import org.htmlparser.Parser;                                                                                          //引入jar包的parser组件
import java.io.File;
import java.io.FileWriter;                                                                                             //引入输入字符流的类
import java.io.IOException;                                                                                            //IO流异常
import java.io.PrintWriter;                                                                                            //打印格式化对象的表示到文本输出流

public class PrintTable {

    public static void main(String URL) {
        Object[][] moduleList;

        try{
            NodeList tableList = null;
            NodeFilter tableFilter = null;
            Parser parser = new Parser();
            parser.setURL(URL);                                                                              //获取page2的URL信息
            parser.setEncoding(parser.getEncoding());
            tableFilter = new NodeClassFilter(TableTag.class);
            tableList = parser.extractAllNodesThatMatch(tableFilter);                                                   //筛选列表节点

            FileWriter fw =null;
            try {
                File f=new File("C:\\Users\\Administrator\\南昌PM2.5及空气质量数据.txt");
                fw = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw);

            for (int i=0; i<tableList.size(); i++) {
                TableTag table = (TableTag) tableList.elementAt(i);
                TableRow[] rows = table.getRows();
                moduleList = new Object[11][];
                for (int r=0; r<rows.length; r++) {
                    moduleList[r] = new Object[11];
                    TableRow tr = rows[r];
                    TableHeader[] headers = tr.getHeaders();
                    for (int j = 0; j < headers.length; j++) {

                    }
                    System.out.println();
                    TableColumn[] td = tr.getColumns();
                    for (int c=0; c<td.length; c++) {

                        moduleList[r][c] = changeLength(td[c].toPlainTextString());
                    }
                    pw.println();
                }
                SwingJTable.main(moduleList);
            }

            pw.flush();
            try{
                fw.flush();
                pw.close();
                fw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch( Exception e ) {
            e.printStackTrace();
        }

    }

    private static String changeLength(String str) {                                                                  //格式化字符串
        int size = str.length();
        String temp = str;
        for (int i = 0; i < 17-size; i++) {
            temp +=" ";
        }
        return temp;
    }
}
