package winning.zhihuibj;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.rd.animation.AnimationType;

import java.util.ArrayList;

import winning.zhihuibj.databinding.ActivityGuideBinding;
import winning.zhihuibj.utils.CacheUtils;
import winning.zhihuibj.utils.CommonUtil;
import winning.zhihuibj.utils.LogUtil;
import winning.zhihuibj.view.adapter.GuideViewPagerAdapter;

public class GuideActivity extends ZHBJBaseActivity {
    private ActivityGuideBinding binding;
    private int preItem = 0;
    //图片
    private ArrayList<ImageView> imgViews;
    private int[] imgs = new int[]{
            R.mipmap.guide_1,
            R.mipmap.guide_2,
            R.mipmap.guide_3
    };

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
//        setContentView(R.layout.activity_guide);
        binding = DataBindingUtil.setContentView(GuideActivity.this, R.layout.activity_guide);
        initData();
        initViews();
    }

    private void initViews() {
//        btn = (Button) findViewById(R.id.btn_start);
        //binding.pageIndicatorView.setAnimationType(AnimationType.SCALE);
        binding.pageIndicatorView.setAnimationDuration(100);
        binding.viewPager.setAdapter(new GuideViewPagerAdapter(GuideActivity.this, imgViews, btn));
        binding.pageIndicatorView.setSelectedColor(Color.parseColor("#ff0000"));
        binding.pageIndicatorView.setUnselectedColor(Color.WHITE);
        binding.pageIndicatorView.setViewPager(binding.viewPager);

        //按钮的监听
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CacheUtils.setBoolean(GuideActivity.this, CacheUtils.IS_APP_FIRST_OPEN, false);
                startMyActivity(MainActivity.class, null);
                finish();
            }
        });
        //ViewPager的监听
        binding.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                LogUtil.d("scroll", positionOffset + "------>" + positionOffsetPixels);
                if(position == 0){
                    binding.ivImg1.setAlpha(1 - positionOffset);
                }else if(position == 1){
                    binding.ivImg2.setAlpha(1 - positionOffset);
                }else if(position == 2){
                    binding.ivImg3.setAlpha(1 - positionOffset);
                }

            }

            @Override
            public void onPageSelected(int position) {
                //  CommonUtil.showToast(GuideActivity.this,position+"");
//                LogUtil.d("size00",position+","+(imgViews.size()-1)+"");
                if (position == imgViews.size() - 1) {
                    //  LogUtil.d("size00","pipeile");
//                    btn.setVisibility(View.VISIBLE);
                    binding.btnStart.setVisibility(View.VISIBLE);
                }


                if (position == preItem) {
                    //不作处理
                    LogUtil.d("scroll", "没有移动");
                    return;
                }
                if (position > preItem) {
                    //从左向右滑
                    LogUtil.d("scroll", "从左向右滑");
                    preItem = position;
                    return;
                }
                if (position < preItem) {
                    //从右向左滑
                    LogUtil.d("scroll", "从右向左滑");
                    preItem = position;
                    return;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                LogUtil.d("scroll", state + "------>");
            }
        });
    }

    private void initData() {
        //添加图片
        imgViews = new ArrayList<ImageView>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView imv = new ImageView(this);
            imv.setAlpha(0);
            imgViews.add(imv);
        }
    }

}
