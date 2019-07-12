package com.xz.demo.service.security;

import com.xz.demo.dao.AdminMapper;
import com.xz.demo.model.jwt.JwtUserFactory;
import com.xz.demo.model.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = new Admin();
        Admin user = adminMapper.selectOne(admin);
        if (null == user) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            //权限日后再研究可以用 security 也可以自己实现
            //authorities.add(new SimpleGrantedAuthority(RoleEnum.roleName(user.getType())));
            return JwtUserFactory.create(admin);
        }
    }


}
