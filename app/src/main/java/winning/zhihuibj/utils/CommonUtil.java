package winning.zhihuibj.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.StatFs;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;



public class CommonUtil {

    /**
     * 格式化下载的文件单位
     *
     * @return 返回以兆为单位
     */
    public static double getProgress(int progress) {
        double temp = progress*1.0;
        double pro = temp/1024/1024;
        DecimalFormat df   = new DecimalFormat("######0.00");
        return Double.parseDouble(df.format(pro));
    }
    /**
     * 返回保留两位小数的结果
     *
     * @return 返回以兆为单位
     */
    public static double getNum(double progress) {
        DecimalFormat df   = new DecimalFormat("######0.00");
        return Double.parseDouble(df.format(progress));
    }


    /**
     * 检测sdcard是否可用
     *
     * @return true为可用，否则为不可用
     */
    public static boolean sdCardIsAvailable() {
        String status = Environment.getExternalStorageState();
        if (!status.equals(Environment.MEDIA_MOUNTED))
            return false;
        return true;
    }
    /**
     * 切割时间的方法
     *
     * @return 返回切割之后的时间
     */
    public static String getMyDay(String time) {
        String day = time.substring(0,8);
        String time_hour = time.substring(8);
        //日期的分割
        String day_split = day.substring(0,4)+"-"+day.substring(4,6)+"-"+day.substring(6);

        String myTtime = day_split+","+time_hour;
        //用法
//        String[] myTime = reDay.split(",");
            return myTtime;
    }

    /**
     * Checks if there is enough Space on SDCard
     *
     * @param updateSize Size to Check
     * @return True if the Update will fit on SDCard, false if not enough space on SDCard Will also return false, if the SDCard is
     * not mounted as read/write
     */
    public static boolean enoughSpaceOnSdCard(long updateSize) {
        String status = Environment.getExternalStorageState();
        if (!status.equals(Environment.MEDIA_MOUNTED))
            return false;
        return (updateSize < getRealSizeOnSdcard());
    }

    /**
     * get the space is left over on sdcard
     */
    public static long getRealSizeOnSdcard() {
        File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
    }

    /**
     * Checks if there is enough Space on phone self
     */
    public static boolean enoughSpaceOnPhone(long updateSize) {
        return getRealSizeOnPhone() > updateSize;
    }

    /**
     * get the space is left over on phone self
     */
    public static long getRealSizeOnPhone() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        long realSize = blockSize * availableBlocks;
        return realSize;
    }

    /**
     * 根据手机分辨率从dp转成px
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f) - 15;
    }

    public static void showToast(Context context, String text) {
        final Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        LinearLayout layout = (LinearLayout) toast.getView();
        TextView textView = (TextView) layout.getChildAt(0);
       // textView.setTextSize(15);
//		toast.show();

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, 4000);
    }


    /**
     * 声音提示
     */
    public static void playSound(Context context, int resource) {
        AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        int volume = mAudioManager.getStreamVolume(AudioManager.STREAM_RING);

        if (volume == 0) {        //音量为0时，启用震动
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
//		vibrator.vibrate(1200);			//震动2秒
        } else {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, AudioManager.FLAG_PLAY_SOUND);
            MediaPlayer mp = null;
            mp = MediaPlayer.create(context, resource);
            if (mp != null)
                mp.start();
        }
    }


    /**
     * 删除用户信息
     *
     * @param context
     */
    public static void deleteLoginInfo(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("LoginCookie", Context.MODE_PRIVATE).edit();
        editor.clear().commit();
    }

    /**
     * 保存首次登陆
     */
    public static void saveFirstLogin(Context context, boolean IsFirst) {
        SharedPreferences preferences = context.getSharedPreferences("FirstLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean("Isfirst", IsFirst);
        edit.commit();
    }

    /**
     * 是否是首次登陆
     */
    public static Boolean IsFirstLogin(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("FirstLogin", Context.MODE_PRIVATE);
        return preferences.getBoolean("Isfirst", false);
    }

    /**
     * 保存配置IP信息
     */
    public static void saveIp(Context context, String Ipname) {
        SharedPreferences preferences = context.getSharedPreferences("IP", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("ip", Ipname);
        edit.commit();
    }

    /**
     * 获取IP配置信息
     */
    public static String getIP(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("IP", Context.MODE_PRIVATE);
        return preferences.getString("ip", "");
    }

    /**
     * 获取当前app版本code
     *
     * @param context
     * @return
     */
    public static int GetCode(Context context) {
        int currentVersionCode = 0;
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            currentVersionCode = info.versionCode; // 版本号
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return currentVersionCode;
    }

    public static String getDeviceId(Context context) {
        String deviceId;
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        deviceId = tm.getDeviceId();
        return deviceId;
    }
}
