package com.groundbuy.mine_model.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.AddressBean;
import com.groundbuy.mine_model.event.AddressEvent;
import com.groundbuy.mine_model.mvp.contract.MineEditAddressContract;
import com.groundbuy.mine_model.mvp.model.MineEditAddressModel;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.mvp.presenter.MineEditAddressPresenter;
import com.groundbuy.mine_model.utils.JsonCityUtils;
import com.groundbuy.mine_model.utils.SoftKeyboardUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineEditAddressActivity extends MineBaseActivity<MineEditAddressPresenter> implements MineEditAddressContract.IView {


    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_simple_address)
    TextView tvSimpleAddress;
    @BindView(R.id.et_details_address)
    EditText etDetailsAddress;
    @BindView(R.id.chb_default)
    CheckBox chbDefault;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    private int mType;
    private OptionsPickerView pvOptions;
    //  省份
    ArrayList<String> provinceBeanList = new ArrayList<>();
    //  城市
    ArrayList<String> cities;
    ArrayList<List<String>> cityList = new ArrayList<>();
    //  区/县
    ArrayList<String> district;
    ArrayList<List<String>> districts;
    ArrayList<List<List<String>>> districtList = new ArrayList<>();

    private AddressBean.BaseDataBean.ListBean mBean;
    private String mProStr, mCityStr, mAreaStr;
    private String mDefault = "0";

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_edit_address;
    }


    @Override
    protected MineEditAddressPresenter initPresenter() {
        return new MineEditAddressPresenter(this, new MineEditAddressModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mType = getIntent().getIntExtra("Type", 0);
        if (mType == 0) {
            titleBar.setCenterTitle("添加地址");
        } else {
            mBean = (AddressBean.BaseDataBean.ListBean) getIntent().getSerializableExtra("bean");
            titleBar.setCenterTitle("编辑地址");
            etName.setText(mBean.getName());
            etPhone.setText("" + mBean.getMobile());
            etDetailsAddress.setText(mBean.getAddress());
            tvSimpleAddress.setText(mBean.getProvince() + mBean.getCity() + mBean.getArea());
        }
        showPicker();

        initLintener();
    }

    private void initLintener() {
        chbDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chbDefault.setChecked(b);
                if (b) {
                    mDefault = "1";
                } else {
                    mDefault = "0";
                }
            }
        });

    }

    @OnClick({R.id.tv_simple_address, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_simple_address:
                if (SoftKeyboardUtils.isSoftShowing(this_()))
                {
                    SoftKeyboardUtils.hideSoftKeyboard (this_());
                }
                pvOptions.show();
                break;
            case R.id.tv_confirm:
                if (TextUtils.isEmpty(etName.getText().toString().trim())) {
                    ToastUtils.showShort("请输入姓名");
                } else if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
                    ToastUtils.showShort("请输入手机号码");
                } else if (TextUtils.isEmpty(tvSimpleAddress.getText().toString().trim())) {
                    ToastUtils.showShort("请选择收货地址");
                } else if (TextUtils.isEmpty(etDetailsAddress.getText().toString().trim())) {
                    ToastUtils.showShort("请输入详细地址");
                } else if (mType == 0) {//添加地址
                    mPresenter.addAddress(etName.getText().toString().toLowerCase(), etPhone.getText().toString().trim(), mProStr, mCityStr, mAreaStr, etDetailsAddress.getText().toString().trim(), mDefault);
                } else if (mType == 1)//更新地址
                {
                    if (TextUtils.isEmpty(mProStr)) {
                        mPresenter.editAddress(etName.getText().toString().toLowerCase(), etPhone.getText().toString().trim(), mBean.getProvince(), mBean.getCity(), mBean.getArea(), etDetailsAddress.getText().toString().trim(), mDefault, mBean.getId() + "");

                    } else {
                        mPresenter.editAddress(etName.getText().toString().toLowerCase(), etPhone.getText().toString().trim(), mProStr, mCityStr, mAreaStr, etDetailsAddress.getText().toString().trim(), mDefault, mBean.getId() + "");

                    }
                }
                break;
        }
    }

    private void showPicker() {
        parseJson(JsonCityUtils.getJson(this_()));
        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {


            }
        }).setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {

                mProStr = provinceBeanList.get(options1);
                mCityStr = cityList.get(options1).get(options2);
                mAreaStr = districtList.get(options1).get(options2).get(options3);
                tvSimpleAddress.setText(mProStr + mCityStr + mAreaStr);
            }
        }).setSubmitText("确定")//确定按钮文字
                .setCancelText("取消")//取消按钮文字
                .setTitleText("请选择地区")//标题
                .setSubCalSize(14)//确定和取消文字大小
                .setTitleSize(15)//标题文字大小
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(getResources().getColor(R.color.colorPrimary))//确定按钮文字颜色
                .setCancelColor(getResources().getColor(R.color.text_999))//取消按钮文字颜色
                .setTitleBgColor(Color.WHITE)//标题背景颜色 Night mode
                .setBgColor(Color.WHITE)//滚轮背景颜色 Night mode
                .setDividerColor(Color.WHITE)
                .setTextColorCenter(getResources().getColor(R.color.colorPrimary))
                .setContentTextSize(18)//滚轮文字大小
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setCyclic(false, false, false)//循环与否
                .setSelectOptions(0, 0, 0)  //设置默认选中项
                .setOutSideCancelable(false)//点击外部dismiss default true
                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                .build();

        pvOptions.setPicker(provinceBeanList, cityList, districtList);//添加数据源

    }

    public void parseJson(String str) {
        try {
            //  获取json中的数组
            JSONArray jsonArray = new JSONArray(str);
            //  遍历数据组
            for (int i = 0; i < jsonArray.length(); i++) {
                //  获取省份的对象
                JSONObject provinceObject = jsonArray.optJSONObject(i);
                //  获取省份名称放入集合
                String provinceName = provinceObject.getString("name");
//                provinceBeanList.add(new ProvinceBean(provinceName));
                provinceBeanList.add(provinceName);
                //  获取城市数组
                JSONArray cityArray = provinceObject.optJSONArray("city");
                cities = new ArrayList<>();
                //   声明存放城市的集合
                districts = new ArrayList<>();
                //声明存放区县集合的集合
                //  遍历城市数组
                for (int j = 0; j < cityArray.length(); j++) {
                    //  获取城市对象
                    JSONObject cityObject = cityArray.optJSONObject(j);
                    //  将城市放入集合
                    String cityName = cityObject.optString("name");
                    cities.add(cityName);
                    district = new ArrayList<>();
                    // 声明存放区县的集合
                    //  获取区县的数组
                    JSONArray areaArray = cityObject.optJSONArray("area");
                    //  遍历区县数组，获取到区县名称并放入集合
                    for (int k = 0; k < areaArray.length(); k++) {
                        String areaName = areaArray.getString(k);
                        district.add(areaName);
                    }
                    //  将区县的集合放入集合
                    districts.add(district);
                }
                //  将存放区县集合的集合放入集合
                districtList.add(districts);
                //  将存放城市的集合放入集合
                cityList.add(cities);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        dismissBaseDialog();
    }

    @Override
    public void addAddressSu() {
        ToastUtils.showShort("添加地址成功");
        EventBus.getDefault().post(new AddressEvent());
        finish();

    }

    @Override
    public void editAddressSu() {
        ToastUtils.showShort("更新地址成功");
        EventBus.getDefault().post(new AddressEvent());
        finish();

    }
}
