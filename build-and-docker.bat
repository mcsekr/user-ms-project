@echo off
echo Building all services and creating Docker images...

call build-all.bat

echo Building Docker images...

cd User-Api-GW
docker build -t user-api-gw .
cd ..

cd user-discovery-service
docker build -t eureka .
cd ..

cd user-login
docker build -t user-login .
cd ..

cd user-registration
docker build -t user-registration .
cd ..

cd user-read-all-records
docker build -t user-read-all-records .
cd ..

cd user-read-single-record
docker build -t user-read-single-record .
cd ..

cd user-update
docker build -t user-update .
cd ..

echo All Docker images built successfully!