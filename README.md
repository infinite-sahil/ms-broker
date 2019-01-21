# ms-broker
Rabbit MQ demonstration

Steps:
1.  Download and Install RabbitMQ (https://www.rabbitmq.com/download.html), 
    > to install RabbitMQ you need to setup EnLarge.exe first
   Since RabbitMQ is built on top of Erlang, we will first need to install Erlang. Got to the Erlang downloads page(https://www.erlang.org/downloads) and download the     erlang binary file for windows which is an executable.
   
2.  Next run the binary file downloaded and install erlang on your machine.
3.  Download/Install RabbitMQ.
4.  We will now start Rabbit, The above installation should have installed the RabbitMQ command prompt. Open it.
    Go to the RabbitMQ Server Location and use the command as follows-
    > rabbitmq-server start
5.  Next we will install the RabbitMQ plugin which will give use the RabbitMQ Management Console which is accessible using the browser. For this use the command as follows-
    > rabbitmq-plugins.bat enable rabbitmq_management
6.  Next go to localhost:15672.We will see the RabbitMQ console. The default username and password is guest.


Sample code with working example can be found in the repository.
