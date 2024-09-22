# JRAFFIC

## Download Java
 - https://download.oracle.com/java/17/archive/jdk-17.0.11_linux-x64_bin.tar.gz
 - tar -xvzf jdk-17.0.11_linux-x64_bin.tar.gz
 - création et déplacement
```
mkdir ~/java
mv jdk-17.0.11 ~/java/
```
 - nano ~/.bashrc
 - mettre ces 2 lignes à la fin
```
export JAVA_HOME=~/java/jdk-17.0.11
export PATH=$JAVA_HOME/bin:$PATH
```
 - source ~/.bashrc
