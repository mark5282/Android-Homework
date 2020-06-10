package com.flag.myapplication.shipin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;
    private ProvinceAdapter mProvinceAdapter;
    private List<ProvinceBean> provinceBeanList=new ArrayList<>();
    //private String[] provinceNames = new String[]{"北京", "上海", "广东", "广西", "天津", "重庆", "湖北", "湖南", "河北", "河南", "山东"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridView = (GridView) this.findViewById(R.id.grid_view);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,PlayActivity.class);
                intent.putExtra("data",provinceBeanList.get(position));
                startActivity(intent);
            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,luxiangActivity.class));
            }
        });
    }

    private void initView() {
        mProvinceAdapter = new ProvinceAdapter(this, provinceBeanList);
        mGridView.setAdapter(mProvinceAdapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sellall();
    }

    public void sellall(  )
    {
        Xutils.post("/seleall", null, new Xutils.GetDataCallback() {
            @Override
            public void success(String result) {
                provinceBeanList.clear();
                Log.e("======", result);
                Gson gson = new Gson();//创建Gson对象  

                ResultModel<ProvinceBean> resultModel = ResultModel.fromJson(result, ProvinceBean.class);

                if (resultModel.getCode()==1) {//有该用户
                    provinceBeanList.addAll(resultModel.getArrayList());
                    initView();
                } else {

                }
            }

            @Override
            public void failed(String... args) {
                 Log.e("",args+"");


            }
        });














    }

}
