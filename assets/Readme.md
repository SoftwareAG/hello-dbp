## Software AG Digital Business Platform
- The base environment for Hello DBP is 10.1 GA, labeled _2017 October (Apama and webMethods 10.1, Terracotta 4.3/DB 10.1, Adabas, Natural)._
- Be sure to use Software AG Update Manager to install the latest fixes.

## Common Utilities
- _Software AG makes no warrantees for third party software and mentioning them here does not constitute an endorsement._
- Link to [Air Server Software](http://www.airserver.com/), for mirroring an iPhone screen onto a Windows or Mac desktop. A free trial is available.
- Link to [Ditto Clipboard Manager](https://sourceforge.net/projects/ditto-cp/), for managing your own collection of text snippets to allow for easily filling in text fields from named clipboard entries.
- Link to [Postman](https://www.getpostman.com/), to test APIs.
- Link to [Elasticsearch Head plugin](https://github.com/mobz/elasticsearch-head), a web front end for Elasticsearch, to browse persisted digital events.

## Sprint 1 - Cumulocity Trial

- Link to create your own [trial Cumulocity tenant](http://www.cumulocity.com/try-for-free/).
- Link to [Cloud Sensor App for Android](https://play.google.com/store/apps/details?id=com.cumulocity.cloudsensor&hl=en_US). But you also scan the QR code from the Cockpit "Add Smartphone" wizard.
- Link to Cloud Sensor App for iPhone (coming soon).
- Link to [Cloud Sensor App Documentation](https://www.cumulocity.com/guides/users-guide/android-cloud-sensor-app/).
- Link to [Cumulocity Cockpit Documentation](https://www.cumulocity.com/guides/users-guide/cockpit/). You can save one of the Acceleration measurements as a Data Point into the library, and set thresholds. This is what it looks like after saving it.
![accelerationY Data Point](/images/AccelerationY_DataPoint.png)
- The built-in alarm keyword is `c8y_ThresholdAlarm`. This is used in the second SmartRule.
- Text for SmartRule to send a notification to a smart phone using the Cloud Sensor App:
```
{
  "c8y_Message": {
    "text": "Slow down!"
  }
}
```

## Sprint 2 - Cumulocity and Integration Server

To reproduce this sprint demo, you'll need the following:
- Your own or access to a shared Cumulocity tenant.
- Integration Server with CloudStreams installed.
- Designer with Service Development plugins.
- Link to [Cumulocity Provider for CloudStreams](http://techcommunity.softwareag.com/ecosystem/communities/public/webmethods/products/cloudstreams/downloads/Cumulocity/index.html), follow instructions to install to IS.
- Download and install the lastest HelloDBP package from [IS](IS) folder.
- From Designer Service Development, you'll also have to use File > Sync Document Types > All Out-of-Sync... to sync the two Digital Event Services types to the common repository.
- Disable and then edit the Cumulocity connector from IS Administration screens to change to your tenant URL, your username and password. It will look something like this:
![CumulocityConnector](/images/CumulocityConnector.png)

## Sprint 3 - IS and Terracotta DB
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- Terracotta DB and Terracotta DB IS Adapter installed, with license file configured.
- Manually create a new dataset called "Things", you can do that via the Terracotta DB IS Adapter administration.
![NewDataset](/images/NewDataset.png)

## Sprint 4 - IS REST Services
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- Edit the HelloREST API Descriptor to adjust for your IS machine name and port:
![HelloREST](/images/HelloREST.png)
- _Warning: this HelloDBP package includes a Flow service called "HelloDBP.Utility:getSwagger", which in turn uses an unsupported IS built-in service. This is only for convenience in the demo. You can also save the swagger file to a file on disk and import into API Gateway, API Portal or Postman._
- Here is a sample json payload for a new Thing object:
```
{ "Thing" : { "Name" : "Thing 1", "Health" : 100, "Account" : "Account 1" } }
```

## Sprint 5 - IS and API Gateway
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- API Gateway installed, which includes Event Data Store.
- To use the API Key policy, your calling applications must include the HTTP header key `x-Gateway-APIKey` and the actual key generated when creating the new application in API Gateway.

## Sprint 6 - IS and API Portal
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- API Portal installed.
- To enable publishing from Gateway to Portal, you must configure that in Gateway administration:
![GatewayPortalConfig](/images/GatewayPortalConfig.png)

## Sprint 7 - IS and Digital Event Services
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- Digital Event Services (DES) and associated Designer plug-in installed.
- Command Central server, not necessarily on same machine or same suite folder.
- Platform Manager in same suite folder as Integration Server.
- Universal Messaging installed, including a Digital Event Service license.
- Integration Server Digital Event Services configured, e.g. the default configuration is:
![DES_Config](/images/DES_Config.png)

## Sprint 8 - Digital Event Services and Digit Event Persistence
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- Digital Event Persistence (DEP) Driver installed.
- JDBC Adapter installed on Integration Server.
- DEP Library jar file copied to JDBC Adapter code/jars folder.
- Event Data Store installed and running, or a supported Elasticsearch or Hadoop server with associated DES custom configuration.
- Integration Server Digital Event Services configured for Event Persistence, e.g. the default configuration is:
![DEP_Config](/images/DEP_Config.png)
- Configure a DES Service Group to store to Elasticsearch in addition to publishing to Universal Messaging, e.g. the configuration for HelloDBP is:
![ServiceGroup_Config](/images/ServiceGroup_Config.png)

## Sprint 9 - Digital Event Services and Apama
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- Apama server, Platform Manager plugin for Apama, and Designer Application Development plugin installed.
- The DES event types for ThingAlert and ThingEvent should already have been synchronized to the DES Event Type repository in the same suite folder as Apama.
- The full Apama project can be found at [HelloApama](/assets/Designer/HelloApama).
- Here's the snippet of EPL code for the HelloApama.mon script:
```
using com.softwareag.connectivity.ConnectivityPlugins;

monitor HelloApama {
	action onload {
		ConnectivityPlugins.onApplicationInitialized();
		
		monitor.subscribe( HelloDBP.HelloEvents.ThingEvent.CHANNEL );
		
		HelloDBP.HelloEvents.ThingEvent		thingEvent;
		
		on all HelloDBP.HelloEvents.ThingEvent() : thingEvent {
			send thingEvent to "com.apama.queries";
			log thingEvent.toString() at INFO;
		}
	}
}
```
- To build the query, these are the shortcuts:
  - Condition: `(t1.Health.toFloat() - t2.Health.toFloat()) / t1.Health.toFloat() >= 0.5`
  - Custom EPL Action: `send HelloDBP.HelloEvents.ThingAlert( t1.Id, "Thing '" + t1.Name + "' may be unhealthy.", t1.EventTime, "Normal", "", new sequence<integer> ) to HelloDBP.HelloEvents.ThingAlert.CHANNEL;`
- Create a new Apama instance in Command Central, e.g. with settings like these:
![Apama_Arguments](/images/Apama_Arguments.png)
![Apama_Initialization](/images/Apama_Initialization.png)

## Sprint 10 - MashZone NextGen with DES, Terracotta DB and Event Persistence data sources
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- MashZone NextGen installed.
- To import MashZone assets
  - Go to folder MashZoneNG > prestocli > bin and run these commands:
  - `padmin importAlias -u <User> -w <Password> -f "<local git path>\hello-dbp\assets\MashZone\Aliases.zip"`
  - `padmin importDashboard -u <User> -w <Password> -f "<local git path>\hello-dbp\assets\MashZone\Dashboard.zip"`
  - Restart MashZone NextGen. This is needed for the Event Services to restart properly.

## Sprint 11 - IS and AgileApps
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- AgileApps installed locally or an AgileApps tenant in the public cloud.
- In the IS package called HelloDBP, edit the HelloDynamicApps > handleThingAlert trigger and enable it.
- In the IS service called HelloDynamicApps > createThingAlertCase, edit the Flow second MAP step to set your userid and password, e.g.:
![AgileApps_CreateCase](/images/AgileApps_CreateCase.png)

## Sprint 12 - Dynamic Business Orchestrator and AgileApps
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
- Dynamic Business Orchestrator IS package installed plus Designer plugin for DBO and My webMethods User Interface for DBO.
- The full DBO project can be found at [HelloDBOProject](/assets/Designer/HelloDBOProject) and [HelloDBOTasks](/assets/Designer/HelloDBOTasks). These can be imported into Designer.
- After importing the Designer project, you could open the HelloDBO process and click "Upload for Dynamic Process".
- If you want to create the process from scratch, make it look like this:
![DBO_Process](/images/DBO_Process.png)
- Link to [Mobile Business Console App for iPhone](https://itunes.apple.com/us/app/webmethods-business-console/id1081041133) or [Mobile Business Console App for Android](https://play.google.com/store/apps/details?id=com.softwareag.mobile.mobilebusinessconsole2)
