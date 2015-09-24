package com.lnyp.quickandroid.db.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.lnyp.quickandroid.bean.User;
import com.lnyp.quickandroid.db.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户信息操作类
 */
public class UserDao {

    private Context context;
    private Dao<User, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public UserDao(Context context) {

        this.context = context;

        try {
            helper = DatabaseHelper.getHeler(context);
            userDaoOpe = helper.getDao(User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加用户
     *
     * @param user
     */
    public void add(User user) {
        try {
            userDaoOpe.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id查询用户
     *
     * @param id
     */
    public User qryUserById(int id) {
        User user = null;
        try {
            user = userDaoOpe.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    public List<User> qryUsers() {
        List<User> users = null;
        try {
            users = userDaoOpe.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
