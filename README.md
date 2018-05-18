Java Practices
ide: eclipse
env: java 1.8.0

### Java Core
#### File IO

#### Multithreading
* [code][multi-demo00] [code][multi-demo01] [code][multi-demo02] Thread creation
* [code][multi-demo03] `volatile` keyword (cpu cache / visibility of changes to variables across threads)
* [code][multi-demo04] `synchronized` keyword on method (`join()`)
* [code][multi-demo05] `synchronized` keyword on method
* [code][multi-demo06] Unsynchronized example. 'synchronized method' not work on different objects
* [code][multi-pc-demo01] Producer & Consumer, `synchronized` code block -- object lock. List size of 1
* [code][multi-pc-demo02] Producer & Consumer, `synchronized` code block -- object lock. List size of N
* [code][multi-pc-demo03] Producer & Consumer, thread save linked list
* [code][multi-pc-demo04] Producer & Consumer, 2 threads add item to list, 2 threads remove item from list
* [code][multi-pc-demo05] Unsynchronized Example. Lock on differet objects.
* [code][multi-pc-demo06] 1 Chef (make food if table empty/block if customer eating) 1 Customer (eat food if food ready/block if food not ready) (Resource 1 table)
* [code][multi-ex-demo00] class `Executor`, method `execute(Runnable)`
* [code][multi-ex-demo01] class `ExecutorService`, method `execute(Runnable/Callable)`.
* [code][multi-ex-demo02] Sum numbers. `ExecutorService` / `Runnable/Callable` / `Future`
* [code][multi-cdl-demo00] CountDownLatch, Max Number
* [code][multi-cdl-demo01] CountDownLatch, Sum Numbers
* [code][multi-cb-demo00] CyclicBarrier
* [code][multi-philos00] Dining Philosopher: DeadLock. Semaphore
* [code][multi-philos01] Dining Philosopher: Solve Deadlock, might have Starvation. Semaphore
* [code][multi-philos02] Dining Philosopher: Solve Starvation. ReentrantLock - Fairness

[multi-demo00]: java-multithread/src/com/shichuan/java/multithread/basics/MultithreadBasics00.java
[multi-demo01]: java-multithread/src/com/shichuan/java/multithread/basics/MultithreadBasics01.java
[multi-demo02]: java-multithread/src/com/shichuan/java/multithread/basics/MultithreadBasics02.java
[multi-demo03]: java-multithread/src/com/shichuan/java/multithread/basics/MultithreadBasics03Volatile.java
[multi-demo04]: java-multithread/src/com/shichuan/java/multithread/basics/MultithreadBasics04SyncMethod.java
[multi-demo05]: java-multithread/src/com/shichuan/java/multithread/basics/MultithreadBasics05SyncMethod.java
[multi-demo06]: java-multithread/src/com/shichuan/java/multithread/basics/MultithreadBasics06UnsyncExample.java
[multi-pc-demo01]: java-multithread/src/com/shichuan/java/multithread/prodcons/Multithread01ProdCons.java
[multi-pc-demo02]: java-multithread/src/com/shichuan/java/multithread/prodcons/Multithread02ProdCons.java
[multi-pc-demo03]: java-multithread/src/com/shichuan/java/multithread/prodcons/Multithread03ThreadSafeList.java
[multi-pc-demo04]: java-multithread/src/com/shichuan/java/multithread/prodcons/Multithread04ObjectLock.java
[multi-pc-demo05]: java-multithread/src/com/shichuan/java/multithread/prodcons/Multithread05UnsyncThread.java
[multi-pc-demo06]: java-multithread/src/com/shichuan/java/multithread/prodcons/Multithread06ChefNCustomer
[multi-ex-demo00]: java-multithread/src/com/shichuan/java/multithread/executor/MultithreadExecutorDemo00.java
[multi-ex-demo01]: java-multithread/src/com/shichuan/java/multithread/executor/MultithreadExecutorDemo01.java
[multi-ex-demo02]: java-multithread/src/com/shichuan/java/multithread/executor/MultithreadExecutorDemo02SumNum.java
[multi-cdl-demo00]: java-multithread/src/com/shichuan/java/multithread/cdl/MultithreadCDL00MaxInput.java
[multi-cdl-demo01]: java-multithread/src/com/shichuan/java/multithread/cdl/MultithreadCDL01SumNum.java
[multi-cb-demo00]: java-multithread/src/com/shichuan/java/multithread/cdl/MultithreadCyclicBarrierDemo00.java
[multi-philos00]: java-multithread/src/com/shichuan/java/philosopher/DiningPhilosophersProblem00DeadLock.java
[multi-philos01]: java-multithread/src/com/shichuan/java/philosopher/DiningPhilosophersProblem01Starvation.java

### Java JDBC

