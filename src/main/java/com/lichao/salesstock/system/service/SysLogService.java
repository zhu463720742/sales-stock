package com.lichao.salesstock.system.service;


import com.lichao.salesstock.system.model.SysLogs;

public interface SysLogService {
    void save(SysLogs sysLogs);

    void save(Long userId, String module, Boolean flag, String remark);

    void deleteLogs();
}
