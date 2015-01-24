package com.github.kennylee26.sample.shiro
import com.github.kennylee26.sample.shiro.security.UserRealm
import org.apache.shiro.spring.LifecycleBeanPostProcessor
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.filter.authc.LogoutFilter
import org.apache.shiro.web.mgt.DefaultWebSecurityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
/**
 * <p> Shiro配置 </p>
 * <p>Created on 19/1/15.</p>
 * @author kennylee
 */
@Configuration
class ShiroConfiguration {

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    def userRealm() {
        new UserRealm()
    }

    @Bean(name = "securityManager")
    def securityManager() {
        def sm = new DefaultWebSecurityManager()
        sm.realm = userRealm()
        sm
    }

    @Bean(name = "shiroFilter")
    def ShiroFilterFactoryBean shiroFilter() {
        def factoryBean = new ShiroFilterFactoryBean()
        factoryBean.securityManager = securityManager()
        factoryBean.loginUrl = "/login"
        factoryBean.successUrl = "/success.html"
        factoryBean.unauthorizedUrl = "/login"
        factoryBean.filters = ['logout': logoutFilter()]
        def filterChainDefinitionMap = new LinkedHashMap(['/': 'anon', '/login*': 'authc', '/logout': 'logout', '/**': 'user'])
        factoryBean.filterChainDefinitionMap = filterChainDefinitionMap
        factoryBean
    }

    def logoutFilter() {
        def logoutFilter = new LogoutFilter()
        logoutFilter.redirectUrl = '/login'
        logoutFilter
    }

    @Bean
    def lifecycleBeanPostProcessor() {
        new LifecycleBeanPostProcessor()
    }
}
