package step2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Project name(项目名称)：作业_反射
 * Package(包名): step2
 * Class(类名): Reflect_run
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/7
 * Time(创建时间)： 14:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Reflect_run
{
    public static void main(String[] args)
    {
        // 请根据提供的 classPath 获取 step2.Apple 的 Class 对象
        String classPath = "step2.Apple";
        Class clazz = null;
        try
        {
            clazz = Class.forName(classPath);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        printConstructors(clazz);
        printFields(clazz);
        printMethods(clazz);
    }

    public static void printConstructors(Class clazz)
    {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors)
        {
            String name = constructor.getName();
            printModifiers(clazz);
            System.out.print(name + "(");

            Class[] paramTypes = constructor.getParameterTypes();
            printParamTypes(paramTypes);
        }
    }

    private static void printModifiers(Class clazz)
    {
        System.out.print("  ");
        String modifiers = Modifier.toString(clazz.getModifiers());
        if (modifiers.length() > 0)
        {
            System.out.print(modifiers + " ");
        }
    }

    public static void printMethods(Class clazz)
    {
        Method[] methos = clazz.getDeclaredMethods();
        for (Method method : methos)
        {
            Class returnType = method.getReturnType();
            String name = method.getName();
            printModifiers(clazz);
            System.out.print(returnType.getName() + " " + name + "(");
            Class[] paramTypes = method.getParameterTypes();
            printParamTypes(paramTypes);
        }
    }

    private static void printParamTypes(Class[] paramTypes)
    {
        for (int j = 0; j < paramTypes.length; ++j)
        {
            if (j > 0)
            {
                System.out.print(",");
            }
            System.out.print(paramTypes[j].getName());
        }
        System.out.println(");");
    }

    public static void printFields(Class clazz)
    {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
        {
            Class type = field.getType();
            String name = field.getName();
            printModifiers(clazz);
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}

