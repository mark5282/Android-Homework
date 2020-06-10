package com.example.tododemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/**
 * @author jqd
 * @date 2020/5/28
 * @desc
 */
@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAll();

    @Insert
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Query("UPDATE task SET isComplete=1 WHERE time = :time")
    void updateTaskCompleted(long time);

    @Query("UPDATE task SET isComplete=0 WHERE time = :time")
    void updateTaskActive(long time);
}
