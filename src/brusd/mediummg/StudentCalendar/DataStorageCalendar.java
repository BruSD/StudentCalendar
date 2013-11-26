package brusd.mediummg.StudentCalendar;

/**
 * Created by BruSD on 05.10.13.
 */
public class DataStorageCalendar {

    private static String selectedDay = "";

    public static void setSelectedDay(String selected_Day){
        selectedDay = selected_Day;
    }

    public static String getSelectedDay(){
        return selectedDay;
    }




}
