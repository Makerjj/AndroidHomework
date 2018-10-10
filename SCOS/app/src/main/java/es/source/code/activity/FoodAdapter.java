package es.source.code.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scos.R;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food>{

    private int resourceId;

    public FoodAdapter(Context context, int resource, List<Food> objects) {
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
            viewHolder.foodName = (TextView) view.findViewById(R.id.food_name);
            viewHolder.foodPrice = (TextView) view.findViewById(R.id.food_price);
            viewHolder.foodButton = (Button) view.findViewById(R.id.food_button);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.foodName.setText(content.getName());
        viewHolder.foodPrice.setText("￥"+content.getPrice());
        viewHolder.foodButton.setTag(position);
        viewHolder.foodButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(viewHolder.foodButton.getText().equals("点菜")){
                    Toast.makeText(getContext(), "点菜成功",Toast.LENGTH_SHORT).show();
                    viewHolder.foodButton.setText("退点");
                    FoodView.listNotInOrder.add(content);
                    FoodView.zongjia += content.getPrice();
                }
                else if(viewHolder.foodButton.getText().equals("退点")){
                    viewHolder.foodButton.setText("点菜");
                    FoodView.listNotInOrder.remove(content);
                    FoodView.zongjia -= content.getPrice();
                }
            }
        });
        return  view;
    }

    class ViewHolder{
        TextView foodName;
        TextView foodPrice;
        Button foodButton;
    }


}