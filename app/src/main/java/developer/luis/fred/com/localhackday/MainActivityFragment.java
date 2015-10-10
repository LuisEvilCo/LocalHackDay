package developer.luis.fred.com.localhackday;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    public MainActivityFragment() {
    }

    private View View_MainFragment;
    private FragmentTwo secondFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View_MainFragment = inflater.inflate(R.layout.fragment_main, container, false);
        UiInitialization();
        secondFragment = new FragmentTwo();
        return View_MainFragment;
    }

    private void UiInitialization(){
        Button btn_click = (Button) View_MainFragment.findViewById(R.id.button_click);
        btn_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_click : {
               /* Toast.makeText(getActivity(), "Fuck Yeah", Toast.LENGTH_LONG).show();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right , android.R.anim.slide_in_left , android.R.anim.slide_out_right);
                transaction.replace(R.id.fragment_container, secondFragment);
                transaction.addToBackStack(null);
                transaction.commit();*/
                break;
            }
        }
    }
}
