package com.lnyp.quickandroid.sys;

import android.content.Context;

import com.lnyp.quickandroid.bean.User;

/**
 * 信息缓存基础类
 *
 * @author lining
 */
public class AppCache {

    private static AppCache mInstance = null;

    public User user = null;

    private AppCache(Context context) {
        AppSetting.init(context);

        user = AppSetting.getInstance().getCacheUser();
    }

    public synchronized static AppCache init(Context context) {
        if (mInstance == null) {
            mInstance = new AppCache(context);
        }

        return mInstance;
    }

    /**
     * 保存用户信息
     *
     * @param user
     */
    public void saveUser(User user) {
        if (user == null) {
            return;
        }
        this.user = user;

        AppSetting.getInstance().setCacheUser(this.user);
    }

    /**
     * 清空用户信息，常用于退出登录
     */
    public void clearData() {

        BaseApp.cache.user = null;
        AppSetting.getInstance().clearUserCache();
    }
}
