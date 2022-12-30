package com.zhijian.gocqhttpSDK.PluginAPI;

import com.zhijian.gocqhttpSDK.PluginAPI.api.*;

public enum API {
    SEND_PRIVATE_MSG("send_private_msg", SendPrivateMsg.class,"发送私聊消息"),
    SEND_GROUP_MSG("send_group_msg", SendGroupMsg.class,"发送群消息"),
    SEND_GROUP_FORWARD_MSG("send_group_forward_msg", SendGroupForwardMsg.class,"发送合并转发 ( 群 )"),
    SEND_MSG("send_msg",SendMsg.class,"发送消息"),
    DELETE_MSG("delete_msg", DeleteMsg.class,"撤回消息"),
    GET_MSG("get_msg", GetMsg.class,"获取消息"),
    GET_FORWARDGSG("get_forward_msg",GetForwardGsg.class,"获取合并转发内容"),
    GET_IMAGE("get_image",GetImage.class,"获取图片信息"),
    SET_GROP_KICK("set_group_kick",SetGroupKick.class,"群组踢人"),
    SET_GROP_BAN("set_group_ban",SetGroupBan.class,"群组单人禁言"),
    SET_GROP_ANONYMOUSBAN("set_grop_anonymousban",SetGroupAnonymousBan.class,"群组匿名用户禁言"),
    SET_GROUP_WHOLE_BAN("set_group_whole_ban",SetgGroupWholeBan.class,"群组全员禁言"),
    SET_GROP_ADMIN("set_grop_admin",SetGroupAdmin.class,"群组设置管理员"),
    SET_GROUP_ANONYMOUS("set_group_anonymous",SetGroupAnonymous.class,"群组匿名"),
    SET_GROP_CARD("set_group_card",SetGroupCard.class,"设置群名片 ( 群备注 )"),
    SET_GROUP_NAME("set_group_name",SetGroupName.class,"设置群名"),
    SET_GROP_LEAVE("set_group_leave",SetGroupLeave.class,"退出群组"),
    GROUP_SPECIAL_TITLE("group_special_title",SetGroupSpecialTitle.class,"设置群组专属头衔"),
    SET_FRIEND_ADDREQUST("set_friend_add_request",SetFriendAddRequest.class,"处理加好友请求"),
    SET_GROP_ADD_RQUEST("set_group_add_request",SetGroupAddRequest.class,"处理加群请求／邀请"),
    GET_LOGIN_INFO("get_login_info",GetLoginInfo.class,"获取登录号信息"),
    GET_STRANGER_INFO("get_stranger_info", GetStrangerInfo.class,"获取陌生人信息"),
    GET_FRIENDLIST("get_friendlist(",GetFriendList.class,"获取好友列表"),
    DELETE_FRIEND("delete_friend", DeleteFriend.class,"删除好友"),
    GET_GROUP_INFO("get_group_info",GetGroupInfo.class,"获取群信息"),
    GET_GROUP_LIST("get_group_list",GetGroupList.class,"获取群列表"),
    GET_GROUP_MEMBER_INFO("get_group_member_info",GetGroupMemberInfo.class,"获取群成员列表"),
    GET_GROUP_MEMBER_LIST("get_group_member_list",GetGroupMemberList.class,"获取群成员信息"),
    GET_GROUP_HONOR_INFO("get_group_honor_info",GetGroupHonorInfo.class,"获取群荣誉信息"),
    GET_COOKIES("get_cookies",GetCookies.class,"获取cookies"),
    GET_CSRFTOKEN("get_csrf_token",GetCsrfToken.class," 获取 CSRF Token"),
    GET_CREDENTIALS("get_credentials",GetCredentials.class,"获取 QQ 相关接口凭证"),
    GET_RECORD("get_record",GetRecord.class,"获取语音"),
    CAN_SEND_IMAGE("can_send_image",GetRecord.class,"是否可以发送图片"),
    CAN_SEND_RECORD("can_send_record",GetRecord.class,"是否可以发送语音"),
    GET_VERSION_INFO("get_version_info",GetRecord.class,"获取版本信息"),
    SET_RESTART("set_restart",GetRecord.class,"重启 go-cqhttp"),
    CLEAN_CACHE("clean_cache",CleanCache.class,"清理缓存"),
    SET_GROUP_PORTRAIT("set_group_portrait", SetGroupPortrait.class,"设置群头像"),
    GET_WORD_SLICES("_get_word_slices",GetWordSlices.class,"获取中文分词 ( 隐藏 API )"),
    OCR_IMAGE("ocr_image", OcrImage.class,"图片 OCR"),
    GET_GROUP_SYSTEM_MSG("get_group_system_msg",OcrImage.class,"获取群系统消息"),
    UPLOAD_GROUP_FILE("upload_group_file",UploadGroupFile.class,"上传群文件"),
    GET_GROUP_FILE_SYSTEM_INFO("get_group_file_system_info",GetGroupFileSystemInfo.class,"获取群文件系统信息"),
    GET_GROUP_ROOT_FILES("get_group_root_files",GetGroupRootFiles.class,"获取群根目录文件列表"),
    GET_GROUPF_ILESBYFOLDER("get_groupfilesbyfolder",GetGroupFilesByFolder.class,"获取群子目录文件列表"),
    GET_GROUP_FILEURL("get_group_file_url",GetGroupFileUrl.class,"获取群文件资源链接"),
    GET_STATUS("get_status",GetSatas.class,"获取状态"),
    GET_GROUP_AT_ALL_REMAIN("get_group_at_all_remain",GetGroupAtAllRemain.class,"获取群 @全体成员 剩余次数"),
    Handle_QuickOperation(".handle_quick_operation",HandleQuickOperation.class,"对事件执行快速操作 ( 隐藏 API )"),
    Get_VipInfo("_get_vip_info",GetVipInfo.class,"获取vip信息"),
    SEND_GROUPNOTICE("_send_group_notice",SendGroupNotice.class,"发送群公告"),
    RELOAD_EVENT_FILTER("reload_event_filter",ReloadEventFilter.class,"重载事件过滤器"),
    DOWNLOADFILE("download_file",DownloadFile.class,"下载文件到缓存目录"),
    GET_ONLINECLIENTS("get_online_clients",GetOnlineClients.class,"获取当前账号在线客户端列表"),
    GET_GROUP_MSG_HISTORY("get_group_msg_history",GetGroupMsgHistory.class,"获取群消息历史记录"),
    SET_ESSENCE_MSG("set_essence_msg",SetEssenceMsg.class,"设置精华消息"),
    DELETE_ESSENCE_MSG("delete_essence_msg", DeleteEssenceMsg.class,"移出精华消息"),
    GET_ESSENCE_MSG_LIST("get_essence_msg_list",GetEssenceMsgList.class,"获取精华消息列表"),
    CHECKURLSAFELY("check_url_safely", CheckUrlSafely.class,"检查链接安全性"),
    GET_MODELSHOW("_get_model_show",GetModelShow.class,"获取在线机型"),
    SET_MODEL_SHOW("set_model_show",SetModelShow.class,"设置在线机型");

    private String apiAdr;
    private Class clazz;
    private String describe;

    public String getApiAdr() {
        return apiAdr;
    }

    public Class getClazz() {
        return clazz;
    }

    public String getDescribe() {
        return describe;
    }

    API(String apiAdr, Class clazz, String describe) {
        this.apiAdr = apiAdr;
        this.clazz = clazz;
        this.describe= describe;
    }
}
