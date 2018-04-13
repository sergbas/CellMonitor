package serg.apps.cellmonitor.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;
import serg.apps.cellmonitor.R;
import serg.apps.cellmonitor.presentation.view.MainScreenView;

/**
 * Created by Xieergai on 12.04.2018.
 */

public class MainScreenFragment extends MvpAppCompatFragment implements MainScreenView {


    private static final String TAG = MainScreenFragment.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        ButterKnife.bind(this, view);

        Log.d(TAG, "onCreateView()");
        setHasOptionsMenu(true);

        assert getActivity() != null;
        //((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        //swipe.setOnRefreshListener(() -> mainScreenPresenter.loadScreenData(true));
        //swipe.setColorSchemeColors(getResources().getColor(R.color.accent, null));

        //loadAnimations();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //prescriptionRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        //prescriptionRecycler.setAdapter(adapter);
    }

    @Override
    public void showErrorToast(Integer errorRsId, String errorMessage) {

    }

    @Override
    public void loadScreenData() {

    }
    
}