* MySQL setups [EmployeeDB][db-emp-sql] [Stored Procedure][db-emp-sp-sql]
* MySQL setups [BookShelfDB][db-book-sql]
* [code][jdbc-demo01] Statement
* [code][jdbc-demo02] [code][jdbc-demo03] [code][jdbc-demo04] PreparedStatement Insert & Select & Update 
* [code][jdbc-demo05] CallableStatement
* [code][jdbc-demo06] [sql script][] Practice. Bookshelf CRUD operation

[db-emp-sql]: java-jdbc/src/sql/db_employee/emp_db.sql
[db-emp-sp-sql]: java-jdbc/src/sql/db_employee/sp_emp_db.sql
[db-book-sql]: java-jdbc/src/sql/db_book/bookshelf_db.sql
[jdbc-demo01]: java-jdbc/src/com/shichuan/java/jdbc/basics/JDBC01Statement
[jdbc-demo02]: java-jdbc/src/com/shichuan/java/jdbc/basics/JDBC02PreparedStatementInsert.java
[jdbc-demo03]: java-jdbc/src/com/shichuan/java/jdbc/basics/JDBC03PreparedStatementSelect.java
[jdbc-demo04]: java-jdbc/src/com/shichuan/java/jdbc/basics/JDBC04PreparedStatementUpdate.java
[jdbc-demo05]: java-jdbc/src/com/shichuan/java/jdbc/basics/JDBC05CallableStatement.java
[jdbc-demo06]: java-jdbc/src/com/shichuan/java/jdbc/practice/

### Java 8
#### Lambda Expression
* [code][lambda-demo00] Java 8 interface feature: default/static method
* [code][lambda-demo01] [code][lambda-demo02] [code][lambda-demo03] Simple demo of functional interface.
* [code][lambda-demo04] Print the string which length <= 4 in a list.
* [code][lambda-demo05] Check if the length of string is less or equal to 4 **(Predicate)**.
* [code][lambda-demo06] Print the length of a string **(Function)**.
* [code][lambda-demo07] Generate a random number **(Supplier)**.
* [code][lambda-demo08] Print the product that its price is less than 1000.0 **(stream api)**.
* [code][lambda-demo09] Print even numbers in the list **(stream api)**.
* [code][lambda-demo10] Print employees whose marks are greater than 90, sort the result by employee ID ** (stream api)**.
* [code][lambda-demo11] For those who marks are less than 40, give them 5 as the grace marks and then print out the final marks and id and sort them on basis of marks **(stream api)**.
* [code][lambda-demo12] Print name of employees who are less than 25 years old and scored more than 40 marks, sort the employees based on their marks **(stream api)**.
* [code][lambda-demo13] Using **stream** with List, Set, Map, Array
* [code][lambda-demo14] Employee class: id, name, salary. For each employee: tax on the income salary: less than 3000: 10%. 3000 and 5000: 20%. above 5000: 30% calculate the salary after tax and then find the employee with max salary.

[lambda-demo00]: java8/src/com/shichuan/java/lambda/LambdaDemo00Interface.java
[lambda-demo01]: java8/src/com/shichuan/java/lambda/LambdaDemo01.java
[lambda-demo02]: java8/src/com/shichuan/java/lambda/LambdaDemo02.java
[lambda-demo03]: java8/src/com/shichuan/java/lambda/LambdaDemo03.java
[lambda-demo04]: java8/src/com/shichuan/java/lambda/LambdaDemo04.java
[lambda-demo05]: java8/src/com/shichuan/java/lambda/LambdaDemo05Predicate.java
[lambda-demo06]: java8/src/com/shichuan/java/lambda/LambdaDemo06Function.java
[lambda-demo07]: java8/src/com/shichuan/java/lambda/LambdaDemo07Supplier.java
[lambda-demo08]: java8/src/com/shichuan/java/lambda/LambdaDemo08.java
[lambda-demo09]: java8/src/com/shichuan/java/lambda/LambdaDemo09.java
[lambda-demo10]: java8/src/com/shichuan/java/lambda/LambdaDemo10.java
[lambda-demo11]: java8/src/com/shichuan/java/lambda/LambdaDemo11.java
[lambda-demo12]: java8/src/com/shichuan/java/lambda/LambdaDemo12.java
[lambda-demo13]: java8/src/com/shichuan/java/lambda/LambdaDemo13.java
[lambda-demo14]: java8/src/com/shichuan/java/lambda/LambdaDemo14.java

#### Stream API
* [code][stream-demo15] Stream api [.filter .distinct(need equals) .collect] TreeSet[comparable]
* [code][stream-demo16] And then
[stream-demo01]: java8/src/com/shichuan/java/streamapi/LambdaDemo01.java
[stream-demo02]: java8/src/com/shichuan/java/streamapi/LambdaDemo02.java
