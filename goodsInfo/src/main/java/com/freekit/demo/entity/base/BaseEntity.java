package com.freekit.demo.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity  {
    /** 主键 */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name  = "create_time", insertable = false,updatable = false)
    protected Date createTime;

    @Column(name  = "update_time" ,insertable = false,updatable = false)
    protected  Date updateTime;


}
