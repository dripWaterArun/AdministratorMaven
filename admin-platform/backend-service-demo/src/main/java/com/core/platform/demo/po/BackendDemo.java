package com.core.platform.demo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "demo")
public class BackendDemo {

    private Long id;

    private String name;

    private String uuid;
}
