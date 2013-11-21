package brusd.mediummg.StudentCalendar;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import brusd.mediummg.StudentCalendar.AppDatabase.AppDB;
import brusd.mediummg.StudentCalendar.AppDatabase.AppOpenHelper;
import brusd.mediummg.StudentCalendar.CustomDialogs.RemoveDialog;
import brusd.mediummg.StudentCalendar.CustomDialogs.TeacherDialog;

/**
 * Created with Android Studio.
 * User: MediumMG
 * Date: 08.11.13
 * Time: 18:03
 */
public class TeachersActivity extends ActionBarActivity {

    private ListView listView;
    private ArrayList<HashMap<String, Object>> teachers;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        getSupportActionBar().setTitle(R.string.teachers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.list_layout_listView);
        listView.setDividerHeight(0);
        registerForContextMenu(listView);

        ((TextView)findViewById(R.id.list_layout_header_textView)).setText(R.string.add_teacher_action);
        findViewById(R.id.list_layout_header_textView).setOnClickListener(new AddTeacherOnClick());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadTeachersList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.list_layout_listView) {

            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle((String)teachers.get(info.position).get(AppOpenHelper.TABLE_TEACHERS_COLUMN_Teacher_Name));

            menu.add(Menu.NONE, 0, 0, getResources().getString(R.string.edit_action));
            menu.add(Menu.NONE, 1, 1, getResources().getString(R.string.remove_action));
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        String name = (String)teachers.get(info.position).get(AppOpenHelper.TABLE_TEACHERS_COLUMN_Teacher_Name);

        switch (menuItemIndex) {
            case 0: {
                TeacherDialog dialog = new TeacherDialog(this, TeacherDialog.MODE_EDIT, name);
                dialog.setOnDismissListener(new DialogDismiss());
                dialog.show();
                break;
            }
            case 1: {
                RemoveDialog dialog = new RemoveDialog(this, RemoveDialog.TYPE_TEACHER, name);
                dialog.setOnDismissListener(new DialogDismiss());
                dialog.show();
                break;
            }
            default:{}
        }

        return true;
    }



    private void loadTeachersList() {
        teachers = AppDB.getInstance(this).getAllTeachers();
        TeachersAdapter adapter = new TeachersAdapter(TeachersActivity.this,
                                                    teachers,
                                                    R.layout.teacher_list_item_layout,
                                                    new String[] {AppOpenHelper.TABLE_TEACHERS_COLUMN_ID_Teacher,
                                                                  AppOpenHelper.TABLE_TEACHERS_COLUMN_Teacher_Name},
                                                    new int[] {R.id.teacher_list_item_layout_textView}
                                            );
        listView.setAdapter(adapter);
    }

    private class TeachersAdapter extends SimpleAdapter {

        private Context context;
        private List<? extends Map<String, ?>> data;
        private int resource;
        private String[] from;
        private int[] to;

        /**
         * Constructor
         *
         * @param context  The context where the View associated with this SimpleAdapter is running
         * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
         *                 Maps contain the data for each row, and should include all the entries specified in
         *                 "from"
         * @param resource Resource identifier of a view layout that defines the views for this list
         *                 item. The layout file should include at least those named views defined in "to"
         * @param from     A list of column names that will be added to the Map associated with each
         *                 item.
         * @param to       The views that should display column in the "from" parameter. These should all be
         *                 TextViews. The first N views in this list are given the values of the first N columns
         */
        public TeachersAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.context = context;
            this.data = data;
            this.resource = resource;
            this.from = from;
            this.to = to;
        }

        /**
         * <p>Count of items in the data set represented by this Adapter</p>
         * @return How many items are in the data set represented by this Adapter
         */
        @Override
        public int getCount() {
            return data.size();
        }

        /**
         * <p>Get the data item associated with the specified position in the data set.</p>
         * @param position Position of the item whose data we want within the adapter's data set.
         * @return The data at the specified position
         */
        @Override
        public Object getItem(int position) {
            return null;
        }

        /**
         * <p>Get the row id associated with the specified position in the list.</p>
         * @param position The position of the item within the adapter's data set whose row id we want
         * @return The id of the item at the specified position
         */
        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * <p>Get a View that displays the data at the specified position in the data set.</p>
         * @param position The position of the item within the adapter's data set of the item whose view we want
         * @param convertView The old view to reuse, if possible. Note: You should check that this view is non-null and of an appropriate type before using. If it is not possible to convert this view to display the correct data, this method can create a new view
         * @param parent The parent that this view will eventually be attached to
         * @return A View corresponding to the data at the specified position
         */
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            final ViewHolder holder;

            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(resource, parent, false);
            holder = new ViewHolder();

            holder.itemView = convertView;
            holder.textView = (TextView)convertView.findViewById(to[0]);

            convertView.setTag(holder);

            if (position % 2 == 0) {
                holder.itemView.setBackgroundColor(getResources().getColor(R.color.white));
                holder.textView.setTextColor(getResources().getColor(R.color.black));
            }
            else {
                holder.itemView.setBackgroundColor(getResources().getColor(R.color.black));
                holder.textView.setTextColor(getResources().getColor(R.color.white));
            }

            holder.textView.setTag(data.get(position).get(from[0]));
            holder.textView.setText((String) data.get(position).get(from[1]));

            registerForContextMenu(convertView);
            return convertView;
        }

        class ViewHolder {
            TextView textView;
            View itemView;
        }
    }

    private class AddTeacherOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TeacherDialog dialog = new TeacherDialog(TeachersActivity.this, TeacherDialog.MODE_NEW, "");
            dialog.setOnDismissListener(new DialogDismiss());
            dialog.show();
        }
    }

    private class DialogDismiss implements DialogInterface.OnDismissListener {
        @Override
        public void onDismiss(DialogInterface dialog) {
            int index = listView.getFirstVisiblePosition();
            View v = listView.getChildAt(0);
            int top = (v == null) ? 0 : v.getTop();

            loadTeachersList();

            listView.setSelectionFromTop(index, top);
        }
    }



}