/********************************************** 
 * Project Name:springboot-swagger2 
 * File Name:User.java  
 * Package Name:com.cloudtop.springbootswagger2.bean 
 * Date:2019年04月09日 10:01
 * Copyright (c) 2019, 西安众盈医疗信息科技有限公司
 *
 *********************************************/
package com.cloudtop.springbootswagger2.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * @author yangyingjie
 * @Title: User.java
 * @Package com.cloudtop.springbootswagger2.bean
 * @Description:
 * @date 2019年04月09日 10:01
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "User-用户对象")
public class User {

    //@ApiModelProperty(value = "主键",example = "8")
    private Integer id;

    //@ApiModelProperty(value = "用户姓名",example = "11")
    private String username;

    //@ApiModelProperty(value = "年龄",example = "12")
    private Integer age;

    //@ApiModelProperty(value = "创建时间",example = "11")
    private Date ctm;
}
