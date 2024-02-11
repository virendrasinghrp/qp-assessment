package github.io.virendrasinghrp.groceryapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select NAME, PASSWORD, ENABLED FROM USER where NAME = ?")
                .authoritiesByUsernameQuery("select USER, ROLE from AUTHORITY where USER = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeRequests()
                //.anyRequest()
                //.authenticated()
                .antMatchers("/api/grocery/admin/**").hasAuthority("ADMIN")
                .antMatchers("/api/grocery/user/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("*/h2-console/**").permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/swagger-ui/", true)
                .failureUrl("/login.html?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/afterlogout.html")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
