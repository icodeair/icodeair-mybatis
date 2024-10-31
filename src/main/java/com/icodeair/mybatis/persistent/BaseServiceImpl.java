package com.icodeair.mybatis.persistent;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

/**
 * @author liuhh
 * @since 2024-04-26
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T, Y> extends ServiceImpl<M, T> {
    public abstract Y getUserId();

    public abstract Y getId();

    /**
     * 是否继承 BaseEntity
     *
     * @param clz 实体类
     * @return 是否继承
     */
    public boolean isExtendsBaseEntity(Class<?> clz) {
        if (clz == Object.class) {
            return false;
        } else {
            Class<?> clzSuper = clz.getSuperclass();
            if (clzSuper == BaseEntity.class) {
                return true;
            } else {
                return isExtendsBaseEntity(clzSuper);
            }
        }
    }

    /**
     * 批量插入
     *
     * @param entityList ignore
     * @param batchSize  ignore
     * @return ignore
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        if (entityList != null && !entityList.isEmpty()) {
            for (T item : entityList) {
                inertDefaultValue(item);
            }
        }
        return super.saveBatch(entityList, batchSize);
    }

    private void inertDefaultValue(T item) {
        if (item != null) {
            if (isExtendsBaseEntity(item.getClass())) {
                BaseEntity entity = (BaseEntity) item;
                LocalDateTime nowTime = LocalDateTime.now();
                if (null == entity.getId()) {
                    entity.setId(getId());
                    entity.setCreateTime(nowTime);
                    if (Objects.isNull(entity.getCreateBy())) {
                        entity.setCreateBy(getUserId());
                    }
                    entity.setDelFlag(false);
                }
                entity.setUpdateTime(nowTime);
                if (Objects.isNull(entity.getUpdateBy())) {
                    entity.setUpdateBy(getUserId());
                }
            }
        }
    }

    public boolean save(T item) {
        inertDefaultValue(item);
        return false;
    }

    public boolean saveOrUpdate(T item) {
        inertDefaultValue(item);
        return super.saveOrUpdate(item);
    }

    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        if (entityList != null && !entityList.isEmpty()) {
            for (T item : entityList) {
                inertDefaultValue(item);
            }
        }
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    public boolean updateById(T item) {
        inertDefaultValue(item);
        return super.updateById(item);
    }

    public boolean update(T item, Wrapper<T> updateWrapper) {
        inertDefaultValue(item);
        return super.update(item, updateWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        if (entityList != null && !entityList.isEmpty()) {
            for (T item : entityList) {
                inertDefaultValue(item);
            }
        }
        return super.updateBatchById(entityList, batchSize);
    }

}
