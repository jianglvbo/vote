package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.TpBigtitleMapper;
import com.gameloft9.demo.dataaccess.model.system.*;
import com.gameloft9.demo.service.api.system.TpBigtitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class TpBigtitleServiceimpl implements TpBigtitleService {
    @Autowired
    TpBigtitleMapper dao;



    public int delete(int bigTitleId) {

        return dao.delete(bigTitleId);
    }

    public TpBigtitle findbybigid(int bigTitleId) {
        return dao.findbybigid(bigTitleId);
    }

}