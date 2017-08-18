package com.nby.test_rxjava;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/8/1.
 */

public class SecondActivity extends BaseActivity {
    @BindView(R.id.btn_call)
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_second);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_call)
    public void onViewClicked() {
       if (ContextCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
           ActivityCompat.requestPermissions(SecondActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
       }else{
           Call();
       }
    }

    private void Call() {
        try {
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e("回调","走了");
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Call();
                }else{
                    Toast.makeText(SecondActivity.this,"你拒绝了权限",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
