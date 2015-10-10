package developer.luis.fred.com.localhackday;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentTwo extends MainActivityFragment {


    private View View_FragmentTwo;
    MainActivityFragment Frag1;
    public FragmentTwo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    Button btn_back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View_FragmentTwo = inflater.inflate(R.layout.fragment_two, container, false);
        UiInitialization();
        Frag1 = new MainActivityFragment();
        return View_FragmentTwo;
    }

    private void UiInitialization(){
        btn_back = (Button) View_FragmentTwo.findViewById(R.id.button_back);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //PUT YOUR CODE HERE
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_back : {
                btn_back.setText("Click Detected !");
                /*
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right , android.R.anim.slide_in_left , android.R.anim.slide_out_right);
                transaction.replace(R.id.fragment_container, Frag1);
                transaction.addToBackStack(null);
                transaction.commit();*/
                break;
            }
        }
    }


}
