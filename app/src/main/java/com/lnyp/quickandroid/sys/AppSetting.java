package com.lnyp.quickandroid.sys;

import android.content.Context;

import com.anupcowkur.reservoir.Reservoir;
import com.lnyp.quickandroid.bean.User;

/**
 * APP全局配置
 */
public class AppSetting {

    // 引导界面的KEY值
    private static final String KEY_GUIDE_ACTIVITY = "guide_activity";

    // 用token信息
    private static final String CACHE_USER_INFO = "cache_user_info";

    private static AppSetting mInstance = null;

    private AppSetting(Context context) {
    }

    public synchronized static AppSetting init(Context context) {
        if (mInstance == null) {
            mInstance = new AppSetting(context);
        }

        return mInstance;
    }

    public static AppSetting getInstance() {
        return mInstance;
    }

    /**
     * 获取新手引导标识
     *
     * @return
     */
    public Boolean getGuideFlag() {
        Boolean isGuide = false;
        try {
            if (Reservoir.contains(KEY_GUIDE_ACTIVITY)) {
                isGuide = Reservoir.get(KEY_GUIDE_ACTIVITY, Boolean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isGuide;
    }

    /**
     * 设置新手引导标识
     *
     * @param guideFlag
     */
    public void setGuideFlag(Boolean guideFlag) {
        try {
            Reservoir.put(KEY_GUIDE_ACTIVITY, guideFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取缓存的用户信息
     *
     * @return
     */
    public User getCacheUser() {
        User user = null;
        try {
            if (Reservoir.contains(CACHE_USER_INFO)) {

                user = Reservoir.get(CACHE_USER_INFO, User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 设置要缓存的用户信息
     *
     * @param user 用户信息
     */
    public void setCacheUser(User user) {
        try {
            Reservoir.put(CACHE_USER_INFO, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清空用户信息
     */
    public void clearUserCache() {
        try {
            Reservoir.delete(CACHE_USER_INFO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
