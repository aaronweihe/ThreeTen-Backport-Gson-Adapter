ThreeTen Backport Gson Adapter
==============================

A library provides serialization/deserialization support for JSR-310 backport types using Gson. 

Currently supports `Instant`, `LocalDate`, `LocalTime`, `LocalDateTime`, `OffsetDate`, `OffsetTime` and `ZonedDateTime`.

Usage
-----

Use one or some of static methods in `ThreeTenGsonAdapter` to register type adapter on `GsonBuilder` object.

For example, if you'd like `Gson` to serialize/deserialize `LocalTime`, register `LocalTime` using `ThreeTenGsonAdapter` like this:

````java
GsonBuilder builder = new GsonBuilder();
Gson gson = ThreeTenGsonAdapter.registerLocalTime(builder).create();
````

If you need all of the supported types, there's a convenient method: `ThreeTenGsonAdapter.registerAll()`.

Build
-----

To build:

````bash
$ git clone git@github.com:aaronhe42/ThreeTen-Backport-Gson-Adapter.git
$ cd ThreeTen-Backport-Gson-Adapter/
$ ./gradlew build
```

[![Build Status](https://travis-ci.org/aaronhe42/ThreeTen-Backport-Gson-Adapter.svg?branch=master)](https://travis-ci.org/aaronhe42/ThreeTen-Backport-Gson-Adapter)

Download
--------

```groovy
compile 'org.aaronhe:threetenbp-gson-adapter:1.0.1'
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository](https://oss.sonatype.org/content/repositories/snapshots/).

If your project uses a library other than [threetenbp](https://github.com/ThreeTen/threetenbp) which actually provides the ThreeTen Backport, like [ThreeTenABP](https://github.com/JakeWharton/ThreeTenABP), you need to exclude threetenbp library from the dependency. Otherwise `UNEXPECTED TOP-LEVEL EXCEPTION: com.android.dex.DexException: Multiple dex files define Lorg/threeten/bp/Clock` will be thrown.

```groovy
compile('org.aaronhe:threetenbp-gson-adapter:1.0.1) {
  exclude module: 'threetenbp'
}
```

Or set `transitive` to `false`:

```groovy
compile('org.aaronhe:threetenbp-gson-adapter:1.0.1') {
  transitive = false
}
```

License
-------

    Copyright (C) 2015 Aaron He
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
