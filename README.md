# [scalajs-react-mdl](http://payalabs.com/scalajs-react-mdl)

An easy way to use JavaScript dependent [MDL](http://getmdl.io) components with Scala.js React.

## Getting started

1. Clone this repository
2. Publish to the local sbt repository
 ```
 $ sbt publishLocal
 ```

3. Add the following dependency to your scalajs-react project
 ```scala
 libraryDependencies += "com.payalabs" %%% "scalajs-react-mdl" % "0.2.0-SNAPSHOT"
 ```

## Using an MDL component
Write the normal ReactTag for whichever MDL component you would like to use and call `.material` at the end:
```scala
import com.payalabs.scalajs.react.mdl.MaterialAble

div(className := "mdl-button mdl-js-button mdl-button--fab mdl-button--colored")(
  i(className := "material-icons")("add")
).material
```

The `material` method returns a ReactComponent that will automatically upgrade the element (adding event listeners, ripples, etc.) once it is in the DOM.
