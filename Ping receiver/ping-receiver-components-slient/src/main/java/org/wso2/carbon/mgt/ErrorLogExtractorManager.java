package org.wso2.carbon.mgt;


import org.wso2.carbon.mgt.data.LogExtractingWorker;

/**
 * Created by Dinanjana on 05/08/2016.
 */
public class ErrorLogExtractorManager {

    private LogExtractingWorker logExtractingWorker;

    public ErrorLogExtractorManager(){
        this.logExtractingWorker =new LogExtractingWorker();
    }

    public String getLogSnippet(String time){
        return logExtractingWorker.findLogSnippet(time);
    }
//    public String getLogSnippetForDuration(String time,String duration){
//        return null;
//    }
//
//    public String getLogSnippet(String time,String upperBound){
//        return null;
//    }
}
