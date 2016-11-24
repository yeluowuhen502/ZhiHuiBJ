package winning.zhihuibj;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import winning.zhihuibj.databinding.ActivityMainBinding;
import winning.zhihuibj.fragment.ContentFragment;
import winning.zhihuibj.fragment.LeftFragment;
import winning.zhihuibj.utils.DeviceUtil;
import winning.zhihuibj.utils.LogUtil;
import winning.zhihuibj.view.adapter.GuideViewPagerAdapter;
import winning.zhihuibj.view.widget.StatusBarCompat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SlidingMenu slidingMenu;
    private int[] imgs = new int[]{
            R.mipmap.guide_1,
            R.mipmap.guide_2,
            R.mipmap.guide_3
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        StatusBarCompat.compat(this, getResources().getColor(R.color.colorRed));
        slidingMenu = (SlidingMenu) findViewById(R.id.slidingmenulayout);
        slidingMenu.setBehindOffset(200);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setMenu(R.layout.left_layout);
        slidingMenu.setDeviceDistance(DeviceUtil.getMetricsWidth(MainActivity.this));
        slidingMenu.setOnScaleListenet(new SlidingMenu.OnScaleListenet() {
            @Override
            public void onScale(double scale) {
                // LogUtil.d("slidingtest", scale+"");
//                binding.ivTest.setAlpha((float) (1-scale));
            }
        });
        initFragment();
        //使用代码设置SlidingMenu
//        setBehindContentView(R.layout.left_layout);
//        //模式设置
//        SlidingMenu slidingMenu = getSlidingMenu();
//        ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
//
//        slidingMenu.setMode(SlidingMenu.LEFT);
//        //设置触摸范围
//        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        slidingMenu.setBehindOffset(200);
//        slidingMenu.setDeviceDistance(DeviceUtil.getMetricsWidth(MainActivity.this));
//        slidingMenu.setOnScaleListenet(new SlidingMenu.OnScaleListenet() {
//            @Override
//            public void onScale(double scale) {
//                // LogUtil.d("slidingtest", scale+"");
////                binding.ivTest.setAlpha((float) (1-scale));
//            }
//        });

    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.ll_left, new LeftFragment(), "LEFTTAG");
        fragmentTransaction.replace(R.id.ll_content,new ContentFragment(),"MAINTAG");
        fragmentTransaction.commit();
    }
}
