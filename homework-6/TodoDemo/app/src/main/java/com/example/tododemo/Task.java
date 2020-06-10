package com.example.tododemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author jqd
 * @date 2020/5/28
 * @desc
 */
@Entity
public class Task {
    @PrimaryKey
    public long time;

    @ColumnInfo(name = "content")
    public String content;

    public boolean isComplete;

    public Task(long time, String content) {
        this.time = time;
        this.content = content;
        isComplete = false;
    }
}
