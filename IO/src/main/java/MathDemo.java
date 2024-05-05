import java.math.BigDecimal;
import java.math.BigInteger;

public class MathDemo {    //掌握Math的使用 以及大部分和计算、大数计算相关的方法
    //1、Math
    //2、BigInteger
    //3、BigDecimal
    //4、Random
    //5、RandomAccess
    public void demonstrateMathMethods() {
        // Math.abs() 返回绝对值
        double a = Math.abs(-10.5);
        // Math.max() 返回两个数中的最大值
        //向上可以自动转型 不会出现精度损失问题
        long b = Math.max(20, 30);

        // Math.sqrt() 返回平方根
        double c = Math.sqrt(16);

        // Math.pow() 返回第一个参数的第二个参数次方
        double d = Math.pow(2, 3);

    }

    public void demonstrateBigIntegerMethods() {
        // 创建 BigInteger 实例
        BigInteger bi1 = new BigInteger("100000000000000000000");
        BigInteger bi2 = new BigInteger("200000000000000000000");
        // BigInteger.add() 返回两个 BigInteger 的和
        BigInteger sum = bi1.add(bi2);
        System.out.println("Sum is " + sum);

        // BigInteger.multiply() 返回两个 BigInteger 的乘积
        BigInteger product = bi1.multiply(bi2);
        System.out.println("Product is " + product);

        // BigInteger.pow() 返回 BigInteger 的指定次方
        BigInteger biPow = bi1.pow(2);
        System.out.println("bi1 to the power of 2 is " + biPow);
    }
    public static void demostrateBigDecimalMethods() {
        // 创建 BigDecimal 实例
         BigDecimal bd1 = new BigDecimal("100000000000000000000.123456789");
         BigDecimal bd2 = new BigDecimal("1.44");
        // // BigDecimal.add() 返回两个 BigDecimal 的和
         BigDecimal sum = bd1.add(bd2);
         System.out.println("Sum is " + sum);
        // // BigDecimal.multiply() 返回两个 BigDecimal 的乘积
         BigDecimal product = bd1.multiply(bd2);
         System.out.println("Product is " + product);
        // // BigDecimal.pow() 返回 BigDecimal 的指定次方
         BigDecimal bdPow = bd1.pow(1/2);//相当于开二次方根
         System.out.println("bd1 to the power of 1/2 is " + bdPow);
    }

    public static void main(String[] args) {
        demostrateBigDecimalMethods();
    }
}