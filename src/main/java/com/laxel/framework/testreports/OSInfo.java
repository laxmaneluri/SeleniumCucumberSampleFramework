/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.testreports;

class OSInfo
{
    private String name;

    private String architecture;

    private String version;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getArchitecture ()
    {
        return architecture;
    }

    public void setArchitecture (String architecture)
    {
        this.architecture = architecture;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", architecture = "+architecture+", version = "+version+"]";
    }
}
