package winning.zhihuibj.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import winning.zhihuibj.Base.BaseFragment;

/**
 * Created by Jiang on 2016/11/10.
 */

public class LeftFragment extends BaseFragment {

    @Override
    protected View initView() {
        TextView tv = new TextView(getActivity());
        tv.setText("左侧菜单");
        return tv;
    }

    @Override
    protected void initData() {

    }

}
