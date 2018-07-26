/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.testreports;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="test_step")
class TestStep
{
    private String id;

    private String status;

    private String description;

    private String screenshot_path;

    private String expected_result;

    private String actual_result;

    private Date time_stamp;

    @XmlAttribute
    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getScreenshot_path ()
    {
        return screenshot_path;
    }

    public void setScreenshot_path (String screenshot_path)
    {
        this.screenshot_path = screenshot_path;
    }

    public String getExpected_result ()
    {
        return expected_result;
    }

    public void setExpected_result (String expected_result)
    {
        this.expected_result = expected_result;
    }

    public String getActual_result ()
    {
        return actual_result;
    }

    public void setActual_result (String actual_result)
    {
        this.actual_result = actual_result;
    }

    @XmlElement
    public Date getTime_stamp ()
    {
        return time_stamp;
    }

    public void setTime_stamp (Date time_stamp)
    {
        this.time_stamp = time_stamp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", status = "+status+", description = "+description+", screenshot_path = "+screenshot_path+", expected_result = "+expected_result+", actual_result = "+actual_result+", time_stamp = "+time_stamp+"]";
    }
}