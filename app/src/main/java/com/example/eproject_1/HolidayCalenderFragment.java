package com.example.eproject_1;

import android.graphics.Paint;
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
    CalendarView calendarView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_holiday_calender, container, false);
//        ColoredCalendarView calendarView =v.findViewById(R.id.calendarView);
//        List<LeaveEvent> leaveEvents = new ArrayList<>();leaveEvents.add(new
//                LeaveEvent(2023, 4, 15, Color.RED));leaveEvents.add(new LeaveEvent(2023, 4, 20,
//                Color.BLUE));// Add more leave events as needed
//        calendarView.setLeaveEvents(leaveEvents);
//
//        Calendar day, RectF cellRect,
//        boolean isSelected) {
//            super.onDrawDayCell(canvas, day, cellRect, isSelected);
//
//            // Determine the date of the current cell
//            int year = day.get(Calendar.YEAR);
//            int month = day.get(Calendar.MONTH);
//            int dayOfMonth = day.get(Calendar.DAY_OF_MONTH);
//
//            for (LeaveEvent leaveEvent : leaveEvents) {
//                // Check if the leave event matches the current cell's date
//                if (leaveEvent.getYear() == year && leaveEvent.getMonth() == month &&
//                        leaveEvent.getDay() == dayOfMonth) {
//                    Paint paint = new Paint();
//                    paint.setColor(leaveEvent.getColor());
//
//                    // Draw a rectangle with the leave event's color
//                    canvas.drawRect(cellRect, paint);
//                    break;
//                }
//            }
//        }
//    }
return v;
   }}
//
//
//
