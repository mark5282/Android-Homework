package com.flag.myapplication.shipin;


import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.MediaStore;
//import androidx.core.content.FileProvider;

import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.common.util.KeyValue;
import org.xutils.x;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class luxiangActivity extends AppCompatActivity {
    Uri     photoUri;
    String path;
    ImageView  shipin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luxiang);



        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                httpupimage();
            }
        });
        shipin= (ImageView) findViewById(R.id.shipin);
        shipin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 path="/sdcard/video.mp4";


                //将照片文件保存在缓存文件夹中，注意这里使用的是缓存文件夹，地址应该是sdcard/android/包名/cache，这样子拍照完后在图库是看不到拍照照片的
                //如果想在图库看到照片 则这里应该用 Environment.getExternalStorageDirectory()
             // String  pathstring=System.currentTimeMillis()+"hehe.jpg";
                File photoFile = new File(path);

                if(photoFile.exists()){
                    photoFile.delete();
                }else{
                    try {
                        photoFile.createNewFile();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                /**
                 * 运行到这，photoFile已经存在，这里需要获得这个文件的uri
                 * 分两种情况，android7.0以上和以下
                 */
                if(Build.VERSION.SDK_INT>=24){

                    /**
                     * FileProvider.getUriForFile(),这个方法中需要填写三个参数，
                     * 第一个Context，
                     * 第二个S
                     * tring 任意
                     * 第三个File
                     */
                         photoUri = FileProvider.getUriForFile(luxiangActivity.this, "guozhaohui.com.picturecropeasy", photoFile);
                }else{
                    photoUri = Uri.fromFile(photoFile);
                }

                Intent intent = new Intent();
                intent.setAction("android.media.action.VIDEO_CAPTURE");
                intent.addCategory("android.intent.category.DEFAULT");
                // 保存录像到指定的路径
//                File file = new File("/sdcard/video.3pg");
//                Uri uri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, 1);

            }
        });
    }

    File file;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
          Uri url=data.getData();
             url=data.getData();

            Uri imageUri = data.getData();
            //处理uri,7.0以后的fileProvider 把URI 以content provider 方式 对外提供的解析方法
             file = new File(path);
           // shipin.setImageBitmap(Uitls.createVideoThumbnail(path,1));
            shipin.setImageResource(R.mipmap.shipin2);


            // file=getFileFromUri(imageUri, this);

        }

    }




    public File getFileFromUri(Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        switch (uri.getScheme()) {
            case "content":
                return getFileFromContentUri(uri, context);
            case "file":
                return new File(uri.getPath());
            default:
                return null;
        }
    }

    /**
     通过内容解析中查询uri中的文件路径
     */
    private File getFileFromContentUri(Uri contentUri, Context context) {
        if (contentUri == null) {
            return null;
        }
        File file = null;
        String filePath;
        String[] filePathColumn = {MediaStore.MediaColumns.DATA};
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(contentUri, filePathColumn, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            filePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
            cursor.close();

            if (!TextUtils.isEmpty(filePath)) {
                file = new File(filePath);
            }







        }
        return file;
    }



    public void httpupimage()
    {

        long timeStamp = System.currentTimeMillis();
        List<KeyValue> list = new ArrayList<>();
        list.add(new KeyValue("uploadFile", file));
        list.add(new KeyValue("fileName", timeStamp));

        Xutils.uplodFile("/upload",list, new Xutils.GetDataCallback() {
            @Override
            public void success(String result) {
              finish();
            }

            @Override
            public void failed(String... args) {
                // Log.e(args+);
            }
        });
    }



}
