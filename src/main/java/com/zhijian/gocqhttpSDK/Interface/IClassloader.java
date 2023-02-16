package com.zhijian.gocqhttpSDK.Interface;

import java.util.List;

public interface IClassloader {
    ClassLoader getFrameClassloader();
    List<ClassLoader> getPluginsClassloader();

    void setFrameClassloader(ClassLoader classLoader);
}
