package com.example.musicplayer;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class chart extends Fragment {

    public chart() {
        // Required empty public constructor
    }
    LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_chart, container, false);
        lineChart = (LineChart) v.findViewById(R.id.lineChart);
        Description description = new Description();
        description.setText("Stress Management using Music Generated Data Graph");
        lineChart.setDescription(description);
        ArrayList<String> xAXES = new ArrayList<>();
        ArrayList<Entry> yAXESsin = new ArrayList<>();
        ArrayList<Entry> yAXEScos = new ArrayList<>();
        float x = 0;
        int numDataPoints = 1000;
        for (int i = 0; i < numDataPoints; i++) {
            float sinFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
            float cosFunction = Float.parseFloat(String.valueOf(Math.cos(x)));


            Entry sinE = new Entry(x, sinFunction);
            yAXESsin.add(sinE);
            Entry cosE = new Entry(x, cosFunction);
            yAXEScos.add(cosE);
            x = x + 0.1f;
        }
        String[] xaxes = new String[xAXES.size()];


        ArrayList<ILineDataSet> lineDataSets = new ArrayList<ILineDataSet>();
        LineDataSet lineDataSet1 = new LineDataSet(yAXEScos, "phasic skin conductance");
        lineDataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);

        LineDataSet lineDataSet2 = new LineDataSet(yAXESsin, "tonic skin conductance");
        lineDataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.RED);

        lineDataSets.add(lineDataSet1);
        lineDataSets.add(lineDataSet2);

        LineData data = new LineData(lineDataSets);
        lineChart.setData(data);
        lineChart.invalidate();
//        lineChart.setData(new LineData(lineDataSets));
        lineChart.setVisibleXRangeMaximum(65f);
        Legend legend = lineChart.getLegend();
        legend.setTextSize(20);
        legend.setWordWrapEnabled(true);
        return v;
    }
}
