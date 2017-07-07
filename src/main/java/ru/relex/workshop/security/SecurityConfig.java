package ru.relex.workshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = SecurityConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler
      authenticationSuccessHandler;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http
        .csrf().disable()
        .exceptionHandling()
        .authenticationEntryPoint(restAuthenticationEntryPoint)
        .and()
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/api/login").permitAll()
        .antMatchers("/resources/css/**").permitAll()
        .antMatchers("/resources/js/**").permitAll()
        .antMatchers("/resources/fonts/**").permitAll()
        .antMatchers("/**").authenticated()
        .and()
        .formLogin()
        .loginProcessingUrl("/api/login")
        .successHandler(authenticationSuccessHandler)
        .failureHandler(new SimpleUrlAuthenticationFailureHandler())
        .and()
        .logout();
    }
    
    @Bean
    public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
        return new MySavedRequestAwareAuthenticationSuccessHandler();
    }
    
    @Bean
    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler();
    }
	
}
