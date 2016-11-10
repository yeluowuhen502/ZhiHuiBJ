package winning.zhihuibj.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jiang on 2016/10/28.
 */

public class MyApplicationUtil {
    public static Map mCheckMap;
    public static int FORRESULT = 100;

    public static void putCheckMap(boolean checked) {
        mCheckMap = new HashMap<String, Boolean>();
        mCheckMap.put("checkFlag", checked);
    }

    public static boolean getCheckMap() {
        if (mCheckMap != null) {
            return (boolean) mCheckMap.get("checkFlag");
        }
        return false;
    }
}
