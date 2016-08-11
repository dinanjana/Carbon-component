package org.wso2.carbon.mgt.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dinanjana on 08/08/2016.
 */
public class LogExtractingWorker {
    private String relativePath="/repository/logs/wso2carbon.log";
    private long timeDiff=100000;
    private String path0;

    public LogExtractingWorker(){
        String path1 = System.getenv("CARBON_HOME");
        path0=path1+relativePath;
    }

    public String findLogSnippet(String timeStamp){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path0));
            boolean trig=false;
            String log="";
            while (reader.readLine() != null){
                if(trig){
                    log += "\n" + reader.readLine();
                }
                if(findClosestLine(reader.readLine(),timeStamp) && !trig){
                    System.out.println("entry point");
                    trig=true;
                }
            }
            reader.close();
            return log;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean findClosestLine(String line,String timeStamp){
        if(line==null){
            return false;
        }
        String [] parts = line.split("\\[");
        try{
            String date0 = parts[3].split("\\]")[0].replace(',','.');
            long date=convertTimeToMilliseconds(date0);
            if(Long.parseLong(timeStamp)-date <= timeDiff){
                return true;
            }

        }catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    private long convertTimeToMilliseconds(String date0){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = null;
        try {
            date = dateFormat.parse(date0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
