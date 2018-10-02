/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author leonam
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().anyRequest().hasAnyRole("USER", "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/signin")
                .usernameParameter("userid") 
                .passwordParameter("passwd") 
                .successHandler((req, res, auth) -> { 
                    for (GrantedAuthority authority : auth.getAuthorities()) {
                        System.out.println(authority.getAuthority());
                    }
                    System.out.println(auth.getName());
                    res.sendRedirect("/"); // Redirect user to index/home page
                })
                .defaultSuccessUrl("/")
                .failureHandler((req, res, exp) -> {  
                    String errMsg = "";
                    if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {
                        errMsg = "Invalid username or password.";
                    } else {
                        errMsg = "Unknown error - " + exp.getMessage();
                    }
                    req.getSession().setAttribute("message", errMsg);
                    res.sendRedirect("/login.xhtml"); // Redirect user to login page with error message.
                })
                .permitAll() // Allow access to any URL associate to formLogin()
                .and()
                .logout()
                .logoutUrl("/logout") // Specifies the logout URL, default URL is '/logout'
                .logoutSuccessHandler((req, res, auth) -> {   // Logout handler called after successful logout 
                    req.getSession().setAttribute("message", "You are logged out successfully.");
                    res.sendRedirect("/"); // Redirect user to login page with message.
                })
                .permitAll() 
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/avaliacao/respostaAvaliacao.xhtml");
        web.ignoring().antMatchers("/getAvaliacao/**");
        web.ignoring().antMatchers("/javax.faces.resource/**");
    }
}
