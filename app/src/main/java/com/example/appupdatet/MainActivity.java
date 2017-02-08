package com.example.appupdatet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bobo.utils.DiffUtils;
import com.bobo.utils.PatchUtils;

public class MainActivity extends Activity {
    private String oldapk = "mnt/sdcard/old.apk";//??汾
    private String newapk = "mnt/sdcard/new.apk";//?°汾
    private String pathapk = "mnt/sdcard/path.patch";//???? . ???????????????????????????
    private String complexapk = "mnt/sdcard/newapk.apk";//????apk
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setMessage("?????...");


    }


    static {
        System.loadLibrary("diff");
    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.add: //????°汾
                dialog.show();
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        PatchUtils.patch(oldapk, complexapk, pathapk);
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(MainActivity.this, "?°汾??????ɡ?", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setDataAndType(Uri.parse("file:///sdcard/newapk.apk"),
                                        "application/vnd.android.package-archive");
                                startActivity(intent);
                            }
                        });
                    }
                }).start();

                break;
            case R.id.diff://???汾???????
                dialog.show();
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        DiffUtils.genDiff(oldapk, newapk, pathapk);
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(MainActivity.this, "??????????ɡ?", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                    }
                }).start();

                break;
            default:
                break;
        }
    }
}
