/**
 * Created with IntelliJ IDEA.
 * User:Wangyu
 * Date: 10/13/2016
 * Time: 16:28 PM
 * 定义类：标签，数据
 */
public class Instance {
    /*public int label;
    public int[] x;*/
	public int label;
	public double[] x;

    public Instance(int label, double[] x) {
        this.label = label;
        this.x = x;
    }

    public int getLabel() {
        return label;
    }

    public double[] getX() {
        return x;
    }
}
