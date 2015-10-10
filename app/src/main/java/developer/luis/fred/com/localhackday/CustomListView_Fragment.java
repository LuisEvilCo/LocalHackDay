package developer.luis.fred.com.localhackday;


import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class CustomListView_Fragment extends Fragment {

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

    private void UiInitialization(){
        String Video[]={"Video1","Video2"};
        String Song[]={"Song1","Song2","Song3","Song4"};
        String Movi[]={"Movi1","Movi2","Movi3","Movi4","Movi5","Movi6","Movi7","Movi8","Movi9"};

        imageArry.add(new Item(R.drawable.ic_attachment, Video));
        imageArry.add(new Item(R.drawable.ic_done, Song));
        imageArry.add(new Item(R.drawable.ic_emoticon, Movi));

        // add data in contact image adapter
        adapter = new CustomImageAdapter(MainActivity.globalContext, R.layout.list, imageArry);
        ListView dataList = (ListView) View_CustomListView_Fragment.findViewById(R.id.list);
        dataList.setAdapter(adapter);

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
