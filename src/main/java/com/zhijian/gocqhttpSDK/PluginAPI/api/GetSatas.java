package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * app_initialized	bool	原 CQHTTP 字段, 恒定为 true
 * app_enabled	bool	原 CQHTTP 字段, 恒定为 true
 * plugins_good	bool	原 CQHTTP 字段, 恒定为 true
 * app_good	bool	原 CQHTTP 字段, 恒定为 true
 * online	bool	表示BOT是否在线
 * good	bool	同 online
 * stat	Statistics	运行统计
 *       PacketReceived	uint64	收到的数据包总数
 *         PacketSent	uint64	发送的数据包总数
 *         PacketLost	uint32	数据包丢失总数
 *         MessageReceived	uint64	接受信息总数
 *         MessageSent	uint64	发送信息总数
 *         DisconnectTimes	uint32	TCP 链接断开次数
 *         LostTimes	uint32	账号掉线次数
 *         LastMessageTime	int64	最后一条消息时间
 */

public class GetSatas extends BaseAPI {

    public boolean app_initialized;
    public boolean app_enabled;
    public boolean plugins_good;
    public boolean app_good;
    public boolean online;
    public boolean good;
    public boolean stat;
    
    class Statistics {
       public long  PacketReceived;
       public long PacketSent;
       public int PacketLost;
       public long MessageReceived;
       public long MessageSent;
       public int DisconnectTimes;
       public int LostTimes;
       public long LastMessageTime;
    }

}
