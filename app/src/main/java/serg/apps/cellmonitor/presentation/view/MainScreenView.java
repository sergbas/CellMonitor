package serg.apps.cellmonitor.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Xieergai on 11.04.2018.
 */

@StateStrategyType(SkipStrategy.class)
public interface MainScreenView extends MvpView {

    void showErrorToast(Integer errorRsId, String errorMessage);

    void loadScreenData();

    void showProfileScreen();

    void toggleIndexDetails();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void toggleIndexDetails(boolean showDetails);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void toggleTasksDetails(boolean showDetails);


}
