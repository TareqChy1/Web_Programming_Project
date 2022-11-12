# Faircorp

__An application to manage a Smart Building__
- - - -
[Deployed Backend on Clever-Cloud](https://faircorp-tareq-chy.cleverapps.io/)

- Author : [Tareq Md Rabiul Hossain Chy](https://github.com/TareqChy1)
- Based on [Guillaume Ehret's course](https://dev-mind.fr/formations.html)
- Backend of the 2022 Web & Mobile Programing project for [MSc CPS2 Web & Mobile programming course](https://ci.mines-stetienne.fr/cps2/syllabus/)



## Context
- - - -
- The management of the users' health (Pollution), comfort, and energy consumption, require conflicting management of windows and heaters in public buildings. It is necessary to ventilate as much as possible, but the weather is cold, and the heaters need to be turned on. So the building has a window opener device, a heater remote controler and some teamperature sensors.
- This applications allows the user to visualize the temperature of each room, the status of the windows and heaters. Also, it allows to control both the heaters and the windows of each room and also room in building and building.

The goal of the 2022 Web & Mobile Programing project is to implement a fully functional Smart Building management system(especially building, rooms, windows and heaters controllers). The project is composed of a [Java SpringBoot Backend server](https://github.com/TareqChy1/Web_Programming_Project), an [Android Kotlin Application]() and a [VueJS Frontend server]() interacting together.



## Project setup
- - - -
Clone the repo. The Login credential is given below. See the Login credential & run.
- Username: user.
- Password: password.

```bash
./gradlew bootRun
```

Anyone can now access the backend on [localhost:8080](http://localhost:8080) or on the [Deployed server](https://faircorp-tareq-chy.cleverapps.io/)



## Project API
- - - -
Anyone can experiment with the API on [localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/) or on the [Deployed server](https://faircorp-tareq-chy.cleverapps.io/swagger-ui/)



### Windows Endpoints
#### Get Windows List:
- Request Type: GET
- Endpoint: /api/windows

#### Create A New Window:
- Request Type: POST
- Endpoint: /api/windows
- Body:
    ```json
    {
      "id": 0,
      "name": "string",
      "roomId": 0,
      "roomName": "string",
      "windowStatus": "CLOSED"
    }
    ```

#### Get Window With A Specific ID:
- Request Type: GET
- Endpoint: /api/windows/{windowId}
- {windowId}: A Long Integer

#### Delete A Window:
- Request Type: DELETE
- Endpoint: /api/windows/{windowId}
- {windowId}: A Long Integer

#### Update A Window Status( OPEN <-> CLOSED):
- Request Type: PUT
- Endpoint: /api/windows/{windowId}/switch
- {windowId}: A Long Integer

#### Get List Of Windows That Belongs To The Same Room:
- Request Type: GET
- Endpoint: /api/windows/room/{roomId}
- {roomId}: A Long Integer




### Heaters Endpoints
#### Get Heaters List:
- Request Type: GET
- Endpoint: /api/heaters

#### Create A New Heater:
- Request Type: POST
- Endpoint: /api/heaters
- Body:
    ```json
    {
      "heaterStatus": "OFF",
      "id": 0,
      "name": "string",
      "power": 0,
      "roomId": 0,
      "roomName": "string"
    }
    ```

#### Get Heater With A Specific ID:
- Request Type: GET
- Endpoint: /api/heaters/{heaterId}
- {heaterId}: A Long Integer

#### Delete A Heater:
- Request Type: DELETE
- Endpoint: /api/heaters/{heaterId}
- {heaterId}: A Long Integer

#### Update A Heater Status(ON <-> OFF):
- Request Type: PUT
- Endpoint: /api/heaters/{heaterId}/switch
- {heaterId}: A Long Integer

#### Get List Of Heaters That Belongs To The Same Room:
- Request Type: GET
- Endpoint: /api/heaters/room/{roomId}
- {roomId}: A Long Integer



### Rooms Endpoints:
#### Get Rooms List:
- Request Type: GET
- Endpoint: /api/rooms

#### Create A New Room:
- Request Type: POST
- Endpoint: /api/rooms
- Body:
    ```json
    {
      "buildingId": 0,
      "currentTemperature": 0,
      "floor": 0,
      "id": 0,
      "name": "string",
      "targetTemperature": 0
    }
    ```
  
#### Get Room With A Specific ID:
- Request Type: GET
- Endpoint: /api/rooms/{roomId}
- {roomId}: A Long Integer

#### Delete A Room:
- Request Type: DELETE
- Endpoint: /api/rooms/{roomId}
- {roomId}: A Long Integer

#### Get List Of Rooms That Belongs To The Same Building
- Request Type: GET
- Endpoint: /api/rooms/buildings/{buildingId}
- {buildingId}: A long Integer

#### Update Heaters Status Inside A Room (ON <-> OFF):
- Request Type: PUT
- Endpoint: /api/rooms/{roomId}/switchHeaters
- {roomId}: A Long Integer

#### Update Windows Status Inside A Room (CLOSED <-> OPEN):
- Request Type: PUT
- Endpoint: /api/rooms/{roomId}/switchWindows
- {roomId}: A Long Integer

#### Get List Of Rooms That Belongs To The Same Building:
- Request Type: GET
- Endpoint: /api/rooms/building/{buildingId}
- {roomId}: A Long Integer



### Buildings Endpoints
#### Get Buildings List:
- Request Type: GET
- Endpoint: /api/buildings

#### Create A New Building:
- Request Type: POST
- Endpoint: /api/buildings
- Body:
    ```json
    {
      "id": 0,
      "name": "string",
      "outsideTemperature": 0
    }
    ```

#### Get Building With A Specific ID:
- Request Type: GET
- Endpoint: /api/buildings/{buildingId}
- {buildingId}: A Long Integer

#### Delete A Building:
- Request Type: DELETE
- Endpoint: /api/buildings/{buildingId}
- {buildingId}: A Long Integer




### NOTES
- - - -

- If anyone delete a room all windows and heaters inside this room will be deleted.
- If anyone delete a building all rooms inside the building will be deleted.


### Contact
- - - -

- For reporting uses you can do it in the issues section of this repository.
- For contacting the developer for any other reason please email me at <tareq.chy@etu.emse.fr> or <tareqfarhadbd@gmail.com>