package brusd.mediummg.StudentCalendar;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;

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
        }
        setContentView(R.layout.main);
    }
}
