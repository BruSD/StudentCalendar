package brusd.mediummg.StudentCalendar.SetOfAdaptorsStudent;


import android.content.Context;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;




import java.util.List;
import java.util.Map;

import brusd.mediummg.StudentCalendar.AppDatabase.AppOpenHelper;
import brusd.mediummg.StudentCalendar.R;

/**
 * Created by BruSD on 05.11.13.
 * Адаптор для перечня пар на день
 */
public class AdapterDetailsDay extends SimpleAdapter {

    private Context context;
    private List<? extends Map<String, ?>> data;
    private int resource;

    public AdapterDetailsDay(Context context,
                             List<? extends Map<String, ?>> data,
                             int resource,
                             String[] from,
                             int[] to) {
        super(context, data, resource, from, to);

        this.context = context;
        this.data = data;
        this.resource = resource;
    }
    /**
     * <p>Count of items in the data set represented by this Adapter</p>
     *
     * @return How many items are in the data set represented by this Adapter
     */
    @Override
    public int getCount() {
        return data.size();
    }

    /**
     * <p>Get the data item associated with the specified position in the data set.</p>
     *
     * @param position Position of the item whose data we want within the adapter's data set.
     * @return The data at the specified position
     */
    @Override
    public Object getItem(int position) {
        return null;
    }

    /**
     * <p>Get the row id associated with the specified position in the list.</p>
     *
     * @param position The position of the item within the adapter's data set whose row id we want
     * @return The id of the item at the specified position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView startTime;
        TextView endTime;
        TextView pairName;
        LinearLayout colorReflacionPair;
    }

    /**
     * Listen click on button buy the coins
     * <p>Get a View that displays the data at the specified position in the data set.</p>
     *
     * @param position    The position of the item within the adapter's data set of the item whose view we want
     * @param convertView The old view to reuse, if possible. Note: You should check that this view is non-null and of an appropriate type before using. If it is not possible to convert this view to display the correct data, this method can create a new view
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(resource, parent, false);

        holder = new ViewHolder();
        holder.startTime = (TextView)convertView.findViewById(R.id.start_time_tv);
        holder.endTime = (TextView)convertView.findViewById(R.id.end_time_tv);
        holder.pairName = (TextView)convertView.findViewById(R.id.name_of_pair_tv);
        holder.colorReflacionPair = (LinearLayout)convertView.findViewById(R.id.pair_color_reflaction);
         Map<String, ?> curentPair = data.get(position);

        holder.startTime.setText(curentPair.get(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time).toString());
        holder.endTime.setText(curentPair.get(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time).toString());
        holder.pairName.setText(curentPair.get(AppOpenHelper.TABLE_LESSONS_COLUMN_Lesson_Name).toString());

        holder.colorReflacionPair.setBackgroundColor(Color.parseColor(curentPair.get(AppOpenHelper.TABLE_LESSONS_COLUMN_Lesson_Color).toString()));



        return convertView;
    }
}
