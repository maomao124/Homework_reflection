package step2;

/**
 * Project name(项目名称)：作业_反射
 * Package(包名): step2
 * Class(类名): Person
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/7
 * Time(创建时间)： 14:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Person
{
    public String name;
    protected String height;
    String sex;
    private int age;

    public Person()
    {
    }

    public Person(String name)
    {
        this.name = name;
    }

    public Person(String name, String sex, String height, int age)
    {
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getHeight()
    {
        return height;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
