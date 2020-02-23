package com.example.android.todolist.database;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class TaskDao_Impl implements TaskDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTaskEntry;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTaskEntry;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTaskEntry;

  public TaskDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTaskEntry = new EntityInsertionAdapter<TaskEntry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `task`(`id`,`description`,`priority`,`updated_at`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskEntry value) {
        stmt.bindLong(1, value.getId());
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
        stmt.bindLong(3, value.getPriority());
        final Long _tmp;
        _tmp = DateConverter.toTimestamp(value.getUpdatedAt());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
      }
    };
    this.__deletionAdapterOfTaskEntry = new EntityDeletionOrUpdateAdapter<TaskEntry>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `task` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskEntry value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTaskEntry = new EntityDeletionOrUpdateAdapter<TaskEntry>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `task` SET `id` = ?,`description` = ?,`priority` = ?,`updated_at` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskEntry value) {
        stmt.bindLong(1, value.getId());
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
        stmt.bindLong(3, value.getPriority());
        final Long _tmp;
        _tmp = DateConverter.toTimestamp(value.getUpdatedAt());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insertTask(TaskEntry taskEntry) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTaskEntry.insert(taskEntry);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTask(TaskEntry taskEntry) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTaskEntry.handle(taskEntry);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTask(TaskEntry taskEntry) {
    __db.beginTransaction();
    try {
      __updateAdapterOfTaskEntry.handle(taskEntry);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TaskEntry> loadAllTasks() {
    final String _sql = "SELECT * FROM task ORDER BY priority";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfPriority = _cursor.getColumnIndexOrThrow("priority");
      final int _cursorIndexOfUpdatedAt = _cursor.getColumnIndexOrThrow("updated_at");
      final List<TaskEntry> _result = new ArrayList<TaskEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TaskEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final int _tmpPriority;
        _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
        final Date _tmpUpdatedAt;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = DateConverter.toDate(_tmp);
        _item = new TaskEntry(_tmpId,_tmpDescription,_tmpPriority,_tmpUpdatedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public TaskEntry loadTaskbyId(int id) {
    final String _sql = "SELECT * FROM task WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfPriority = _cursor.getColumnIndexOrThrow("priority");
      final int _cursorIndexOfUpdatedAt = _cursor.getColumnIndexOrThrow("updated_at");
      final TaskEntry _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final int _tmpPriority;
        _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
        final Date _tmpUpdatedAt;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = DateConverter.toDate(_tmp);
        _result = new TaskEntry(_tmpId,_tmpDescription,_tmpPriority,_tmpUpdatedAt);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
