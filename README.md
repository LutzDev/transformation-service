# Transformation Service
This service provides the ability to do JSON-to-JSON transformations with JOLT. Dependencies are managed by gradle.
## Installation
### Executable jar-File
```shell
./gradlew shadowJar   
```
### Docker
Run docker-compose in root directory
```shell
docker-compose build && docker-compose up -d    
```
## Structure
    .
    ├── build                           # Compiled files
    │   └── libs                        # executable jar-file
    ├── src                             # Source files
    │   ├── main                        
    │   │   ├── kotlin                  
    │   │   │   └── com.transformation         
    │   │   │       ├─ plugins          # used plugins
    │   │   │       ├─ routes           # REST-API routes   
    │   │   │       └── service         # logic of jolt   
    │   │   └── ressources             
    │   │       ├─ specifications       # jolt-specifications
    │   │       ├─ application.conf     # define server specifications
    │   │       └── logback.xml         # Defines the Logging-Frameworks
    │   └── test                        # Automated tests
    └── ...                             # Configuration files for gradle and docker