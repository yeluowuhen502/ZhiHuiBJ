package winning.zhihuibj;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import winning.zhihuibj.databinding.ActivitySplashBinding;
import winning.zhihuibj.utils.CacheUtils;
import winning.zhihuibj.utils.CommonUtil;

public class SplashActivity extends ZHBJBaseActivity {
    private ActivitySplashBinding binding;
    //private String IS_APP_FIRST_OPEN = "is_app_first_open";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
        binding = DataBindingUtil.setContentView(SplashActivity.this, R.layout.activity_splash);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);

        //创建动画集合
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);

        binding.rlSplash.startAnimation(animationSet);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束用来判断的
                boolean isAppFirstOpen = CacheUtils.getBoolean(SplashActivity.this, CacheUtils.IS_APP_FIRST_OPEN, true);
                if (isAppFirstOpen) {
                    //CommonUtil.showToast(SplashActivity.this, "进入引导页");
                    startMyActivity(GuideActivity.class, null);
                    finish();
                } else {
                   // CommonUtil.showToast(SplashActivity.this, "进入主页");
                    startMyActivity(MainActivity.class, null);
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
