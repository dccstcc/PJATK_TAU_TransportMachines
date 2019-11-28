#!/bin/sh
cd $TRAVIS_BUILD_DIR/TransportMachinesApp
mvn -up -U test
