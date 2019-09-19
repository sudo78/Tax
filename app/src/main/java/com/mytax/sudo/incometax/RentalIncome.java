package com.mytax.sudo.incometax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RentalIncome extends AppCompatActivity {

    EditText bi_EditText_MonthlyRent;
    EditText bi_EditText_NumberofMonths;

    TextView bi_TextView_AnnualRent;
    TextView bi_TextView_MonthlyLiability;
    TextView bi_TextView_AnnualLiability;

    DbHelper myDBHelper;
    String RENTAL_TAX_TABLE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_income);
        bi_EditText_MonthlyRent = findViewById(R.id.RentalEdittext);
        bi_EditText_NumberofMonths = findViewById(R.id.MonthsEdittext);

        bi_TextView_AnnualRent = findViewById(R.id.valueAnnualRent);
        bi_TextView_MonthlyLiability = findViewById(R.id.valueMonthlyLiability);
        bi_TextView_AnnualLiability = findViewById(R.id.valueAnnualLiability);

        myDBHelper = new DbHelper(this);
        RENTAL_TAX_TABLE = "rental_tax_table";



    }


    public void CalculateTax_Click(View view) {
        double rent = myDBHelper.checkValues(bi_EditText_MonthlyRent.getText().toString());
        double months = myDBHelper.checkValues(bi_EditText_NumberofMonths.getText().toString());

        //check for critical value i.e rent.

        double annualRent = rent*months;
        DataClass rentalTaxData = null;
        double tax = 0;

        ArrayList<DataClass> dataList = myDBHelper.getTaxRow(annualRent,RENTAL_TAX_TABLE);

        if(dataList.size() > 0){
            rentalTaxData = dataList.get(0);
        }
        else{
            //show error message
        }

        tax = myDBHelper.getTax(annualRent, rentalTaxData);

        bi_TextView_AnnualRent.setText(String.valueOf(new DecimalFormat("##.##").format((annualRent))));


        /*if(annualRent > 0 && annualRent < 200000)
        {
            tax = 0;
        }
        else if (annualRent > 200000 && annualRent < 600000)
        {
            tax = annualRent - 200000;
            tax = tax* 0.05;
        }

        else if (annualRent > 600000 && annualRent < 1000000)
        {
            tax = annualRent - 600000;
            tax =(tax * 0.1) + 20000;
        }

        else if (annualRent > 600000 && annualRent < 1000000)
        {
            tax = annualRent - 600000;
            tax = (tax * 0.1) + 20000;
        }

        else if (annualRent > 1000000 && annualRent < 2000000)
        {
            tax = annualRent - 1000000;
            tax = (tax * 0.15) + 60000;
        }

        else if (annualRent > 2000000)
        {
            tax = annualRent - 2000000;
            tax = (tax * 0.2) + 210000;
        }*/
        if(tax == 0)
        {
            bi_TextView_MonthlyLiability.setText("No Tax");
            bi_TextView_AnnualLiability.setText("No Tax");
        }
        else
        {
            bi_TextView_MonthlyLiability.setText(String.valueOf(new DecimalFormat("##.##").format(tax/months)));
            bi_TextView_AnnualLiability.setText(String.valueOf(new DecimalFormat("##.##").format((tax))));

        }


    }
}
