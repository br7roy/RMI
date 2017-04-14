/*
* Package com.fth.rpc 
* FileName: ServiceImpl
* Author:   fth
* Date:     2017/4/7 14:21
*/
package com.rust.rmiSpecial.service;


import com.rust.rmiSpecial.deploy.KSOA;
import org.apache.log4j.Logger;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * FileName:    ServiceImpl
 * Author:      Br7roy
 * Date:        2017/4/7
 * Description: 服务层实现
 */
@Service
public class ServiceImpl
        extends UnicastRemoteObject
        implements IService {
    private static final long serialVersionUID = 4770317667348538261L;
    private Logger logger = Logger.getLogger(ServiceImpl.class);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public ServiceImpl() throws RemoteException {
        super();
    }


    @Override
    @KSOA(value = "queryName", desc = "查询名称")
    public String queryName(String s) throws RemoteException {

        System.out.println("queryName....." + s);
        return simpleDateFormat.format(Calendar.getInstance().getTimeInMillis());
    }

    @Override
    @KSOA(value = "execute", desc = "处理")
    public String execute(String s) throws RemoteException {
        System.out.println("execute....." + s);

        return simpleDateFormat.format(new Date());
    }


}
