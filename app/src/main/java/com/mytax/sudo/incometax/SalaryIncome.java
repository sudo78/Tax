package com.mytax.sudo.incometax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SalaryIncome extends AppCompatActivity {

    EditText bi_EditText_MonthlySalary;
    EditText bi_EditText_Allownaces;
    EditText bi_EditText_MedAllownaces;

    TextView bi_TextView_Annual;
    TextView bi_TextView_Taxable;
    TextView bi_TextView_TaxLiability;
    TextView bi_TextView_SeniorRebate;
    TextView bi_TextView_NetLiability;

    DbHelper myDBHelper;
    String SALARY_TAX_TABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_income);
        bi_EditText_MonthlySalary = findViewById(R.id.SalaryEditText);
        bi_EditText_Allownaces = findViewById(R.id.AllowanceEditText);
        bi_EditText_MedAllownaces = findViewById(R.id.MedAllowanceEditText);

        bi_TextView_Annual = findViewById(R.id.valueAnnualSalary);
        bi_TextView_Taxable = findViewById(R.id.valueTaxableAmount);
        bi_TextView_TaxLiability = findViewById(R.id.valueTaxLiability);
        bi_TextView_SeniorRebate = findViewById(R.id.valueSeniorRebate);
        bi_TextView_NetLiability = findViewById(R.id.valueNetLiability);

        myDBHelper = new DbHelper(this);
        SALARY_TAX_TABLE = "salary_tax_table";




    }


    /*private double checkValues(String value){
        if(!TextUtils.isEmpty(value))
            return Double.parseDouble(value);
        else
            return 0;
    }*/

    public void CalculateTax_Click(View view) {


        double basic = myDBHelper.checkValues(bi_EditText_MonthlySalary.getText().toString());
        double allowances = myDBHelper.checkValues(bi_EditText_Allownaces.getText().toString());
        double medAllowances = myDBHelper.checkValues(bi_EditText_MedAllownaces.getText().toString());

        DataClass salaryTaxData = null;


        if(basic == 0)
        {
            //show error message and ask to enter values again
        }

        double taxable = (basic + allowances) * 12;
        double annualSalary = (basic + allowances + medAllowances)*12;
        double tax = 0;

        ArrayList<DataClass> dataList = myDBHelper.getTaxRow(taxable, SALARY_TAX_TABLE);

        if(dataList.size() > 0) {
            salaryTaxData = dataList.get(0);
        }
        else {
            //show error box here
        }

        tax = myDBHelper.getTax(taxable, salaryTaxData);

        bi_TextView_Annual.setText(String.valueOf(new DecimalFormat("##.##").format((annualSalary))));
        bi_TextView_Taxable.setText(String.valueOf(new DecimalFormat("##.##").format((taxable))));


        /*if(taxable <= 40000)
        {
            tax = 0;
        }
        else if(taxable >= 400001 && taxable <= 500000)
        {
            tax = taxable - 400000;
            tax = tax*0.02;
        }
        else if(taxable >= 500001 && taxable <= 750000)
        {
            tax = taxable - 500000;
            tax = (tax * 0.05) + 2000;
        }
        else if(taxable >= 750001 && taxable <= 1400000)
        {
            tax = taxable - 750000;
            tax = (tax * 0.1) + 14500;
        }
        else if(taxable >= 1400001 && taxable <= 1500000)
        {
            tax = taxable - 1400000;
            tax = (tax * 0.125) + 79500;
        }
        else if(taxable >= 1500001 && taxable <= 1800000)
        {
            tax = taxable - 1500000;
            tax = (tax * 0.15) + 92000;
        }
        else if (taxable >= 1800001 && taxable <= 2500000)
        {
            tax = taxable - 1800000;
            tax = (tax * 0.175) + 137000;
        }
        else if (taxable >= 2500001 && taxable <= 3000000)
        {
            tax = taxable - 2500000;
            tax = (tax * 0.20) + 259500;
        }
        else if (taxable >= 3000001 && taxable <= 3500000)
        {
            tax = taxable - 3000000;
            tax = (tax * 0.225) + 359500;
        }
        else if (taxable >= 3500001 && taxable <= 4000000)
        {
            tax = taxable - 3500000;
            tax = (tax * 0.25) + 472000;
        }
        else if (taxable >= 4000001 && taxable <= 7000000)
        {
            tax = taxable - 4000000;
            tax = (tax * 0.275) + 597000;
        }
        else if (taxable >= 7000001 )
        {
            tax = taxable - 7000000;
            tax = (tax * 0.30) + 1422000;
        }*/


        if(tax == 0)
        {
            bi_TextView_TaxLiability.setText("No Tax");
            bi_TextView_NetLiability.setText("No Tax");

        }
        else
        {
            bi_TextView_TaxLiability.setText(String.valueOf(new DecimalFormat("##.##").format((tax))));
            bi_TextView_NetLiability.setText(String.valueOf(new DecimalFormat("##.##").format((tax))));


        }


    }
}

