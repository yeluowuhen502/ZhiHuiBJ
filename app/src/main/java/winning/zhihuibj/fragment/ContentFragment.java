package winning.zhihuibj.fragment;

import android.view.View;
import android.widget.TextView;

import winning.zhihuibj.Base.BaseFragment;
import winning.zhihuibj.R;

/**
 * Created by Jiang on 2016/11/24.
 */

public class ContentFragment extends BaseFragment {
    @Override
    protected View initView() {
       View view = View.inflate(mActivity, R.layout.content_fragment_layout,null);
        return view;
    }

    @Override
    protected void initData() {

    }
}
