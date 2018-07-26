/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.testreports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="test_suite")
class TestSuite 
{
    private String id;
    private Date start_time;
    private Date end_time;
    private String duration;
    
    private List<Testcase> testcase;
    private Testcase currentTestcase;

    public String getId ()
    {
        return id;
    }
    
    @XmlElement
    public void setId (String id)
    {
        this.id = id;
    }
    public Date getStart_time ()
    {
        return start_time;
    }
    
    @XmlElement
    public void setStart_time (Date start_time)
    {
        this.start_time = start_time;
    }
    public Date getEnd_time ()
    {
        return end_time;
    }
    
    public String getDuration ()
    {
        return this.duration;
    }
    
    @XmlElement
    public void setEnd_time (Date end_time)
    {
        this.end_time = end_time;
    }
    
    @XmlElement
    public void setDuration (String duration)
    {
    	
        this.duration = duration;
    }
     
    @XmlElementWrapper(name="testcases")
    public List<Testcase> getTestcase ()
    {
        return testcase;
    }

    public void setTestcase (List<Testcase> testcase)
    {
        this.testcase = testcase;
    }

    @XmlTransient
    public Testcase getCurrentTestcase ()
    {
        return currentTestcase;
    }
    
    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", testcases = "+testcase+"]";
    }
    
    public void addNewTest(String testCaseID,String description)
    {
    	this.currentTestcase = new Testcase();
    	this.currentTestcase.setId(testCaseID);
    	this.currentTestcase.setDescription(description);
    	this.currentTestcase.setStart_time(Calendar.getInstance().getTime());
    	if (testcase == null)
    	{
    		this.setTestcase(new ArrayList<Testcase>());
    	}
    	testcase.add(this.currentTestcase);
    }
}