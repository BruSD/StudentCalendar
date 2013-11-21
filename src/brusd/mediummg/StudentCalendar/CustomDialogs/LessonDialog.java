package brusd.mediummg.StudentCalendar.CustomDialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

import brusd.mediummg.StudentCalendar.AppDatabase.AppDB;
import brusd.mediummg.StudentCalendar.R;

/**
 * Created with Android Studio.
 * User: MediumMG
 * Date: 21.11.13
 * Time: 12:37
 */
public class LessonDialog extends Dialog {

    public final static int MODE_NEW = 0;
    public final static int MODE_EDIT = 1;

    private Context mContext;
    private int mMode = 0;
    private String mOldLessonName;
    private int mOldColor;

    private View colorView;
    private EditText editText;
    private RelativeLayout colorPickerContainer;
    private ColorPickerView colorPickerView;
    private Button buttonOk;
    private Button buttonCancel;

    private int newColor;

    public LessonDialog(Context context, int mode, String oldLessonName, int oldLessonColor) {
        super(context);
        this.mContext = context;

        if (mode != MODE_NEW && mode != MODE_EDIT)
            mode = MODE_NEW;

        this.mMode = mode;
        this.mOldLessonName = oldLessonName;
        this.mOldColor = oldLessonColor;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setTitle(mMode == MODE_NEW ? R.string.adding_lesson : R.string.editing);

        setContentView(R.layout.lesson_dialog_layout);

        editText = (EditText)findViewById(R.id.lesson_dialog_layout_editText);
        if (mMode == TeacherDialog.MODE_EDIT) {
            editText.setText(mOldLessonName);
            editText.setSelection(mOldLessonName.length());
        }
        else {
            Random rnd = new Random();
            mOldColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }

        colorView = findViewById(R.id.lesson_dialog_layout_colorView);
        colorView.setBackgroundColor(mOldColor);
        colorView.setOnClickListener(new ColorOnClick());

        buttonOk = (Button) findViewById(R.id.lesson_dialog_layout_buttonOk);
        buttonOk.setOnClickListener(new OkOnClick());

        buttonCancel = (Button) findViewById(R.id.lesson_dialog_layout_buttonCancel);
        buttonCancel.setOnClickListener(new CancelOnClick());

        colorPickerView = new ColorPickerView(mContext, new ColorSelected(), mOldColor);

        colorPickerContainer = (RelativeLayout)findViewById(R.id.lesson_dialog_layout_colorPickerContainer);
        colorPickerContainer.addView(colorPickerView);

        newColor = mOldColor;
    }

    @Override
    public void onStart() {
        super.onStart();

        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    private class OkOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String newLessonName = editText.getText().toString();
            String color = String.format("#%06X", (0xFFFFFF & newColor));

            switch (mMode) {
                case MODE_NEW: {
                    AppDB.getInstance(mContext).addLesson(newLessonName, color);
                    break;
                }
                case  MODE_EDIT: {
                    if (!newLessonName.equals(mOldLessonName) || newColor != mOldColor)
                        AppDB.getInstance(mContext).changeLesson(mOldLessonName, newLessonName, color);
                    break;
                }
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

    private class ColorSelected implements OnColorChangedListener {

        @Override
        public void colorChanged(int color) {
            newColor = color;

            colorView.setBackgroundColor(newColor);
            colorPickerContainer.setVisibility(View.GONE);
            buttonCancel.setEnabled(true);
            colorView.setEnabled(true);
            buttonOk.setEnabled(true);
            editText.setEnabled(true);

            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null){
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        }
    }

    private class ColorOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (colorPickerContainer.getVisibility() == View.GONE) {
                colorPickerContainer.setVisibility(View.VISIBLE);
                buttonCancel.setEnabled(false);
                colorView.setEnabled(false);
                buttonOk.setEnabled(false);
                editText.setEnabled(false);

                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        }
    }
}
