package com.mpj.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.mpj.dao.UserDao;
import com.mpj.pojo.User;

/**
 * hzmpj 2017年6月30日 Shiro自定义域
 */
public class MyRealm extends AuthorizingRealm {

	private UserDao userdao;

	/**
	 * 用于权限的认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String username = principalCollection.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roleName = userdao.findRoles(username);
		Set<String> permissions = userdao.findPermissions(username);
		info.setRoles(roleName);
		info.setStringPermissions(permissions);
		return info;
	}

	/**
	 * 首先执行这个登陆认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户帐号
		String username = token.getPrincipal().toString();
		User user = userdao.findeUserByUsername(username);
		if (user != null) {
			// 将查询到的用户账户和密码存放到authenticationInfo用于后面的权限判断。第三个参数随便放
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(),
					"a");
			return authenticationInfo;
		}
		return null;
	}
 
}
