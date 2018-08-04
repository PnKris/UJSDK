package com.ujia.permission;

import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PermissionFragment extends Fragment {
    private static final String TAG = "PermissionFragment";
    private PermissionCallback permissionCallback;

    public static PermissionFragment newInstance() {
        Bundle args = new Bundle();
        PermissionFragment fragment = new PermissionFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public void setPermissionCallback(PermissionCallback permissionCallback) {
        this.permissionCallback = permissionCallback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void request(int requestCode, String... permissions) {
        if (permissions.length == 0) {
            return;
        }

        List<String> deniedPermissions = new ArrayList<>();
        for (String permission : permissions) {
            int result = ContextCompat.checkSelfPermission(this.getContext(), permission);
            if (result == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permission);
            }
        }

        if (permissionCallback == null) {
            return;
        }
        if (deniedPermissions.isEmpty()) {
            Log.d(TAG, "request: granted");
            permissionCallback.granted(requestCode);
        } else {
            Log.d(TAG, "request: denied");
            String[] permissionArray = deniedPermissions.toArray(new String[deniedPermissions.size()]);
            requestPermissions(permissionArray, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        List<String> deniedPermissions = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permissions[i]);
            }
        }

        if (deniedPermissions.isEmpty()) {
            Log.d(TAG, "request: granted");
            permissionCallback.granted(requestCode);
        } else {
            Log.d(TAG, "request: denied" + deniedPermissions.toString());
            String[] permissionArray = deniedPermissions.toArray(new String[deniedPermissions.size()]);
            permissionCallback.denied(permissionArray, requestCode);
        }
    }
}
