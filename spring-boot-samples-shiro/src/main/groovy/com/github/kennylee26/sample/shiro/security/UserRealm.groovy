package com.github.kennylee26.sample.shiro.security

import com.google.common.collect.Sets
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.SimpleAuthenticationInfo
import org.apache.shiro.authz.AuthorizationInfo
import org.apache.shiro.authz.SimpleAuthorizationInfo
import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.subject.PrincipalCollection

/**
 * <p> 用户数据库验证模块 </p>
 * <p>Created on 19/1/15.</p>
 * @author kennylee
 */
class UserRealm extends AuthorizingRealm {
    @Override
    def AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(Sets.newHashSet("user"));
        authorizationInfo.setStringPermissions(Sets.newHashSet("user:list"));
        authorizationInfo;
    }

    @Override
    def AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        new SimpleAuthenticationInfo("admin", "111111", getName());
    }
}
