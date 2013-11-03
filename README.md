google-pinger
=============

Scheduled URL pinger for Google App Engine.

It stays silent during the default time (defined in cron.xml) and when invoked it tries to fetch the given URLs.

Useful for keeping awake those URLs that can be marked as idle after a certain amount of time (Openshift cartridges for example).
