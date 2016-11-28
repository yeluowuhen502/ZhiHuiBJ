package winning.zhihuibj;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jiang on 2016/10/28.
 */

public class MyApplicationUtil extends Application{
    public static Map mCheckMap;
    public static Map slindingMenu;
    public static int FORRESULT = 100;

    public static void putSlidingMenuMap(Object slindingMenu) {
        mCheckMap = new HashMap<String, Boolean>();
        mCheckMap.put("slindingMenu", slindingMenu);
    }

     public static Object getSlidingMenuMap() {
         return mCheckMap.get("slindingMenu");
     }

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
