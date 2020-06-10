package com.example.tododemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author jqd
 * @date 2020/5/28
 * @desc
 */
@Database(entities = { Task.class }, version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}