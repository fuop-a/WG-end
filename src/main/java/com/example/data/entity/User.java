package com.example.data.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-04-14 13:43:37
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User {
    
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    
    /** ${column.comment} */
    @TableField(value = "username")  
    private String username;
    
    /** ${column.comment} */
    @TableField(value = "password")  
    private String password;

}

