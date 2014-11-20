# nscala-time
[![Build Status](https://travis-ci.org/nscala-time/nscala-time.png)](https://travis-ci.org/nscala-time/nscala-time)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nscala-time/nscala-time_2.11/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.nscala-time/nscala-time_2.11)
[![Scaladoc](http://javadoc-badge.appspot.com/com.github.nscala-time/nscala-time_2.11.svg?label=scaladoc)](http://javadoc-badge.appspot.com/com.github.nscala-time/nscala-time_2.11)


A new Scala wrapper for Joda Time.  This project forked from [scala-time](https://github.com/jorgeortiz85/scala-time/ "scala-time") since
it seems that scala-time is no longer maintained.


## Installation

Add the following to your sbt build (Scala 2.9.3, Scala 2.10.x, and Scala 2.11.0!):

```scala
libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "1.6.0"
```

Latest stable release is `1.6.0`. `1.4.0`, `1.2.0`, `1.0.0`, `0.8.0`, `0.6.0`, `0.4.2`, `0.4.0`, and `0.2.0` are also available.  What you need to do to use the previous versions
is replaing `1.6.0` with `x.y.z` in build.sbt simply.

## Release Note

### 1.6.0
* [joda-time 2.5](https://github.com/nscala-time/nscala-time/commit/944f048065a5fd0)
* drop Scala 2.9.1 and 2.9.2 support
* [conversion to and from scala std duration](https://github.com/nscala-time/nscala-time/pull/72)
* [Added static method wrappers](https://github.com/nscala-time/nscala-time/pull/74)

### 1.4.0
* joda-time 2.4 support

### 1.2.0

* [Remove implicit DateMidnightOrdering](https://github.com/nscala-time/nscala-time/pull/59)
* [Add toInterval to RichString](https://github.com/nscala-time/nscala-time/pull/60)
* [Add millis method to RichDateTime](https://github.com/nscala-time/nscala-time/pull/62)
* [Remove deprecated class RichMidnight](https://github.com/nscala-time/nscala-time/pull/63)
* [Make DurationBuilder public](https://github.com/nscala-time/nscala-time/pull/64)

### 1.0.0

* Binaries compiled with Scala 2.11.0 are included.
* <https://github.com/nscala-time/nscala-time/pull/53>

### 0.8.0

Binaries compiled with Scala 2.11.0-M8 are included.

### 0.6.0

Two major changes has been introduced in 0.6.0:

* [value class](https://github.com/nscala-time/nscala-time/issues/42)
* [update joda-time 2.3](https://github.com/nscala-time/nscala-time/issues/44)

Although I believe that these changes don't break your code, if you have some problems,
don't mind reporting the problem to [issues](https://github.com/nscala-time/nscala-time/issues).

### Version Numbering Policy

`x.y.z`, each letter is digit, format is used as version number.  Meanings of `x` is not determined yet.  
`y` means major-version.  Note that `y` is even number in any version of released `nscala-time`.  If `y` is odd, 
it's development and/or SNAPSHOT version.  `z` is mainly used for bug fix releases.  Currently, the value of `z` is 0
in most cases.

## Usage

This is mostly a convenience wrapper around the Joda Time libraries, adding
more pleasant syntax like operators for addition, subtraction, and comparison.
Also, most fields usually available as `getField` are now simply available as
`field`, following the Scala convention. Some instances of `asX` or `toX` have
also been shortened.


### Import
```scala
import com.github.nscala_time.time.Imports._
```


### Date/Time Operations
```scala
DateTime.now + 2.months // returns org.joda.time.DateTime = 2009-06-27T13:25:59.195-07:00

DateTime.nextMonth < DateTime.now + 2.months // returns Boolean = true

DateTime.now to DateTime.tomorrow  // return org.joda.time.Interval = > 2009-04-27T13:47:14.840/2009-04-28T13:47:14.840

(DateTime.now to DateTime.nextSecond).millis // returns Long = 1000

2.hours + 45.minutes + 10.seconds
// returns com.github.nscala_time.time.DurationBuilder
// (can be used as a Duration or as a Period)

(2.hours + 45.minutes + 10.seconds).millis
// returns Long = 9910000

2.months + 3.days
// returns Period
```


### Fluent interface
```scala
DateTime.now // returns org.joda.time.DateTime = 2009-04-27T13:25:42.659-07:00

DateTime.now.hour(2).minute(45).second(10) // returns org.joda.time.DateTime = 2009-04-27T02:45:10.313-07:00
```


Please see Joda Time for full explanation of key concepts and API:
http://www.joda.org/joda-time/

## Documents

 - [scaladoc (latest stable release)](http://javadoc-badge.appspot.com/com.github.nscala-time/nscala-time_2.11)

Documentation of joda-time will be also a help.
 - [User guide](http://www.joda.org/joda-time/userguide.html)
 - [Javadoc](http://www.joda.org/joda-time/apidocs/index.html)

## Motivation

The Java Date and Calendar libraries are largely inadequate. They are mutable, not thread-safe, and very inconvenient to use.

The Joda Time library is a great replacement for Java's Date and Calendar classes. They're immutable by default, have a much
richer and nicer API, and can easily be converted to Java's Date and Calendar classes when necessary.

This project provides a thin layer of convenience around the Joda Time libraries, making them more idiomatic to use within Scala.
