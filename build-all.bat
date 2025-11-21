@echo off

echo Starting build and run process...
if exist "%USERPROFILE%\app\practice\env_setup.bat" (
    call "%USERPROFILE%\app\practice\env_setup.bat"
) else (
    echo Environment setup file not found, continuing...
)

echo Building all microservices...

cd User-Api-GW
call mvnw clean package -DskipTests
cd ..

cd user-discovery-service
call mvnw clean package -DskipTests
cd ..

cd user-login
call mvnw clean package -DskipTests
cd ..

cd user-registration
call mvnw clean package -DskipTests
cd ..

cd user-read-all-records
call mvnw clean package -DskipTests
cd ..

cd user-read-single-record
call mvnw clean package -DskipTests
cd ..

cd user-update
call mvnw clean package -DskipTests
cd ..

echo All services built successfully!