# SNUnit ♥️ Http4s

This is the simplest possible example using Http4s with SNUnit on Scala Native.

## How to run

You need to install and run NGINX Unit.

Then you can run with Sbt:
```scala
sbt
> snunit/deployToNGINXUnit
```

Try with `curl`
```
curl localhost:8080
Hello Http4s!⏎
```

### If you see permission denied issues

If you see issues like:
```
703#49703 bind(6, 2022/10/31 19:51:03 [alert] 49703#49703 bind(6, unix:/var/run/control.unit.sock.tmp) failed (13: Permission denied)
```
It means that NGINX Unit control.sock file is protected for root user only.
The workaround is to use `sudo curl` as your `curl` command to update the Unit configuration.
In Sbt add: `snunitCurlCommand := Seq("sudo", "curl")` to the `snunit` module settings

### Ember version

For faster development a JVM version is provided.
Run it with:
```scala
sbt
> ~emberJVM/reStart
```

You can also build the Scala Native ember version:
```scala
sbt
> emberNative/nativeLink
```
