package winning.zhihuibj.fragment;

import android.view.View;
import android.widget.TextView;

import winning.zhihuibj.Base.BaseFragment;

/**
 * Created by Jiang on 2016/11/24.
 */

public class ContentFragment extends BaseFragment {
    @Override
    protected View initView() {
        TextView tv = new TextView(getActivity());
        tv.setText("主菜单");
        return tv;
    }

    @Override
    protected void initData() {

    }
}
