/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RoleService
 * Author:   tjqwecom
 * Date:     2020-11-04 20:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.system.service;

import com.example.system.mapper.RoleMapper;
import com.example.system.pojo.Role;
import com.example.system.pojo.User_info;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tjqwecom
 * @create 2020-11-04
 * @since 1.0.0
 */
public interface RoleService {
     List<Role> getRolesByUserId(Integer userid);

}