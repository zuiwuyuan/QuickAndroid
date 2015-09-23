package com.lnyp.quickandroid.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class User {

    @DatabaseField(columnName = "name", dataType = DataType.INTEGER, generatedId = true)
    private int id;

    @DatabaseField(columnName = "name", dataType = DataType.STRING)
    private String name;

    @DatabaseField(columnName = "age", dataType = DataType.INTEGER)
    private int age;

    @DatabaseField(columnName = "sex", dataType = DataType.BOOLEAN)
    private boolean sex;

    @DatabaseField(columnName = "avatar", dataType = DataType.STRING)
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
