package com.xz.demo.model.jwt;

import com.xz.demo.model.pojo.Admin;


public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Admin admin) {
        return new JwtUser(
                admin.getId(),
                admin.getUsername(),
                admin.getPassword()
        );
    }

  /*  private static List<GrantedAuthority> mapToGrantedAuthorities(List<SysRole> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getTitle()))
                .collect(Collectors.toList());
    }*/
}
