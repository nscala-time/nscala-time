# nscala-time
[![Build Status](https://travis-ci.org/nscala-time/nscala-time.svg?branch=master)](https://travis-ci.org/nscala-time/nscala-time)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nscala-time/nscala-time_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.nscala-time/nscala-time_2.12)
[![Scaladoc](http://javadoc-badge.appspot.com/com.github.nscala-time/nscala-time_2.12.svg?label=scaladoc)](http://javadoc-badge.appspot.com/com.github.nscala-time/nscala-time_2.12/com/github/nscala_time/time/index.html)
[![Reference Status](https://www.versioneye.com/java/com.github.nscala-time:nscala-time_2.11/reference_badge.svg?style=flat)](https://www.versioneye.com/java/com.github.nscala-time:nscala-time_2.11/references)

A new Scala wrapper for Joda Time.  This project forked from [scala-time](https://github.com/jorgeortiz85/scala-time/ "scala-time") since
it seems that scala-time is no longer maintained.


## Installation

Add the following to your sbt build (Scala 2.10.x, 2.11.x and 2.12.x):

```scala
libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.16.0"
```

if you want to use previous versions, [you can find it from here](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.nscala-time%22)

## Release Note

### 2.16.0
* [joda-time 2.9.7](https://github.com/nscala-time/nscala-time/commit/7882d08833b5862fadb033cc158bcc37e038efe0)
* [Scala 2.12.1](https://github.com/nscala-time/nscala-time/commit/be6e4212c9a92e197ee4a660d006db45ea191e3f)

### 2.14.0
* [Scala 2.12.0-RC1](https://github.com/nscala-time/nscala-time/commit/5916ede4276e3bef76dc1f659afe8ce81d224837)
* [s/Super/AnyVal](https://github.com/nscala-time/nscala-time/commit/18267aaf85f98a4aa64aca1aace94268086dd630)
* [joda-time 2.9.4](https://github.com/nscala-time/nscala-time/commit/03a50ec26c5d81364abc97d77fbc31a08098d70f)

### 2.12.0
* [change private `RichString#toOption` method](https://github.com/nscala-time/nscala-time/pull/102)
* [Drop Scala 2.9.3 support](https://github.com/nscala-time/nscala-time/pull/104)
* [use `FiniteDuration` instead of `Duration`](https://github.com/nscala-time/nscala-time/pull/106)
* [joda-time 2.9.3](https://github.com/nscala-time/nscala-time/commit/f8b2caae3de2225ce)

### 2.10.0
* adding the flexibility to include format for local date and date time.  See [scaladoc](
https://oss.sonatype.org/service/local/repositories/releases/archive/com/github/nscala-time/nscala-time_2.11/2.10.0/nscala-time_2.11-2.10.0-javadoc.jar/!/index.html#com.github.nscala_time.time.RichString)

### 2.8.0
* [joda-time 2.9.2](https://github.com/nscala-time/nscala-time/commit/73a57beea4533311)

### 2.6.0
* [joda-time 2.9.1](https://github.com/nscala-time/nscala-time/commit/19b1cf4818c25b78fdff8d0)

### 2.4.0
* [joda-time 2.9](https://github.com/nscala-time/nscala-time/commit/d1bea9dfb7d96526f8c5eac0fd49cd993fc8c0a0)

### 2.2.0
* [joda-time 2.8.2](https://github.com/nscala-time/nscala-time/commit/b6db535005c25931f31ef637e98f1e19c0f02891)
* [Add parentheses to methods which are not purely-functional](https://github.com/nscala-time/nscala-time/pull/93)
* [`object BuilderImplicits` should not extends `trait Implicits`](https://github.com/nscala-time/nscala-time/pull/92)

### 2.0.0
* [Now interval by period contains interval end if possible](https://github.com/nscala-time/nscala-time/issues/83)

### 1.8.0
* [Add method to convert an interval into a collection](https://github.com/nscala-time/nscala-time/pull/79)
* [joda-time 2.7](https://github.com/nscala-time/nscala-time/commit/83fe9f09456d2fa2bf11790f58d17fe1a187a808)
* [Add arithmetic and others methods to Duration, Interval, and Period](https://github.com/nscala-time/nscala-time/pull/80)

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

//Convert Date String to Date Time Object
  val inputDate = "Sat Feb 06 13:21:55 +0000 2016"
  DateTimeZone.setDefault(DateTimeZone.UTC)
  val dateObj = DateTime.parse(inputDate, DateTimeFormat.forPattern(s"E MMM dd HH:mm:ss Z yyyy"))
  val outputDate = DateTimeFormat.forPattern("yy-MM-dd HH:mm:ss").print(dateObj)
```


Please see Joda Time for full explanation of key concepts and API:
http://www.joda.org/joda-time/

## Documents

 - [scaladoc (latest stable release)](http://javadoc-badge.appspot.com/com.github.nscala-time/nscala-time_2.12/com/github/nscala_time/time/index.html)

Documentation of joda-time will be also a help.
 - [User guide](http://www.joda.org/joda-time/userguide.html)
 - [Javadoc](http://www.joda.org/joda-time/apidocs/index.html)

## Motivation

The Java Date and Calendar libraries are largely inadequate. They are mutable, not thread-safe, and very inconvenient to use.

The Joda Time library is a great replacement for Java's Date and Calendar classes. They're immutable by default, have a much
richer and nicer API, and can easily be converted to Java's Date and Calendar classes when necessary.

This project provides a thin layer of convenience around the Joda Time libraries, making them more idiomatic to use within Scala.
