package winning.myapplication;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /***
     * Design的输入容器(子控件需要包含EditText)
     */
    TextInputLayout mTextInputLayout;
    /**
     * EditText输入框
     */
    EditText mEditText;
    /***
     * Design的输入容器(子控件需要包含EditText)
     */
    TextInputLayout mbTextInputLayout;
    /**
     * EditText输入框
     */
    EditText mbEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextInputLayout = (TextInputLayout) findViewById(R.id.a_textinputlayout);
        //设置hint提示
        mTextInputLayout.setHint("请输入用户名");
        //获取TextInputLayout下的输入框
        mEditText = mTextInputLayout.getEditText();
        //设置对EditText输入的监听事件
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //这儿判断操作，如果输入错误可以给用户提示
                if (s.length() < 5) {
                    mTextInputLayout.setErrorEnabled(true);
                    mTextInputLayout.setError("用户名不能小于6位");
                } else {
                    mTextInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mbTextInputLayout = (TextInputLayout) findViewById(R.id.b_textinputlayout);
        //设置hint提示
        mbTextInputLayout.setHint("请输入密码");
        //获取TextInputLayout下的输入框
        mbEditText = mbTextInputLayout.getEditText();
        //设置对EditText输入的监听事件
        mbEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //这儿判断操作，如果输入错误可以给用户提示
                if (s.length() < 5) {
                    mbTextInputLayout.setErrorEnabled(true);
                    mbTextInputLayout.setError("用户名不能小于6位");
                } else {
                    mbTextInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
