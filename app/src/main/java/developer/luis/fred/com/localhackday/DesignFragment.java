package developer.luis.fred.com.localhackday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DesignFragment extends Fragment {
    private static final String TAB_POSITION = "tab_position";

    public DesignFragment() {

    }

    public static DesignFragment newInstance(int tabPosition) {
        DesignFragment fragment = new DesignFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int tabPosition = args.getInt(TAB_POSITION);
        switch (tabPosition){
            case 0:{
                FragmentTwo fg2 = new FragmentTwo();
                return  fg2.onCreateView(inflater, container, savedInstanceState); /// oncreated view fragmento con lay aut tab metodo que ecoba un numero entero de salon cuadriti ensima dek mapa ubicacion locationfragmentn
            }
            //case 1:
                //LocationFragment lcfg = new LocationFragment();
                //return lcfg.onCreateView(inflater, container, savedInstanceState);

            case 2:{
                LocationFragment lcfg = new LocationFragment();
                return lcfg.onCreateView(inflater, container, savedInstanceState);
            }
            default:{
                TextView tv = new TextView(getActivity());
                tv.setGravity(Gravity.CENTER);
                tv.setText("Text in Tab #" + tabPosition);
                return tv;
            }
        }
    }
} //manifest linea 14 y 16 indica q se pone ixcpno en el lauchewr

