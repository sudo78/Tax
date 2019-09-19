package com.mytax.sudo.incometax;

/**
 * Created by Ayaz on 5/28/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DbHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tax.db";

    public static final String BUSINESS_TAX_TABLE = "business_tax_table";
    public static final String SALARY_TAX_TABLE = "salary_tax_table";
    public static final String RENTAL_TAX_TABLE = "rental_tax_table";

    private static final int DATABASE_VERSION = 2;
    public static final String MIN_RANGE = "min_range";
    public static final String MAX_RANGE = "max_range";
    public static final String TAX_RATE = "tax_rate";
    public static final String ADDITIONAL_AMOUNT = "additional_amount";


    // SQL statement of the carts table creation
    private static final String SQL_CREATE_TABLE_BUSSINESS = "CREATE TABLE " + BUSINESS_TAX_TABLE + "("
            + MIN_RANGE + " INTEGER, "
            + MAX_RANGE + " INTEGER, "
            + TAX_RATE + " REAL, "
            + ADDITIONAL_AMOUNT + " INTEGER "
            + ");";
    private static final String SQL_CREATE_TABLE_SALARY = "CREATE TABLE " + SALARY_TAX_TABLE + "("
            + MIN_RANGE + " INTEGER, "
            + MAX_RANGE + " INTEGER, "
            + TAX_RATE + " REAL, "
            + ADDITIONAL_AMOUNT + " INTEGER "
            + ");";
    private static final String SQL_CREATE_TABLE_RENTAL = "CREATE TABLE " + RENTAL_TAX_TABLE + "("
            + MIN_RANGE + " INTEGER, "
            + MAX_RANGE + " INTEGER, "
            + TAX_RATE + " REAL, "
            + ADDITIONAL_AMOUNT + " INTEGER "
            + ");";



    public DbHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQL_CREATE_TABLE_BUSSINESS);
        database.execSQL(SQL_CREATE_TABLE_SALARY);
        database.execSQL(SQL_CREATE_TABLE_RENTAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG,
                "Upgrading the database from version " + oldVersion + " to " + newVersion);
        // clear all data

        db.execSQL("DROP TABLE IF EXISTS " + BUSINESS_TAX_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SALARY_TAX_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RENTAL_TAX_TABLE);

        // recreate the tables
        onCreate(db);
    }


}
