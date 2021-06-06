package com.example.htc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Employee> employees;

    public EmployeeAdapter(Context context, List<Employee> employees) {
        this.employees = employees;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.employee_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeAdapter.ViewHolder holder, int position) {
        Employee employee = employees.get(position);
        if (employee.getName() != null) {
            holder.employeeName.setText(employee.getName());
        } else {
            holder.employeeName.setText("none");
        }
        if (employee.getPhone_number() != 0) {
            holder.employeePhoneNumber.setText(String.valueOf(employee.getPhone_number()));
        } else {
            holder.employeePhoneNumber.setText("none");
        }
        if (employee.getSkills() != null) {
            holder.employeeSkills.setText(employee.getSkills().toString());
        } else {
            holder.employeeSkills.setText("none");
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView employeeName;
        private TextView employeePhoneNumber;
        private TextView employeeSkills;

        public ViewHolder(View view) {
            super(view);
            employeeName = view.findViewById(R.id.employeeName);
            employeePhoneNumber = view.findViewById(R.id.employeePhoneNumber);
            employeeSkills = view.findViewById(R.id.employeeSkills);
        }
    }
}
