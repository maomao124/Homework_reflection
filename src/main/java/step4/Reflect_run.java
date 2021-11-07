package step4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Project name(项目名称)：作业_反射
 * Package(包名): step4
 * Class(类名): Reflect_run
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/7
 * Time(创建时间)： 15:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Reflect_run
{
    public static void main(String[] args) throws InvocationTargetException
    {
        //使用反射调用
        Class clazz = null;
        try
        {
            clazz = Class.forName("step4.Apple");
            Method setPriceMethod = clazz.getMethod("setPrice", double.class);
            Constructor appleConstructor = clazz.getConstructor();
            Object apple = appleConstructor.newInstance();
            setPriceMethod.invoke(apple, 20);
            Method getPriceMethod = clazz.getMethod("getPrice");
            System.out.println(getPriceMethod.invoke(apple));
            Method getTotal = clazz.getMethod("getTotal", double.class, int.class);
            System.out.println(getTotal.invoke(apple, 20, 24));
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException e)
        {
            e.printStackTrace();
        }
    }
}
