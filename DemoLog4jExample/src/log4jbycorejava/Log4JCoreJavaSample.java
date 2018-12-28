package log4jbycorejava;

import org.apache.log4j.Logger;

public class Log4JCoreJavaSample {
 final static Logger logger = Logger.getLogger(Log4JCoreJavaSample.class);
 public void callMeInAppInfo(String parameter) {
  if (logger.isInfoEnabled()) {
   logger.info("This is info : " + parameter);
  }
 }
 
 public void callMeInAppWarn(String parameter) {
  if (logger.isDebugEnabled()) {
   logger.warn("This is warn : " + parameter);
  }
 }
 public void callMeInAppError(String parameter) {
  if (logger.isInfoEnabled()) {
   logger.error("This is error : " + parameter);
  }
 }
 public void callMeInAppDebug(String parameter) {
  if (logger.isDebugEnabled()) {
   logger.debug("This is Debug : " + parameter);
  }
 }
 
}

