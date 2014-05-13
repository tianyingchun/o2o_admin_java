package framework.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Specifically, the "/" and "/home" paths are configured to not require any authentication.
		//All other paths must be authenticated.
		//When a user successfully logs in, they will be redirected to the previously requested page that requires authentication
		//There is a custom "/login" page specified by loginPage(), and everyone is allowed to view it.
		http.authorizeRequests()//.antMatchers("/", "/admin").permitAll()
				.anyRequest().authenticated();
		http.formLogin().loginPage("/login").permitAll().and().logout()
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password")
				.roles("USER");
	}
}
