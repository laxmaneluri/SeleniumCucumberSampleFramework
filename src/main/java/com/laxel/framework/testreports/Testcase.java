/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.testreports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="testcase")
class Testcase
{

	private String id;
    private List<TestStep> test_step;
    private EnvironmentInfo environment_info;
    private Date end_time;
    private String description;
    private Date start_time;

    @XmlAttribute
    public String getId ()
    {
        return id;
    }

    @XmlElement
    public void setId (String id)
    {
        this.id = id;
    }

    @XmlElementWrapper(name="test_steps")
    public List<TestStep> getTest_step ()
    {
        return test_step;
    }

    @XmlElement
    public void setTest_step (List<TestStep> test_step)
    {
        this.test_step = test_step;
    }

    public EnvironmentInfo getEnvironment_info ()
    {
        return environment_info;
    }

    public void setEnvironment_info (EnvironmentInfo environment_info)
    {
        this.environment_info = environment_info;
    }

    public Date getEnd_time ()
    {
        return end_time;
    }

    public void setEnd_time (Date end_time)
    {
        this.end_time = end_time;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Date getStart_time ()
    {
        return start_time;
    }

    public void setStart_time (Date start_time)
    {
        this.start_time = start_time;
    }
    
    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", test_step = "+test_step+", environment_info = "+environment_info+", end_time = "+end_time+", description = "+description+", start_time = "+start_time+"]";
    }

	public void addNewTestStep(String step_id, String description, String expected_result, String actual_result,String status, String screenShotPath) {
		// TODO Auto-generated method stub
		if (this.test_step==null)
			this.test_step = new ArrayList<TestStep>();
		TestStep testStep = new TestStep();
		testStep.setId(step_id);
		testStep.setDescription(description);
		testStep.setActual_result(actual_result);
		testStep.setExpected_result(expected_result);
		testStep.setStatus(status);
		testStep.setTime_stamp(Calendar.getInstance().getTime());
		testStep.setScreenshot_path(screenShotPath);
		this.test_step.add(testStep);
		
	}
}