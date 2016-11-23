package winning.zhihuibj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

import winning.zhihuibj.utils.MyApplicationUtil;


/**
 * Created by Jiang on 2016/10/28.
 */

public class ZHBJBaseActivity extends AppCompatActivity {
    private Activity mActivity;
    public ForResultCallBack forResultCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;
    }

    /**
     * 提供统一的启动方式
     *
     * @param cls，intent（另一个Activity，intent携带的数据）
     */
    public void startMyActivity(Class<?> cls, Bundle mBundle) {
        Intent intent = new Intent(mActivity, cls);
        // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (mBundle != null) {
            intent.putExtras(mBundle);
        }
        mActivity.startActivity(intent);
        mActivity.overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }

    /**
     * 提供统一的关闭方式
     * <p>
     * （另一个Activity）
     */
    public void finishMyActivity() {
        mActivity.finish();
        mActivity.overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
    }

    //封装startActivityForResult
    public void startMyActivityForResult(Class<?> cls, Bundle bundle, ForResultCallBack forResultCallBack) {
        this.forResultCallBack = forResultCallBack;
        Intent intent = new Intent(mActivity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, MyApplicationUtil.FORRESULT);
        mActivity.overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }

    public interface ForResultCallBack {
        public void forResult(Intent data);
    }

    //将数据传递给回调方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case 100:
                forResultCallBack.forResult(data);
                break;
        }
    }


    //监听按下了返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finishMyActivity();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

}
