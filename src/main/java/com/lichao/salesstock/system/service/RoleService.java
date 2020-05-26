package com.lichao.salesstock.system.service;


import com.lichao.salesstock.system.dto.RoleDto;

public interface RoleService {

    void saveRole(RoleDto roleDto);

    void deleteRole(Long id);
}
