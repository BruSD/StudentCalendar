package brusd.mediummg.StudentCalendar.FragmentCalendar;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import brusd.mediummg.StudentCalendar.DataStoregCalendar;
import brusd.mediummg.StudentCalendar.R;

/**
 * Created by BruSD on 07.10.13.
 */
public class DetailDayFragment extends Fragment {
    private static Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datail_day, container, false);

        activity = getActivity();

        changTargetDay();
        return view;
    }

    public static void changTargetDay(){
        activity.getActionBar().setTitle(DataStoregCalendar.getSelectedDay());


    }
}
