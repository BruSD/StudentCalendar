package brusd.mediummg.StudentCalendar.FragmentCalendar;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import brusd.mediummg.StudentCalendar.DataStoregCalendar;
import brusd.mediummg.StudentCalendar.R;

/**
 * Created by BruSD on 07.10.13.
 */
public class DetailDayFragment extends Fragment {
    private static ActionBarActivity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datail_day, container, false);

        activity = (ActionBarActivity) getActivity();

        changTargetDay();
        return view;
    }

    public static void changTargetDay(){
       activity.getSupportActionBar().setTitle(DataStoregCalendar.getSelectedDay());
    }
}
