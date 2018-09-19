package expensetracker.tejas.expensetrckr19;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ProductListAdapter extends BaseAdapter {

    private Context mcontext;
    private List<Product> mProductList;

    public ProductListAdapter(Context mcontext, List<Product> mProductList) {
        this.mcontext = mcontext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(mcontext,R.layout.item_product_list,null);
        TextView tv_name=(TextView)v.findViewById(R.id.tv_name);
        TextView tv_price=(TextView)v.findViewById(R.id.tv_price);
        tv_name.setText(mProductList.get(position).getName());
        tv_price.setText("Rs"+String.valueOf(mProductList.get(position).getAmount()));
        v.setTag(mProductList.get(position).getId());
        return v;
    }
}
