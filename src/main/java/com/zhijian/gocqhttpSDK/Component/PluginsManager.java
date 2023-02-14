package com.zhijian.gocqhttpSDK.Component;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.*;

@Component
public class PluginsManager implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(PluginsManager.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent cre) {
        new Thread(()->{
            Scanner scanner = new Scanner(System.in);

            while(scanner.hasNext()){
                String cmd = scanner.nextLine();
                cmd = cmd.trim().replaceAll(" +", " ");
                if("plugins".equalsIgnoreCase(cmd)){
                    print_plugins();
                }else if(cmd.startsWith("pause")){
                    pause_plugins(cmd);
                }else if(cmd.startsWith("unpause")){
                    unpause_plugins(cmd);
                }
            }
        }).start();
    }

    void unpause_plugins(String cmd){
        String args[] = cmd.split(" ");
        String digits = StringUtils.getDigits(args[1]);
        if(digits != null && digits.length()>0) {
            int id = Integer.parseInt(digits);
            List<PluginInfo> allPlugins = getPluginsList();
            if(0 >= id){
                for (PluginInfo pi: allPlugins){
                    pi.paused = 0;
                }
                logger.info("全部插件已恢复");
            }else if(id <= allPlugins.size()){
                allPlugins.get(id-1).paused = 0;
                logger.info("插件{}:{} [{}]已恢复,使用'unpause id'命令恢复", id, allPlugins.get(id-1).PluginClass,allPlugins.get(id-1).PluginName);
            }else{
                logger.error("恢复出错[插件id:{}超过了上限,最大不应超过{}]", id, allPlugins.size());
            }
        }
    }

    void pause_plugins(String cmd){
        String args[] = cmd.split(" ");
        String digits = StringUtils.getDigits(args[1]);
        if(digits != null && digits.length()>0) {
            int id = Integer.parseInt(digits);
            List<PluginInfo> allPlugins = getPluginsList();
            if(0 >= id){
                for (PluginInfo pi: allPlugins){
                    pi.paused = 1;
                }
                logger.info("全部插件已暂停,使用'unpause 0'恢复");
            }else if(id <= allPlugins.size()){
                allPlugins.get(id-1).paused = 1;
                logger.info("插件{}:{} [{}]已暂停,使用'unpause id'命令恢复", id, allPlugins.get(id-1).PluginClass,allPlugins.get(id-1).PluginName);
            }else{
                logger.error("暂停出错[插件id:{}超过了上限,最大不应超过{}]", id, allPlugins.size());
            }
        }
    }

    List<PluginInfo> getPluginsList(){
        Map<String, List<PluginInfo>> listHandlers = EventHandler.listHandlers;
        List<PluginInfo> allPlugins = new ArrayList<>();
        listHandlers.forEach((k,v)->{
            allPlugins.addAll(v);
        });
        return allPlugins;
    }

    void print_plugins(){
        List<PluginInfo> allPlugins = getPluginsList();

        int total = allPlugins.size();
        int paused = 0;
        for (PluginInfo p: allPlugins){
            if(p.paused > 0)
                paused ++;
        }

        System.out.printf("Total %d plugins, %d running, %d paused.(使用'pause/unpause 编号'可关开插件)\r\n", total,total-paused,paused);
        String[] heads = {"编号", "类名", "插件名", "上报类型", "顺序", "外部插件", "状态"};
        String[][] arrPlugins = new String[total][];

        for (int i = 0; i<total; ++i) {
            PluginInfo p = allPlugins.get(i);
            List<String> strPlugin = new ArrayList<>();
            strPlugin.add(String.valueOf(i+1));
            strPlugin.add(p.PluginClass);
            strPlugin.add(p.PluginName);
            strPlugin.add(p.PostType);
            strPlugin.add(String.valueOf(p.PluginOrder));
            strPlugin.add(String.valueOf(p.fromJar));
            strPlugin.add(p.paused>0?"paused":"running");

            arrPlugins[i] = strPlugin.toArray(new String[0]);
        }
        printTable(heads, arrPlugins);
    }


    // misc

    //按表格打印数据
    public static void printTable(String[] heads, String[][] data) {
        if (null == heads || heads.length <= 0) {
            throw new RuntimeException("标头heads[]不能为空!");
        }

        if (null == data || null == data[0] || data[0].length <= 0) {
            throw new RuntimeException("数据data[][]不能为空!");
        }
        if (heads.length != data[0].length) {
            throw new RuntimeException("标头与数据列数不一致!");
        }
        //数据列数
        int rowNum = heads.length;
        //数据行数
        int lineNum = data.length;
        //每列数据宽度
        Map<Integer, Integer> rowWidthMap = getRowWidthMap(rowNum, lineNum, heads, data);

        //打印表头
        printHead(rowNum, rowWidthMap, heads);
        //打印数据
        printData(rowNum, lineNum, rowWidthMap, data);

    }

    //获取列宽度-每列取最大
    public static Map<Integer, Integer> getRowWidthMap(int rowNum, int lineNum, String[] heads, String[][] data) {
        Map<Integer, Integer> rowWidthMap = new HashMap<>();
        //先记入表头各列宽度
        for (int i = 0; i < rowNum; i++) {
            int len = length(heads[i]);
            if (null == rowWidthMap.get(i)) {
                rowWidthMap.put(i, len);
            } else if (rowWidthMap.get(i) < len) {
                rowWidthMap.put(i, len);
            }
        }
        //比较并记入数据的最大宽度
        for (int i = 0; i < lineNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                int len = length(data[i][j]);
                //System.out.println("[" + i + "," + j + "]:" + data[i][j] + ",width：" + len);
                if (null == rowWidthMap.get(j)) {
                    rowWidthMap.put(j, len);
                } else if (rowWidthMap.get(j) < len) {
                    rowWidthMap.put(j, len);
                }
            }
        }
        return rowWidthMap;
    }

    //打印表格中的横线
    public static void printLine(int rowNum, Map<Integer, Integer> map) {
        for (int i = 0; i < rowNum; i++) {
            int len = map.get(i);
            System.out.print("+");
            for (int k = 0; k < len; k++) {
                System.out.print("-");
            }
        }
        System.out.print("+");
        System.out.println();
    }

    public static int length(String str) {

        if (StringUtils.isBlank(str)) {
            return 0;
        }
        return str.getBytes().length;//str.length();
    }

    //打印表头内容
    public static void printHead(int rowNum, Map<Integer, Integer> rowWidthMap, String[] heads) {
        printLine(rowNum, rowWidthMap);
        for (int h = 0; h < rowNum; h++) {
            System.out.print("|");
            int actLength = rowWidthMap.get(h);
            int dataLength = length(heads[h]);//(StringUtils.isBlank(heads[h]))?0: heads[h].length();
            executePrintData(actLength, dataLength, heads[h]);//dataLength*2 - 1
            if (h == rowNum - 1) {
                System.out.print("|");
            }
        }
        System.out.println();
        printLine(rowNum, rowWidthMap);
    }

    //打印表数据
    public static void printData(int rowNum, int lineNum, Map<Integer, Integer> rowWidthMap, String[][] data) {
        for (int j = 0; j < lineNum; j++) {
            for (int i = 0; i < rowNum; i++) {
                System.out.print("|");
                int dataLength = length(data[j][i]);
                int actLength = rowWidthMap.get(i);
                executePrintData(actLength, dataLength, data[j][i]);
                if (i == rowNum - 1) {
                    System.out.print("|");
                }
            }

            System.out.println();
            printLine(rowNum, rowWidthMap);
        }
        System.out.println();
    }

    //执行打印数据
    public static void executePrintData(int actLength, int dataLength, String data) {
        if (actLength > dataLength) {
            int num = actLength - dataLength;
            if (num == 1) {
                System.out.print(data);
                System.out.print(" ");
            } else {
                int beforeNum = num / 2;
                int afterNum = num - beforeNum;
                for (int m = 0; m < beforeNum; m++) {
                    System.out.print(" ");
                }
                System.out.print(data);
                for (int m = 0; m < afterNum; m++) {
                    System.out.print(" ");
                }
            }
        } else {
            System.out.print(data);
        }
    }

}
