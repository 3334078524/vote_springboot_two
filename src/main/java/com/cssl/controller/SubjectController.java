package com.cssl.controller;

import com.cssl.entity.Items;
import com.cssl.entity.Options;
import com.cssl.entity.Subject;
import com.cssl.service.SubjectService;
import com.cssl.vojo.SubjectVo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.util.*;

@Controller
@RequestMapping("/subjectController")
public class SubjectController {
    @Autowired(required = false)
    private SubjectService subService;

    //查询所有
    @RequestMapping(value = "/showAll", produces = "application/json;charset=utf-8")
    public String showAll(Integer index, Model model, String keywords) {
        if (index == null)
            index = 1;
        Map map = new HashMap();
        map.put("title", keywords);
        PageInfo pageInfo = subService.showAllItems(index, 5, map);
        System.out.println(pageInfo.getList());
        model.addAttribute("showAll", pageInfo);
        model.addAttribute("index", index);
        model.addAttribute("title", keywords);
        return "votelist";
    }

    @RequestMapping("/showPoll")
    public String showPoll(Integer id, Model model) {
        gg(id,model);
        return "voteview";
    }
    public void gg(Integer id, Model model){
        Items items = subService.showItems(id);
        System.out.println("------------------id" + id);
        Map map = new HashMap();
        map.put("sid", id);
        PageInfo pageInfo = subService.showAllItems(1, 1, map);
        model.addAttribute("items", items);
        System.out.println("items" + items);
        model.addAttribute("showAll", pageInfo.getList());
    }
    @RequestMapping("/canyu")
    public String canYu(Integer id, Model model) {
        gg(id,model);
        return "vote";
    }
    @RequestMapping("/addSubject")
    public String addSubject(SubjectVo subVo,String options, Model model,String ty,Integer sid,Integer type){
        if("weihu".equals(ty)){
            Items items = subService.showItems(sid);
            String[] sp = options.split(",");
            List<String> strings = Arrays.asList(sp);
            List<Options> options1 = items.getOptions();
            List<String> listS=new ArrayList<String>(strings);
            List<Options> listO=new ArrayList<Options>(options1);
            boolean tf=false;
            if(!items.getSubject().getType().equals(type)){
                tf=subService.updSub(type,sid)>0;
            }
            Options opp=null;
            for (int i=0;i<listO.size();i++){
                Options options2 = listO.get(i);
                for (int j=0;j<listS.size();j++){
                    String s = listS.get(j);
                    if(options2.equals(s)){
                        listO.remove(i);
                        listS.remove(j);
                    }
                }
            }
            if(listS!=null&&listS.size()>0){
                for (String stt:listS) {
                    tf=subService.addOP(new Options(stt,sid))>0;
                }
            }
            if(listO!=null&&listO.size()>0){
                for (Options stt:options1) {
                    tf=subService.delOP(stt.getOid())>0;
                    subService.delItemss(stt.getOid());
                }
            }
            if(tf)
                System.out.println("修改成功");
            return "redirect:/subjectController/showAll";
        }
        Subject sub=new Subject();
        String[] sp = options.split(",");
        List<String> strings = Arrays.asList(sp);
        subVo.setAllOptions(strings);
        BeanUtils.copyProperties(subVo,sub);
        Integer integer = subService.addSubject(sub);
        System.out.println("-------------"+integer);
        if(integer>0){
           return "/subjectController/showAll";
        }else{
           return "redirect:/add.html?code=1023";
       }
    }
    @RequestMapping("/addhtml")
    public String addHtml(HttpServletRequest request){
        return "redirect:/add.html";
    }
    @RequestMapping("/shanchu")
    public String shanchu(Integer id,Model model){
        Integer integer=subService.delOptions(id);
        if(integer>0){
            integer=subService.delSubject(id);
            if(integer>0)
                subService.delItem(id);
        }
        if(integer<1){
            model.addAttribute("sb",7788);
            return "redirect:/subjectController/showAll";
        }
        model.addAttribute("sb",7780);
        return "redirect:/subjectController/showAll";
    }
    @RequestMapping("/addItems")
    public String addItems(Integer sid,Integer uid,String options,Model model){
        System.out.println("-------------------addItems");
        String[] split = options.split(",");
        List<String> strings = Arrays.asList(split);
        List<String> list=new ArrayList<String>(strings);
//        先去查询是否已经投票
        System.out.println("yuid"+uid);
        System.out.println("ysid"+sid);
        Integer items = subService.findItems(uid, sid);
        System.out.println("shifotp=-----"+items);
        if(items>0){
            //已经投票了
            return "redirect:/subjectController/showAll";
        }else{
            Integer index=0;
            System.out.println("ccccccccdddddd---"+list.size());
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i).toString());
                index= subService.addItems(uid, sid, Integer.parseInt(list.get(i)));
            }
            if(index>0){
                //投票成功
                model.addAttribute("cg",6666);
                return "redirect:/subjectController/showAll";
            }
            else{
                //投票失败
                model.addAttribute("cg",9999);
                return "redirect:/subjectController/showAll";
            }
        }
    }
    @RequestMapping("/weihu")
    public String weihu(Integer id,Model model){
        System.out.println("--------------------------------------------维护");
        gg(id,model);
        model.addAttribute("weihu","weihu");
        return  "add";
    }
}
