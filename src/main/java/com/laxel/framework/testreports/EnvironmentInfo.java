/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.testreports;

class EnvironmentInfo
{
    private String app_info;

    private Machine machine;

    public String getApp_info ()
    {
        return app_info;
    }

    public void setApp_info (String app_info)
    {
        this.app_info = app_info;
    }

    public Machine getMachine ()
    {
        return machine;
    }

    public void setMachine (Machine machine)
    {
        this.machine = machine;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [app_info = "+app_info+", machine = "+machine+"]";
    }
}