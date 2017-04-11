package com.fth.rmiSpecial.deploy;

import java.rmi.Remote;

/**
 * FileName:    RPC
 * Created by   kwx
 * on :         2017-04-10
 * Description:
 */
public class KSoaClient implements SoaClient {
    private static final long serialVersionUID = 8963733452577369089L;
    private String name;
    private Remote remote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Remote getRemote() {
        return remote;
    }

    public void setRemote(Remote remote) {
        this.remote = remote;
    }

    public KSoaClient(String name,
                      Remote remote) {
        this.name = name;
        this.remote = remote;
    }

    public KSoaClient() {
    }

    @Override
    public Object invoke(Object... objs) {
        try {
            Class<?>[] parms = null;
            if (objs != null) {
                parms = new Class[objs.length];
            }
            for (int i = 0; objs != null & i < objs.length; i++) {
                parms[i] = objs[i].getClass();
            }
            return remote.getClass().getMethod(name, parms).invoke(remote, objs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
