/*
* Package com.fth.rpc 
* FileName: IService
* Author:   fth
* Date:     2017/4/7 14:20
*/
package com.fth.rmiSpecial.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * FileName:    IService
 * Author:      Br7roy
 * Date:        2017/4/7
 * Description: JAVA自带的远程方法调用工具，
 * 不过有一定的局限性，毕竟是JAVA语言最开始时的设计，后来很多框架的原理都基于RMI
 */
public interface IService extends Remote {

    String queryName(String s)throws RemoteException;

    String execute(String s)throws RemoteException;





}
