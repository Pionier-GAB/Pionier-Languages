@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Resolve any " " by replacing them with spaces
if "%DIRNAME:~-1%"=="\" (
    set "APP_HOME=%DIRNAME:~0,-1%"
)

if exist "%APP_HOME%\gradle\wrapper\gradle-wrapper.jar" (
    set GRADLE_JAR=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar
) else (
    echo Gradle wrapper jar not found. Run './gradlew --version' first.
    exit /b 1
)

set "JAVA_EXE=java.exe"
if not "%JAVA_HOME%" == "" (
    set "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
)

if not exist "%JAVA_EXE%" (
    echo Error: JAVA_HOME is not set and java.exe is not in PATH. %JAVA_EXE%
    exit /b 1
)

%JAVA_EXE% -jar %GRADLE_JAR% %*
