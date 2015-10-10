package developer.luis.fred.com.localhackday;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class LocationFragment extends  Activity {

    private ImageView ima;
    private View View_LocationFragment;
    MainActivityFragment Frag1;
    Bitmap bitmap;
    Paint paint;
    Canvas canvas;
    float downx, downy, movex, movey, upx, upy=0;
    //private String imagename = "MapaEscom";

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

       // ima =(ImageView)findViewById(R.id.imageView);
/*
        Display dis = getWindowManager().getDefaultDisplay();
        float dw =dis.getHeight();
        float dh= dis.getHeight();
        bitmap= Bitmap.createBitmap((int)dw, (int)dh, Bitmap.Config.ARGB_8888);
        canvas= new Canvas(bitmap);
        paint= new Paint();
        paint.setColor(Color.BLUE);
        paint.setShadowLayer(5, 2, 2, Color.BLUE);
        ima.setImageBitmap(bitmap);
        ima.setOnTouchListener((View.OnTouchListener) this);
*/
        return View_LocationFragment;
    }

   /* //@Override
    public boolean onTouch(View arg0, MotionEvent arg1){
        switch (arg1.getAction()){
            case MotionEvent.ACTION_DOWN:
                downx=arg1.getX();
                downy=arg1.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                movex =arg1.getX();
                movey = arg1.getY();
                break;
            case MotionEvent.ACTION_UP:
                upx = arg1.getX();
                upy = arg1.getY();
                canvas.drawRect(downx,downy,upx,upy,paint);
                ima.invalidate();
                break;
        }
        return true;
    }*/
}