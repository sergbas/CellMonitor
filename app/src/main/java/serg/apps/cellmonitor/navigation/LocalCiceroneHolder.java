package serg.apps.cellmonitor.navigation;

import java.util.HashMap;
import java.util.Map;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Router;

/**
 * Created by Xieergai on 11.04.2018.
 */

public class LocalCiceroneHolder {

    private Map<String, Cicerone<Router>> containers;

    public LocalCiceroneHolder() {
        containers = new HashMap<>();
    }

    public Cicerone<Router> getCicerone(String groupName) {
        if (!containers.containsKey(groupName)) {
            containers.put(groupName, Cicerone.create());
        }
        return containers.get(groupName);
    }
}
