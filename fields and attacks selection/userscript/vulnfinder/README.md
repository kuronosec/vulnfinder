# VulnFinder

## What it does ##

The extension includes:

* a browser action which enables/disables the VulnFinder nav-bar
* a content script which creates/removes the VulnFinder nav-bar iFrame
* the nav-bar UI resources, packaged as web accessible resources

When the user clicks the browser action button, a nav-bar is shown/hidden
in the current web page.

The nav-bar UI is packaged in the add-on resources, exposed to the current
web page as a web accessible resource and injected into the page by the
content script by creating and injecting into the page an iframe which
points to the nav-bar UI page.

