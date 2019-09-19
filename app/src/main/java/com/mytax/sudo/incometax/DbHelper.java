package com.mytax.sudo.incometax;

/**
 * Created by Ayaz on 5/28/2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

public class DbHelper {
    public static final String TAG = "UserDatabase";

    // Database fields
    private SQLiteDatabase mDatabase;
    private DbHandler myDbHandler;
    private Context mContext;
    public static final String MIN_RANGE = "min_range";
    public static final String MAX_RANGE = "max_range";
    public static final String TAX_RATE = "tax_rate";
    public static final String ADDITIONAL_AMOUNT = "additional_amount";

//    private String[] mAllColumns = {DbHandler.COLUMN_USER_ID,
//            DbHandler.COLUMN_USER_NAME, DbHandler.COLUMN_PASSWORD, DbHandler.COLUMN_EMAIL};

    public DbHelper(Context context) {
        this.mContext = context;
        myDbHandler = new DbHandler(context);
        // open the database
        try {
                open();
                populateBusinessTaxTable();
                populateSalaryTaxTable();
                populateRentalTaxTable();
        }

        catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        mDatabase = myDbHandler.getWritableDatabase();
    }

    public void close() {
        myDbHandler.close();
    }

    public void populateBusinessTaxTable(){
        open();
        ContentValues content = new ContentValues();

        content.put(MIN_RANGE, 0);
        content.put(MAX_RANGE, 400000);
        content.put(TAX_RATE, 0.00);
        content.put(ADDITIONAL_AMOUNT,0);
        mDatabase.insert(myDbHandler.BUSINESS_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 400000);
        content.put(MAX_RANGE, 500000);
        content.put(TAX_RATE, 7.00);
        content.put(ADDITIONAL_AMOUNT,0);
        mDatabase.insert(myDbHandler.BUSINESS_TAX_TABLE, null, content);


        content.put(MIN_RANGE, 500001);
        content.put(MAX_RANGE, 750000);
        content.put(TAX_RATE, 10.00);
        content.put(ADDITIONAL_AMOUNT, 7000);
        mDatabase.insert(myDbHandler.BUSINESS_TAX_TABLE, null, content);


        content.put(MIN_RANGE, 750001);
        content.put(MAX_RANGE, 1500000);
        content.put(TAX_RATE, 15.00);
        content.put(ADDITIONAL_AMOUNT, 32000);
        mDatabase.insert(myDbHandler.BUSINESS_TAX_TABLE, null, content);


        content.put(MIN_RANGE, 1500001);
        content.put(MAX_RANGE, 2500000);
        content.put(TAX_RATE, 20.50);
        content.put(ADDITIONAL_AMOUNT, 144500);
        mDatabase.insert(myDbHandler.BUSINESS_TAX_TABLE, null, content);


        content.put(MIN_RANGE, 2500001);
        content.put(MAX_RANGE, 4000000);
        content.put(TAX_RATE, 25.00);
        content.put(ADDITIONAL_AMOUNT, 344500);
        mDatabase.insert(myDbHandler.BUSINESS_TAX_TABLE, null, content);


        content.put(MIN_RANGE, 4000001);
        content.put(MAX_RANGE, 6000000);
        content.put(TAX_RATE, 30.00);
        content.put(ADDITIONAL_AMOUNT, 719500);
        mDatabase.insert(myDbHandler.BUSINESS_TAX_TABLE, null, content);


        content.put(MIN_RANGE, 6000001);
        content.put(MAX_RANGE, 10000000);
        content.put(TAX_RATE, 35.00);
        content.put(ADDITIONAL_AMOUNT, 1319500);
        mDatabase.insert(myDbHandler.BUSINESS_TAX_TABLE, null, content);


    }

    public void populateSalaryTaxTable(){

        open();
        ContentValues content = new ContentValues();

        content.put(MIN_RANGE, 0);
        content.put(MAX_RANGE, 400000);
        content.put(TAX_RATE, 0.00);
        content.put(ADDITIONAL_AMOUNT,0);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 400000);
        content.put(MAX_RANGE, 500000);
        content.put(TAX_RATE, 2.00);
        content.put(ADDITIONAL_AMOUNT,0);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 500001);
        content.put(MAX_RANGE, 750000);
        content.put(TAX_RATE, 5.00);
        content.put(ADDITIONAL_AMOUNT, 2000);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 750001);
        content.put(MAX_RANGE, 1400000);
        content.put(TAX_RATE, 10.00);
        content.put(ADDITIONAL_AMOUNT, 14500);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1400001);
        content.put(MAX_RANGE, 1500000);
        content.put(TAX_RATE, 12.50);
        content.put(ADDITIONAL_AMOUNT, 79500);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1500001);
        content.put(MAX_RANGE, 1800000);
        content.put(TAX_RATE, 15.00);
        content.put(ADDITIONAL_AMOUNT, 92000);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1800001);
        content.put(MAX_RANGE, 2500000);
        content.put(TAX_RATE, 17.00);
        content.put(ADDITIONAL_AMOUNT, 137000);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 2500001);
        content.put(MAX_RANGE, 3000000);
        content.put(TAX_RATE, 20.00);
        content.put(ADDITIONAL_AMOUNT, 259500);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 3000001);
        content.put(MAX_RANGE, 3500000);
        content.put(TAX_RATE, 22.50);
        content.put(ADDITIONAL_AMOUNT, 359500);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 3500001);
        content.put(MAX_RANGE, 4000000);
        content.put(TAX_RATE, 25.00);
        content.put(ADDITIONAL_AMOUNT, 472500);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 4000001);
        content.put(MAX_RANGE, 7000000);
        content.put(TAX_RATE, 27.50);
        content.put(ADDITIONAL_AMOUNT, 597000);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 7000000);
        content.put(MAX_RANGE, 10000000);
        content.put(TAX_RATE, 30.00);
        content.put(ADDITIONAL_AMOUNT, 1422000);
        mDatabase.insert(myDbHandler.SALARY_TAX_TABLE, null, content);

    }


    public void populateRentalTaxTable(){

         open();
        ContentValues content = new ContentValues();

        content.put(MIN_RANGE, 0);
        content.put(MAX_RANGE, 200000);
        content.put(TAX_RATE, 0.00);
        content.put(ADDITIONAL_AMOUNT,0);
        mDatabase.insert(myDbHandler.RENTAL_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 200001);
        content.put(MAX_RANGE, 600000);
        content.put(TAX_RATE, 5.00);
        content.put(ADDITIONAL_AMOUNT,0);
        mDatabase.insert(myDbHandler.RENTAL_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 600001);
        content.put(MAX_RANGE, 1000000);
        content.put(TAX_RATE, 10.00);
        content.put(ADDITIONAL_AMOUNT, 20000);
        mDatabase.insert(myDbHandler.RENTAL_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 1000001);
        content.put(MAX_RANGE, 2000000);
        content.put(TAX_RATE, 15.00);
        content.put(ADDITIONAL_AMOUNT, 60000);
        mDatabase.insert(myDbHandler.RENTAL_TAX_TABLE, null, content);

        content.put(MIN_RANGE, 2000001);
        content.put(MAX_RANGE, 10000000);
        content.put(TAX_RATE, 20.00);
        content.put(ADDITIONAL_AMOUNT, 21000);
        mDatabase.insert(myDbHandler.RENTAL_TAX_TABLE, null, content);

    }




    public ArrayList<DataClass> getTaxRow(double amount, String table_name){

        ArrayList<DataClass> dataList =  new ArrayList<>();
        Cursor cursor = null;
        try {
            open();
            String query = "select * from " + table_name +
                    " where " + amount + " >= " + MIN_RANGE + " AND " + amount + " <= " + MAX_RANGE;
            cursor = mDatabase.rawQuery(query, null);

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
    protected DataClass cursorToUsers(Cursor cursor) {
        DataClass user = new DataClass();
        user.setMinimumRange(cursor.getInt(0));
        user.setMaximumRange(cursor.getInt(1));
        user.setTaxRate(cursor.getDouble(2));
        user.setAdditionalAmount(cursor.getInt(3));
        return user;
    }

    public double getTax(double taxable, DataClass taxData) {
        double tax = 0;
        if(taxData.getTaxRate() == 0)
        {
            return tax;
        }
        else {
            tax = taxable - taxData.getMinimumRange();
            tax = (tax * (taxData.getTaxRate() / 100)) + taxData.getAdditionalAmount();
        }
        return tax;
    }

    public double checkValues(String value){
        if(!TextUtils.isEmpty(value))
            return Double.parseDouble(value);
        else
            return 0;
    }
//    public ArrayList getAllCarts() {
//        this.open();
//        ArrayList userList = new ArrayList();
//
//        Cursor cursor = mDatabase.query(myDbHandler.BUSINESS_TAX_TABLE, mAllColumns,
//                null, null, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                User carts = cursorToUsers(cursor);
//                userList.add(carts);
//                cursor.moveToNext();
//            }
//
//            // make sure to close the cursor
//            cursor.close();
//        }
//        return userList;
//    }
}
