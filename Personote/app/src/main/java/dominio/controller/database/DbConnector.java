package dominio.controller.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * alsabino on 29/03/2018.
 */

public class DbConnector extends SQLiteOpenHelper {
    public DbConnector(Context context) {
        super(context,"journalnotes",null,2);
        getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = ScriptDLL.getOnCreateTable();
       try {
           sqLiteDatabase.execSQL(query);
       } catch (Exception ex) {
           Log.d("DB", ex.getLocalizedMessage());
       }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(ScriptDLL.getOnCreateTable());
    }
}
