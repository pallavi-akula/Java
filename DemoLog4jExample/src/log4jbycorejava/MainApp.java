package log4jbycorejava;

public class MainApp {
 public static void main(String[] args) {
  Log4JCoreJavaSample objLog4JCoreJavaSample = new Log4JCoreJavaSample();
  objLog4JCoreJavaSample.callMeInAppInfo("Log4JCoreJavaSample by Info");
 // objLog4JCoreJavaSample.callMeInAppWarn("Log4JCoreJavaSample by Warn");
  objLog4JCoreJavaSample.callMeInAppDebug("Log4JCoreJavaSample by Debug");
  //objLog4JCoreJavaSample.callMeInAppError("Log4JCoreJavaSample by Error");
  //objLog4JCoreJavaSample.callMeInAppFatal("Log4JCoreJavaSample by Fatel");
 }
}