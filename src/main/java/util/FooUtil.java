/*
* Package util 
* FileName: FooUtil
* Author:   fth
* Date:     2017/4/14 16:13
*/
package util;

/**
 * FileName:    FooUtil
 * Author:      Br7roy
 * Date:        2017/4/14
 * Description: just a util
 */
public class FooUtil {
    public static boolean isBlank(String string) {
        return ("".equals(string) ||
                string.length() == 0 ||
                string.equals("null") ||
                string.equals("NULL"));
    }

    public static boolean isBlankArray(Object... objects) {
        if (objects.length == 1) {
            return "0".equals(objects.length);
        } else if (objects.length > 1) {
            return false;
        }
        return false;
    }
}
