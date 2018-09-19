package expensetracker.tejas.expensetrckr19;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class stats extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5,10,5,7);

        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(50f);

        float var = 66f;

        ArrayList<PieEntry> pieValues = new ArrayList<>();

        pieValues.add(new PieEntry(var,"Food"));
        pieValues.add(new PieEntry(45f,"Groceries"));
        pieValues.add(new PieEntry(50f,"Medicines"));
        pieValues.add(new PieEntry(32f,"Movies"));
        pieValues.add(new PieEntry(67f,"Loan"));
        pieValues.add(new PieEntry(35f,"Fuel"));

        PieDataSet dataSet = new PieDataSet(pieValues," Expenses ");
        dataSet.setSliceSpace(5f);
        dataSet.setSelectionShift(10f);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setColors(ColorTemplate.PASTEL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
    }

}
