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
            int n=2210;
            int x=0;
            if((n<2215&&n>2115)||(n<1215&&n>1115)) {
                x = 3;
                n = n - 200;
            }
            else if((n<2115&&n>2015)||(n<1115&&n>1015))
            { x=2;
            n=n-100;}
            else if((n<2015&&n>0)||(n<1015&&n>0))
                x=1;
        //DrawMarker(floor(n),building(n),salon(n));//2001
       switch(n) {
           case 2014:
           DrawMarker(x, 75, 60);
               break;
           case 2013:
           DrawMarker(x, 75, 149);
               break;
           case 2012:
           DrawMarker(x, 75, 238);
               break;
           case 2011:
           DrawMarker(x, 75, 327);
               break;
           case 2010:
           DrawMarker(x, 75, 416);
               break;
           case 2009:
           DrawMarker(x, 75, 505);
               break;
           case 2008:
           DrawMarker(x, 75, 594);
               break;
           case 2007:
           DrawMarker(x, 75, 683);
               break;
           case 2006:
           DrawMarker(x, 75, 772);
               break;
           case 2005:
           DrawMarker(x, 75, 861);
               break;
           case 2004:
           DrawMarker(x, 75, 950);
               break;
           case 2003:
           DrawMarker(x, 75, 1039);
               break;
           case 2002:
           DrawMarker(x, 75, 1128);
               break;
           case 2001:
           DrawMarker(x, 75, 1217);
               break;
           case 1014:
               DrawMarker(x, 903, 60);
               break;
           case 1013:
               DrawMarker(x, 903, 149);
               break;
           case 1012:
               DrawMarker(x, 903, 238);
               break;
           case 1011:
               DrawMarker(x, 903, 327);
               break;
           case 1010:
               DrawMarker(x, 903, 416);
               break;
           case 1009:
               DrawMarker(x, 903, 505);
               break;
           case 1008:
               DrawMarker(x, 903, 594);
               break;
           case 1007:
               DrawMarker(x, 903, 683);
               break;
           case 1006:
               DrawMarker(x, 903, 772);
               break;
           case 1005:
               DrawMarker(x, 903, 861);
               break;
           case 1004:
               DrawMarker(x, 903, 950);
               break;
           case 1003:
               DrawMarker(x, 903, 1039);
               break;
           case 1002:
               DrawMarker(x, 903, 1128);
               break;
           case 1001:
               DrawMarker(x, 903, 1217);
               break;
       }
    }
/*
    public int floor(int room){
        int a;
        if(building(room)==903)
            a=room-1000;
        else
            a=room-2000;
        double x=a*0.01;
        int b=(int)x;
       return b+1;
    }
    public float building(int room){
        double x=room*0.001;
        int b=(int)x;
        float z=0;
        switch(b){
            case 1: {
                z = 903;
                break;
            }
            case 2: {
                z = 75;
                break;
            }
        }
        return z;
    }
    public float salon(int room){
        int a;
        if(building(room)==903)
            a=1000;
        else
            a=2000;
        int z=floor(room)*100;
        int x=a+z;
        int i;
        float b=60;
        for(i=0;i<=x;i++)
        {
            b+=89;
        }
        return b;
    }
*/

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