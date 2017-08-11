<img src="https://s-media-cache-ak0.pinimg.com/originals/74/14/c9/7414c9138964f7ad1953a58ec71271f8.jpg" width="150">

# Hummingbird
Java Runtime Environment (JRE) Minification Tool

## Overview
Hummingbird can take a regular JRE and shrink it down to just the features and functionality needed by your app.  

The standard Java 8 JRE is almost 200 megabytes in size.  Hummingbird [version v1.0.0 (coming soon)] will be able compress it down to just over 30 megabytes!

## Usage
  
  1. Download the latest version and extract tar file
  2. Run hummingbird from command line and provide location of JRE
  ```sh
  [/opt/hummingbird]$ bin/hummingbird /opt/java/1.8.0_144/jre
  ```
  The JRE specified will be updated in place.  Hummingbird will be able to shink the JRE by almost 50MB!  The JRE can then be tar'ed up and redistributed with any application.
  
## Schedule
  - [x] v0.1.0 - Support removing unnecessary files
  - [x] v0.2.0 - Support compressing jar files
  - [ ] v0.3.0 - Support removing unnecessary files from jar files

