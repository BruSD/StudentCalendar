package brusd.mediummg.StudentCalendar;


import android.content.res.Configuration;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;


/**
 * Created by BruSD on 06.11.13.
 */
public class DayActivity extends ActionBarActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        setContentView(R.layout.activity_detail_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
