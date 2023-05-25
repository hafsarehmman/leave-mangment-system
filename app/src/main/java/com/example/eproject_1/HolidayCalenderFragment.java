package com.example.eproject_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class HolidayCalenderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CalendarView calendarView;

        View v = inflater.inflate(R.layout.fragment_holiday_calender, container, false);

//                calendarView =v.findViewById(R.id.calendar_view);
//                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//                    @Override
//                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                        // Convert the selected date to a Calendar object
//                        Calendar selectedDate = Calendar.getInstance();
//                        selectedDate.set(year, month, dayOfMonth);
//
//                        // Fetch the list of applied leaves for the selected date
//                        fetchAppliedLeaves(selectedDate.getTime());
//                    }
//               });
return v;
   }}
//
//            private void fetchAppliedLeaves(Date selectedDate) {
//                // Create a request queue using Volley
//                RequestQueue requestQueue= Volley.newRequestQueue(getContext());
//
//                // Define the API endpoint URL for fetching applied leaves
//                String url = "http://your-api-endpoint.com/applied_leaves";
//
//                // Create the request parameters with the selected date
//                Map<String, String> params = new HashMap<>();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//                params.put("selected_date", sdf.format(selectedDate));
//                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Parse the response and process the applied leaves
//                                List<Leave> appliedLeaves = pa(response);
//                                processAppliedLeaves(appliedLeaves);
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//
//                        Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }){
//
//            private List<Leave> parseAppliedLeavesResponse(String response) {
//                // Parse the JSON response and convert it to a list of Leave objects
//                List<Leave> appliedLeaves = new ArrayList<>();
//                // Implement the parsing logic based on your API response structure
//                // Add parsed Leave objects to the appliedLeaves list
//                return appliedLeaves;
//            }
//
//            private void processAppliedLeaves(List<Leave> appliedLeaves) {
//                // Process the applied leaves
//                if (!appliedLeaves.isEmpty()) {
//                    // Apply styling or color to the calendar dates to indicate applied leaves
//                    for (Leave leave : appliedLeaves) {
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.setTime(leave.getDate());
//                        int year = calendar.get(Calendar.YEAR);
//                        int month = calendar.get(Calendar.MONTH);
//                        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//                        calendar.setText(year, month, dayOfMonth, R.style.AppliedLeaveTextStyle);
//                    }
//                }
//            }
//        }



