import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Wangyu
 * Date: 10/13/16
 * Time: 16:28 
 * 将从文本读入的数据进行结构化处理
 * 
 */
public class DataSet {

    public static List<Instance> readDataSet(String file) throws FileNotFoundException {
        List<Instance> dataset = new ArrayList<Instance>();
        Scanner scanner = new Scanner(new File(file));
        //按行读入
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //第一行用于说明，不读取
            if (line.startsWith("#")) {
                continue;
            }
            //String[] columns = line.split("\\s+");
            String[] columns = line.split(",");//用逗号分割字符串
            // skip first column and last column is the label
            /*int i = 1;
            double[] data = new double[columns.length-2];
            for (i=1; i<columns.length-1; i++)*/
            int i = 0;//前面是数据，最后一列是标签
            double [] data = new double [columns.length - 1];
            for(i = 0;i < columns.length - 2;i++){
                //data[i-1] = Integer.parseInt(columns[i]);
            	data[i] = Double.parseDouble(columns[i]);//将字符串转换成double
            }
            //int label = Integer.parseInt(columns[i]);
            int label = Integer.parseInt(columns[columns.length-1]);//将最后一列的标签转换成整数
            Instance instance = new Instance(label, data);
            dataset.add(instance);
        }
        return dataset;
    }
}
