import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.PatternSyntaxException;
import org.quartz.Scheduler;

public class xIncrase {
    public static void main(String [ ] args) {
        final Map<Integer, String> correctQueryMap = new HashMap<Integer, String>();
        String saveFileStartHourNotParsed = "08:15:00.0";
        String saveFileEndHourNotParsed = "18:45:00.0";
        try{
            Date startDate = new SimpleDateFormat("HH:mm:ss.S").parse(saveFileStartHourNotParsed);
            Date endDate = new SimpleDateFormat("HH:mm:ss.S").parse(saveFileEndHourNotParsed);
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.getContext().put("myContextVar", correctQueryMap);
            JobDetail savingFile = newJob(savingFile.class)
                    .withIdentity("savingFile", "group1")
                    .build();
            JobDetail ClassesnBreaks = newJob(ClassesJobBreak.class)
                    .withIdentity("breksAndClassesJob", "group2")
                    .build();
            Trigger savingFileTrigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule("0,30 * * ? * * *"))
                    .build();
            Trigger ClassesnBreaksTrig1 = newTrigger()
                    .withIdentity("trigger2", "group2")
                    .startAt(startDate)
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 * * ? * MON,WED,THU,FRI *"))
                    .endAt(endDate)
                    .build();
            scheduler.scheduleJob(savingFile, savingFileTrigger);
            scheduler.scheduleJob(ClassesnBreaks, ClassesnBreaksTrig1);
            scheduler.start();
        }catch(Exception e){}
        Thread inputThread = new Thread(new Runnable() {
            public void run() {
                Scanner scan = new Scanner(System.in);
                int assigmentNumber = 0;
                String sqlQuery = "";
                while (true) {
                    assigmentNumber = scan.nextInt();
                    scan.nextLine();
                    sqlQuery = scan.nextLine();
                    if (assigmentNumber != 0 && sqlQuery != "" && checkQuery(sqlQuery)) {
                        correctQueryMap.put(assigmentNumber,sqlQuery);
                        assigmentNumber = 0;
                        sqlQuery = "";
                    }
                    else if(assigmentNumber != 0 && sqlQuery != "" && !checkQuery(sqlQuery)){
                        System.out.println("NIEPOPRAWNE ZAPYTANIE");
                        assigmentNumber = 0;
                        sqlQuery = "";
                    }
                }
            }
        });
        inputThread.start();
    }
    public static boolean checkQuery(String query){
        int[] inputQueryOrderArray = new int[]{0,0,0,0,0};
        String [] splitQuery = query.split("\\s+");
        try {
            for(int i = 0; i < splitQuery.length; i++){
                if(splitQuery[i].equals("SELECT")){
                    inputQueryOrderArray[0] = 1;
                } else if (splitQuery[i].equals("FROM")) {
                    inputQueryOrderArray[1] = 2;
                } else if (splitQuery[i].equals("WHERE")) {
                    inputQueryOrderArray[2] = 3;
                } else if (splitQuery[i].equals("ORDER")) {
                    inputQueryOrderArray[3] = 4;
                } else if (splitQuery[i].equals("BY")) {
                    inputQueryOrderArray[4] = 5;
                }
            }
        } catch(PatternSyntaxException ex) {}
        for(int k = 0; k < queryOrderArray.perfectQueryOrderArray.length; k++) {
            if(Arrays.equals(inputQueryOrderArray,queryOrderArray.perfectQueryOrderArray[k]) && splitQuery[0].equals("SELECT"))
                return true;
        }
        return false;
    }
}