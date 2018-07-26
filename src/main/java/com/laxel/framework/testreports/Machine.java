/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.testreports;

class Machine
{
    private String id;

    private OSInfo os;

    private String host_name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public OSInfo getOs ()
    {
        return os;
    }

    public void setOs (OSInfo os)
    {
        this.os = os;
    }

    public String getHost_name ()
    {
        return host_name;
    }

    public void setHost_name (String host_name)
    {
        this.host_name = host_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", os = "+os+", host_name = "+host_name+"]";
    }
}