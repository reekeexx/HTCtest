package com.example.htc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private RecyclerView employeeList;
    private CompanyView companyView;
    private List<Employee> employees;
    private EmployeeAdapter adapter;

    private TextView companyName;
    private TextView companyAge;
    private TextView companyCompetences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyTask task = new MyTask();
        task.execute("https://www.mocky.io/v2/5ddcd3673400005800eae483");
    }

    private class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    content.append(inputLine.trim());
                }
            } catch (Exception e) {
                e.printStackTrace();;
            }
            return content.toString();
        }

        @Override
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            companyView = JsonParser.getCompanyView(result);
            employees = companyView.getCompany().getEmployees();
            Collections.sort(employees);
            employeeList = findViewById(R.id.employeeList);
            adapter = new EmployeeAdapter(MainActivity.this, employees);
            employeeList.setAdapter(adapter);

            companyName = findViewById(R.id.companyName);
            companyAge = findViewById(R.id.companyAge);
            companyCompetences = findViewById(R.id.companyCompetences);
            companyName.setText(companyView.getCompany().getName());
            companyAge.setText(String.valueOf(companyView.getCompany().getAge()));
            companyCompetences.setText(companyView.getCompany().getCompetences().toString());
        }
    }
}