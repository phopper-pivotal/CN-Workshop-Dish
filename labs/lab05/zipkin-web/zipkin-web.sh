#!/usr/bin/env bash

java -jar lib/zipkin-web-all.jar -zipkin.web.port=:9412 -zipkin.web.rootUrl=/ -zipkin.web.query.dest=zipkin-query-service-unnymphean-dentil.cfapps.io:80
