package com.example.luo.updateservice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        showDialog();
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("升级提示");
        builder.setMessage("版本：1.0.1\n大小：6.5M\n1、修改Bug\n2、增加功能");
        builder.setNegativeButton("稍后再说", new AlertDialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        builder.setPositiveButton("马上跟新", new AlertDialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(mContext, DownloadService.class);
                intent.putExtra("url", "http://gdown.baidu.com/data/wisegame/3b01550409c1ed1b/QQ_300.apk");
                startService(intent);
            }
        });
        builder.show();
    }

}
