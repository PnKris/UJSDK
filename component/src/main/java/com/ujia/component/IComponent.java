package com.ujia.component;

public interface IComponent {

    public String getName();

    public void onCreate();

    public void onRegister();

    public void onCall();

    public void onUnregister();

    public void onDestroy();

}
