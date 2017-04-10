/*
* Package com.fth.rpc 
* FileName: ServiceImpl
* Author:   fth
* Date:     2017/4/7 14:21
*/
package com.fth.rmiSpecial;


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
    private Logger logger = Logger.getLogger(ServiceImpl.class);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    ServiceImpl() throws RemoteException {
        super();
    }


    @Override
    @KSOA("queryName")
    public String queryName(String s) throws RemoteException {
        System.out.println("queryName....."+s);
        return simpleDateFormat.format(Calendar.getInstance().getTimeInMillis());
    }

    @Override
    @KSOA("execute")
    public String execute(String s) throws RemoteException {
        System.out.println("execute....."+s);

        return simpleDateFormat.format(new Date());
    }


}
