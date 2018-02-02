package com.example.vitalya.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Contract mDbHelper;
    private SQLiteDatabase mDb;
    Button Write;
    Button Read;
    EditText tofile;
    TextView fromfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper=new Contract(this);

        Read=findViewById(R.id.read);
        tofile=findViewById(R.id.tofile);
        fromfile=findViewById(R.id.fromfile);
        Write=findViewById(R.id.write);

       // mDb=mDbHelper.getWritableDatabase();

        Write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                String data1=tofile.toString();
                values.put(Contract.FeedEntry.COLUMN_NAME_TITLE, data1);
                values.put(Contract.FeedEntry.COLUMN_NAME_SUBTITLE, "subtitle");

// Insert the new row, returning the primary key value of the new row
                long newRowId = db.insert(Contract.FeedEntry.TABLE_NAME, null, values);
            }
        });
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mDbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
//                String[] projection = {
//                        Contract.FeedEntry._ID,
//                        Contract.FeedEntry.COLUMN_NAME_TITLE,
//                        Contract.FeedEntry.COLUMN_NAME_SUBTITLE
//                };
//
//// Filter results WHERE "title" = 'My Title'
//                String selection = Contract.FeedEntry.COLUMN_NAME_TITLE + " = ?";
//              String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
//                String sortOrder =
//                        Contract.FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

                Cursor cursor = db.query(
                        Contract.FeedEntry.TABLE_NAME,                     // The table to query
                       null,                               // The columns to return
                        null,                                // The columns for the WHERE clause
                        null,                            // The values for the WHERE clause
                        null,                                     // don't group the rows
                        null,                                     // don't filter by row groups
                        null                                 // The sort order
                );
               String item=new String();

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    item += cursor.getString(1) + " | ";
                    cursor.moveToNext();
                }
                cursor.close();
                    fromfile.setText(item);



//                List itemIds = new ArrayList<>();
//                while(cursor.moveToNext()) {
//                    long itemId = cursor.getLong(
//                            cursor.getColumnIndexOrThrow(Contract.FeedEntry._ID));
//
//                    itemIds.add(itemId);
//

            }
        });

    }

}
