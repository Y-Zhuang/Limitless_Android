package com.zhuang.limitless_android.view.activity;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import com.zhuang.limitless_android.R;
import com.zhuang.limitless_android.base.BaseViewImpl;
import com.zhuang.limitless_android.presenter.activity.LoginActivity;
import com.zhuang.limitless_android.presenter.fragment.LoginFragment;
import com.zhuang.limitless_android.presenter.fragment.RegFragment;

/**
 * @Package     : com.zhuang.limitless_android.view.activity
 * @ClassName   : LoginView 
 * @Description : 登陆注册视图
 * @author      : Zhuang
 * @date        : 2019-12-04 16:23
 */
public class LoginView extends BaseViewImpl implements View.OnClickListener {

    private Button loginBtn;
    private Button regBtn;
    private int frameLayout;
    private int selectedId;

    public int getFrameLayout() {
        return frameLayout;
    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        loginBtn = get(R.id.login_Btn);
        regBtn = get(R.id.reg_Btn);
        frameLayout = R.id.login_reg_fl;
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        loginBtn.setOnClickListener(this);
        regBtn.setOnClickListener(this);
    }

    public void setSelected(int viewId, float value, int color){
        get(viewId).animate().scaleX(value).scaleY(value).setDuration(300).start();
        GradientDrawable gradientDrawable = (GradientDrawable)get(viewId).getBackground();
        gradientDrawable.setColor(color);
        if(value == 1.2){
            selectedId = viewId;
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_Btn:
                if(selectedId != v.getId()){
                    ((LoginActivity)getActivity()).switchFragment(frameLayout,new LoginFragment());
                    setSelected(v.getId(),1.2f,getActivity().getResources().getColor(R.color.colorBlue));
                    setSelected(R.id.reg_Btn,1f,getActivity().getResources().getColor(R.color.colorGray));
                }
                break;
            case R.id.reg_Btn:
                if(selectedId != v.getId()){
                    ((LoginActivity)getActivity()).switchFragment(frameLayout,new RegFragment());
                    setSelected(v.getId(),1.2f,getActivity().getResources().getColor(R.color.colorBlue));
                    setSelected(R.id.login_Btn,1f,getActivity().getResources().getColor(R.color.colorGray));
                }
                break;
            default:
                break;
        }
    }
}
