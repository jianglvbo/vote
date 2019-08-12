package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.TpQueCreating;
import com.gameloft9.demo.dataaccess.model.system.TpQueOption;
import com.gameloft9.demo.dataaccess.model.system.TpQueSubject;
import com.gameloft9.demo.dataaccess.model.system.TpQueTemplate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpQueTemplateMapper {
    public List<TpQueTemplate> findAll5(@Param("start") int start, @Param("end") int end);
    public int getCount5(String tid);
    public Boolean add6_1(TpQueTemplate templateQue);
    public Boolean update5(String tid);
    public Boolean update5_1(String tid);
    public String getForm(String tid);
    public String getForm4(String qid);
    public TpQueCreating getForm1(String cid);
    public List<TpQueSubject> getForm2(String cid);
    public List<TpQueOption> getForm3(String sid);
    //统计每个选项票数
    public String totalOption(String oid);
}