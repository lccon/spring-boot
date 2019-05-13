package com.lc.Enum;

/**
 * Description:
 *
 * @Date:2019/5/11
 * @Author:lc
 */
public enum EmployerEnum {

    NAME_1("张三", 16),
    NAME_2("李四", 17),
    NAME_3("王五", 18),
    NAME_4("孙六", 19);

    private String name;
    private Integer age;

    EmployerEnum(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
