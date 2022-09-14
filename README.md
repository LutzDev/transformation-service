# Transformation Service
This service is used to transform dialog files into a readable format. Currently the service supports only Inky files, but it can be extended for other authoring tools.
This service provides the ability to do JSON-to-JSON transformations with JOLT. Dependencies are managed by gradle.
## Executing the project
### Executable jar-File
```shell
./gradlew shadowJar   
```
### Docker
Run docker-compose in root directory
```shell
docker-compose build && docker-compose up -d    
```

## Endpoints
|       HTTP-Method | Endpoint | Description                                                                |
|------------------:|:--------:|----------------------------------------------------------------------------|
|         POST | `/transform/inky` | Accepts an Inky dialog as a json file and returns the transformed format. The specification file for the transformation can be found at ressources/specifications/inky.json |

## Output format (example)
```json
{
  "flows": {
    "init": {
      "link": "start"
    },
    "start": {
      "link": "introduction",
      "messages": "Heute ist der $systemDay.$systemMonth.$systemYear",
      "type": "text"
    },
    "introduction": {
      "link": "registration",
      "messages": [
        "Ich bin ihr Assistent namens $coachName und führe Sie durch die Intervention",
        "Fangen wir direkt an."
      ],
      "type": "text"
    },
    ....
  }
}
```
Each flow has a unique name (e.g. start). The flow name init is added automatically and refers to the starting flow.

**type:** Specifies the type of the flow. <br>
**link:** Defines which flow is to be continued with afterwards. <br>
**messages:** Is an array and contains all text entries of a flow. Each text entry will be displayed in a separate text message to the client. <br>
**ref:** Specifies the reference to the resource.

## Helpful links
### Ktor: 
* Official documentary: https://ktor.io/docs/welcome.html

### Jolt:
* Demo: https://jolt-demo.appspot.com/#inception
* Official documentary: https://github.com/bazaarvoice/jolt#-documentation
* Preferred documentation: https://intercom.help/godigibee/en/articles/4044359-transformer-getting-to-know-jolt

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
    │   │   │       ├─ util             # Helpers, Tool-Specification, ...
    │   │   │       └── service         # Transformation
    │   │   └── ressources             
    │   │       ├─ specifications       # jolt-specifications
    │   │       ├─ application.conf     # define server specifications
    │   │       └── logback.xml         # Defines the Logging-Frameworks
    │   └── test                        # Automated tests
    └── ...                             # Configuration files for gradle and docker