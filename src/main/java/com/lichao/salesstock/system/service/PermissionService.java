package com.lichao.salesstock.system.service;


import com.lichao.salesstock.system.model.Permission;

public interface PermissionService {

    void save(Permission permission);

    void update(Permission permission);

    void delete(Long id);
}
