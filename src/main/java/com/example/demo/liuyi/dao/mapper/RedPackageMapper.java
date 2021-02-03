package com.example.demo.liuyi.dao.mapper;

import com.example.demo.liuyi.dao.entry.RedPackageDo;

public  interface RedPackageMapper {
    int createRedPackage(RedPackageDo record);
     long isexpier(long id,long expire);
}
