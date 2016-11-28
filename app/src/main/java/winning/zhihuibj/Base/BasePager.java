package winning.zhihuibj.Base;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;

/**
 * Created by Jiang on 2016/11/28.
 */

public abstract class BasePager {
    public Context mContext;
    public View rootView;

    public BasePager(Context mContext) {
        this.mContext = mContext;
        rootView = initView();
    }

    //必须实现，返回View
    protected abstract View initView();

    //初始化数据，不一定需要实现
    public void initData() {

    }

    ;
}
