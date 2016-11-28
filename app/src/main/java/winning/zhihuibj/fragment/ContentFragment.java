package winning.zhihuibj.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import winning.zhihuibj.Base.BaseFragment;
import winning.zhihuibj.Base.BasePager;
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
    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.content_fragment_layout, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        return view;
    }

    @Override
    protected void initData() {
        ArrayList<BasePager> pagers = new ArrayList<BasePager>();
        pagers.add(new HomePager(mActivity));
        pagers.add(new NewsPager(mActivity));
        pagers.add(new SmartServicePager(mActivity));
        pagers.add(new GovAffairsPager(mActivity));
        pagers.add(new SettingsPager(mActivity));
        mViewPager.setAdapter(new MyPagerAdapter(pagers));
    }
}
