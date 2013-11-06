package brusd.mediummg.StudentCalendar.FragmentCalendar;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;


import brusd.mediummg.StudentCalendar.AppDatabase.AppDB;
import brusd.mediummg.StudentCalendar.AppDatabase.TestData;
import brusd.mediummg.StudentCalendar.DataStoregCalendar;
import brusd.mediummg.StudentCalendar.R;
import brusd.mediummg.StudentCalendar.SetOfAdaptorsStudent.AdapterDetailsDay;

/**
 * Created by BruSD on 07.10.13.
 */
public class DetailDayFragment extends Fragment {
    private static ActionBarActivity activity;
    private static ListView listOfStudentPair;
    private static AppDB appDB;
    private static ArrayList<HashMap<String, Object>> listFromDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datail_day, container, false);

        activity = (ActionBarActivity) getActivity();

        listOfStudentPair = (ListView)view.findViewById(R.id.list_of_student_pair);

        changTargetDay();




        return view;
    }

    @Override
    public void onStart() {
        super.onStart();





    }

    public static void changTargetDay(){
        activity.getSupportActionBar().setTitle(DataStoregCalendar.getSelectedDay());

        appDB = AppDB.getInstance(activity);
        new TestData().addingTo(appDB);
        int dayNumber = getDayOfWeek(DataStoregCalendar.getSelectedDay());


        listFromDB = appDB.getLessonsFor("Расписание", dayNumber);

        AdapterDetailsDay adapterDetailsDay = new AdapterDetailsDay(activity, listFromDB, R.layout.item_detail_days, null, null);
        listOfStudentPair.setAdapter(adapterDetailsDay);
    }

    private static int getDayOfWeek(String selectedData){
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");

        Date date = null;
        try {
            date = format.parse(selectedData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
