package com.wangzuo.tencenttinkerdemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    private Button loadPatchBtn;
    private Button showBugBtn;
    private MyOnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    /**
     * 初始化
     */
    private void init() {
        findview();

        setListener();
    }

    /**
     * 设置监听
     */
    private void setListener() {
        listener = new MyOnClickListener();
        loadPatchBtn.setOnClickListener(listener);
        showBugBtn.setOnClickListener(listener);
    }

    /**
     * 找到控件
     */
    private void findview() {
        loadPatchBtn = (Button) findViewById(R.id.loadPatch);
        showBugBtn = (Button) findViewById(R.id.showBug);
    }


    /**
     * 监听器
     */
    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Button btn = (Button) view;
            int id = btn.getId();
            switch (id) {
                case R.id.loadPatch:
                    loadPatch();
                    break;
                case R.id.showBug:
                    showBug();
                    break;
            }
        }
    }

    /**
     * 显示bug信息
     */
    private void showBug() {
        Toast.makeText(this,R.string.show_bug,Toast.LENGTH_SHORT).show();
    }

    /**
     * 加载补丁
     */
    private void loadPatch() {
        TinkerInstaller.
                onReceiveUpgradePatch(
                        getApplicationContext(),
                        Environment.getExternalStorageDirectory().
                                getAbsolutePath() + "/patch_signed_7zip.apk");

    }
}
