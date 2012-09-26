export JAVA_HOME=/usr/java/jdk1.6.0_21/
export JAVA_BIN=/usr/java/jdk1.6.0_21//bin
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export LANG=zh_CN.UTF-8
export LC_CTYPE=zh_CN.UTF-8
java -classpath $PWD/classes:$PWD/lib/* com.pw.spider.index.BookIndexManager 0
