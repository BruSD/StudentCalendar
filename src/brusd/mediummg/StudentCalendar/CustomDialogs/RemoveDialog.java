package brusd.mediummg.StudentCalendar.CustomDialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import brusd.mediummg.StudentCalendar.AppDatabase.AppDB;
import brusd.mediummg.StudentCalendar.R;

/**
 * Created with Android Studio.
 * User: MediumMG
 * Date: 20.11.13
 * Time: 18:04
 */
public class RemoveDialog extends Dialog {

    public static final int TYPE_TEACHER = 0;
    public static final int TYPE_LESSON = 1;

    private Context mContext;
    private int mItemType;
    private String mItemName;

    private TextView textView;
    private Button buttonOk;
    private Button buttonCancel;

    public RemoveDialog(Context context, int itemType, String itemName) {
        super(context);
        this.mContext = context;
        if (itemType != TYPE_TEACHER && itemType != TYPE_LESSON)
            itemType = TYPE_TEACHER;

        this.mItemType = itemType;
        this.mItemName = itemName;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setCanceledOnTouchOutside(false);
        setTitle(R.string.removing);
        setContentView(R.layout.remove_dialog_layout);

        textView = (TextView)findViewById(R.id.remove_dialog_layout_text);
        textView.setText(String.format(mContext.getResources().getString(R.string.remove_item_text), mItemName));

        buttonOk = (Button) findViewById(R.id.remove_dialog_layout_buttonOk);
        buttonOk.setOnClickListener(new OkOnClick());

        buttonCancel = (Button) findViewById(R.id.remove_dialog_layout_buttonCancel);
        buttonCancel.setOnClickListener(new CancelOnClick());
    }

    @Override
    public void onBackPressed() {
        dismiss();
    }

    private class OkOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (mItemType){
                case TYPE_TEACHER: {
                    AppDB.getInstance(mContext).removeTeacher(mItemName);
                    break;
                }
                case TYPE_LESSON: {
                    AppDB.getInstance(mContext).removeLesson(mItemName);
                    break;
                }
                default: { break; }
            }
            dismiss();
        }
    }

    private class CancelOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    }

}
