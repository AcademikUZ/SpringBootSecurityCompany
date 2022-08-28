package fan.company.springsecuritycompany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // BASIC authentication orqali hodisalarni boshqarishda qo'shiladi
public class XavfsizlikniSozlash extends WebSecurityConfigurerAdapter {

    public final static String ROLE_SUPER_ADMIN = "SUPER_ADMIN";
    public final static String ROLE_MODERATOR = "MODERATOR";
    public final static String ROLE_OPERATOR = "OPERATOR";
    public final static String GET_ALL = "GET_ALL";
    public final static String GET_ONE = "GET_ONE";
    public final static String ADD = "ADD";
    public final static String EDIT = "EDIT";
    public final static String DELETE = "DELETE";


    /**
     * SUPER_ADMIN, MODERATOR va OPERATOR rollari bo’lsin.
     * SUPER_ADMIN har qanday ishni qila oladi;
     * MODERATOR mahsulot qo’sha oladi va tahrirlay oladi ,ammo o’chira olmaydi;
     * OPERATOR buyurtmalar bilan ishlaydi, mahsulotni o'chira olmaydi va tahrirlay olmaydi.
     */


    /**
     *
     * @param auth ROL YARATISH
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser(ROLE_SUPER_ADMIN).password(passwordEncoder().encode(ROLE_SUPER_ADMIN)).roles(ROLE_SUPER_ADMIN)
//                .and()
//                .withUser(ROLE_MODERATOR).password(passwordEncoder().encode(ROLE_MODERATOR)).roles(ROLE_MODERATOR)
//                .and()
//                .withUser(ROLE_OPERATOR).password(passwordEncoder().encode(ROLE_OPERATOR)).roles(ROLE_OPERATOR)
//    }

    /**
     *
     * @param "authorities" orqli hodisalarni boshqarish uchun authorities(GET_ALL,GET_ONE,ADD,EDIT,DELETE) qo'shiladi
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(ROLE_SUPER_ADMIN).password(passwordEncoder().encode(ROLE_SUPER_ADMIN)).roles(ROLE_SUPER_ADMIN).authorities(GET_ALL,GET_ONE,ADD,EDIT,DELETE)
                .and()
                .withUser(ROLE_MODERATOR).password(passwordEncoder().encode(ROLE_MODERATOR)).roles(ROLE_MODERATOR).authorities(GET_ALL,GET_ONE,ADD,EDIT)
                .and()
                .withUser(ROLE_OPERATOR).password(passwordEncoder().encode(ROLE_OPERATOR)).roles(ROLE_OPERATOR).authorities(GET_ALL,GET_ONE);
    }

    /**
     *
     * @param http BASIC authentication orqali hodisalarni boshqarish
     * @throws Exception
     */

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/product/**").hasAnyRole(ROLE_SUPER_ADMIN, ROLE_MODERATOR, ROLE_OPERATOR)
//                .antMatchers(HttpMethod.POST, "/api/product/**").hasAnyRole(ROLE_SUPER_ADMIN, ROLE_MODERATOR)
//                .antMatchers(HttpMethod.PUT, "/api/product/**").hasAnyRole(ROLE_SUPER_ADMIN, ROLE_MODERATOR)
//                .antMatchers(HttpMethod.DELETE, "/api/product/**").hasRole(ROLE_SUPER_ADMIN)
//                .antMatchers("/api/product/**").hasRole(ROLE_SUPER_ADMIN)
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }


    /**
     * authentication orqali hodisalarni boshqarish
     * @param http
     * @throws Exception
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/product/**").hasAnyAuthority(GET_ONE)
//                .antMatchers(HttpMethod.GET, "/api/product").hasAuthority(GET_ALL)
//                .antMatchers(HttpMethod.POST, "/api/product/**").hasAuthority(ADD)
//                .antMatchers(HttpMethod.PUT, "/api/product/**").hasAuthority(EDIT)
//                .antMatchers(HttpMethod.DELETE, "/api/product/**").hasAuthority(DELETE)
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }




    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
