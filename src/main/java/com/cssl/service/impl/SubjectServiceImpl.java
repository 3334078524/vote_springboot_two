package com.cssl.service.impl;

import com.cssl.entity.Items;
import com.cssl.entity.Options;
import com.cssl.entity.Subject;
import com.cssl.mapper.SubjectMapper;
import com.cssl.service.SubjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Resource
    private SubjectMapper subjectMapper;
    @Override
    public PageInfo showAllItems(Integer index, Integer size, Map map) {
        System.out.println("index"+index);
        Page<Subject> page = PageHelper.startPage(index,size);
        PageInfo pageInfo=new PageInfo();
        List<Subject> subjects = subjectMapper.showAllSubject(map);
        System.out.println(subjects);
        pageInfo.setList(subjects);
        pageInfo = page.toPageInfo();
        return pageInfo;
    }

    @Override
    public Items showItems(Integer index) {
        Items items = subjectMapper.showItems(index);
        return items;
    }

    @Override
    public Integer addSubject(Subject subject) {
        Integer integer = subjectMapper.addSubject(subject);
        if(integer>0){
            integer = subjectMapper.addOptions(subject);
        }
        return integer;
    }

    @Override
    public Integer delOptions(Integer osid) {
        return subjectMapper.delOptions(osid);
    }

    @Override
    public Integer delSubject(Integer sid) {
        return subjectMapper.delSubject(sid);
    }

    @Override
    public Integer delItem(Integer sid) {
        return subjectMapper.delItem(sid);
    }

    @Override
    public Integer findItems(Integer uid, Integer sid) {
        return subjectMapper.findItems(uid,sid);
    }

    @Override
    public Integer addItems(Integer uid,Integer sid,Integer pid) {
        return subjectMapper.addItems(uid,sid,pid);
    }

    @Override
    public Integer addOP(Options op) {
        return subjectMapper.addOP(op);
    }

    @Override
    public Integer delOP(Integer oid) {
        return subjectMapper.delOP(oid);
    }

    @Override
    public Integer updSub(Integer type, Integer sid) {
        return subjectMapper.updSub(type,sid);
    }

    @Override
    public Integer delItemss(Integer oid) {
        return subjectMapper.delItems(oid);
    }

}
