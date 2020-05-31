package com.example.chapter3.homework;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView lottieAnimationView;
    private ListView mListView = null;
    private String[] data = {"xiao ming","xiao hong","xiao bai","da pang"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lottieAnimationView = (LottieAnimationView)getView().findViewById(R.id.lottie);
        mListView = (ListView)getView().findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(arrayAdapter);
        //mListView.setAlpha(0);
        mListView.setVisibility(View.GONE);

        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alpha = new AlphaAnimation(1,0);
        alpha.setDuration(5000);
        animationSet.addAnimation(alpha);

        final AnimationSet animationSet1 = new AnimationSet(true);
        AlphaAnimation alpha1 = new AlphaAnimation(0,1);
        alpha1.setDuration(5000);
        animationSet1.addAnimation(alpha1);

        lottieAnimationView.startAnimation(animationSet);
        lottieAnimationView.playAnimation();
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setVisibility(View.GONE);

                mListView.setVisibility(View.VISIBLE);
                mListView.startAnimation(animationSet1);
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
