## Software AG Digital Business Platform
- The base environment for Hello DBP is 10.1 GA, labeled _2017 October (Apama and webMethods 10.1, Terracotta 4.3/DB 10.1, Adabas, Natural)._
- Be sure to use Software AG Update Manager to install the latest fixes.

## Common Utilities
- _Software AG makes no warrantees for third party software and mentioning them here does not constitute an endorsement._
- Link to [Air Server Software](http://www.airserver.com/), for mirroring an iPhone screen onto a Windows or Mac desktop. A free trial is available.
- Link to [Ditto Clipboard Manager](https://sourceforge.net/projects/ditto-cp/), for managing your own collection of text snippets to allow for easily filling in text fields from named clipboard entries.
- Link to [Postman](https://www.getpostman.com/), to test APIs.

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
1. Your own or access to a shared Cumulocity tenant.
1. Integration Server with CloudStreams installed.
1. Designer with Service Development plugins.
1. Link to [Cumulocity Provider for CloudStreams](http://techcommunity.softwareag.com/ecosystem/communities/public/webmethods/products/cloudstreams/downloads/Cumulocity/index.html), follow instructions to install to IS.
1. Download and install the lastest HelloDBP package from [IS](IS) folder.
1. From Designer Service Development, you'll also have to use File > Sync Document Types > All Out-of-Sync... to sync the two Digital Event Services types to the common repository.
1. Disable and then edit the Cumulocity connector from IS Administration screens to change to your tenant URL, your username and password. It will look something like this:
![CumulocityConnector](/images/CumulocityConnector.png)

## Sprint 3 - IS and Terracotta DB
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
1. Terracotta DB and Terracotta DB IS Adapter installed, with license file configured.
1. Manually create a new dataset called "Things", you can do that via the Terracotta DB IS Adapter administration.
![NewDataset](/images/NewDataset.png)

## Sprint 4 - IS REST Services
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
1. Edit the HelloREST API Descriptor to adjust for your IS machine name and port:
![HelloREST](/images/HelloREST.png)
1. _Warning: this HelloDBP package includes a Flow service called "HelloDBP.Utility:getSwagger", which in turn uses an unsupported IS built-in service. This is only for convenience in the demo. You can also save the swagger file to a file on disk and import into API Gateway, API Portal or Postman._
1. Here is a sample json payload for a new Thing object:
```
{ "Thing" : { "Name" : "Thing 1", "Health" : 100, "Account" : "Account 1" } }
```

## Sprint 5 - IS and API Gateway
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
1. API Gateway installed, which includes Event Data Store.
1. To use the API Key policy, your calling applications must include the HTTP header key `x-Gateway-APIKey` and the actual key generated when creating the new application in API Gateway.

## Sprint 6 - IS and API Portal
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
1. API Portal installed.
1. To enable publishing from Gateway to Portal, you must configure that in Gateway administration:
![GatewayPortalConfig](/images/GatewayPortalConfig.png)

## Sprint 7 - IS and Digital Event Services
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
1. Digital Event Services (DES) and associated Designer plug-in installed.
1. Command Central server, not necessarily on same machine or same suite folder.
1. Platform Manager in same suite folder as Integration Server.
1. Universal Messaging installed, including a Digital Event Service license.
1. Integration Server Digital Event Services configured, e.g. the default configuration is:
![DES_Config](/images/DES_Config.png)

## Sprint 8 - Digital Event Services and Digit Event Persistence
To reproduce this sprint, you'll need the following, in addition to everything from previous sprints:
1. Digital Event Persistence (DEP) Driver installed.
1. JDBC Adapter installed on Integration Server.
1. DEP Library jar file copied to JDBC Adapter code/jars folder.
1. Event Data Store installed and running, or a supported Elasticsearch or Hadoop server with associated DES custom configuration.
1. Integration Server Digital Event Services configured for Event Persistence, e.g. the default configuration is:
![DEP_Config](/images/DEP_Config.png)
