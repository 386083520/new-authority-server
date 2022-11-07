package com.gsd.system.service;

import java.util.Set;

public interface ISysMenuService {
    public Set<String> selectMenuPermsByUserId(Long userId);
}
