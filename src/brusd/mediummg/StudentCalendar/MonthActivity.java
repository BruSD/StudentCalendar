package brusd.mediummg.StudentCalendar;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;

import brusd.mediummg.StudentCalendar.FragmentCalendar.DetailDayFragment;

public class MonthActivity extends Activity {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            getActionBar().hide();
            setContentView(R.layout.main);

        }else {
            setContentView(R.layout.main);

            Fragment newFragment = new DetailDayFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.day_or_pair_frame, newFragment).commit();

        }



    }
}
