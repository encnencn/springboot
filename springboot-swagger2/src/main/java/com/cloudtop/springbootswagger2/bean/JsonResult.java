/********************************************** 
 * Project Name:springboot-swagger2 
 * File Name:JsonResult.java  
 * Package Name:com.cloudtop.springbootswagger2.bean 
 * Date:2019年04月09日 10:56
 * Copyright (c) 2019, 西安众盈医疗信息科技有限公司
 *
 *********************************************/
package com.cloudtop.springbootswagger2.bean;

import lombok.*;

/**
 * @author yangyingjie
 * @Title: JsonResult.java
 * @Package com.cloudtop.springbootswagger2.bean
 * @Description:
 * @date 2019年04月09日 10:56
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JsonResult {
    private String status = null;

    private Object result = null;
}
