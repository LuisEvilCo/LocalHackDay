package developer.luis.fred.com.localhackday;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomImageAdapter extends ArrayAdapter<Item>  {
    Context context;
    int layoutResourceId;
    LinearLayout linearMain;
    ArrayList<Item> data = new ArrayList<>();

    public CustomImageAdapter(Context context, int layoutResourceId,
                              ArrayList<Item> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            linearMain = (LinearLayout) row.findViewById(R.id.lineraMain);

            Item myImage = data.get(position);
            for (int j = 0; j < myImage.getName().length; j++) {
                TextView label = new TextView(context);
                label.setText(myImage.name[j]);
                linearMain.addView(label);
            }
            ImageView image = new ImageView(context);
            int outImage = myImage.image;
            image.setImageResource(outImage);
            linearMain.addView(image);
        }

        return row;

    }

}