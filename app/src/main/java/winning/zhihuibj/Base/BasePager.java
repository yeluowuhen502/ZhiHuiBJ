package winning.zhihuibj.Base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import winning.zhihuibj.MyApplicationUtil;
import winning.zhihuibj.R;

/**
 * Created by Jiang on 2016/11/28.
 */

public abstract class BasePager {
    public Context mContext;
    public View rootView;

    //头布局相关声明
    public ImageButton ib_basepager_menu;
    public TextView tv_basepager_title;
    public FrameLayout fl_basepager_content;

    public BasePager(Context mContext) {
        this.mContext = mContext;
        rootView = initView();
    }

    //必须实现，返回View
    protected View initView() {
        View view = View.inflate(mContext, R.layout.basepager, null);
        //头布局的初始化
        ib_basepager_menu = (ImageButton) view.findViewById(R.id.ib_basepager_menu);
        tv_basepager_title = (TextView) view.findViewById(R.id.tv_basepager_title);
        fl_basepager_content = (FrameLayout) view.findViewById(R.id.fl_basepager_content);
        ib_basepager_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlidingMenu slidingMenu = (SlidingMenu) MyApplicationUtil.getSlidingMenuMap();
                slidingMenu.toggle();
            }
        });
        return view;
    }

    ;

    //初始化数据，不一定需要实现
    public void initData() {

    }
}
