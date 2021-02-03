package com.example.demo.liuyi.manager;

import com.example.demo.liuyi.dao.entry.RedPackageDo;
import com.example.demo.liuyi.dao.mapper.RedPackageMapper;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class redPackageManager {
    @Autowired
    RedPackageMapper redPackageMapper;

    public int createRedPackage(RedPackageDo r){
       return redPackageMapper.createRedPackage(r);
    }
    public long ifexpire(long id,long expire){return redPackageMapper.isexpier(id,expire);};
}
