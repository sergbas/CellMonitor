package serg.apps.cellmonitor.permission;

/**
 * Created by Xieergai on 11.04.2018.
 */

public class PermissionResult {

    private String permissionName;
    private boolean isGranted;

    public PermissionResult(String permissionName, boolean isGranted) {
        this.permissionName = permissionName;
        this.isGranted = isGranted;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public boolean isGranted() {
        return isGranted;
    }
}
