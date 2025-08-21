To get rid of RMI warning message when running benchmarks, add this to VM options in Run configuration:

```
-Djava.rmi.server.hostname=localhost
```