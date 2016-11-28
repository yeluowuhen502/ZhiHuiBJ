package winning.zhihuibj.view.viewpagers;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import winning.zhihuibj.Base.BasePager;
import winning.zhihuibj.utils.ConstantUtils;

/**
 * 首页ViewPager
 * Created by Jiang on 2016/11/28.
 */

public class NewsPager extends BasePager {
    public NewsPager(Context mContext) {
        super(mContext);
    }

    @Override
    public void initData() {
        tv_basepager_title.setText("新闻中心");
        TextView tv = new TextView(mContext);
        tv.setText("新闻中心");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.RED);
        fl_basepager_content.removeAllViews();
        fl_basepager_content.addView(tv);
        //访问网络
        getDataFromServer();
    }

    //从服务端获取数据
    public void getDataFromServer() {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, ConstantUtils.NEWSCENTER_URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> info) {
                String msg = info.result.toString();
            }

            @Override
            public void onFailure(HttpException e, String s) {
                String string = s;
            }
        });
    }
}
