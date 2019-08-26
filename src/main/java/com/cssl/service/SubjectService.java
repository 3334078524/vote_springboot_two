package com.cssl.service;

import com.cssl.entity.Items;
import com.cssl.entity.Options;
import com.cssl.entity.Subject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

public interface SubjectService {
    public PageInfo showAllItems(Integer index, Integer size , Map map);
    public Items showItems(Integer index);
    public Integer addSubject(Subject subject);
    public Integer delOptions(@Param("osid")Integer osid);
    public Integer delSubject(@Param("sid")Integer sid);
    public Integer delItem(@Param("sid")Integer sid);
    public Integer findItems(Integer uid,Integer sid);
    public  Integer addItems(Integer uid,Integer sid,Integer pid);
    public Integer addOP(Options op);
    public Integer delOP(Integer oid);
    public  Integer updSub(Integer type,Integer sid);
    public Integer delItemss(Integer oid);
}
