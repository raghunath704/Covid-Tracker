package com.raghunath704.covix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private  int positionCountry;

    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        positionCountry=intent.getIntExtra("position",0);

        getSupportActionBar().setTitle(AffectedCountries.counteryModelList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);



        tvCountry=findViewById(R.id.tvCountry);
        tvCases=findViewById(R.id.tvCases);
        tvRecovered=findViewById(R.id.tvRecovered);
        tvCritical=findViewById(R.id.tvCritical);
        tvActive=findViewById(R.id.tvActive);
        tvTodayCases=findViewById(R.id.tvTodayCases);
        tvTotalDeaths=findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths=findViewById(R.id.tvTodayDeaths);

        tvCountry.setText(AffectedCountries.counteryModelList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.counteryModelList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.counteryModelList.get(positionCountry).getRecovered());
        tvCritical.setText(AffectedCountries.counteryModelList.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.counteryModelList.get(positionCountry).getActive());
        tvTodayCases.setText(AffectedCountries.counteryModelList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(AffectedCountries.counteryModelList.get(positionCountry).getDeaaths());
        tvTodayDeaths.setText(AffectedCountries.counteryModelList.get(positionCountry).getTodayDeaths());

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}