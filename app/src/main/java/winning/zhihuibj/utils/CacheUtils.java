package winning.zhihuibj.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Jiang on 2016/11/10.
 */

public class CacheUtils {
    private static String FILE_NAME = "zhbj";
    private static SharedPreferences sp;

    public static void setBoolean(Context context, String key, boolean value) {
        sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, Boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }
}
