package com.fth.rmiSpecial.deploy;

import java.rmi.Remote;

/**
 * FileName:    RPC
 * Created by   kwx
 * on :         2017-04-10
 * Description:
 */
public class KSoaClient implements SoaClient{
    private String name;
    private String method;
    private Remote remote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Remote getRemote() {
        return remote;
    }

    public void setRemote(Remote remote) {
        this.remote = remote;
    }

    public KSoaClient(String name, String method, Remote remote) {
        this.name = name;
        this.method = method;
        this.remote = remote;
    }

    public KSoaClient() {
    }

    @Override
    public Object invoke(Object... objs) {
        try {
            Class<?>[] parms = null;
            if (objs !=null){
                parms = new Class[objs.length];
            }
            for(int i=0; objs != null & i < objs.length; i++){
                parms[i] = objs[i].getClass();
            }
            return remote.getClass().getMethod(method, parms).invoke(remote,objs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
