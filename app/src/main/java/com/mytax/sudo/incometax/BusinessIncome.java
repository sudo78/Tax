package com.mytax.sudo.incometax;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BusinessIncome extends AppCompatActivity {

    DbHelper myDBHelper;
    EditText bi_EditText;
    TextView bi_TextView_Annual;
    TextView bi_TextView_Taxable;
    TextView bi_TextView_Total;
    Button bi_btn_OK;
    String BUSINESS_TAX_TABLE;
    Dialog myDialog;
    LayoutInflater layoutInflater;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_income);
        bi_EditText = findViewById(R.id.edittext);
//        bi_TextView_Annual = findViewById(R.id.valueAnnualIncome);
//        bi_TextView_Taxable = findViewById(R.id.valueTaxableAmount);
//        bi_TextView_Total = findViewById(R.id.valueTotalTax);
        myDBHelper = new DbHelper(this);
        BUSINESS_TAX_TABLE = "business_tax_table";

        layoutInflater = (LayoutInflater) BusinessIncome.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    public void CalculateTax_Click(View view) {
        double basic = Double.parseDouble(bi_EditText.getText().toString());
        double taxable = basic;
        double tax = 0;
        DataClass taxData = null;

        ArrayList<DataClass> dataList = myDBHelper.getTaxRow(taxable, BUSINESS_TAX_TABLE);

        if(dataList.size() > 0) {
            taxData = dataList.get(0);
        }
        else {
            //show error box here
        }
        tax = myDBHelper.getTax(taxable, taxData);

        CustomDialog(taxable,tax);


//        bi_TextView_Total.setText(String.valueOf(min));

//        bi_TextView_Annual.setText(String.valueOf(new DecimalFormat("##.##").format((taxable))));
//        bi_TextView_Taxable.setText(String.valueOf(new DecimalFormat("##.##").format((taxable))));




       /* if(taxable <= 40000)
        {
            tax = 0;
        }
        else if(taxable >= 400001 && taxable <= 5000000)
        {
            tax = taxable - 400000;
            tax = tax*0.07;
        }
        else if(taxable >= 500001 && taxable <= 750000)
        {
            tax = taxable - 500000;
            tax = (tax * 0.1) + 7000;
        }
        else if(taxable >= 750001 && taxable <= 1500000)
        {
            tax = taxable - 750000;
            tax = (tax * 0.15) + 32000;
        }
        else if(taxable >= 1500001 && taxable <= 2500000)
        {
            tax = taxable - 1500000;
            tax = (tax * 0.20) + 144500;
        }
        else if(taxable >= 2500001 && taxable <= 4000000)
        {
            tax = taxable - 2500001;
            tax = (tax * 0.25) + 344500;
        }
        else if(taxable >= 4000001 && taxable <= 6000000)
        {
            tax = taxable - 4000000;
            tax = (tax * 0.30) + 719500;
        }
        else if(taxable >= 6000001)
        {
            tax = taxable - 60000001;
            tax = (tax * 0.35) + 1319500;
        }
*/
//        if(tax == 0)
//        {
//            bi_TextView_Total.setText("No Tax");
//        }
//        else
//        {
//            bi_TextView_Total.setText(String.valueOf(new DecimalFormat("##.##").format((tax))));
//
//
//        }


    }

//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//
//        View view = null;
//    }



    public void CustomDialog(double taxable, double tax)
    {

//        View view = null;
//        if(view == null)
//            view = layoutInflater.inflate(R.layout.business_income_custom_dialog, null);
//        else
//            return;
//
//        view.findViewById(R.id.textAnnualIncome)

        myDialog = new Dialog(BusinessIncome.this);
        myDialog.setContentView(R.layout.business_income_custom_dialog);
        myDialog.setTitle("Business Income Tax Calculation");

        bi_TextView_Annual = myDialog.findViewById(R.id.valueAnnualIncome);
        bi_TextView_Taxable = myDialog.findViewById(R.id.valueTaxableAmount);
        bi_TextView_Total = myDialog.findViewById(R.id.valueTotalTax);
        //bi_btn_OK = (Button)myDialog.findViewById(R.id.bt);

        bi_TextView_Annual.setText(String.valueOf(new DecimalFormat("##.##").format((taxable))));
        bi_TextView_Taxable.setText(String.valueOf(new DecimalFormat("##.##").format((taxable))));

        if(tax == 0)
        {
            bi_TextView_Total.setText("No Tax");
        }
        else
        {
            bi_TextView_Total.setText(String.valueOf(new DecimalFormat("##.##").format((tax))));

        }

        myDialog.show();



    }

    /*public double getTax(double taxable, DataClass taxData) {
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
    }*/
}
