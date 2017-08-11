<img src="https://s-media-cache-ak0.pinimg.com/originals/74/14/c9/7414c9138964f7ad1953a58ec71271f8.jpg" width="150">

# Hummingbird
Java Runtime Environment (JRE) Minification Tool

## Overview
Hummingbird can take a regular JRE and shrink it down to just the features and functionality needed by your app.  

The standard Java 8 JRE is almost 200 megabytes in size.  Hummingbird currently can reduce the size of a JRE by almost 50 megabytes.  Soon Hummingbird will be able compress it all the way down to just over 30 megabytes!

## Usage
  
  1. Download the latest [version](https://github.com/abrayall/hummingbird/releases/download/v0.2.0/hummingbird.tar) and extract tar file
  2. Run hummingbird from command line and provide location of a JRE:
  ```sh
  [/opt/hummingbird]$ bin/hummingbird /opt/java/1.8.0_144/jre
  ```
  
    - The JRE specified will be updated in place.  
    - The JRE can then be tar'ed up and redistributed with any application.
  
## Schedule
  - [x] v0.1.0 - Support removing all unnecessary files
  - [x] [v0.2.0](https://github.com/abrayall/hummingbird/releases/download/v0.2.0/hummingbird.tar) - Support compressing jar files
  - [ ] v0.3.0 - Support removing unnecessary files from jar files
  - [ ] v0.4.0 - Support removing unnecesarry feature files
  - [ ] v1.0.0 - Support predefined compression levels
  - [ ] v1.1.0 - Support removing features based on trace files


