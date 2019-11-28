package com.lhx.haoke.dubbo.server.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BasePojo implements Serializable {

    private Date created;
    private Date updated;
}
