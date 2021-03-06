package winning.zhihuibj.view.viewpagers;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import winning.zhihuibj.Base.BasePager;

/**
 * 首页ViewPager
 * Created by Jiang on 2016/11/28.
 */

public class HomePager extends BasePager {
    public HomePager(Context mContext) {
        super(mContext);
    }

    @Override
    public void initData() {
        tv_basepager_title.setText("首页");
        ib_basepager_menu.setVisibility(View.GONE);
        TextView tv = new TextView(mContext);
        tv.setText("首页");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.RED);
        fl_basepager_content.removeAllViews();
        fl_basepager_content.addView(tv);
    }
}
