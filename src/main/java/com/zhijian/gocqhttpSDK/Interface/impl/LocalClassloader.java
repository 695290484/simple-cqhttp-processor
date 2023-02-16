package com.zhijian.gocqhttpSDK.Interface.impl;

import com.zhijian.gocqhttpSDK.Component.PluginInfo;
import com.zhijian.gocqhttpSDK.Component.PluginsManager;
import com.zhijian.gocqhttpSDK.Interface.IClassloader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocalClassloader implements IClassloader {

    static private ClassLoader frameClassloader = null;

    @Autowired
    PluginsManager pluginsManager;

    @Override
    public ClassLoader getFrameClassloader() {
        return frameClassloader;
    }

    @Override
    public List<ClassLoader> getPluginsClassloader() {
        List<ClassLoader> loaders = new ArrayList<>();
        List<PluginInfo> pluginsList = pluginsManager.getPluginsList();
        for (PluginInfo p: pluginsList){
            loaders.add(p.classLoader);
        }

        return loaders;
    }

    @Override
    public void setFrameClassloader(ClassLoader classLoader) {
        frameClassloader = classLoader;
    }
}
