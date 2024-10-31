package com.icodeair.mybatis;

import lombok.Data;
import com.icodeair.mybatis.persistent.BaseEntity;

@Data
public class DemoEntity extends BaseEntity<Long> {
    private String name;
}
