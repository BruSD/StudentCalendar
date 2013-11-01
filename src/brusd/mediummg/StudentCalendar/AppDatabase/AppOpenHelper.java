package brusd.mediummg.StudentCalendar.AppDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created with Android Studio.
 * User: MediumMG
 * Date: 05.10.13
 * Time: 21:54
 */
public class AppOpenHelper extends SQLiteOpenHelper{

    // DB
    public static final String DATABASE_NAME  = "StudentDiary.sqlite3";
    public static final int DATABASE_VERSION = 1;

    // Templates Table
    public static final String TABLE_TEMPLATES = "templates";
    public static final String TABLE_TEMPLATES_COLUMN_Template_Name = "template_name";
    public static final String TABLE_TEMPLATES_COLUMN_Week_Day = "day_of_week";
    public static final String TABLE_TEMPLATES_COLUMN_Lesson_Number = "lesson_number";
    public static final String TABLE_TEMPLATES_COLUMN_Start_Time = "start_time";
    public static final String TABLE_TEMPLATES_COLUMN_End_Time = "end_time";
    public static final String TABLE_TEMPLATES_COLUMN_Lesson_Name_ID = "lesson_name_id";
    public static final String TABLE_TEMPLATES_COLUMN_Lesson_Type_ID = "lesson_type_id";
    public static final String TABLE_TEMPLATES_COLUMN_Teacher_Name_ID = "teacher_name_id";

    private static final String TABLE_TEMPLATES_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_TEMPLATES
            + " ("
            + TABLE_TEMPLATES_COLUMN_Template_Name + " TEXT NOT NULL, "
            + TABLE_TEMPLATES_COLUMN_Week_Day + " INTEGER, "
            + TABLE_TEMPLATES_COLUMN_Lesson_Number + " INTEGER, "
            + TABLE_TEMPLATES_COLUMN_Start_Time + " TEXT NOT NULL, "
            + TABLE_TEMPLATES_COLUMN_End_Time + " TEXT NOT NULL, "
            + TABLE_TEMPLATES_COLUMN_Lesson_Name_ID + " INTEGER, "
            + TABLE_TEMPLATES_COLUMN_Lesson_Type_ID + " INTEGER, "
            + TABLE_TEMPLATES_COLUMN_Teacher_Name_ID + " INTEGER"
            + ");";

    private static final String TABLE_TEMPLATES_DROP = "DROP TABLE IF EXISTS " + TABLE_TEMPLATES;


    // Teachers Table
    public static final String TABLE_TEACHERS = "teachers";
    public static final String TABLE_TEACHERS_COLUMN_ID_Teacher = "id_teacher";
    public static final String TABLE_TEACHERS_COLUMN_Teacher_Name = "teacher_name";

    private static final String TABLE_TEACHERS_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_TEACHERS
            + " ("
            + TABLE_TEACHERS_COLUMN_ID_Teacher + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TABLE_TEACHERS_COLUMN_Teacher_Name + " TEXT NOT NULL"
            + ");";

    private static final String TABLE_TEACHERS_DROP = "DROP TABLE IF EXISTS " + TABLE_TEACHERS;


    // Lessons Table
    public static final String TABLE_LESSONS = "lessons";
    public static final String TABLE_LESSONS_COLUMN_ID_Lesson = "id_lesson";
    public static final String TABLE_LESSONS_COLUMN_Lesson_Name = "lesson_name";
    public static final String TABLE_LESSONS_COLUMN_Lesson_Color = "lesson_color";

    private static final String TABLE_LESSONS_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_LESSONS
            + " ("
            + TABLE_LESSONS_COLUMN_ID_Lesson + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TABLE_LESSONS_COLUMN_Lesson_Name + " TEXT NOT NULL, "
            + TABLE_LESSONS_COLUMN_Lesson_Color + " TEXT NOT NULL"
            + ");";

    private static final String TABLE_LESSONS_DROP = "DROP TABLE IF EXISTS " + TABLE_LESSONS;


    // Lesson Types Table
    public static final String TABLE_LESSON_TYPES = "lesson_types";
    public static final String TABLE_LESSON_TYPES_COLUMN_ID_Type = "id_lesson_types";
    public static final String TABLE_LESSON_TYPES_COLUMN_Type_Name = "type_name";

    private static final String TABLE_LESSON_TYPES_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_LESSON_TYPES
            + " ("
            + TABLE_LESSON_TYPES_COLUMN_ID_Type + " INTEGER PRIMARY KEY, "
            + TABLE_LESSON_TYPES_COLUMN_Type_Name + " TEXT NOT NULL"
            + ");";

    private static final String TABLE_LESSON_TYPES_DROP = "DROP TABLE IF EXISTS " + TABLE_LESSON_TYPES;

    private static final String TABLE_LESSON_TYPES_CONTENT =
            "INSERT OR IGNORE INTO "+ TABLE_LESSON_TYPES +" (" + TABLE_LESSON_TYPES_COLUMN_ID_Type + ", " + TABLE_LESSON_TYPES_COLUMN_Type_Name + ") VALUES ('1', 'лекция');" +
            "INSERT OR IGNORE INTO "+ TABLE_LESSON_TYPES +" (" + TABLE_LESSON_TYPES_COLUMN_ID_Type + ", " + TABLE_LESSON_TYPES_COLUMN_Type_Name + ") VALUES ('2', 'семинар');" +
            "INSERT OR IGNORE INTO "+ TABLE_LESSON_TYPES +" (" + TABLE_LESSON_TYPES_COLUMN_ID_Type + ", " + TABLE_LESSON_TYPES_COLUMN_Type_Name + ") VALUES ('3', 'прак.занятие');" +
            "INSERT OR IGNORE INTO "+ TABLE_LESSON_TYPES +" (" + TABLE_LESSON_TYPES_COLUMN_ID_Type + ", " + TABLE_LESSON_TYPES_COLUMN_Type_Name + ") VALUES ('4', 'лаб.занятие');";



    public AppOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_TEMPLATES_CREATE);
        db.execSQL(TABLE_TEACHERS_CREATE);
        db.execSQL(TABLE_LESSONS_CREATE);
        db.execSQL(TABLE_LESSON_TYPES_CREATE);

        db.execSQL(TABLE_LESSON_TYPES_CONTENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_TEMPLATES_DROP);
        db.execSQL(TABLE_TEACHERS_DROP);
        db.execSQL(TABLE_LESSONS_DROP);
        db.execSQL(TABLE_LESSON_TYPES_DROP);

        onCreate(db);
    }
}
