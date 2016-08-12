# !/bin/bash
# @file compile.sh - compiles Crypton
# @requires ant
# @author ItaySharon

ant clean
ant build
ant build-jar
