package com.mytax.sudo.incometax;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class CardViewActivity extends AppCompatActivity implements View.OnClickListener {

    CardView bussinessCard, salaryCard, rentalCard, corporateCard;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        init();
    }

    private void init() {
        context = this;
        bussinessCard = findViewById(R.id.business_tax_card_view);
        salaryCard = findViewById(R.id.salary_tax_card_view);
        rentalCard = findViewById(R.id.rental_tax_card_view);
        bussinessCard.setOnClickListener(this);
        salaryCard.setOnClickListener(this);
        rentalCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.business_tax_card_view:
                Intent businessIncome = new Intent(CardViewActivity.this, BusinessIncome.class);
                startActivity(businessIncome);

                break;
            case R.id.salary_tax_card_view:
                Intent salaryIncome = new Intent(CardViewActivity.this, SalaryIncome.class);
                startActivity(salaryIncome);
                break;
            case R.id.rental_tax_card_view:
                Intent rentalIncome = new Intent(CardViewActivity.this, RentalIncome.class);
                startActivity(rentalIncome);
                break;
            default:
                break;
        }
    }
}
