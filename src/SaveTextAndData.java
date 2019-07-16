import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableHeader;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class SaveTextAndData extends JFrame {
    public static void main(String[] args) {
        new SaveTextAndData();
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.showDialog(new JLabel(), "存储");
        File file=jfc.getSelectedFile();
        if(file.isDirectory()){
            System.out.println("文件夹:"+file.getAbsolutePath());
            SaveData(file.getAbsolutePath());
        }else if(file.isFile()){
            System.out.println("文件:"+file.getAbsolutePath());
            SaveData(file.getAbsolutePath());
        }
        System.out.println(jfc.getSelectedFile().getName());
        JOptionPane.showMessageDialog(null,"存储成功！","成功",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void SaveData(String path){
        try{
            NodeList tableList = null;
            NodeFilter tableFilter = null;
            Parser parser = new Parser();
            parser.setURL(InputURL.getURL());                                                                              //获取page2的URL信息
            parser.setEncoding(parser.getEncoding());
            tableFilter = new NodeClassFilter(TableTag.class);
            tableList = parser.extractAllNodesThatMatch(tableFilter);

            FileWriter fw =null;
            try {
                File f=new File(path);
                fw = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw);

            FileWriter fwx=null;
            try{
                File fx=new File("C:\\Users\\Administrator\\Desktop\\Data.txt");
                fwx = new FileWriter(fx,true);
            } catch(IOException e){
                e.printStackTrace();
            }
            PrintWriter pwx = new PrintWriter(fwx);

            FileWriter fwy=null;
            try{
                File fy=new File("C:\\Users\\Administrator\\Desktop\\URL.txt");
                fwy = new FileWriter(fy,true);
            } catch(IOException e){
                e.printStackTrace();
            }
            PrintWriter pwy = new PrintWriter(fwy);


            for (int i=0; i<tableList.size(); i++) {
                TableTag table = (TableTag) tableList.elementAt(i);
                TableRow[] rows = table.getRows();
                pw.println(InputURL.getURL()+"");
                pwx.println(InputURL.getURL()+"");
                pwy.println(InputURL.getURL()+"");
                for (int r=0; r<rows.length; r++) {
                    TableRow tr = rows[r];
                    TableHeader[] headers = tr.getHeaders();
                    for (int j = 0; j < headers.length; j++) {
                        pw.println("tag标签为：" + headers[j].getTagName());
                        pw.println("标签的内容为：" + headers[j].getStringText());
                        pwx.println("tag标签为：" + headers[j].getTagName());
                        pwx.println("标签的内容为：" + headers[j].getStringText());
                    }
                    TableColumn[] td = tr.getColumns();
                    for (int c=0; c<td.length; c++) {
                        pw.print(td[c].toPlainTextString() + " ");
                        pwx.print(td[c].toPlainTextString() + " ");
                    }
                    pw.println();
                    pwx.println();
                    pwy.println();
                }
            }

            pw.flush();
            pwx.flush();
            pwy.flush();

            try{
                fw.flush();
                pw.close();
                fw.close();
            }catch(IOException e){
                e.printStackTrace();
            }

            try{
                fwx.flush();
                pwx.close();
                fwx.close();
            }catch(IOException e){
                e.printStackTrace();
            }

            try{
                fwy.flush();
                pwy.close();
                fwy.close();
            }catch(IOException e){
                e.printStackTrace();
            }

        }catch( Exception e ) {
            e.printStackTrace();
        }
    }

    private static void message( String szMsg ) {
        try{
            System.out.println(new String(szMsg.getBytes("GBK"), System.getProperty("file.encoding")));
        } catch(Exception e ){}
    }
}  