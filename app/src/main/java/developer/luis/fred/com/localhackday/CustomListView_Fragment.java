package developer.luis.fred.com.localhackday;


import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListView_Fragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View View_CustomListView_Fragment;

    ArrayList<Item> imageArry = new ArrayList<>();
    CustomImageAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View_CustomListView_Fragment = inflater.inflate(R.layout.fragment_custom_list_view, container, false);
        UiInitialization();
        return View_CustomListView_Fragment;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:{
                Snackbar.make(view, "No hay tarea, descansa", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            }
            case 1:{
                Snackbar.make(view, "No hay tarea, descansa", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            }
            case 2:{
                Snackbar.make(view, "No hay tarea, descansa", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            }
            case 3:{
                Snackbar.make(view, "Peligro examen !!!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            }
            case 4:{
                Snackbar.make(view, "Tarea pendiente", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            }
            default:{
                Snackbar.make(view, "Click On List", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            }
        }
    }

    private void UiInitialization(){
        String Monday[]={"Lunes"};
        String Tuesday[]={"Martes"};
        String Wednesday[]={"Miercoles"};
        String Thursday[]={"Jueves"};
        String Friday[]={"Viernes"};


        imageArry.add(new Item(R.drawable.ic_done_black_24dp, Monday));
        imageArry.add(new Item(R.drawable.ic_done_black_24dp, Tuesday));
        imageArry.add(new Item(R.drawable.ic_done_black_24dp, Wednesday));
        imageArry.add(new Item(R.drawable.ic_highlight_off_black_24dp, Thursday));
        imageArry.add(new Item(R.drawable.ic_extension_black_24dp, Friday));

        // add data in contact image adapter
        adapter = new CustomImageAdapter(MainActivity.globalContext, R.layout.list, imageArry);
        ListView dataList = (ListView) View_CustomListView_Fragment.findViewById(R.id.list);
        dataList.setAdapter(adapter);
        dataList.setOnItemClickListener(this);

    }


    public static CustomListView_Fragment newInstance(String param1, String param2) {
        CustomListView_Fragment fragment = new CustomListView_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CustomListView_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
