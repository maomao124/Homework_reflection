package step3;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Project name(项目名称)：作业_反射
 * Package(包名): step3
 * Class(类名): Reflect_run
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/7
 * Time(创建时间)： 15:21
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Reflect_run
{
    public static String toString(Object obj)
    {
        Class cl = obj.getClass();
        String r = "";
        r += "[";
        Field[] fields = cl.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field f : fields)
        {
            if (!Modifier.isStatic(f.getModifiers()))
            {
                if (!r.endsWith("[")) r += ",";
                r += f.getName() + "=";
                try
                {
                    Class t = f.getType();
                    Object val = f.get(obj);
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
