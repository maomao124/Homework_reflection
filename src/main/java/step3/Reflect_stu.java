package step3;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Project name(项目名称)：作业_反射
 * Package(包名): step3
 * Class(类名): Reflect_stu
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/7
 * Time(创建时间)： 15:20
 * Version(版本): 1.0
 * Description(描述)： 无
 */
public class Reflect_stu
{

    public static String toString(Object obj)
    {
        Class cl = obj.getClass();
        String r = "";
        r += "[";

        // 请获取所有 Field 并设置访问权限为 true
        /********** Begin *********/
        Field[] fields = cl.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        /********** End *********/
        for (Field f : fields)
        {
            // 此处 if，逻辑为判断 Field 域是否为非静态域
            if (!Modifier.isStatic(f.getModifiers()))
            {
                if (!r.endsWith("[")) r += ",";
                r += f.getName() + "=";
                try
                {
                    // 请获取域的类型及值
                    /********** Begin *********/
                    Class t = f.getType();
                    Object val = f.get(obj);
                    /********** End *********/
                    // isPrimitive() 用于判断是否为基本数据类型，若为基础数据类型直接拼接，否则递归调用 toString 方法
                    if (t.isPrimitive())
                    {
                        r += val;
                    }
                    else
                    {
                        r += toString(val);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        r += "]";
        return r;
    }

    public static void main(String[] args)
    {
        Person person = new Person(88, 19, 175);
        System.out.println(toString(person));
    }
}

class Person
{
    public Integer weight;
    private Integer age;
    private Double height;

    public Person(Integer weight, Integer age, double height)
    {
        this.weight = weight;
        this.age = age;
        this.height = height;
    }
}


