# Scala + Play Framework 2.x Sample Application

This Scala + Play2 Framework Web Application has been created with aim to test [Mechanize Framework](http://gistlabs.com/software/mechanize-for-java/),
but it's also also a good choice to learn [Play Framework 2.x](http://playframework.com/).

Tested with Play 2.1.3 / Scala 2.10.2

##Config & Deploy

* Clone repository to a folder
* Set tmp.path value in conf/appication.conf to the writable folder path you want to get temporary files stored to.
* Run `play run` or `play start` in the application folder. Go to http://localhost:9000 to see it in action(to change port e.g. to 9001 use
`play "run 9001"` or `play "start 9001"`).
* Run `play test` to run tests
* You can build and deploy WAR also as the application uses Play2War plugin.

##Structure and Features

* Controllers with different response codes: 302 redirect, 302 infinite redirect, 466 code, internal server error with custom message
* Cookies examples: printing cookies got in request, setting cookie
* XML examples: simple XML document output and echoing value passed in an input XML document passed with PUT request
* JSON example: echoing value passed in an input JSON document passed with PUT request
* Not-Modified example: on first request Etag/Cache-Control headers are sent in response, then Not-Modified result sent
* Forms: GET/POST forms, POST form with validation
* Files: single file upload, multiple files upload, POST/PUT/GET service example(create a file with random filename on POST,
 create a file with specified filename on PUT, then get file with GET request)
* Auth: login to see secret token, or try to access secret area directly(with redirect to index page)


Copyright (C) 2012 [Gist Labs, LLC.](http://gistlabs.com) Developed by [Alexander Chepurnoy](http://chepurnoy.org/)