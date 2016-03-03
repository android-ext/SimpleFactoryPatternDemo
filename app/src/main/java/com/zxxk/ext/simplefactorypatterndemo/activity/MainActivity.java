package com.zxxk.ext.simplefactorypatterndemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.zxxk.ext.simplefactorypatterndemo.R;
import com.zxxk.ext.simplefactorypatterndemo.service.Operation;
import com.zxxk.ext.simplefactorypatterndemo.service.OperationFactory;

/**
 * @description: 工厂方法模式测试
 * @Time: 2016/3/2 11:38
 * @param 
 * @return 
 */ 
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    /** 单价 */
    private EditText mOneET;
    /** 数量 */
    private EditText mTwoET;
    /** 计算方式选择控件 */
    private Spinner mSpinner;
    /** 总价 */
    private TextView mResultTV;
    /** 计算方式 */
    private static final String[] mTypes = new String[]{"+", "-", "*", "/"};
    /** 选择的计算方式下标 */
    private int mSelectedIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    /**
     * @description: 初始化布局控件
     * @Created Time: 2016/3/2 8:30
     * @param
     * @return
     */
    private void initViews() {

        mOneET = initViewById(R.id.main_price_et);
        mTwoET = initViewById(R.id.main_count_et);
        mSpinner = initViewById(R.id.main_calculate_type);
        mResultTV = initViewById(R.id.main_total_tv);

        initSpinner();

        registerViewListener();
    }

    /**
     * @description: 初始化运算符号
     * @Created Time: 2016/3/2 8:46
     * @param
     * @return
     */
    private void initSpinner() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinenr_item_view, mTypes);

        mSpinner.setAdapter(adapter);
    }

    /**
     * @description: 控件注册监听器
     * @Created Time: 2016/3/2 8:42
     * @param
     * @return
     */
    private void registerViewListener() {

        initViewById(R.id.main_submit_btn).setOnClickListener(this);
        initViewById(R.id.main_reset_btn).setOnClickListener(this);
        mSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.main_submit_btn:

                calculateTotalCash();
                break;

            case R.id.main_reset_btn:
                resetViewsValue();
                break;
        }
    }

    /**
     * @description: 计算运算结果
     * @Time: 2016/3/2 11:41
     * @param
     * @return
     */
    private void calculateTotalCash() {
        String oneStr = mOneET.getText().toString().trim();
        if (validateStr(oneStr)) {
            showToast("输入正确的操作数1");
            return;
        }

        String twoStr = mTwoET.getText().toString().trim();
        if (validateStr(twoStr)) {
            showToast("输入正确的操作数2");
            return;
        }

        String operate = mTypes[mSelectedIndex];
        Operation operation = OperationFactory.createOperation(operate);
        operation.setNumberA(Double.parseDouble(oneStr));
        operation.setNumberB(Double.parseDouble(twoStr));

        mResultTV.setText(String.valueOf(operation.getResult()));

    }

    /**
     * @description 输入值有效性判断
     * @Created Time 2016/3/2 9:07
     * @param
     * @return
     */
    private boolean validateStr(String value) {

        boolean isValid = true;
        if (TextUtils.isEmpty(value))
            return isValid;

        try {
            if (Integer.parseInt(value) > 0) {
                isValid = false;
            }
        } catch (Exception e) {

        }
        return isValid;
    }

    /**
     * @description: 重置控件的值
     * @Created Time: 2016/3/2 8:44
     * @param
     * @return
     */
    private void resetViewsValue() {

        mOneET.setText("");
        mTwoET.setText("");
        mResultTV.setText("");
        mSpinner.setSelection(0);
    }

    private <T extends View> T initViewById(int resId) {

        return (T) findViewById(resId);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        mSpinner.setSelection(position);
        mSelectedIndex = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
