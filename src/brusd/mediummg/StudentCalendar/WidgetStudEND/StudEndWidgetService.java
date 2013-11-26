package brusd.mediummg.StudentCalendar.WidgetStudEND;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import brusd.mediummg.StudentCalendar.AppDatabase.AppDB;
import brusd.mediummg.StudentCalendar.AppDatabase.AppOpenHelper;
import brusd.mediummg.StudentCalendar.DataStorageCalendar;
import brusd.mediummg.StudentCalendar.R;

/**
 * Created by BruSD on 21.11.13.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class StudEndWidgetService extends RemoteViewsService {

    private static ArrayList<HashMap<String, Object>> listFromDB;
    private static AppDB appDB;


    @Override
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        // Since we reload the cursor in onDataSetChanged() which gets called immediately after
        // onCreate(), we do nothing here.



        return new PairListRemoteViewsFactory(this.getApplicationContext(), intent);
    }

    class PairListRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
        private Context mContext;

        private int mAppWidgetId;
        private ArrayList<HashMap<String, Object>> listFromDB;


        public PairListRemoteViewsFactory(Context context, Intent intent ){
            mContext = context;
            mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);



        }
        @Override
        public void onCreate() {
            appDB = AppDB.getInstance(mContext);
            int dayNumber = getDayOfWeek();
            listFromDB = appDB.getLessonsFor("Расписание", dayNumber);
        }

        @Override
        public void onDataSetChanged() {

        }

        @Override
        public void onDestroy() {
                //TODO: Destroi connection to DB
        }

        @Override
        public int getCount() {
            return listFromDB.size();//listFromDB.size();
        }

        @Override
        public RemoteViews getViewAt(int i) {
            // Get the data for this position from the content provider
            HashMap<String, Object> item = listFromDB.get(i);
            // Return a proper item with the proper city and temperature.  Just for fun, we alternate
            // the items to make the list easier to read.
            final int itemId = (R.layout.item_widget_list_layot);
            RemoteViews rv = new RemoteViews(mContext.getPackageName(), itemId);

            String startTime = item.get(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time).toString();
            String endTime = item.get(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time).toString();
            String lessonsName = item.get(AppOpenHelper.TABLE_LESSONS_COLUMN_Lesson_Name).toString();

            rv.setTextViewText(R.id.start_time_tv_widget, startTime);
            rv.setTextViewText(R.id.end_time_tv_widget, endTime);
            rv.setTextViewText(R.id.name_of_pair_tv_widget, lessonsName);


//            final Intent fillInIntent = new Intent();
//            final Bundle extras = new Bundle();
//
//            fillInIntent.putExtras(extras);
//            rv.setOnClickFillInIntent(R.id.pair_color_reflaction_widget, fillInIntent);
            return rv;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }


    private static int getDayOfWeek(){

        Calendar calendar = Calendar.getInstance();


        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
