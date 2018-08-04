package com.ujia.permission;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class PermissionManager {

    private static final String TAG = "PermissionManager";
    private PermissionFragment fragment;

    private PermissionCallback permissionCallback;
    private static PermissionManager permissionManager = new PermissionManager();
    private PermissionManager(){}
    public static PermissionManager getInstance() {
        return permissionManager;
    }

    public PermissionManager with(Activity activity) {
        fragment = getPermissionFragment(activity);
        return this;
    }

    public PermissionManager setPermissionCallback(PermissionCallback permissionCallback) {
        this.permissionCallback = permissionCallback;
        this.fragment.setPermissionCallback(permissionCallback);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void request(int requestCode, String... permissions) {
        fragment.request(requestCode, permissions);
    }

    private synchronized PermissionFragment getPermissionFragment(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        PermissionFragment permissionFragment = (PermissionFragment) fragmentManager.findFragmentByTag(TAG);
        if (permissionFragment == null) {
            permissionFragment = PermissionFragment.newInstance();
            fragmentManager
                    .beginTransaction()
                    .add(permissionFragment, TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return permissionFragment;

    }

}
