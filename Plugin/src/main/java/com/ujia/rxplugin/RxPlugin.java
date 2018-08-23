package com.ujia.rxplugin;

import android.content.Context;

import java.util.List;

import dalvik.system.DexClassLoader;

public class RxPlugin {
    private Context ctx;
    private String pluginPath;
    private List<String> classNames;

    public void with(Context context) {
        this.ctx = context;
    }

    public void loadRes() {
        DexClassLoader classLoader = new DexClassLoader(pluginPath, ctx.getDir(pluginPath, Context.MODE_PRIVATE).getAbsolutePath(),
                null, ctx.getClassLoader());
        Class<?> clz = classLoader.loadClass("")
    }


}
