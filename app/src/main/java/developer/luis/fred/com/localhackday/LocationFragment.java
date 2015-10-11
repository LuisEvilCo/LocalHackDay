package developer.luis.fred.com.localhackday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class LocationFragment extends   MainActivityFragment  {

    private ImageView ima;
    private View View_LocationFragment;
    private ImageView Circle_one, Circle_two, Circle_tree;
    MainActivityFragment Frag1;


    public LocationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View_LocationFragment = inflater.inflate(R.layout.locationfragment, container, false);
        Frag1 = new MainActivityFragment();
        UiInitialization();
        map();
        return View_LocationFragment;
    }

    private void map(){
        DrawMarker(1,50,500);//1102
    }
    private void DrawMarker (int floor_to_mark, float x_position, float y_position){
        switch (floor_to_mark){
            case 1:{
                Circle_one.setX(x_position);
                Circle_one.setY(y_position);
                Circle_one.setVisibility(View.VISIBLE);
                break;
            }
            case 2:{
                Circle_two.setX(x_position);
                Circle_two.setY(y_position);
                Circle_two.setVisibility(View.VISIBLE);
                break;
            }
            case 3:{
                Circle_tree.setX(x_position);
                Circle_tree.setY(y_position);
                Circle_tree.setVisibility(View.VISIBLE);
                break;
            }
            default:{
                break;
            }
        }
    }

    private void UiInitialization(){
        Circle_one = (ImageView) View_LocationFragment.findViewById(R.id.floor1);
        Circle_one.setOnClickListener(this);
        Circle_two = (ImageView) View_LocationFragment.findViewById(R.id.floor2);
        Circle_two.setOnClickListener(this);
        Circle_tree = (ImageView) View_LocationFragment.findViewById(R.id.floor3);
        Circle_tree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:{
                //Toast.makeText(getContext(), "Fuck Yeah", Toast.LENGTH_LONG).show();
                break;
            }
        }
    }

}