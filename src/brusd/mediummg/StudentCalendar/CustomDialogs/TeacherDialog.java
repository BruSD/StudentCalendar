package brusd.mediummg.StudentCalendar.CustomDialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import brusd.mediummg.StudentCalendar.AppDatabase.AppDB;
import brusd.mediummg.StudentCalendar.R;

/**
 * Created with Android Studio.
 * User: MediumMG
 * Date: 19.11.13
 * Time: 15:04
 */
public class TeacherDialog extends Dialog {

    public final static int MODE_NEW = 0;
    public final static int MODE_EDIT = 1;

    private Context mContext;
    private int mMode = 0;
    private String mOldTeacherName;

    private EditText editText;
    private Button buttonOk;
    private Button buttonCancel;

    public TeacherDialog(Context context, int mode, String oldTeacherName) {
        super(context);
        this.mContext = context;

        if (mode != MODE_NEW && mode != MODE_EDIT)
            mode = MODE_NEW;

        this.mMode = mode;
        this.mOldTeacherName = oldTeacherName;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setTitle(mMode == MODE_NEW ? R.string.adding_teacher : R.string.editing);
        setContentView(R.layout.teacher_dialog_layout);

        editText = (EditText)findViewById(R.id.teacher_dialog_layout_editText);

        if (mMode == TeacherDialog.MODE_EDIT) {
            editText.setText(mOldTeacherName);
            editText.setSelection(mOldTeacherName.length());
        }

        buttonOk = (Button) findViewById(R.id.teacher_dialog_layout_buttonOk);
        buttonOk.setOnClickListener(new OkOnClick());

        buttonCancel = (Button) findViewById(R.id.teacher_dialog_layout_buttonCancel);
        buttonCancel.setOnClickListener(new CancelOnClick());
    }

    @Override
    public void onStart() {
        super.onStart();

        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null){
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
        }
    }

    @Override
    public void onBackPressed() {
        dismiss();
    }


    private class OkOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String newTeacherName = editText.getText().toString();

            switch (mMode){
                case MODE_NEW: {
                    AppDB.getInstance(mContext).addTeacher(newTeacherName);
                    break;
                }
                case MODE_EDIT:{
                    if (!newTeacherName.equals(mOldTeacherName)) {
                        AppDB.getInstance(mContext).changeTeacherName(mOldTeacherName, newTeacherName);
                    }
                    break;
                }
                default: { return; }
            }

            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

            dismiss();
        }
    }

    private class CancelOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

            dismiss();
        }
    }


}
