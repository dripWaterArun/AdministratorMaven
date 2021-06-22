package com.core.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//import lombok.extern.slf4j.Slf4j;

/**
 * 处理新增和更新的基础数据填充，配合BaseEntity和MyBatisPlusConfig使用
 * 自动填充创建时间和修改时间
 */

//@Slf4j
@Component
public class MetaHandler implements MetaObjectHandler {
    private static final Logger logger = LoggerFactory.getLogger(MetaHandler.class);

    /**
     * 新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //log.info("start insert fill ....");
        /**
         * 新增时 增加创建时间和修改时间
         */
        // 获取参数，判断字段在实体类中是否存在,看实体类中是否有这个属性，有的话就执行。没有就不执行
        boolean createBy = metaObject.hasSetter("createBy");
        boolean createTime = metaObject.hasSetter("createTime");
        boolean updateBy = metaObject.hasSetter("updateBy");
        boolean updateTime = metaObject.hasSetter("updateTime");
        boolean delFlag = metaObject.hasSetter("delFlag");
        //创建人
        if (createBy){
            this.fillStrategy(metaObject,"createBy","admin");
        }
        //创建时间
        if (createTime){
            this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        }
        //修改人
        if (updateBy){
            this.fillStrategy(metaObject,"updateBy","admin");
        }
        //修改时间
        if (updateTime){
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        }

        //逻辑删除
        if (delFlag){
            this.fillStrategy(metaObject,"delFlag","0");
        }
    }

    /**
     * 更新数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //log.info("start update fill ....");
        //修改时 重新设置修改时间
        boolean updateBy = metaObject.hasSetter("updateBy");
        boolean updateTime = metaObject.hasSetter("updateTime");
        //修改人
        if (updateBy){
            this.fillStrategy(metaObject,"updateBy","admin");
        }
        //修改时间
        if (updateTime){
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        }
    }
}
