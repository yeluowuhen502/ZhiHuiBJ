package winning.zhihuibj;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import winning.zhihuibj.databinding.ActivityMainBinding;
import winning.zhihuibj.fragment.LeftFragment;
import winning.zhihuibj.utils.DeviceUtil;
import winning.zhihuibj.utils.LogUtil;
import winning.zhihuibj.view.widget.StatusBarCompat;

public class MainActivity extends SlidingFragmentActivity {
    private ActivityMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        StatusBarCompat.compat(this,getResources().getColor(R.color.colorRed));
        setBehindContentView(R.layout.left_layout);
        //模式设置
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置触摸范围
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(200);
        slidingMenu.setDeviceDistance(DeviceUtil.getMetricsWidth(MainActivity.this));
        slidingMenu.setOnScaleListenet(new SlidingMenu.OnScaleListenet() {
            @Override
            public void onScale(double scale) {
                // LogUtil.d("slidingtest", scale+"");
//                binding.ivTest.setAlpha((float) (1-scale));
            }
        });
        initFragment();
    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.ll_left, new LeftFragment(), "LEFTTAG");
        fragmentTransaction.commit();
    }
}
