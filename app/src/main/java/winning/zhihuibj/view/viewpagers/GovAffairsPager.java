package winning.zhihuibj.view.viewpagers;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import winning.zhihuibj.Base.BasePager;

/**
 * 首页ViewPager
 * Created by Jiang on 2016/11/28.
 */

public class GovAffairsPager extends BasePager {
    public GovAffairsPager(Context mContext) {
        super(mContext);
    }

    @Override
    protected View initView() {
        TextView tv = new TextView(mContext);
        tv.setText("政务");
        return tv;
    }
}
