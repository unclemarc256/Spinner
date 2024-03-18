package com.spinner.myspin1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner classSpinner, divSpinner;
    private ArrayAdapter<String> classAdapter, divAdapter;
    private HashMap<String, List<String>> classToDivMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classSpinner = findViewById(R.id.classSpinner);
        divSpinner = findViewById(R.id.divSpinner);

        classToDivMap = new HashMap<>();
        List<String> class1Divs = new ArrayList<>();
        class1Divs.add("Div 1-A");
        class1Divs.add("Div 1-B");
        classToDivMap.put("Class 1", class1Divs);

        List<String> class2Divs = new ArrayList<>();
        class2Divs.add("Div 2-A");
        class2Divs.add("Div 2-B");
        class2Divs.add("Div 2-C");
        class2Divs.add("Div 2-D");
        class2Divs.add("Anything else???");
        classToDivMap.put("Class 2", class2Divs);

        List<String> class01Divs = new ArrayList<>();
        class2Divs.add("Div 1-C");
        classToDivMap.put("Class 01", class1Divs);

        classAdapter = new ArrayAdapter<>(this, R.layout.colorchange, new ArrayList<>(classToDivMap.keySet()));
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);

        divAdapter = new ArrayAdapter<>(this, R.layout.colorchange, new ArrayList<>());
        divAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        divSpinner.setAdapter(divAdapter);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = classSpinner.getSelectedItem().toString();
                List<String> divs = classToDivMap.get(selectedClass);
                divAdapter.clear();
                divAdapter.addAll(divs);
                divSpinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Implementation for onNothingSelected method
                divSpinner.setVisibility(View.GONE);
            }
        });

        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = classSpinner.getSelectedItem().toString();
                String selectedDiv = divSpinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "Class: " + selectedClass + ",  Div: " + selectedDiv, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Implementation for onNothingSelected method
            }
        });
    }
}
