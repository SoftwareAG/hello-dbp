## Common Utilities
- _Software AG makes no warrantees for third party software and mentioning them here does not constitute an endorsement._
- Link to [Air Server Software](http://www.airserver.com/), for mirroring an iPhone screen onto a Windows or Mac desktop. A free trial is available.
- Link to [Ditto Clipboard Manager](https://sourceforge.net/projects/ditto-cp/), for managing your own collection of text snippets to allow for easily filling in text fields from named clipboard entries.

## Sprint 1 - Cumulocity Trial

- Link to create your own [trial Cumulocity tenant](http://www.cumulocity.com/try-for-free/).
- Link to [Cloud Sensor App for Android](https://play.google.com/store/apps/details?id=com.cumulocity.cloudsensor&hl=en_US). But you also scan the QR code from the Cockpit "Add Smartphone" wizard.
- Link to Cloud Sensor App for iPhone (coming soon).
- Link to [Cloud Sensor App Documentation](https://www.cumulocity.com/guides/users-guide/android-cloud-sensor-app/).
- Link to [Cumulocity Cockpit Documentation](https://www.cumulocity.com/guides/users-guide/cockpit/). You can save one of the Acceleration measurements as a Data Point into the library, and set thresholds.
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
