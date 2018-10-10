package es.source.code.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scos.R;

import java.util.List;

public class FoodOrderAdapter extends ArrayAdapter<Food> {
    private int resourceId;

    public FoodOrderAdapter(Context context, int resource, List<Food> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Food content = getItem(position);
        View view;
        final ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.foodName = (TextView) view.findViewById(R.id.food_name2);
            viewHolder.foodPrice = (TextView) view.findViewById(R.id.food_price2);
            viewHolder.foodBackup = (EditText) view.findViewById(R.id.backup);
            viewHolder.cnt = (TextView) view.findViewById(R.id.food_cnt);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.foodName.setText(content.getName());
        viewHolder.foodPrice.setText("￥"+content.getPrice());
        viewHolder.cnt.setText("1");

        return  view;
    }

    class ViewHolder{
        TextView foodName;
        TextView foodPrice;
        EditText foodBackup;
        TextView cnt;
    }
}
