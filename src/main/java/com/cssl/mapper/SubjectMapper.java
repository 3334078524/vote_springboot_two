package com.cssl.mapper;

import com.cssl.entity.Items;
import com.cssl.entity.Options;
import com.cssl.entity.Subject;
import org.apache.ibatis.annotations.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

public interface SubjectMapper {
    public List<Subject> showAllSubject(Map map);
    public Items showItems(@Param("index") Integer index);
    public Integer addSubject(Subject subject);
    public Integer addOptions(Subject subject);
    public Integer delOptions(@Param("osid")Integer osid);
    public Integer delSubject(@Param("sid")Integer sid);
    public Integer delItem(@Param("sid")Integer sid);
    public Integer addItems(Integer uid,Integer sid,Integer pid);
    public Integer findItems(@Param("uid") Integer uid,@Param("sid") Integer sid);
    public Integer addOP(Options op);
    public Integer delOP(@Param("oid") Integer oid);
    public Integer updSub(@Param("type")Integer type,@Param("sid") Integer sid);
    public Integer delItems(@Param("oid") Integer oid);
}
