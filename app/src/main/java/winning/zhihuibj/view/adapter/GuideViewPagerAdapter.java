package winning.zhihuibj.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import winning.zhihuibj.utils.CommonUtil;

/**
 * Created by Jiang on 2016/11/10.
 */

public class GuideViewPagerAdapter extends PagerAdapter {
    private ArrayList<ImageView> imgViews;
    private Context mContext;
    private Button btn;
    public GuideViewPagerAdapter(Context context,ArrayList<ImageView> imgViews, Button btn) {
        this.imgViews = imgViews;
        this.btn = btn;
        mContext =context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img = new ImageView(mContext);
        img.setAlpha(0);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imgViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
