package com.gameloft9.demo.controllers.system;

import com.gameloft9.demo.dataaccess.model.system.*;
import com.gameloft9.demo.mgrframework.annotation.BizOperLog;
import com.gameloft9.demo.mgrframework.beans.constant.OperType;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.TpQueCreatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/wjdc")
public class TpQueCreatingController {
    @Resource
    TpQueCreatingService creatingQueService;

    TpQueInvestigation investigationQue;

    TpQueVerification verificationQue;

    Boolean flag3 = null;

    //创建问卷调查和把生成的账号存入数据库
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    @ResponseBody
    @BizOperLog(operType = OperType.ADD,memo = "创建问卷调查和存账号")
    public IResult add(@RequestBody TpQueCreating creatingQue){
        creatingQueService.add(creatingQue);
        List<TpQueSubject> timus = creatingQue.getTimus();
        for (TpQueSubject subjectQue : timus){
            subjectQue.setOid(creatingQue.getCid());
            creatingQueService.add3(subjectQue);
            List<TpQueOption> xuanxiang = subjectQue.getXuanxiang();
            for (TpQueOption optionQue : xuanxiang) {
                optionQue.setSid(subjectQue.getSid());
                creatingQueService.add4(optionQue);
            }
        }
        Date startTime = new Date();
        investigationQue = new TpQueInvestigation(creatingQue.getCid(),startTime,"35");
        Boolean flag = creatingQueService.add5(investigationQue);
        if(flag==true){
            List<String> accounts = creatingQue.getAccounts();
            for (String content : accounts) {
                String isVote = "0";
                String id = "47";
                verificationQue = new TpQueVerification(content,investigationQue.getQid(),isVote,id);
                Boolean flag2 = creatingQueService.addVerification(verificationQue);
                flag3 = flag2;
            }
        }
        return new ResultBean<Boolean>(flag3);
    }
    //存为模板
    @RequestMapping(value = "/add6.do",method = RequestMethod.POST)
    @ResponseBody
    @BizOperLog(operType = OperType.ADD,memo = "存为模板")
    public IResult add6(@RequestBody TpQueCreating creatingQue){
        creatingQueService.add(creatingQue);
        List<TpQueSubject> timus = creatingQue.getTimus();
        for (TpQueSubject subjectQue : timus){
            subjectQue.setOid(creatingQue.getCid());
            creatingQueService.add3(subjectQue);
            List<TpQueOption> xuanxiang = subjectQue.getXuanxiang();
            for (TpQueOption optionQue : xuanxiang) {
                optionQue.setSid(subjectQue.getSid());
                creatingQueService.add4(optionQue);
            }
        }
        Date createTime = new Date();
        TpQueTemplate templateQue = new TpQueTemplate(creatingQue.getCid(),createTime,"53");
        templateQue.setTemplateTitle(creatingQue.getTemplateTitle());
        return new ResultBean<Boolean>(creatingQueService.add6(templateQue));
    }

    //根据ID查询
    @RequestMapping(value = "/findById.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult findById(String cid){
        return new ResultBean<TpQueCreating>(creatingQueService.findById(cid));
    }

}