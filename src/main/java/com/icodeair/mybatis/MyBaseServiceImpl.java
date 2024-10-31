package com.icodeair.mybatis;


import com.icodeair.common.utils.IdUtil;
import com.icodeair.mybatis.persistent.BaseServiceImpl;

public class MyBaseServiceImpl<M, T, Y> extends BaseServiceImpl {
    @Override
    public Y getUserId() {
        if(Y instanceof Long) {
            return (Long) System.currentTimeMillis();
        } else {
            return (Y) IdUtil.randomUUID();
        }
    }

    @Override
    public Y getId() {
        return System.currentTimeMillis();
    }

}
