package com.ujia.permission;

public interface PermissionCallback {
    public void granted(int requestCode);

    public void denied(String[] permissions, int requestCode);

}
