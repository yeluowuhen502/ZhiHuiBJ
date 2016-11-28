package winning.zhihuibj.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import winning.zhihuibj.Base.BaseFragment;
import winning.zhihuibj.Base.BasePager;
import winning.zhihuibj.MyApplicationUtil;
import winning.zhihuibj.R;
import winning.zhihuibj.view.adapter.MyPagerAdapter;
import winning.zhihuibj.view.viewpagers.GovAffairsPager;
import winning.zhihuibj.view.viewpagers.HomePager;
import winning.zhihuibj.view.viewpagers.NewsPager;
import winning.zhihuibj.view.viewpagers.SettingsPager;
import winning.zhihuibj.view.viewpagers.SmartServicePager;

/**
 * Created by Jiang on 2016/11/24.
 */

public class ContentFragment extends BaseFragment {
    private ViewPager mViewPager;
    private RadioGroup rg_bt_bg;
    //Viewpager页面的缓存
    protected ArrayList<BasePager> pagers;

    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.content_fragment_layout, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        rg_bt_bg = (RadioGroup) view.findViewById(R.id.rg_bt_bg);

        rg_bt_bg.check(R.id.rb_home);
        enableSlidingMenu(false);
        //RadioGroup的选中监听
        rg_bt_bg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mViewPager.setCurrentItem(0, false);
                        enableSlidingMenu(false);
                        break;
                    case R.id.rb_news_center:
                        mViewPager.setCurrentItem(1, false);
                        enableSlidingMenu(true);
                        break;
                    case R.id.rb_smart_service:
                        mViewPager.setCurrentItem(2, false);
                        enableSlidingMenu(true);
                        break;
                    case R.id.rb_govaffaiirs:
                        mViewPager.setCurrentItem(3, false);
                        enableSlidingMenu(true);
                        break;
                    case R.id.rb_settings:
                        mViewPager.setCurrentItem(4, false);
                        enableSlidingMenu(false);
                        break;
                }
            }
        });
        //Viewpager的选中监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pagers.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    @Override
    protected void initData() {
        //将每一页缓存在了ArrayList集合之中
        pagers = new ArrayList<BasePager>();

        pagers.add(new HomePager(mActivity));
        pagers.add(new NewsPager(mActivity));
        pagers.add(new SmartServicePager(mActivity));
        pagers.add(new GovAffairsPager(mActivity));
        pagers.add(new SettingsPager(mActivity));
        //设置一下适配器
        mViewPager.setAdapter(new MyPagerAdapter(pagers));
        pagers.get(0).initData();
    }
    //是否可以打开SlidingMenu的触发事件
    protected void enableSlidingMenu(boolean flag){
        SlidingMenu slidingMenu = (SlidingMenu) MyApplicationUtil.getSlidingMenuMap();
        if(flag){
           slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }
}
