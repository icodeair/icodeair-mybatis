package com.icodeair.mybatis.persistent;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类
 *
 * @Author LiuHH
 * @Since 2024-05-01
 */
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * AUTO:
     * 情况一：表字段必须是自增
     * 情况二：如果该业务是分库分表sharding策略字段，则系统自动设置值；
     * INPUT：
     * 需要手动设置id，表字段不是自增
     * ID_WORKER
     * 雪花算法主键
     * UUID
     * uuid主键
     */
    @TableId(type = IdType.INPUT)
    private Object id;

    /**
     * 是否删除（0否 1是）
     */
    @TableField("is_del_flag")
    private Boolean delFlag;
    /**
     * 创建者
     */
    private Object createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private Object updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
