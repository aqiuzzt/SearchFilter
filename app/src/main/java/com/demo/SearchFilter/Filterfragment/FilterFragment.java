package com.demo.SearchFilter.Filterfragment;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.SearchFilter.KCalendar;
import com.demo.SearchFilter.R;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FilterFragment extends BaseFragment {

    private static final String LOG_TAG = "FilterFragment";


    private RelativeLayout drawer_content;
    private TextView popupwindow_calendar_month;
    private KCalendar calendar;
    private RelativeLayout popupwindow_calendar_next_month, popupwindow_calendar_last_month;

    String date = null;// 设置默认选中的日期 格式为 “2016-07-05” 标准DATE格式


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fiter_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {


        drawer_content = (RelativeLayout) view.findViewById(R.id.drawer_content);

        popupwindow_calendar_month = (TextView) view
                .findViewById(R.id.popupwindow_calendar_month);
        calendar = (KCalendar) view.findViewById(R.id.popupwindow_calendar);


        popupwindow_calendar_last_month = (RelativeLayout) view
                .findViewById(R.id.popupwindow_calendar_last_month);
        popupwindow_calendar_next_month = (RelativeLayout) view
                .findViewById(R.id.popupwindow_calendar_next_month);

        initData();


    }

    /**
     * 初始化数据
     */
    private void initData() {


        popupwindow_calendar_month.setText(calendar.getCalendarYear() + "年" + calendar.getCalendarMonth() + "月");

        if (null != date) {
            int years = Integer.parseInt(date.substring(0, date.indexOf("-")));
            int month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.lastIndexOf("-")));
            popupwindow_calendar_month.setText(years + "年" + month + "月");

            calendar.showCalendar(years, month);
            calendar.setCalendarDayBgColorByStr(date, R.drawable.calendar_date_focused);
        }

        List<String> list = new ArrayList<String>(); // 设置标记列表
        list.add("2016-07-01");
        list.add("2016-07-02");
        calendar.addMarks(list, 0);

        // 监听所选中的日期
        calendar.setOnCalendarClickListener(new KCalendar.OnCalendarClickListener() {

            public void onCalendarClick(int row, int col, String dateFormat) {
                int month = Integer.parseInt(dateFormat.substring(
                        dateFormat.indexOf("-") + 1,
                        dateFormat.lastIndexOf("-")));
                if (calendar.getCalendarMonth() - month == 1// 跨年跳转
                        || calendar.getCalendarMonth() - month == -11) {
                    calendar.lastMonth();

                } else if (month - calendar.getCalendarMonth() == 1 // 跨年跳转
                        || month - calendar.getCalendarMonth() == -11) {
                    calendar.nextMonth();

                } else {
                    calendar.removeAllBgColor();
                    calendar.setCalendarDayBgColorByStr(dateFormat, R.drawable.calendar_date_focused);
                    date = dateFormat;// 最后返回给全局 date
                }
                Toast.makeText(getActivity(), "date:" + date, Toast.LENGTH_SHORT).show();
            }
        });

        // 监听当前月份
        calendar.setOnCalendarDateChangedListener(new KCalendar.OnCalendarDateChangedListener() {
            public void onCalendarDateChanged(int year, int month) {
                popupwindow_calendar_month.setText(year + "年" + month + "月");
            }
        });

        // 上月监听按钮
        popupwindow_calendar_last_month
                .setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        calendar.lastMonth();
                    }

                });

        // 下月监听按钮
        popupwindow_calendar_next_month
                .setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        calendar.nextMonth();
                    }
                });



    }




    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }





}
