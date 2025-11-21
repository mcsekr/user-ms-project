@echo off
echo Starting build and run process...
if exist "%USERPROFILE%\app\practice\env_setup.bat" (
    call "%USERPROFILE%\app\practice\env_setup.bat"
) else (
    echo Environment setup file not found, continuing...
)

echo Running Maven build...
call mvn clean install
set MAVEN_EXIT_CODE=%ERRORLEVEL%
echo Maven exit code: %MAVEN_EXIT_CODE%

if %MAVEN_EXIT_CODE% NEQ 0 (
    echo Maven build failed with exit code %MAVEN_EXIT_CODE%, skipping Docker Compose
    goto :END
)

echo Maven build successful.

REM Stop and remove containers, networks and images created by this compose project
echo Bringing down existing Docker Compose services (containers, networks, images)...
call docker compose down --rmi all -v --remove-orphans
echo Docker compose down exit code: %ERRORLEVEL%

REM Remove dangling images to free space (safe, only dangling)
echo Pruning dangling Docker images...
call docker image prune -f
echo Docker image prune exit code: %ERRORLEVEL%

echo Starting Docker Compose (build and run)...
call docker compose up -d --build
echo Docker Compose up exit code: %ERRORLEVEL%

:END
echo Process completed.
pause
