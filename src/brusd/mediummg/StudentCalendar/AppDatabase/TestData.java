package brusd.mediummg.StudentCalendar.AppDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: MediumMG
 * Date: 01.11.13
 * Time: 9:33
 * To change this template use File | Settings | File Templates.
 */
public class TestData {


    public void addingTo(AppDB appDB) {
        addLessonsList(appDB);
        addTeacherList(appDB);
        addTemplate(appDB);
    }

    private void addLessonsList(AppDB appDB) {
        appDB.addLessons("Зовнішня політика України", "#33B5E5");
        appDB.addLessons("Логістика", "#99CC00");
        appDB.addLessons("Кредит і банківська справа", "#FF4444");
        appDB.addLessons("Дипломатичний протокол", "#0099CC");
        appDB.addLessons("Основна іноземна мова", "#0099CC");
        appDB.addLessons("Захист інформаційних технологій", "#CC0000");
        appDB.addLessons("Теорія і практика перекладу", "#AA66CC");
        appDB.addLessons("Міжнародні економічні відносини", "#FFBB33");
        appDB.addLessons("Друга іноземна мова", "#FF8800");
        appDB.addLessons("Структура і органи ЄС", "#00DDFF");
        appDB.addLessons("Цивільний захист", "##0000EE");
        appDB.addLessons("Фінансова політика країн ЄС", "#808080");
        appDB.addLessons("Основи аудиту", "#000000");
    }

    private void addTeacherList(AppDB appDB) {
        appDB.addTeacher("The Teacher");
    }

    private void addTemplate(AppDB appDB) {
        String templateName = "Расписание";

        ArrayList<HashMap<String, Object>> lessons = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> temp;

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "08:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "09:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Зовнішня політика України"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "09:55");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "11:30");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Зовнішня політика України"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "12:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "13:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Логістика"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        //

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "08:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "09:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Кредит і банківська справа"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "09:55");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "11:30");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Дипломатичний протокол"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "12:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "13:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Основна іноземна мова"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        //

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "08:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "09:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Захист інформаційних технологій"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "09:55");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "11:30");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Теорія і практика перекладу"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "12:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "13:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Міжнародні економічні відносини"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 4);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "13:55");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "15:15");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Міжнародні економічні відносини"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        //

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 4);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "09:55");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "11:30");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Структура і органи ЄС"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 4);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "12:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "13:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Структура і органи ЄС"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 4);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 4);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "13:55");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "15:15");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Цивільний захист"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        //

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 5);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "08:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "09:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Фінансова політика країн ЄС"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 1);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 5);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "09:55");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "11:30");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Фінансова політика країн ЄС"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        temp = new HashMap<String, Object>();
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Week_Day, 5);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Number, 3);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Start_Time, "12:00");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_End_Time, "13:35");
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Name_ID, lessonIDForName(appDB, "Основи аудиту"));
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Lesson_Type_ID, 2);
        temp.put(AppOpenHelper.TABLE_TEMPLATES_COLUMN_Teacher_Name_ID, teacherIDForName(appDB, "The Teacher"));
        lessons.add(temp);

        appDB.addTemplates(templateName, lessons);
    }




    private int teacherIDForName(AppDB appDB, String name) {
        ArrayList<HashMap<String,Object>> teachers = appDB.getTeachers();
        for (HashMap<String,Object> object : teachers) {
            if (name.equals((String)object.get(AppOpenHelper.TABLE_TEACHERS_COLUMN_Teacher_Name))) {
                return (Integer)object.get(AppOpenHelper.TABLE_TEACHERS_COLUMN_ID_Teacher);
            }
        }
        return -1;
    }

    private int lessonIDForName(AppDB appDB, String name) {
        ArrayList<HashMap<String,Object>> lessons = appDB.getLessons();
        for (HashMap<String,Object> object : lessons) {
            if (name.equals((String)object.get(AppOpenHelper.TABLE_LESSONS_COLUMN_Lesson_Name))) {
                return (Integer)object.get(AppOpenHelper.TABLE_LESSONS_COLUMN_ID_Lesson);
            }
        }
        return -1;
    }
}
