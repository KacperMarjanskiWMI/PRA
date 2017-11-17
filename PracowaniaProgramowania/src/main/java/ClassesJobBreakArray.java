import java.util.Date;
import java.util.HashMap;

public class ClassesJobBreakArray {
    static final HashMap<Integer, String[]> ClassesnBreaks = new HashMap<Integer, String[]>();
    static{
        ClassesnBreaks.put(0,new String[]{"Zajęć", "8:15", "9:45"});
        ClassesnBreaks.put(1,new String[]{"Przerwy", "9:45", "10:00"});
        ClassesnBreaks.put(2,new String[]{"Zajęć", "10:00", "11:30"});
        ClassesnBreaks.put(3,new String[]{"Przerwy", "11:30", "11:45"});
        ClassesnBreaks.put(4,new String[]{"Zajęć", "11:45", "13:15"});
        ClassesnBreaks.put(5,new String[]{"Przerwy", "13:15", "13:45"});
        ClassesnBreaks.put(6,new String[]{"Zajęć", "13:45", "15:15"});
        ClassesnBreaks.put(7,new String[]{"Przerwy", "15:15", "15:30"});
        ClassesnBreaks.put(8,new String[]{"Zajęć", "15:30", "17:00"});
        ClassesnBreaks.put(9,new String[]{"Przerwy", "17:00", "17:15"});
        ClassesnBreaks.put(10,new String[]{"Zajęć", "17:15", "18:45"});

    }

}