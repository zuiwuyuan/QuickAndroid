package com.lnyp.quickandroid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "/helper.db3";

    private Map<String, Dao> daos = new HashMap<String, Dao>();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static DatabaseHelper heler;

    public static synchronized DatabaseHelper getHeler(Context context) {
        context = context.getApplicationContext();

        if (heler == null) {
            synchronized (DatabaseHelper.class) {
                if (heler == null)
                    heler = new DatabaseHelper(context);
            }
        }
        return heler;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }


    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao.clearObjectCache();
            dao = null;
        }
    }

    public synchronized Dao getDao(Class clazz) {

        Dao dao = null;

        String className = clazz.getSimpleName();

        if (daos.containsKey(className)) {
            dao = daos.get(className);
        } else {

            try {
                dao = super.getDao(clazz);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            daos.put(className, dao);
        }

        return dao;
    }

}
