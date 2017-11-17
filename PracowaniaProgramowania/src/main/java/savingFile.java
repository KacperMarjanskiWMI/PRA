import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.quartz.*;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;


public class savingFile implements org.quartz.Job {

    public void wykonac(JobExecutionContext context)
            throws JobExecutionException {
        String PATH = "J:\\Desktop\\odp.txt";
        try {
            SchedulerContext schedulerContext = context.getScheduler().getContext();
            HashMap<Integer, String> correctQueryHashMap = (HashMap<Integer, String>) schedulerContext.get("myContextVar");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonCorrectQueryHashMap = gson.toJson(correctQueryHashMap);
            try {
                FileWriter fileWriter = new FileWriter(PATH);
                fileWriter.write(jsonCorrectQueryHashMap);
                fileWriter.flush();
                System.out.println("Json array of sql queries saved to odp.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SchedulerException e1) {
            e1.printStackTrace();
        }

    }
}