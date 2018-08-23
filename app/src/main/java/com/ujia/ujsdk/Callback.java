package com.ujia.ujsdk;

import java.io.Serializable;

public interface Callback extends Serializable {
    public void callback(String msg);
}
