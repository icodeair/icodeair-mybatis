package com.icodeair.mybatis;

import com.alibaba.fastjson2.JSON;

public class DemoServiceImpl extends MyBaseServiceImpl<DemoMapper, DemoEntity, Long> {
    public void main() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName("1234");
        try {
            super.save(demoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(demoEntity));
    }
}
