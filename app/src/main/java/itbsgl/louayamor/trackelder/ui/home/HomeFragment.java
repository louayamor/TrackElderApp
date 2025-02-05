package itbsgl.louayamor.trackelder.ui.home;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import itbsgl.louayamor.trackelder.databinding.FragmentHomeBinding;

import itbsgl.louayamor.trackelder.Constants;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = binding.editTextPhone.getText().toString();
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(
                        number,
                        null,
                        Constants.MSG_SENDME_POSITION,
                        null,
                        null
                        );
            }
        } );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}