package winning.zhihuibj.view.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import winning.zhihuibj.Base.BasePager;

/**
 * Created by Jiang on 2016/11/28.
 */

public class MyPagerAdapter extends PagerAdapter {
    private LayoutInflater mInflater;
    private List<BasePager> pagers;

    public MyPagerAdapter(ArrayList<BasePager> pagers) {
        this.pagers = pagers;
    }

    @Override
    public int getCount() {
        return pagers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BasePager pager = pagers.get(position);
        container.addView(pager.rootView);
        return pager.rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
