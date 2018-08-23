package com.ujia.component;

import java.util.HashMap;
import java.util.Map;

/**
 * 组件服务中心，提供组件注册，查找，通信，注销
 */
public class ComponentService {

    public Map<String, IComponent> componentMap = new HashMap<>();

    public synchronized void registerComponent(IComponent component) {
        if (componentMap.containsKey(component.getName())) {
            throw new IllegalStateException("组件" + component.getName() + "已经注册过");
        }
        componentMap.put(component.getName(), component);
    }

    public IComponent findComponent(String name) {
        if (!componentMap.containsKey(name)) {
            throw new IllegalStateException("组件" + name + "未注册");
        }
        return componentMap.get(name);
    }

    public void call(String name) {
        IComponent component = findComponent(name);
        component.onCall();
    }

    public void unregisterComponent(String name) {

    }

    public void unregisterComponent(IComponent component) {

    }



}
