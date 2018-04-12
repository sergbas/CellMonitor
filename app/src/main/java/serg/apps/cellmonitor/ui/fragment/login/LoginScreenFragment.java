package serg.apps.cellmonitor.ui.fragment.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;
import serg.apps.cellmonitor.R;
import serg.apps.cellmonitor.presentation.presenter.LoginScreenPresenter;
import serg.apps.cellmonitor.presentation.view.LoginScreenView;
import serg.apps.cellmonitor.ui.activity.LoginActivity;

/**
 * Created by Xieergai on 12.04.2018.
 */

public class LoginScreenFragment extends MvpAppCompatFragment implements LoginScreenView {

    private final static String TAG = LoginScreenFragment.class.getSimpleName();

    @InjectPresenter
    LoginScreenPresenter loginScreenPresenter;

    private ViewGroup container;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_screen, this.container = container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
    }

}
