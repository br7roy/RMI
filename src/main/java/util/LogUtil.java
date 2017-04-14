/*
* Package util 
* FileName: LogUtil
* Author:   Rust
* Date:     2017/6/9 10:10
*/
package util;

import org.slf4j.Logger;

/**
 * FileName:    LogUtil
 * Author:      Rust
 * Date:        2017/6/9
 * Description:
 */
public class LogUtil {
    private static String LEFT_PLACE ="------------------------》";
    private static String RIGHT_PLACE="《------------------------";

    private static String LEFT_PLACE_A ="============================";
    private static String RIGHT_PLACE_A ="============================";

    public static void debug(Logger logger, String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(LEFT_PLACE + msg + RIGHT_PLACE);
        }
    }

    public static void debugAO(Logger logger, String msg){
        if(logger.isDebugEnabled()){
            logger.debug(LEFT_PLACE_A +msg+ RIGHT_PLACE_A);
        }
    }

}
