package com.core.platform.demo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.core.pojo.demo.database.PlatformDemo;
import lombok.Data;

@Data
@TableName(value = PlatformDemo.DEMO)
public class BackendDemo {

    private Long id;

    private String name;

    private String uuid;
}
