package step1;

/**
 * Project name(项目名称)：作业_反射
 * Package(包名): t1
 * Class(类名): Reflect_run
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/7
 * Time(创建时间)： 14:41
 * Version(版本): 1.0
 * Description(描述)： 无
 */

/**
 * 评测执行文件
 */

public class Reflect_run
{

    public static void main(String[] args)
    {
//        Class clazz1 = Person.class;
////        2、通过对象的getClass()方法返回一个Class类型的实例
//        Person person = new Person();
//        Class clazz2 = person.getClass();
////        3、通过静态方法Class.forName()获取类名对应的Class对象
//        Class clazz3 = null;
//        try {
//            clazz3 = Class.forName("step1.Person");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // 使用 "==" 进行比较 clazz1 与 clazz2 的关系
//        System.out.println(clazz1 == clazz2);
//        // 使用 "==" 进行比较 clazz2 与 clazz3 的关系
//        System.out.println(clazz2 == clazz3);
        System.out.println("通过Object 类中的 getClass() 获取的 Class 对象为：" + getPersonClass1());
        System.out.println("通过静态方法 Class.forName() 获取的 Class 对象为：" + getPersonClass2());
        System.out.println("通过类字面常量获取 Class 的对象为：" + getPersonClass3());
    }

    /**
     * 通过 Object 类中的 getClass() 获取的 Class 对象
     *
     * @return
     */
    public static Class getPersonClass1()
    {
        return new Person().getClass();
    }

    /**
     * 通过静态方法 Class.forName() 获取的 Class 对象
     *
     * @return
     */
    public static Class getPersonClass2()
    {
        Class clazz = null;
        try
        {
            clazz = Class.forName("step1.Person");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 通过类字面常量获取 Class 的对象
     *
     * @return
     */
    public static Class getPersonClass3()
    {
        return Person.class;
    }
}
