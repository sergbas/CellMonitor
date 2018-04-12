package serg.apps.cellmonitor.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Xieergai on 12.04.2018.
 */

@StateStrategyType(SkipStrategy.class)
public interface MainView extends MvpView {

    void setSelectedBottomMenuItem(int menuId);

}