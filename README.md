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