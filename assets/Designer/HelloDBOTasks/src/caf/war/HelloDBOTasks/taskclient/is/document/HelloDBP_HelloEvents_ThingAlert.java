package caf.war.HelloDBOTasks.taskclient.is.document;

import java.io.Serializable;

/**
 * IS document wrapper
 */
public  class HelloDBP_HelloEvents_ThingAlert extends java.lang.Object implements Serializable {

	
	private static final long serialVersionUID = 1L;
	// IS Document type used to generate this class
	public static final String DOCUMENT_TYPE = "HelloDBP.HelloEvents:ThingAlert";
	private java.lang.String id;
	private java.lang.String alert;
	private java.util.Date _time;
	public static String[][] FIELD_NAMES = new String[][] {{"id", "Id"},{"alert", "Alert"},{"_time", "Time"},{"severity", "Severity"},
	};
	private java.lang.String severity;
	

	public HelloDBP_HelloEvents_ThingAlert() {
	}


	public java.lang.String getId()  {
		
		return id;
	}


	public void setId(java.lang.String id)  {
		this.id = id;
	}


	public java.lang.String getAlert()  {
		
		return alert;
	}


	public void setAlert(java.lang.String alert)  {
		this.alert = alert;
	}


	public java.util.Date get_time()  {
		
		return _time;
	}


	public void set_time(java.util.Date _time)  {
		this._time = _time;
	}


	public java.lang.String getSeverity()  {
		
		return severity;
	}


	public void setSeverity(java.lang.String severity)  {
		this.severity = severity;
	}

}