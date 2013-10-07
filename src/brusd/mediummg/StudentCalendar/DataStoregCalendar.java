package brusd.mediummg.StudentCalendar;

import java.text.SimpleDateFormat;

/**
 * Created by BruSD on 05.10.13.
 */
public class DataStoregCalendar {

    private static String selectedDay = "";

    public static void setSelectedDay(String selected_Day){
        selectedDay = selected_Day;
    }

    public static String getSelectedDay(){
        return selectedDay;
    }
}
