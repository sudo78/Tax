/*
package com.mytax.ayaz.incometax;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

*/
/**
 * Created by Ayaz on 5/2/2018.
 *//*


 class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tax.db";

    private static final String BUSINESS_TAX_TABLE = "business_tax_table";
    private static final String SALARY_TAX_TABLE = "salary_tax_table";
    private static final String RENTAL_TAX_TABLE = "rental_tax_table";

    private static final String MIN_RANGE = "min_range";
    private static final String MAX_RANGE = "max_range";
    private static final String TAX_RATE = "tax_rate";
    private static final String ADDITIONAL_AMOUNT = "additional_amount";

    private SQLiteDatabase mDatabase;
    private DbHandler myDbHandler;



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


    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_BUSSINESS);
        db.execSQL(SQL_CREATE_TABLE_SALARY);
        db.execSQL(SQL_CREATE_TABLE_RENTAL);
//        db.execSQL("CREATE TABLE " + BUSINESS_TAX_TABLE + "( "+ MIN_RANGE +"INTEGER , " +
//                " "+MAX_RANGE+" INTEGER, "+TAX_RATE+" REAL, "+ADDITIONAL_AMOUNT+"INTEGER )");

//        db.execSQL("CREATE TABLE " + SALARY_TAX_TABLE + "( "+ MIN_RANGE +"INTEGER , " +
//                " "+MAX_RANGE+" INTEGER, "+TAX_RATE+" REAL, "+ADDITIONAL_AMOUNT+"INTEGER )");
//
//        db.execSQL("CREATE TABLE " + RENTAL_TAX_TABLE + "( "+ MIN_RANGE +"INTEGER , " +
//                " "+MAX_RANGE+" INTEGER, "+TAX_RATE+" REAL, "+ADDITIONAL_AMOUNT+"INTEGER )");

        populateBusinessTaxTable();
        populateSalaryTaxTable();
        populateRentalTaxTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " +BUSINESS_TAX_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " +SALARY_TAX_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " +RENTAL_TAX_TABLE);

        onCreate(db);
    }

    public void populateBusinessTaxTable(){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(MIN_RANGE, 0);
        content.put(MAX_RANGE, 400000);
        content.put(TAX_RATE, 0.00);
        content.put(ADDITIONAL_AMOUNT,0);
        db.insert(BUSINESS_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 400000);
        content.put(MAX_RANGE, 500000);
        content.put(TAX_RATE, 7.00);
        content.put(ADDITIONAL_AMOUNT,0);
        db.insert(BUSINESS_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 500001);
        content.put(MAX_RANGE, 750000);
        content.put(TAX_RATE, 10.00);
        content.put(ADDITIONAL_AMOUNT, 7000);
        db.insert(BUSINESS_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 750001);
        content.put(MAX_RANGE, 1500000);
        content.put(TAX_RATE, 15.00);
        content.put(ADDITIONAL_AMOUNT, 32000);
        db.insert(BUSINESS_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1500001);
        content.put(MAX_RANGE, 2500000);
        content.put(TAX_RATE, 20.50);
        content.put(ADDITIONAL_AMOUNT, 144500);
        db.insert(BUSINESS_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 2500001);
        content.put(MAX_RANGE, 4000000);
        content.put(TAX_RATE, 25.00);
        content.put(ADDITIONAL_AMOUNT, 344500);
        db.insert(BUSINESS_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 4000001);
        content.put(MAX_RANGE, 6000000);
        content.put(TAX_RATE, 30.00);
        content.put(ADDITIONAL_AMOUNT, 719500);
        db.insert(BUSINESS_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 6000001);
        content.put(MAX_RANGE, 10000000);
        content.put(TAX_RATE, 35.00);
        content.put(ADDITIONAL_AMOUNT, 1319500);
        db.insert(BUSINESS_TAX_TABLE, null, content);

    }


    public void populateSalaryTaxTable(){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(MIN_RANGE, 0);
        content.put(MAX_RANGE, 400000);
        content.put(TAX_RATE, 0.00);
        content.put(ADDITIONAL_AMOUNT,0);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 400000);
        content.put(MAX_RANGE, 500000);
        content.put(TAX_RATE, 2.00);
        content.put(ADDITIONAL_AMOUNT,0);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 500001);
        content.put(MAX_RANGE, 750000);
        content.put(TAX_RATE, 5.00);
        content.put(ADDITIONAL_AMOUNT, 2000);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 750001);
        content.put(MAX_RANGE, 1400000);
        content.put(TAX_RATE, 10.00);
        content.put(ADDITIONAL_AMOUNT, 14500);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1400001);
        content.put(MAX_RANGE, 1500000);
        content.put(TAX_RATE, 12.50);
        content.put(ADDITIONAL_AMOUNT, 79500);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1500001);
        content.put(MAX_RANGE, 1800000);
        content.put(TAX_RATE, 15.00);
        content.put(ADDITIONAL_AMOUNT, 92000);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1800001);
        content.put(MAX_RANGE, 2500000);
        content.put(TAX_RATE, 17.00);
        content.put(ADDITIONAL_AMOUNT, 137000);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 2500001);
        content.put(MAX_RANGE, 3000000);
        content.put(TAX_RATE, 20.00);
        content.put(ADDITIONAL_AMOUNT, 259500);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 3000001);
        content.put(MAX_RANGE, 3500000);
        content.put(TAX_RATE, 22.50);
        content.put(ADDITIONAL_AMOUNT, 359500);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 3500001);
        content.put(MAX_RANGE, 4000000);
        content.put(TAX_RATE, 25.00);
        content.put(ADDITIONAL_AMOUNT, 472500);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 4000001);
        content.put(MAX_RANGE, 7000000);
        content.put(TAX_RATE, 27.50);
        content.put(ADDITIONAL_AMOUNT, 597000);
        db.insert(SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 7000000);
        content.put(MAX_RANGE, 10000000);
        content.put(TAX_RATE, 30.00);
        content.put(ADDITIONAL_AMOUNT, 1422000);
        db.insert(SALARY_TAX_TABLE, null, content);

    }


    public void populateRentalTaxTable(){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(MIN_RANGE, 0);
        content.put(MAX_RANGE, 200000);
        content.put(TAX_RATE, 0.00);
        content.put(ADDITIONAL_AMOUNT,0);
        db.insert(RENTAL_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 200001);
        content.put(MAX_RANGE, 600000);
        content.put(TAX_RATE, 5.00);
        content.put(ADDITIONAL_AMOUNT,0);
        db.insert(RENTAL_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 600001);
        content.put(MAX_RANGE, 1000000);
        content.put(TAX_RATE, 10.00);
        content.put(ADDITIONAL_AMOUNT, 20000);
        db.insert(RENTAL_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1000001);
        content.put(MAX_RANGE, 2000000);
        content.put(TAX_RATE, 15.00);
        content.put(ADDITIONAL_AMOUNT, 60000);
        db.insert(RENTAL_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 2000001);
        content.put(MAX_RANGE, 10000000);
        content.put(TAX_RATE, 20.00);
        content.put(ADDITIONAL_AMOUNT, 21000);
        db.insert(RENTAL_TAX_TABLE, null, content);

    }

    public void open() throws SQLException {
        mDatabase = myDbHandler.getWritableDatabase();
    }

    public ArrayList<DataClass> getBusinessRow(double amount, String table_name){

        ArrayList<DataClass> dataList =  new ArrayList<>();
        Cursor cursor = null;
        try {
            open();
            String query = "select * from " + table_name +
                    " where " + amount + " >= " + MIN_RANGE + " AND " + amount + " <= " + MAX_RANGE;
            cursor = db.rawQuery(query, null);

            if (cursor != null) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    DataClass carts = cursorToUsers(cursor);
                    dataList.add(carts);
                    cursor.moveToNext();
                }

                // make sure to close the cursor
                cursor.close();
            }
        }
        catch(Exception e)
        {
            Log.w("",e);
        }
        return dataList;
    }
    public  SQLiteDatabase open() throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();
        return db;
    }
}
*/
