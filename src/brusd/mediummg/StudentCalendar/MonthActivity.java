package brusd.mediummg.StudentCalendar;




import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;


import com.slidingmenu.lib.SlidingMenu;

import brusd.mediummg.StudentCalendar.AppDatabase.AppDB;
import brusd.mediummg.StudentCalendar.AppDatabase.TestData;
import brusd.mediummg.StudentCalendar.FragmentCalendar.DetailDayFragment;

public class MonthActivity extends ActionBarActivity {

    private SlidingMenu slidingMenu;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        slidingMenu = new SlidingMenu(MonthActivity.this);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.main);
            slidingMenu.setBehindOffset((int) (getResources().getDisplayMetrics().widthPixels * 0.15));
        }
        else {
            setContentView(R.layout.main);
            slidingMenu.setBehindOffset((int) (getResources().getDisplayMetrics().widthPixels * 0.5));
            Fragment newFragment = new DetailDayFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.day_or_pair_frame, newFragment).commit();
        }

        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        slidingMenu.setMenu(R.layout.sliding_menu);

        slidingMenu.findViewById(R.id.sliding_menu_lessons).setOnClickListener(new LessonsItemOnClick());
        slidingMenu.findViewById(R.id.sliding_menu_teachers).setOnClickListener(new TeachersItemOnClick());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        new TestData().addingTo(AppDB.getInstance(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                slidingMenu.toggle(true);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (slidingMenu.isMenuShowing())
            slidingMenu.toggle(true);
        else
            super.onBackPressed();
    }

    @Override
    public void onResume(){
        super.onResume();
        if (slidingMenu.isMenuShowing())
            slidingMenu.showContent(false);
    }

    private class LessonsItemOnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            startActivity(new Intent(MonthActivity.this, LessonsActivity.class));
        }
    }

    private class TeachersItemOnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            startActivity(new Intent(MonthActivity.this, TeachersActivity.class));
        }
    }

}
