import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class ClassesJobBreak implements org.quartz.Job {
    public void wykonac(JobExecutionContext jobExecutionContext) throws JobExecutionException {
         final long MSEC_SINCE_EPOCH = System.currentTimeMillis();
        Date instant = new Date( MSEC_SINCE_EPOCH );
        SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm" );
        String currentTime = sdf.format( instant );
        for (Map.Entry<Integer, String[]> entry : ClassesJobBreakArray.ClassesnBreaks.entrySet()) {
            int key = entry.getKey();
            String[] value = entry.getValue();
            sprCzas(value[1], value[2], currentTime, value[0]);
        }
    }
    private void sprCzas(String Time1, String Time3, String currentTime, String xbreakx){
        try {
            String string1 = Time1;
            Date time1 = new SimpleDateFormat("HH:mm").parse(string1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.DATE, 1);
            String string3 = Time3;
            Date time3 = new SimpleDateFormat("HH:mm").parse(string3);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(time3);
            calendar3.add(Calendar.DATE, 1);
            Date lateTime = calendar3.getTime();
            Date time2 = new SimpleDateFormat("HH:mm").parse(currentTime);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);
            Date currentTimeParsed = calendar2.getTime();
            if (currentTimeParsed.after(calendar1.getTime()) && currentTimeParsed.before(calendar3.getTime())) {
                long difference = lateTime.getTime() - currentTimeParsed.getTime();
                System.out.println("Zostało: " + TimeUnit.MILLISECONDS.toMinutes(difference) + " min do końca " + xbreakx);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}