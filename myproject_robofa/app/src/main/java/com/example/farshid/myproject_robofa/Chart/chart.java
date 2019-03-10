package com.example.farshid.myproject_robofa.Chart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Term1;
import com.example.farshid.myproject_robofa.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class chart extends AppCompatActivity {

    BarChart chart;
    ArrayList<BarEntry> BARENTRY;
    ArrayList<String> BarEntryLabels;
    BarDataSet Bardataset;
    BarData BARDATA;
    int col1, col2, col3, col4, col5, col6, col7, col8, col9;
    int ADD1 = 0, ADD2 = 0, ADD3 = 0, ADD4 = 0, ADD5 = 0, ADD6 = 0, ADD7 = 0, ADD8 = 0, ADD9 = 0;
    ImageView idback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mychart);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ADD1 = Integer.parseInt(extras.getString("Weekk1"));
            ADD2 = Integer.parseInt(extras.getString("Weekk2"));
            ADD3 = Integer.parseInt(extras.getString("Weekk3"));
            ADD4 = Integer.parseInt(extras.getString("Weekk4"));
            ADD5 = Integer.parseInt(extras.getString("Weekk5"));
            ADD6 = Integer.parseInt(extras.getString("Weekk6"));
            ADD7 = Integer.parseInt(extras.getString("Weekk7"));
            ADD8 = Integer.parseInt(extras.getString("Weekk8"));
            ADD9 = Integer.parseInt(extras.getString("TERM"));

        }

//        idback = findViewById(R.id.idback);
        chart = (BarChart) findViewById(R.id.chart1);
//        idback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(com.example.farshid.myproject_robofa.Chart.chart.this, Term1.class);
//                startActivity(in);
//                System.exit(0);
//                finish();
//            }
//        });

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();
        SETCOLOR();

        AddValuesToBARENTRY();

        if (ADD9 == 1) {
            AddValuesToBarEntryLabels();
        } else if (ADD9 == 2) {
            AddValuesToBarEntryLabels2();
        }
        Bardataset = new BarDataSet(BARENTRY, "ن ت:قرمز | ق ق:زرد | خ:آبی | خ خ:سبز ");
//        Bardataset.setColor(Color.RED);

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(new int[]{R.color.White, R.color.White,col1, col2, col3, col4, col5, col6, col7, col8}, this);

//        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        Bardataset.setDrawValues(false);

        chart.setDescription("نمودار نمرات دانش آموزان");    // Hide the description
        chart.getAxisRight().setDrawLabels(false);


        chart.getAxisLeft().setDrawLabels(false);


//        activity_mychart.getXAxis().setDrawLabels(false);
//
        chart.getLegend().setEnabled(true);
        chart.setData(BARDATA);
        chart.setTouchEnabled(false);
        chart.setDragEnabled(false);
        chart.animateY(2000);
    }

