## Memory Leak Generator<br/>(`memory-leak-generator`)


##### This app generates various situations in which OutOfMemoryError (OOM) occurs.<br/> It was made for basic training of heap dump (*.hprof) file analysis. <br/> Cases presented in this app are very simple.

Please always run this app with following JVM options:

| Option | Description |
| --- | --- |
| -XX:+HeapDumpOnOutOfMemoryError | Makes heap dump when OutOfMemoryError occurs. By default heap dump (*.hprof) is saved in application directory, but it could be changed using another JVM option -XX:HeapDumpPath=some/directory/path |
| -Xmx512m | Use this option to make app crash faster and to reduce thread dump (*.hprof file) size. It sets maximum heap size to 512 megabytes (MB). If this size of heap is reached OutOfMemoryError (OOM) occurs. |

If you want you might run this app with following JVM options:

Option | Description
--- | ---
-XX:HeapDumpPath=some/directory/path | Changes default path for heap dump (*.hprof) file done after OutOfMemoryError (OOM) occurs. It must be used together with -XX:+HeapDumpOnOutOfMemoryError option.

Proposed software:
* You can use VisualVm from JDK to see how memory is leaking in running app before OutOfMemoryError (OOM) occurs.
* You can use Eclipse Memory Analyzer to Analyze heap dumps

Proposed tutorials:
* [[Youtube Video] JVM Heap Dump Analysis - OpenJPA memory leak](https://www.youtube.com/watch?v=5joejuE2rEM)
* [10 Tips for using the Eclipse Memory Analyzer](https://eclipsesource.com/blogs/2013/01/21/10-tips-for-using-the-eclipse-memory-analyzer/)

### How to run the project
* From console
  * Enter project main directory (where the pom.xml is)<br/>For example `C:\Dev\Intellij training workspace\memory-leak-generator`
  * Just run current release *.jar from release directory using the following command:<br/>`java -XX:+HeapDumpOnOutOfMemoryError -Xmx512m -jar release/memory-leak-generator-1.0.jar`
  
  ![21](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/21_release_java_jar_run.png)
  
  * When OutOfMemoryError (OOM) occurs there should be *.hprof file in project main directory<br/>For example `java_pid5272.hprof`
  
* From Intellij IDEA (with project rebuild)
  * Right click on App class and select run App.main()
  
  ![01](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/01_intellij_launch.png)
  
  * Stop the app (Left lower or right upper corner)
  
  ![02](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/02_intellij_stop.png)
  
  * Edit configuration (Right upper corner or Run menu)
  
  ![03](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/03_intellij_edit_conf_click.png)
  
  * Put -XX:+HeapDumpOnOutOfMemoryError -Xmx512m and other parameters if you want to
  
  ![04](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/04_intellij_edit_conf_edit.png)
  
  * Run the app once again (Right upper corner)
  
  ![05](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/05_intellij_final_launch.png)
  
  * The app should work
  
  ![06](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/06_intellij_launch_result.png)
  
* Using console with manual source build (with project rebuild)
  * Enter the main directory (where pom.xml is)<br/>For example `C:\Dev\Intellij training workspace\memory-leak-generator`
  * Build the project using maven command<br/>`mvn clean install`
  
  ![11](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/11_mvn_clean_install.png)
  
  ![12](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/12_mvn_clean_install_result.png)
  
  * Run newly generated *.jar from target directory using the following command:<br/>C:\Dev\Intellij training workspace\memory-leak-generator>java -XX:+HeapDumpOnOutOfMemoryError -Xmx512m -jar target/memory-leak-generator-1.0.jar
  
  ![13](https://raw.githubusercontent.com/lukedd3/memory-leak-generator/master/docs/images/13_java_run_target_jar.png)

### How to make a heap dump
* First option was already presented. You can use -XX:+HeapDumpOnOutOfMemoryError option to make JVM do heap dump for you when OutOfMemoryError (OOM) occurs.
* From Eclipse Memory Analyzer TODO
* From VisualVm TODO
* From Console TODO
