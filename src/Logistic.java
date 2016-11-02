import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: WanYu
 * Date: 10/13/16
 * Time: 16:53 PM
 * To change this template use File | Settings | File Templates.
 * 逻辑回归中的梯度下降使用的是次数限制，也可以使用下面的
 * |损失函数的变化|<一个很小的阈值
 */
public class Logistic {

    /** 学习率（即 alpha） */
    private double rate;

    /** the weight to learn */
    private double[] weights;

    /** 迭代次数 */
    private int ITERATIONS = 3000;

    public Logistic(int n) {
        this.rate = 0.0001;
        weights = new double[n];
    }
    /** sigmoid函数*/
    private double sigmoid(double z) {
        return 1.0 / (1.0 + Math.exp(-z));
    }

    public void train(List<Instance> instances) {
        for (int n = 0; n < ITERATIONS; n++) 
        {
            double lik = 0.0;
            for (int i = 0; i < instances.size(); i++) 
            {
                double[] x = instances.get(i).getX();
                double predicted = classify(x);
                int label = instances.get(i).getLabel();
                for (int j = 0; j < weights.length; j++) 
                {
                    weights[j] = weights[j] - rate * (predicted - label) * x[j];
                }
                // not necessary for learning
                lik -= label * Math.log(classify(x)) + (1-label) * Math.log(1- classify(x));
            }
            System.out.println("iteration: " + n + " " + Arrays.toString(weights) + " mle: " + lik);
        }
    }

    private double classify(double[] x) {
        double logit = .0;
        for (int i=0; i<weights.length;i++)  {
            logit += weights[i] * x[i];
        }
        return sigmoid(logit);
    }


    public static void main(String... args) throws FileNotFoundException {
        //List<Instance> instances = DataSet.readDataSet("dataset.txt");
    	List<Instance> instances = DataSet.readDataSet("iris.txt");
        Logistic logistic = new Logistic(4);//4是由数据集得来的
        logistic.train(instances);
        //int[] x = {2, 1, 1, 0, 1};
        double [] x = {5.0,3.3,1.4,0.2};
        System.out.println("prob(1|x) = " + logistic.classify(x));
        if(logistic.classify(x) < 0.5)
        {
        	System.out.println("this kind  is " + "Setosa");
        }
        else
        {
        	System.out.println("this kind  is " + "Versicolor");
        }
        

        //int[] x2 = {1, 0, 1, 0, 0};
        double [] x2 = {5.7,2.8,4.1,1.3};
        System.out.println("prob(1|x2) = " + logistic.classify(x2));
        if(logistic.classify(x2) < 0.5)
        {
        	System.out.println("this kind  is " + "Setosa");
        }
        else
        {
        	System.out.println("this kind  is " + "Versicolor");
        }

    }
}
