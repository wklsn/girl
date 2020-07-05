package com.wkl.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlResp;

    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl("S", 45);
        girlResp.save(girl1);
        Girl girl2 = new Girl("C", 14);
        girlResp.save(girl2);
    }

}
