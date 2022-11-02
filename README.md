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
