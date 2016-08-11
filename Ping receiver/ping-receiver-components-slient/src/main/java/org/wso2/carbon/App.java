package org.wso2.carbon;

import org.wso2.carbon.mgt.ErrorLogExtractorManager;
import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    public static void main(String[] args1) throws AxisFault {

        RPCServiceClient serviceClient = new RPCServiceClient();
        serviceClient.i

        Options options = serviceClient.getOptions();

        EndpointReference targetEPR = new EndpointReference(
                "http://localhost:8080/axis2/services/WeatherService");
        options.setTo(targetEPR);

        // Setting the weather
        QName opSetWeather =
                new QName("http://service.pojo.sample/xsd", "setWeather");

        ErrorLogExtractorManager w = new ErrorLogExtractorManager();

//        w.setTemperature((float)39.3);
//        w.setForecast("Cloudy with showers");
//        w.setRain(true);
//        w.setHowMuchRain((float)4.5);

        Object[] opSetWeatherArgs = new Object[] { w };

        serviceClient.invokeBlocking(opSetWeather, opSetWeatherArgs);
    }
}
