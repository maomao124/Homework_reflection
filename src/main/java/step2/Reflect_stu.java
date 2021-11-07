package step2;

/**
 * Project name(项目名称)：作业_反射
 * Package(包名): step2
 * Class(类名): Reflect_stu
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/7
 * Time(创建时间)： 14:53
 * Version(版本): 1.0
 * Description(描述)：
 * 提示：
 * <p>
 * Method.getReturnType()可以获得方法的返回类型。
 * <p>
 * 打印方法或域的修饰符可以调用提供的printModifiers()方法
 * <p>
 * 打印方法的参数可以调用提供的printParamTypes()方法
 * <p>
 * Field的getType方法可以获得域类型、getName方法可以获得域的名称
 * <p>
 * 测试说明
 * 预期输出：
 * private java.lang.String name;
 * public step2.Apple();
 * public step2.Apple(java.lang.String);
 * public void setName(java.lang.String);
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Apple
{
    private String name;

    public Apple()
    {
    }

    public Apple(String name)
    {
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

public class Reflect_stu
{

    public static void main(String[] args)
    {
        // 请根据提供的 classPath 获取 step2.Apple 的 Class 对象， 请使用 Class.forName() 方法， 注意捕获异常
        // 通关之后，你也可以修改 clasapath 为其他类路径，分析某个类的能力， 例如: java.util.Date
        String classPath = "step2.Apple";
        Class clazz = null;
        /********** Begin *********/
        try
        {
            clazz = Class.forName("step2.Apple");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        /********** End *********/
        printFields(clazz);
        printConstructors(clazz);
        printMethods(clazz);
    }

    /**
     * 请打印类的每个域,输出格式为：修饰符 类型 变量名;
     *
     * @param clazz
     */
    public static void printFields(Class clazz)
    {
        /********** Begin *********/
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
        {
            Class type = field.getType();
            int mod = field.getModifiers();
            System.out.print(Modifier.toString(mod) + " ");
            System.out.print(type.getName() + " ");
            System.out.println(field.getName() + ";");
        }

        /********** End *********/
    }

    /**
     * 打印构造函数,输出格式为：修饰符 方法名称（参数）
     *
     * @param clazz
     */
    public static void printConstructors(Class clazz)
    {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors)
        {
            Class[] paramTypes = constructor.getParameterTypes();
            /********** Begin *********/
            String name = constructor.getName();
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0)
            {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            //end
            printParamTypes(paramTypes);
        }
    }

    /**
     * 请针对每个方法打印其签名，格式为：修饰符 返回值类型 方法名称(参数);
     *
     * @param clazz
     */
    public static void printMethods(Class clazz)
    {
        Method[] methos = clazz.getDeclaredMethods();
        for (Method method : methos)
        {
            Class[] paramTypes = null;
            /********** Begin *********/
            String name = method.getName();
            Class returnType = method.getReturnType();
            String modifiers = Modifier.toString(method.getModifiers());
            System.out.print(modifiers + " " + returnType.getName() + " " + name + "(");
            paramTypes = method.getParameterTypes();

            /********** End *********/
            printParamTypes(paramTypes);
        }
    }

    /**
     * 打印方法参数
     *
     * @param paramTypes
     */
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

}
