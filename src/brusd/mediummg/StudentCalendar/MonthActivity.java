package brusd.mediummg.StudentCalendar;




import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;


import brusd.mediummg.StudentCalendar.AppDatabase.AppDB;
import brusd.mediummg.StudentCalendar.AppDatabase.TestData;
import brusd.mediummg.StudentCalendar.FragmentCalendar.DetailDayFragment;

public class MonthActivity extends ActionBarActivity {



    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){


            setContentView(R.layout.main);

        }else {
            setContentView(R.layout.main);

            Fragment newFragment = new DetailDayFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.day_or_pair_frame, newFragment).commit();
        }

        getSupportActionBar();





    }
}