//    @Override
//    public void onBackPressed() {
//
//    }


    private void SETCOLOR() {
        if (ADD1 > 17) {
            col1 = R.color.Green;
        }
        if (ADD1 > 15 && ADD1 <= 17) {
            col1 = R.color.Blue;
        }
        if (ADD1 <= 15 && ADD1 > 10) {
            col1 = R.color.Black;
        }

        if (ADD1 <= 10) {
            col1 = R.color.RED;
        }




//        2
        if (ADD2 > 17) {
            col2 = R.color.Green;

        }
        if (ADD2 > 15 && ADD2 <= 17) {
            col2 = R.color.Blue;

        }
        if (ADD2 <= 15 && ADD2 > 10) {
            col2 = R.color.Black;

        }
        if (ADD2 <= 10) {
            col2 = R.color.RED;

        }



//        3
        if (ADD3 > 17) {
            col3 = R.color.Green;

        }
        if (ADD3 > 15 && ADD3 <= 17) {
            col3 = R.color.Blue;

        }
        if (ADD3 <= 15 && ADD3 > 10) {
            col3 = R.color.Black;


        }

        if (ADD3 <= 10) {
            col3 = R.color.RED;
        }



//        4
        if (ADD4 > 17) {
            col4 = R.color.Green;
        }
        if (ADD4 > 15 && ADD4 <= 17) {
            col4 = R.color.Blue;

        }
        if (ADD4 <= 15 && ADD4 > 10) {
            col4 = R.color.Black;

        }

        if (ADD4 <= 10) {
            col4 = R.color.RED;

        }




//        5
        if (ADD5 > 17) {
            col5 = R.color.Green;

        }
        if (ADD5 > 15 && ADD5 <= 17) {
            col5 = R.color.Blue;

        }
        if (ADD5 <= 15 && ADD5 > 10) {
            col5 = R.color.Black;

        }
        if (ADD5 <= 10) {
            col5 = R.color.RED;

        }



//        6
        if (ADD6 > 17) {
            col6 = R.color.Green;

        }
        if (ADD6 > 15 && ADD6 <= 17) {
            col6 = R.color.Blue;

        }
        if (ADD6 <= 15 && ADD6 > 10) {
            col6 = R.color.Black;

        }
        if (ADD6 <= 10) {
            col6 = R.color.RED;

        }



//        7
        if (ADD7 > 17) {
            col7 = R.color.Green;

        }
        if (ADD7 > 15 && ADD7 <= 17) {
            col7 = R.color.Blue;

        }
        if (ADD7 <= 15 && ADD7 > 10) {
            col7 = R.color.Black;

        }
        if (ADD7 <= 10) {
            col7 = R.color.RED;

        }




//        8
        if (ADD8 > 17) {
            col8 = R.color.Green;

        }
        if (ADD8 > 15 && ADD8 <= 17) {
            col8 = R.color.Blue;

        }
        if (ADD8 <= 15 && ADD8 > 10) {
            col8 = R.color.Black;

        }
        if (ADD8 <= 10) {
            col8 = R.color.RED;

        }



//        8
        if (ADD9 <= 10) {
            col9 = R.color.RED;
        }
        if (ADD9 <= 15 && ADD9 > 10) {
            col9 = R.color.Black;
        }
        if (ADD9 > 15 && ADD9 <= 17) {
            col9 = R.color.Blue;
        }
        if (ADD9 > 17) {
            col9 = R.color.Green;
        }


    }

    public void AddValuesToBARENTRY() {

        BARENTRY.add(new BarEntry(10, 0));
        BARENTRY.add(new BarEntry(10, 1));
        BARENTRY.add(new BarEntry(ADD1, 2));
        BARENTRY.add(new BarEntry(ADD2, 3));
        BARENTRY.add(new BarEntry(ADD3, 4));
        BARENTRY.add(new BarEntry(ADD4, 5));
        BARENTRY.add(new BarEntry(ADD5, 6));
        BARENTRY.add(new BarEntry(ADD6, 7));
        BARENTRY.add(new BarEntry(ADD7, 8));
        BARENTRY.add(new BarEntry(ADD8, 9));

//        BARENTRY.add(new BarEntry(ADD9, 8));

    }

    public void AddValuesToBarEntryLabels() {
        BarEntryLabels.add("ماه");
        BarEntryLabels.add("ماه");
        BarEntryLabels.add(" مهر");
        BarEntryLabels.add(" مهر");
        BarEntryLabels.add(" آبان");
        BarEntryLabels.add(" آبان");
        BarEntryLabels.add(" آذر");
        BarEntryLabels.add(" آذر");
        BarEntryLabels.add(" دی");
        BarEntryLabels.add(" دی");

    }

    public void AddValuesToBarEntryLabels2() {
        BarEntryLabels.add("ماه");
        BarEntryLabels.add("ماه");
        BarEntryLabels.add("بهمن");
        BarEntryLabels.add("بهمن");
        BarEntryLabels.add("اسفند");
        BarEntryLabels.add("اسفند");
        BarEntryLabels.add("فروردین");
        BarEntryLabels.add("فروردین");
        BarEntryLabels.add("اردی");
        BarEntryLabels.add("اردی");


    }


}
