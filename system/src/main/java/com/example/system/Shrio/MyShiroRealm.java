/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MyShiroRealm
 * Author:   tjqwecom
 * Date:     2020-11-04 20:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.system.Shrio;

import com.example.system.pojo.Permission;
import com.example.system.pojo.Role;
import com.example.system.pojo.User_info;
import com.example.system.service.AdUserService;
import com.example.system.service.PermissionService;
import com.example.system.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Permissions;
import java.util.HashSet;
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
public class MyShiroRealm extends AuthorizingRealm {
    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Autowired
    private AdUserService adUserService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken att) throws AuthenticationException {
        System.out.println("————认证逻辑————");
        UsernamePasswordToken token = (UsernamePasswordToken) att;
        String userName = (String) token.getPrincipal();
        //获得用户用户名和密码
        User_info user = adUserService.findByName(userName);
        if (user == null) {
            throw new AccountException("用户名不存在");
        }
        //传入用户数据库密码信息
        //交给MyShiroRealm使用hashedCredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(userName, user.getPassword(), ByteSource.Util.bytes(user.getName() + "salt"),getName());
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection att
     * @return
     */
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection att) {
        System.out.println("————赋权逻辑————");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加资源的授权字符串
        //info.addStringPermission("user:add");

        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        User_info user_info=adUserService.findByName(username);
        List<Role> Roles = roleService.getRolesByUserId(user_info.getId());
        List<Permission> percussionist;
        Set<String> perms=new HashSet<>();
        for (Role role : Roles) {
           percussionist=permissionService.findPermissionsByRole(role.getId());
            for(Permission permission:percussionist){
                perms.add(permission.getPermission());
            }
        }


        info.addStringPermissions(perms);

        return info;
    }
}

 
