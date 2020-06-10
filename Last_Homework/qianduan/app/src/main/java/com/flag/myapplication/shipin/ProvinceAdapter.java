package com.flag.myapplication.shipin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

public class ProvinceAdapter extends BaseAdapter {

    private List<ProvinceBean> provinceBeanList;
    private LayoutInflater layoutInflater;

    public ProvinceAdapter(Context context, List<ProvinceBean> provinceBeanList) {
        this.provinceBeanList = provinceBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return provinceBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return provinceBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.view_item, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ProvinceBean provinceBean = provinceBeanList.get(position);
        if (provinceBean != null) {

            //            provinceBean.setUrl("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4");
         //   holder.image.setImageBitmap(Uitls.createVideoThumbnail("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4",1));
//     String uri=   Xutils.BASE_URL+"/"+provinceBean.getUrl()+".mp4";
//            holder.image.setImageBitmap(Uitls.createVideoThumbnail(uri,1));

            holder.image.setImageResource(R.mipmap.shipin2);
        }
        return convertView;
    }

    class ViewHolder {
        ImageView image;
    }

}

