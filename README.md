# TynLog
A simple logger written in Kotlin, by me, for me. (ies***tyn***129)

## Plan
TynLog is intended to be specialised logger for my specific use cases,
with plans to include the following features:
- ✅ A single `TynLog` object responsible for all logging and configuration. It will have to be initialised
before any logging takes place.
- ✅ 4 log levels, info (`INF`), warning (`WRN`), error (`ERR`), and debug (`DBG`).
The debug level will be toggleable, ignoring any debug messages when disabled.
- ✅ The date and time present in every log message, in a `yyyy-MM-dd HH:mm:ss.SSS` format,
timezone will default to the devices. Both will be customisable.
- ✅ Options to log to the console and or a file. Not using either would effectively disable logging.
Log files will use the `.log` file extension since there's no standard associated with it.
An error stream will also be specifiable for `ERR`s.
- ✅ When logging to a file, a log folder will be set, 
and log file names will be the date and time the program started. This format will also be customisable,
but will default to `yyyy-MMM-dd HH:mm:ss`. Log files will not overwrite existing files, but will append
`-n` where `n` increases until not necessary.
- ✅ Auto deletion of log files can be setup, based on the time passed since the file was last modified.
File creation times won't work, programs could easily run longer than the auto deletion time.
I think 7 days would be a reasonable default.
- ⏸️ Maybe stacktrace options for showing the class where its being called from, or even file and line.

Example log output could look something like this:
```log
[2025-10-21 06:43:28.184] [INF] Initialising stuff or whatever...
[2025-10-21 06:43:28.396] [DBG] test.example = StuffClass(a = 1, b = 2, c = 3)
[2025-10-21 06:43:28.727] [INF] Done initialising stuff.
[2025-10-21 06:49:51.904] [WRN] Config something is unset, default to whatever.
[2025-10-21 06:52:02.082] [ERR] Unknown exception thown in main server thread.
[2025-10-21 07:00:03.228] [INF] [StuffClass] This is what the stacktrace could look like.
[2025-10-21 07:00:03.235] [INF] [StuffClass.meth] Or this.
[2025-10-21 07:00:03.241] [INF] [dev.iestyn129.example.StuffClass.meth] Even this.
[2025-10-21 07:00:03.249] [INF] [StuffClass.kt:47] More useful for errors.
[2025-10-21 07:00:03.262] [INF] [src/dev/iestyn129/example/StuffClass.kt:47:13] Maybe this one is a little extra.
```

## Building
TynLog is written in Kotlin 2.2 on Java 8, and uses the IntelliJ IDEA build system.
This is what's most convenient for me, so don't complain about it.
Just be thankful there's no other dependencies.

## Issues and Contribution
If you want to create issues or pull requests be my guest, but expect nothing from them. Yet again,
this is only for me.

## Licence
This project is licenced under the GNU General Public Licence version 3 or later (GPLv3+).
See the [LICENCE](./LICENCE) file for more details.
