package com.zhijian.gocqhttpSDK.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TestMapper {
    @Insert({"insert NewTable(test) values('123')"})
    public int insert();

    @Update({"Update NewTable set test=#{text}"})
    public int update(String text);

    @Select({"select test from NewTable limit 0,1"})
    public String read();
}
