package step1;

/**
 * Project name(项目名称)：作业_反射
 * Package(包名): t1
 * Class(类名): Reflect_stu
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/7
 * Time(创建时间)： 14:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */


/**
 * 学员任务文件
 */
public class Reflect_stu
{

    public static void main(String[] args)
    {
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
        /********** Begin *********/
        Person p = new Person();
        Class c = p.getClass();
        return c;
        /********** End *********/
    }

    /**
     * 通过静态方法 Class.forName() 获取的 Class 对象
     * <p>
     * 注意：Person 类的全路径为: step1.Person
     *
     * @return
     */
    public static Class getPersonClass2()
    {
        /********** Begin *********/

        Class c = null;
        String strcalss = "t1.Person";
        try
        {
            c = Class.forName(strcalss);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return c;
        /********** End *********/
    }

    /**
     * 通过类字面常量获取 Class 的对象
     *
     * @return
     */
    public static Class getPersonClass3()
    {
        /********** Begin *********/
        Class c = Person.class;
        return c;
        /********** End *********/
    }
}